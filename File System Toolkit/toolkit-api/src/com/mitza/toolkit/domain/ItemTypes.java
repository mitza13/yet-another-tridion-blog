package com.mitza.toolkit.domain;

/**
 * Enumeration representing the types of a Tridion item
 *
 * @author Mihai Cadariu
 * @since 03.12.2015
 */
public enum ItemTypes {

    COMPONENT(16), COMPONENT_TEMPLATE(32), PAGE(64);

    private int value;

    /**
     * Create enumeration instance from the given type
     *
     * @param value int representing the item type
     */
    ItemTypes(int value) {
        this.value = value;
    }

    /**
     * Maps the given type to an enumeration instance
     *
     * @param value int representing the type to map from
     * @return ItemTypes the mapped enumeration instance, or null if given type cannot be mapped
     */
    public static ItemTypes fromInt(int value) {
        switch (value) {
            case 16:
                return COMPONENT;

            case 32:
                return COMPONENT_TEMPLATE;

            case 64:
                return PAGE;
        }

        return null;
    }

    /**
     * Return the int representation of this instance
     *
     * @return int the representation of this enumeration instance
     */
    public int getValue() {
        return value;
    }
}
