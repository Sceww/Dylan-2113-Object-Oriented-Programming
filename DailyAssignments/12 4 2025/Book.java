class Book {
    String title;
    int pageCount;

    Book(String title, int value) {
        this.title = title;
        this.pageCount = value;
    }

    public String toString() {
        return String.format("%s - %d pages", title, pageCount);
    }
    static void printList(Book[] list) {
        System.out.println("LIST:");
        for (Book b : list) {
            System.out.printf("  %s\n", b);
        }
    }

    static void insertionSortByPages(Book[] books) {
        for (int i = 1; i < books.length; i++) { 
            // get key
            Book key = books[i];

            for (int k = i-1; k >= -1; k--) {
                if (k == -1) {
                    // value is smaller than all other values; insert at 0.
                    books[0] = key;
                }
                else if (books[k].pageCount > key.pageCount) {
                    books[k+1] = books[k]; // move value right
                }
                else {
                    books[k+1] = key; // insert key into empty value
                    break;
                }
            }
        }
    }
    
    static void insertionSortRecursiveByPages(Book[] books, int n) {
        // n starts @ 1
        if (n == books.length) { return; }
        Book key = books[n];
        for (int i = n-1; i >= -1; i--) {
            if (i == -1) {
                books[0] = key;
            }
            else if (key.pageCount < books[i].pageCount) {
                // we gotta move the array to the right...
                books[i+1] = books[i];
            }
            else {
                books[i+1] = key;
                break;
            }
        }
        insertionSortRecursiveByPages(books, n+1);
    }

    static void insertionSortByTitle(Book[] books) {
        for (int i = 1; i < books.length; i++) { 
            // get key
            Book key = books[i];

            for (int k = i-1; k >= -1; k--) {
                if (k == -1) {
                    // value is smaller than all other values; insert at 0.
                    books[0] = key;
                }
                else if (books[k].title.compareToIgnoreCase(key.title) > 0) {
                    books[k+1] = books[k]; // move value right
                }
                else {
                    books[k+1] = key; // insert key into empty value
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Book[] list = {
            new Book("The Silent Forest", 320),
            new Book("Beyond the Horizon", 210),
            new Book("Chronicles of Aralon", 450),
            new Book("Midnight Library Tales", 275),
            new Book("Echoes of the Past", 390),
        };

        insertionSortByPages(list);
        printList(list);
        insertionSortByTitle(list);
        printList(list);
        insertionSortRecursiveByPages(list, 1);
        printList(list);

    }
}