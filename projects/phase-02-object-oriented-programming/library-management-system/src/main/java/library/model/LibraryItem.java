package library.model;

public class LibraryItem {
    private final String itemId;
    private String title;
    private final ItemType itemType;
    private ItemStatus status;

    public LibraryItem(String itemId, String title, ItemType itemType) {
        this.itemId = itemId;
        this.title = title;
        this.itemType = itemType;
        this.status = ItemStatus.AVAILABLE;

    }
}