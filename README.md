# Receipt Creator
The ReceiptCreator class is a utility class that allows you to generate formatted receipts based on a set of items and customer information. It provides methods for generating a receipt string and formatting the date.

<img src="https://i.imgur.com/YXzpAkk.jpg" alt="Alt text" width="126" style="display: block; margin: auto;">


## License

[MIT](https://github.com/ammardevz/ReceiptCreator/blob/master/LICENSE)

## Usage

The ReceiptCreator library provides a straightforward and efficient way to generate receipts programmatically. It operates by following a logical flow that encompasses configuration, item management, customization, calculation, output formatting, error handling, and integration. Here's a more detailed explanation of how ReceiptCreator works:

- Configuration: To begin using ReceiptCreator, you start by configuring the necessary details for the receipt. This includes specifying customer information, such as their name and address, as well as important business information like the store name, address, and contact details. This configuration ensures that the receipt contains accurate and relevant information to represent a transaction effectively.

- Item Management: ReceiptCreator allows you to add items to the receipt. Each item is defined by its name, quantity, and price. You can add multiple items to reflect the specifics of the transaction. As you add items, ReceiptCreator performs calculations to determine the subtotal for each item and keeps a running total to calculate the final receipt total. This ensures accurate financial representation and provides a clear breakdown of costs to the customer.

- Calculation and Totals: As items are added to the receipt, ReceiptCreator performs calculations to determine the subtotal, discount (if applicable), and the final total amount. These calculations ensure accurate financial representation and assist in providing a clear breakdown of costs to the customer. The library handles the calculations automatically, simplifying the receipt generation process.

- Output Formats: ReceiptCreator supports various output formats, such as plain text, HTML, or PDF (User manual config needed). Depending on your requirements, you can choose the format that best suits your needs. This flexibility allows you to seamlessly integrate the generated receipt into your existing systems or present it to customers in a preferred format. You can easily generate receipts in the desired format without having to worry about the underlying implementation details.

- Error Handling: ReceiptCreator incorporates error handling mechanisms to ensure the generation of reliable and error-free receipts. It validates user inputs and handles exceptional cases gracefully, providing informative error messages when necessary. This helps maintain the integrity of the receipt generation process and ensures accurate financial information. By handling errors effectively, ReceiptCreator enhances the overall reliability and stability of the receipt generation process.

- Integration: ReceiptCreator is designed to be easily integrated into your application workflow. You can incorporate it into your transactional processes, invoicing systems, or point-of-sale (POS) systems to automatically generate receipts after successful transactions. This integration streamlines your business operations and enables efficient receipt generation. By seamlessly integrating ReceiptCreator, you can automate the receipt generation process and improve the overall efficiency of your business workflows.

By following this logical flow, ReceiptCreator simplifies the process of generating receipts programmatically. It abstracts the complexities of receipt formatting, calculations, and customization, allowing developers to focus on the core functionality of their applications while delivering professional and accurate receipts to end-users.

### Dependency - Maven
```xml
    <dependencies>
        <dependency>
            <groupId>com.github.ammardevz</groupId>
            <artifactId>receiptcreator</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```

### Dependency - Gradle
```groovy
dependencies {
    implementation 'com.github.ammardevz:receiptcreator:1.0.0'
}
```


### Example 1:
```java
        Function<Item, Map<String, Object>> propertyExtractor = item -> {
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", item.getName());
            properties.put("quantity", item.getQuantity());
            properties.put("price", item.getPrice());
            return properties;
        };

        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 2, 10.0f));
        items.add(new Item("Item 2", 1, 5.0f));

        ReceiptCreator<Item> receiptCreator = ReceiptCreator.<Item>builder()
                .items(items)
                .propertyExtractor(propertyExtractor)
                .customerName("John Doe")
                .customerAddress("123 Main St")
                .cashierName("Jane Smith")
                .receiptNumber(1)
                .storeName("ABC Store")
                .storeAddress("456 Elm St")
                .build();

        String receiptString = receiptCreator.generateReceiptString();
        System.out.println(receiptString);
```
### Example 2:
```java
ReceiptCreator<Item> receiptCreator = ReceiptCreator.<Item>builder()
        .items(Arrays.asList(
                new Item("Item 1", 2, 10.0f),
                new Item("Item 2", 1, 5.0f)
        ))
        .propertyExtractor(item -> {
            Map<String, Object> properties = new HashMap<>();
            properties.put("name", item.getName());
            properties.put("quantity", item.getQuantity());
            properties.put("price", item.getPrice());
            return properties;
        })
        .customerName("John Doe")
        .customerAddress("123 Main St")
        .cashierName("Jane Smith")
        .receiptNumber(1)
        .storeName("ABC Store")
        .storeAddress("456 Elm St")
        .build();

String receiptString = receiptCreator.generateReceiptString();
System.out.println(receiptString);
```

### Example 3:
```java
ReceiptCreator<Product> receiptCreator = ReceiptCreator.<Product>builder()
        .customerName("Alice Smith")
        .customerAddress("456 Pine St")
        .cashierName("Bob Johnson")
        .receiptNumber(3)
        .storeName("XYZ Store")
        .storeAddress("789 Oak St")
        .storePhoneNumber("987-654-3210")
        .propertyExtractor(product -> {
            Map<String, Object> properties = new HashMap<>();
            properties.put("productName", product.getProductName());
            properties.put("quantity", product.getQuantity());
            properties.put("price", product.getPrice());
            return properties;
        })
        .items(Arrays.asList(
                new Product("Product 1", 2, 9.99f),
                new Product("Product 2", 3, 12.99f),
                new Product("Product 3", 1, 24.99f)
        ))
        .build();

String receiptString = receiptCreator.generateReceiptString();
System.out.println(receiptString);
```


## Authors

- [ammardev](https://www.github.com/ammardevz)

