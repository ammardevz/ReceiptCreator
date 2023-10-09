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
// Create an instance of ReceiptCreator
ReceiptCreator<Item> receiptCreator = ReceiptCreator.<Item>builder()
    .items(items)
    .propertyExtractor(item -> {
        // Define the property extractor logic
        // ...
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
