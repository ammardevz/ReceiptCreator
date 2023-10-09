# ReceiptCreator Class

**Description:**
The `ReceiptCreator` class is a Java class that generates a receipt string based on a list of items and various properties. It provides methods to set and retrieve customer information, store information, and generate a formatted receipt string.

**Usage:**
- The class has a generic type `T` for the items in the receipt.
- It has various properties such as `items`, `propertyExtractor`, `customerName`, `customerAddress`, `customerPhoneNumber`, `discount`, `cashierName`, `receiptNumber`, `storeName`, `storeAddress`, and `storePhoneNumber`.
- The `generateReceiptString()` method generates a formatted receipt string based on the provided items and properties.
- The class performs validation checks for required fields and throws exceptions if they are not provided or have invalid values.
- It also provides helper methods such as `getFormattedPrice()` and `getFormattedDate()`.

**Example:**
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create a list of items
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 2, 10.99f));
        items.add(new Item("Item 2", 1, 5.99f));
        items.add(new Item("Item 3", 3, 7.99f));

        // Create an instance of ReceiptCreator
        ReceiptCreator<Item> receiptCreator = ReceiptCreator.<Item>builder()
                .items(items)
                .propertyExtractor(item -> {
                    // Define the property extractor logic
                    String itemName = item.getName();
                    int itemQuantity = item.getQuantity();
                    float itemPrice = item.getPrice();

                    // Create a map to hold the extracted properties
                    Map<String, String> properties = Map.of(
                            "Item Name", itemName,
                            "Quantity", String.valueOf(itemQuantity),
                            "Price", String.valueOf(itemPrice)
                    );

                    return properties;
                })
                .customerName("John Doe")
                .customerAddress("123 Main St")
                .cashierName("Jane Smith")
                .receiptNumber(1)
                .storeName("My Store")
                .storeAddress("456 Elm St")
                .build();

        // Generate the receipt string
        String receiptString = receiptCreator.generateReceiptString();
        System.out.println(receiptString);
    }
}

class Item {
    private String name;
    private int quantity;
    private float price;

    public Item(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
}
