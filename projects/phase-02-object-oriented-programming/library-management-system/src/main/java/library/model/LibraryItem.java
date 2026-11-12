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

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void borrow() {
        if (status != ItemStatus.AVAILABLE) {
            throw new IllegalStateException("Item is not available for borrowing.");
        }
        status = ItemStatus.BORROWED;
    }

    public void returnItem() {
        if (status != ItemStatus.BORROWED) {
            throw new IllegalStateException("Item is not currently borrowed.");
        }
        status = ItemStatus.AVAILABLE;
    }

    public void retire() {
        if (status == ItemStatus.RETIRED) {
            throw new IllegalStateException("Item is already retired.");
        }
        if (status == ItemStatus.BORROWED) {
            throw new IllegalStateException("Item cannot be retired while borrowed.");
        }
        status = ItemStatus.RETIRED;
    }
}