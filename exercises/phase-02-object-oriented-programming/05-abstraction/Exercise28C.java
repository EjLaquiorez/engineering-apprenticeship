public class Exercise28C {

    static abstract class LibraryItem {
        public abstract void displayType();
    }

    abstract static class Magazine extends LibraryItem {

    }

    static class SpecialMagazine extends Magazine {
        public void displayType() {
            System.out.println("This is a special magazine.");
        }
    }

    public static void main(String[] args) {
        SpecialMagazine magazine = new SpecialMagazine();
        magazine.displayType();
    }
}