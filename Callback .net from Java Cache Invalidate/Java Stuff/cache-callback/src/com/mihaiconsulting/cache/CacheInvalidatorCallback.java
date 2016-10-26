package com.mihaiconsulting.cache;

import com.codemesh.peer.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Decompiled from raw byte code
 *
 * @author Mihai Cadariu
 * @since 07.03.2016
 */
public class CacheInvalidatorCallback implements CacheInvalidator {

    private static final Logger log = LoggerFactory.getLogger(CacheInvalidatorCallback.class);

    private long _xmog_inst = 0L;
    private boolean _xmog_enabled = true;
    private boolean _xmog_synchronized = true;
    private long[] _xmog_cbs = null;

    public CacheInvalidatorCallback() {
    }

    public CacheInvalidatorCallback(long var1, long[] var3) {
        _xmog_inst = var1;
        _xmog_cbs = var3;
    }

    public CacheInvalidatorCallback(long var1, long[] var3, boolean var4) {
        _xmog_inst = var1;
        _xmog_cbs = var3;
        _xmog_synchronized = var4;
    }

    public synchronized void xmog_disable() {
        _xmog_enabled = false;
    }

    public long xmog_get_native() {
        return _xmog_inst;
    }

    private void xmog_throwRTE(Object value) {
        throw new RuntimeException("A Java exception of \"type not allowed by this method\" was thrown from JuggerNET.\\n" + value);
    }

    @Override
    public void invalidate(String key) {
        log.debug("Invalidate callback for key: {}", key);

        if (Thread.currentThread().getContextClassLoader() == null) {
            Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        }

        Value value = new Value();
        log.trace("about to call native code with inst={}, _xmog_cb={}", Long.toHexString(_xmog_inst), Long.toHexString(_xmog_cbs[0]));

        if (_xmog_enabled) {
            if (!_xmog_synchronized) {
                Value.callback_opt(this, _xmog_inst, _xmog_cbs[0], value, key);
            } else {
                synchronized (this) {
                    Value.callback_opt(this, _xmog_inst, _xmog_cbs[0], value, key);
                }
            }

            if (value.type == 1) {
                if (value.l instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) value.l;
                    log.error("Exception occurred", runtimeException);
                    throw runtimeException;
                }

                Constructor constructor = null;

                try {
                    constructor = RuntimeException.class.getConstructor(String.class, Throwable.class);
                } catch (Throwable throwable) {
                    log.error("Exception occurred", throwable);
                    xmog_throwRTE(value.l);
                }

                try {
                    RuntimeException runtimeException = (RuntimeException) constructor.newInstance("A Java exception of \"type not allowed by this method\" was thrown from JuggerNET.", value.l);
                    log.error("Exception occurred", runtimeException);
                    throw runtimeException;
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException | SecurityException exception) {
                    log.error("Exception occurred", exception);
                    xmog_throwRTE(value.l);
                }
            }
        }
    }
}
