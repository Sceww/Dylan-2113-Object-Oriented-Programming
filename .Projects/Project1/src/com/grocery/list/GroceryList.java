package com.grocery.list;
// import com.grocery.*;

public class GroceryList {
    private int listCount;       // How many groceries are in the list
    private String[] list;       // list holding String objects
    private boolean[] checkList; // Because the technical requirements demands this of me.

    public GroceryList() {
        list = new String[255];
        checkList = new boolean[255];
        listCount = -1;
    }

    // removes an item from the list, and moves the rest of the list down.
    private void pop(int idx) {
        for (int i = idx; i < listCount; i++) {
            list[i] = list[i+1]; // replace current item with next item in array.
            checkList[i] = checkList[i + 1];
        }
        // Last item in array is now a duplicate; remove it.
        list[listCount] = null;
        checkList[listCount] = false;
        listCount--; //There is now one less item in the stack, update listCount to reflect this.
    }

    private boolean isInt(String string) {
        boolean verdict;
        try {
            /* If string can be parsed, then isInt() can return with true */
            Integer.parseInt(string);
            verdict = true;
        } catch(Exception e) { 
            verdict = false;  // String does not contain a number
        }

        return verdict;
    }

    public boolean isEmpty() {
        return (listCount < 0);
    }

    /* Checks if name is already on list */
    public void addItem(String name) {

        if (!isEmpty()) { // Only check if list is NOT empty
            for (int idx = 0; idx <= listCount; idx++) {
                String itemName = list[idx];
                if (name.toLowerCase().equals(itemName.toLowerCase())) {
                    // Oops! We already this item...
                    System.out.printf("Not adding this item; already exist in list!\n", itemName);
                    return;
                }
            }
        }
        /* Add item to end of list */
        String newItem = name; // create item
        listCount++;                         // Move up list,
        list[listCount] = newItem;           // add item
        System.out.printf("Added '%s' to list!\n", list[listCount]);
    }

    /* removes item from list stack */
    public void removeItem(String nameOrID) {
        if (isEmpty()) { // safety check.
            System.out.println("List is empty!"); 
            return; 
        } 
        // check if int:
        if (isInt(nameOrID)) {
            /* Is a number */
            int idx = Integer.parseInt(nameOrID) - 1; // Index to remove
            if ((idx > listCount) || (idx < 0)) {
                System.out.println("Cannot remove this item; out of range!");
                return;
            }
            System.out.printf("Removing '%s' from list!\n", list[idx]);
            pop(idx); // pop item from list
            return; // return; item was successfully removed
        } else {
            /* Is a string; loop through list until the name is found. */
            for (int idx = 0; idx <= listCount; idx++) {
                String itemName = list[idx];
                if (nameOrID.toLowerCase().equals(itemName.toLowerCase())) {
                    // Item at idx matches nameOrID, let's pop it.
                    System.out.printf("Removing '%s' from list!\n", itemName);
                    pop(idx); // pop item from list
                    return; // return because item was successfully removed
                }
            }
        }
        // No items were found.
        System.out.println("The item specified wasn't found on the list; No items were removed.");
        return;
    }

    // checks off an item
    public void checkOffItem(String nameOrID) {
        if (isEmpty()) { // safety check.
            System.out.println("List is empty!"); 
            return; 
        } 
        // Check if int:
        if (isInt(nameOrID)) {
            /* Is a number */
            int idx = Integer.parseInt(nameOrID) - 1;
            if ((idx > listCount) || (idx < 0)) { 
                System.out.println("Could not check off; Item out of range!");
                return;
            } 
            // list[idx].checkOff(); 
            checkList[idx] = true;
            System.out.printf("'%s' was checked off!\n", list[idx]);
            return;
        } else {
            /* Is a string; loop through list until the name is found. */
            for (int idx = 0; idx <= listCount; idx++) {
                String itemName = list[idx];
                if (nameOrID.toLowerCase().equals(itemName.toLowerCase())) {
                    // A match was found at idx; check off and return
                    // list[idx].checkOff();
                    checkList[idx] = true;
                    System.out.printf("'%s' was checked off!\n", itemName);
                    return;
                }
            }
        }
        System.out.println("Item not found in list; No items were checked off.");
    }

    // prints out the grocery list
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        System.out.printf("Grocery List - %d items:\n", listCount+1);
        for (int idx = 0; idx <= listCount; idx++) {
            char mark;
            if (checkList[idx]) { mark = 'x'; } else { mark = '-'; } // Determines which char to use for the 'mark' when an item is checked off.
            String grocery = list[idx];
            System.out.printf("%d. %c %s\n", idx + 1, mark, grocery);
            // grocery.printInfo();
        }
    }
}