package com.mitza.toolkit.util;

import com.mitza.toolkit.domain.ComponentMetaImpl;
import com.mitza.toolkit.domain.ItemMeta;
import com.mitza.toolkit.domain.PageMetaImpl;
import com.mitza.util.TcmUri;

/**
 * Utility class providing helper functionality related to models.
 *
 * @author Mihai Cadariu
 * @since 04.02.2016
 */
public class ModelUtils {

    /**
     * Retrn the specialized type of an ItemMeta corresponding to the provided TcmUri. It returns either a ComponentMetaImpl
     * or PageMetaImpl class.
     *
     * @param tcmUri TcmUri the Tridion URI to use
     * @param <T>    specialization of ItemMeta; either ComponentMetaImpl or PageMetaImpl
     * @return the page or component meta class
     */
    public static <T extends ItemMeta> Class<T> getClass(TcmUri tcmUri) {
        switch (tcmUri.getType()) {
            case PAGE:
                return (Class<T>) PageMetaImpl.class;

            default:
                return (Class<T>) ComponentMetaImpl.class;
        }
    }
}
