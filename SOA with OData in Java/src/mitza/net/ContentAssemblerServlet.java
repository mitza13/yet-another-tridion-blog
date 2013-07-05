package mitza.net;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.ODataConsumers;
import org.odata4j.core.OEntity;
import org.odata4j.core.OLink;

public class ContentAssemblerServlet extends HttpServlet {

	private static final long serialVersionUID = -7794369747885244355L;

	private ODataConsumer client;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		String oDataEndpoint = servletConfig.getInitParameter("ODataEndpoint");
		client = ODataConsumers.create(oDataEndpoint);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		handleRequest(request, response);
	}

	private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String servletUrl = request.getRequestURI().substring(request.getContextPath().length());
		String filter = String.format("Url eq '%s'", servletUrl);
		Enumerable<OEntity> pageEntities = client.getEntities("Pages").filter(filter).expand("PageContent").top(2)
				.execute();

		int count = pageEntities.count();
		if (count == 0) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
			return;
		} else if (count == 2) {
			response.sendError(HttpServletResponse.SC_PRECONDITION_FAILED,
					"Multiple resources available for the same URL");
			return;
		}

		OEntity pageContentEntity = pageEntities.first().getLink("PageContent", OLink.class).getRelatedEntity();
		if (pageContentEntity == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found");
			return;
		}

		String pageContent = pageContentEntity.getProperty("Content", String.class).getValue();
		PrintWriter writer = response.getWriter();
		writer.print(pageContent);
	}
}
