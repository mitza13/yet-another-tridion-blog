package mitza.coreservice.util;

/**
 * @author Mihai Cadariu
 */
public class TcmUri {

	public static final TcmUri NULL_URI = new TcmUri(0, 0, ItemTypes.NONE);

	private int publicationId;
	private int itemId;
	private ItemTypes itemType;
	private int version;

	/**
	 * Creates a TcmUri instance representing a Component
	 * 
	 * @param publicationId
	 *            the ID of the Publication
	 * @param itemId
	 *            the ID of the item
	 */
	public TcmUri(int publicationId, int itemId) {
		this(publicationId, itemId, ItemTypes.COMPONENT, 0);
	}

	/**
	 * Creates a TcmUri instance representing the latest version of an item
	 * 
	 * @param publicationId
	 *            the ID of the Publication
	 * @param itemId
	 *            the ID of the item
	 * @param itemType
	 *            the ItemTypes of the item
	 */
	public TcmUri(int publicationId, int itemId, ItemTypes itemType) {
		this(publicationId, itemId, itemType, 0);
	}

	/**
	 * Creates a TcmUri instance representing the latest version of an item
	 * 
	 * @param publicationId
	 *            the ID of the Publication
	 * @param itemId
	 *            the ID of the item
	 * @param itemType
	 *            the ID of the item type
	 */
	public TcmUri(int publicationId, int itemId, int itemType) {
		this(publicationId, itemId, ItemTypes.fromValue(itemType), 0);
	}

	/**
	 * Creates a TcmUri instance representing the latest version of an item
	 * 
	 * @param publicationId
	 *            the ID of the Publication
	 * @param itemId
	 *            the ID of the item
	 * @param itemType
	 *            the ItemTypes of the item
	 * @param version
	 *            the version of the item
	 */
	public TcmUri(int publicationId, int itemId, ItemTypes itemType, int version) {
		this.publicationId = publicationId;
		this.itemId = itemId;
		this.itemType = itemType;
		this.version = version;
	}

	/**
	 * Creates a TcmUri instance representing the latest version of an item
	 * 
	 * @param publicationId
	 *            the ID of the Publication
	 * @param itemId
	 *            the ID of the item
	 * @param itemType
	 *            the ID of the item type
	 * @param version
	 *            the version of the item
	 */
	public TcmUri(int publicationId, int itemId, int itemType, int version) {
		this(publicationId, itemId, ItemTypes.fromValue(itemType), version);
	}

	/**
	 * Creates a TcmUri instance by parsing a String representing a TCM URI.
	 * 
	 * @param tcmUri
	 *            String representing the TCM URI
	 * @param version
	 *            the version of the item
	 * @throws InvalidTcmUriException
	 *             if the TCM URI is not valid
	 */
	public TcmUri(String tcmUri, int version) {
		this(tcmUri);
		this.version = version;
	}

	/**
	 * Creates a TcmUri instance by parsing a String representing a TCM URI.
	 * 
	 * @param tcmUri
	 *            String representing the TCM URI
	 * @throws InvalidTcmUriException
	 *             if the TCM URI is not valid
	 */
	public TcmUri(String tcmUri) {
		if (!isValid(tcmUri)) {
			throw new InvalidTcmUriException();
		}

		String parts[] = tcmUri.substring(4).split("-");
		publicationId = Integer.parseInt(parts[0]);
		itemId = Integer.parseInt(parts[1]);

		if (parts.length == 2) {
			itemType = ItemTypes.COMPONENT;
		} else if (parts[2].startsWith("v")) {
			itemType = ItemTypes.COMPONENT;
			version = Integer.parseInt(parts[2].substring(1));
		} else {
			itemType = ItemTypes.fromValue(parts[2]);
		}

		if (parts.length == 4 && parts[3].startsWith("v")) {
			version = Integer.parseInt(parts[3].substring(1));
		}
	}

	/**
	 * Checks whether the TCM URI passed as parameter is valid. This simplified method only checks whether the TCM URI
	 * starts with "tcm:".
	 * 
	 * @param tcmUri
	 *            the TCM URI to validate
	 * 
	 * @return true, if the TCM URI starts with "tcm:"; false, otherwise
	 */
	public static boolean isValid(String tcmUri) {
		return tcmUri != null && tcmUri.startsWith("tcm:");
	}

	/**
	 * Returns a String representation of this TCM URI
	 * 
	 * @return String representing this TCM URI
	 */
	@Override
	public String toString() {
		return String.format("tcm:%d-%d%s%s", publicationId, itemId, itemType == ItemTypes.COMPONENT ? "" : "-" +
				itemType.getValue(), version == 0 ? "" : "-v" + version);
	}

	/**
	 * Checks whether the TCM URI passed as parameter is the same as the current TCM URI.
	 * 
	 * @return true, if the parameter TCM URI has the same toString() representation as this TCM URI; otherwise, false
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof TcmUri && ((TcmUri) obj).toString().equals(toString());
	}

	/**
	 * Gets the Publication ID part of this TCM URI
	 * 
	 * @return the Publication ID
	 */
	public int getPublicationId() {
		return publicationId;
	}

	/**
	 * Gets the item ID part of this TCM URI
	 * 
	 * @return the item ID
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * Gets the ItemType part of this TCM URI
	 * 
	 * @return the ItemType
	 */
	public ItemTypes getItemType() {
		return itemType;
	}

	/**
	 * Gets the version of this TCM URI
	 * 
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
}
