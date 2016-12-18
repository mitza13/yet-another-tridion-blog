package com.mitza.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mitza.toolkit.domain.ItemTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing a Tridion Content Manager URI.
 *
 * @author Mihai Cadariu
 * @since 20.10.2015
 */
public class TcmUri {

    public static final TcmUri NULL_URI = new TcmUri(0, 0, 0);
    public static final int COMPONENT_TYPE = 16;
    private static final Pattern PATTERN = Pattern.compile("tcm:(\\d+)-(\\d+)(-(\\d+))??");

    @JsonProperty("p")
    private int publicationId;
    @JsonProperty("i")
    private int itemId;
    @JsonProperty("t")
    private int itemType;

    /**
     * Empty constructor
     */
    public TcmUri() {
    }

    /**
     * Create and initialize a new TcmUri
     *
     * @param publicationId int the Publication id
     * @param itemId        int the item id
     */
    public TcmUri(int publicationId, int itemId) {
        this(publicationId, itemId, ItemTypes.COMPONENT);
    }

    /**
     * Create and initialize a new TcmUri
     *
     * @param publicationId int the Publication id
     * @param itemId        int the item id
     * @param itemType      int the item type
     */
    public TcmUri(int publicationId, int itemId, int itemType) {
        this.publicationId = publicationId;
        this.itemId = itemId;
        this.itemType = itemType;
    }

    /**
     * Create and initialize a new TcmUri
     *
     * @param publicationId int the Publication id
     * @param itemId        int the item id
     * @param itemType      ItemType representing the item type
     */
    public TcmUri(int publicationId, int itemId, ItemTypes itemType) {
        this.publicationId = publicationId;
        this.itemId = itemId;
        this.itemType = itemType.getValue();
    }

    /**
     * Create and initialize a new TcmUri by parsing the given String representation
     *
     * @param tcmUri String representing the TcmUri to parse
     */
    public TcmUri(String tcmUri) {
        Matcher matcher = PATTERN.matcher(tcmUri);
        if (matcher.matches()) {
            publicationId = Integer.parseInt(matcher.group(1));
            itemId = Integer.parseInt(matcher.group(2));
            String groupType = matcher.group(4);
            if (groupType == null) {
                itemType = COMPONENT_TYPE;
            } else {
                itemType = Integer.parseInt(groupType);
            }
        } else {
            throw new TcmUriException(tcmUri + " is not a valid TCM Uri");
        }
    }

    /**
     * Checks whether the given TcmUri represents a valid TCM URI
     *
     * @param tcmUri String representing the TcmUri to parse
     * @return boolean true, if the given TcmUri is valid
     */
    public boolean isValid(String tcmUri) {
        return PATTERN.matcher(tcmUri).matches();
    }

    /**
     * Checks whether the given TcmUri equals this object
     *
     * @param other Object representing the other TcmUri to compare
     * @return boolean true, if the other TcmUri has the same Publication, item id and item type as this instance
     */
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TcmUri)) {
            return false;
        }

        TcmUri o = (TcmUri) other;

        return publicationId == o.getPublicationId() &&
                itemId == o.getItemId() &&
                itemType == o.getItemType();
    }

    /**
     * Return a String representation of this TcmUri
     *
     * @return String representating the current TcmUri
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("tcm:");
        sb.append(publicationId);
        sb.append("-");
        sb.append(itemId);

        if (itemType != COMPONENT_TYPE) {
            sb.append("-");
            sb.append(itemType);
        }

        return sb.toString();
    }

    /**
     * Return the current TcmUri Publication id
     *
     * @return int representing the current TcmUri Publication id
     */
    public int getPublicationId() {
        return publicationId;
    }

    /**
     * Return the current TcmUri item id
     *
     * @return int representing the current TcmUri item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Return the current TcmUri item type
     *
     * @return int representing the current TcmUri item type
     */
    public int getItemType() {
        return itemType;
    }

    /**
     * Return the current TcmUri item type as ItemTypes enumeration
     *
     * @return ItemTypes representing the current TcmUri item type
     */
    @JsonIgnore
    public ItemTypes getType() {
        return ItemTypes.fromInt(itemType);
    }
}
