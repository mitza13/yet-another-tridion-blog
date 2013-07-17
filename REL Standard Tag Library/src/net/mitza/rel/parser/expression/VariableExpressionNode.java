package net.mitza.rel.parser.expression;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.mitza.rel.parser.TokenTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.TransformContext;

/**
 * An ExpressionNode that stores a named variable or a context bean with its potential property and index.
 */
public class VariableExpressionNode extends ExpressionNode {

	private static final Logger log = LoggerFactory.getLogger(VariableExpressionNode.class);

	private String name;
	private Object value;
	private boolean valueSet;
	private VariableExpressionNode property;
	private ExpressionNode index;
	private TransformContext context;

	public VariableExpressionNode(String name) {
		this.name = name;
		valueSet = false;
	}

	public String getName() {
		return name;
	}

	public TokenTypes getType() {
		return TokenTypes.VARIABLE;
	}

	public void setValue(Object value) {
		this.value = value;
		this.valueSet = true;
	}

	public Object getValue() {
		if (valueSet) {
			return value;
		}

		try {
			if (context == null) {
				throw new EvaluationException(
						"Context has not been set. Use the SetContextVisitor on the top-level expression.");
			} else {
				VariableExpressionNode variable = this;
				Object value = context.get(name, null);

				VariableExpressionNode property;
				do {
					value = applyIndex(variable, value);
					property = variable.getProperty();
					if (property != null) {
						value = getBeanProperty(value, property.getName());
						variable = property;
					}
				} while (property != null);

				return value;
			}
		} finally {
			context = null; // context is transient, use it once then set it again if needed
		}
	}

	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
		if (index != null) {
			index.accept(visitor);
		}
		if (property != null) {
			property.accept(visitor);
		}
	}

	public VariableExpressionNode getProperty() {
		return property;
	}

	public void setProperty(VariableExpressionNode property) {
		this.property = property;
	}

	public ExpressionNode getIndex() {
		return index;
	}

	public void setIndex(ExpressionNode index) {
		this.index = index;
	}

	public void setContext(TransformContext context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return String.format("%s%s%s", name, index == null ? "" : String.format("[%s]", index), property == null ? ""
				: String.format(".%s", property));
	}

	private Object getBeanProperty(Object bean, String property) {
		Object value = null;
		String firstChar = property.substring(0, 1);
		String restPropertyName = property.substring(1);
		String methodName = "get" + firstChar.toUpperCase() + restPropertyName;
		Class<?> beanClass = bean.getClass();
		try {
			Method beanMethod = beanClass.getMethod(methodName, new Class[0]);
			value = beanMethod.invoke(bean, new Object[0]);
			log.debug("Found value={} for property={}", value, property);
		} catch (Exception e) {
			log.error("Could not get value for bean " + bean + " and property " + property, e);
		}

		return value;
	}

	private Object applyIndex(VariableExpressionNode variable, Object value) {
		ExpressionNode index = variable.getIndex();
		if (index == null) {
			return value;
		}

		Object indexValue = index.getValue();
		if (value instanceof Map<?, ?>) {
			return ((Map<?, ?>) value).get(indexValue);
		} else {
			if (!(indexValue instanceof Number)) {
				throw new EvaluationException("Index is not a number " + indexValue);
			}

			int idx = ((Number) indexValue).intValue();
			if (value instanceof Object[]) {
				return ((Object[]) value)[idx];
			} else if (value instanceof List) {
				return ((List<?>) value).get(idx);
			} else {
				throw new EvaluationException("Attempted to index a non-collection variable " + value);
			}
		}
	}
}
