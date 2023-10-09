# Receipt Creator
The ReceiptCreator class is a utility class that allows you to generate formatted receipts based on a set of items and customer information. It provides methods for generating a receipt string and formatting the date.


## License

[MIT](https://github.com/ammardevz/ReceiptCreator/blob/master/LICENSE)

## Usage

The ReceiptCreator library provides a straightforward and efficient way to generate receipts programmatically. It operates by following a logical flow that encompasses configuration, item management, customization, calculation, output formatting, error handling, and integration. Here's a more detailed explanation of how ReceiptCreator works:

- Configuration: To begin using ReceiptCreator, you start by configuring the necessary details for the receipt. This includes specifying customer information, such as their name and address, as well as important business information like the store name, address, and contact details. This configuration ensures that the receipt contains accurate and relevant information to represent a transaction effectively.

- Item Management: ReceiptCreator allows you to add items to the receipt. Each item is defined by its name, quantity, and price. You can add multiple items to reflect the specifics of the transaction. As you add items, ReceiptCreator performs calculations to determine the subtotal for each item and keeps a running total to calculate the final receipt total. This ensures accurate financial representation and provides a clear breakdown of costs to the customer.

- Customization: ReceiptCreator offers customization options to tailor the appearance of the receipt. You can adjust the layout, font styles, and placement of information to match your business branding and preferences. This customization allows you to create a professional and visually appealing receipt that aligns with your company's image. You can also incorporate additional information such as logos or company-specific details to further personalize the receipt.

- Calculation and Totals: As items are added to the receipt, ReceiptCreator performs calculations to determine the subtotal, discount (if applicable), and the final total amount. These calculations ensure accurate financial representation and assist in providing a clear breakdown of costs to the customer. The library handles the calculations automatically, simplifying the receipt generation process.

- Output Formats: ReceiptCreator supports various output formats, such as plain text, HTML, or PDF. Depending on your requirements, you can choose the format that best suits your needs. This flexibility allows you to seamlessly integrate the generated receipt into your existing systems or present it to customers in a preferred format. You can easily generate receipts in the desired format without having to worry about the underlying implementation details.

- Error Handling: ReceiptCreator incorporates error handling mechanisms to ensure the generation of reliable and error-free receipts. It validates user inputs and handles exceptional cases gracefully, providing informative error messages when necessary. This helps maintain the integrity of the receipt generation process and ensures accurate financial information. By handling errors effectively, ReceiptCreator enhances the overall reliability and stability of the receipt generation process.

- Integration: ReceiptCreator is designed to be easily integrated into your application workflow. You can incorporate it into your transactional processes, invoicing systems, or point-of-sale (POS) systems to automatically generate receipts after successful transactions. This integration streamlines your business operations and enables efficient receipt generation. By seamlessly integrating ReceiptCreator, you can automate the receipt generation process and improve the overall efficiency of your business workflows.

By following this logical flow, ReceiptCreator simplifies the process of generating receipts programmatically. It abstracts the complexities of receipt formatting, calculations, and customization, allowing developers to focus on the core functionality of their applications while delivering professional and accurate receipts to end-users.

### Dependecy
```xml
    <dependencies>
        <dependency>
            <groupId>com.github.ammardevz</groupId>
            <artifactId>receiptcreator</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```


### Example 1: Creating a Basic Receipt
```java
ReceiptCreator<Item> receiptCreator = ReceiptCreator.<Item>builder()
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
```apache
Output:

ABC Store
456 Elm St
N/A

John Doe                   10/09/2023
123 Main St                 Receipt #1
N/A                         Cashier: Jane Smith

------------------------------------------------------------
Item                   Qty    Price   Subtotal
------------------------------------------------------------
Item 1                      5     $9.99    $49.95
Item 2                      3    $12.99    $38.97
Item 3                      2    $24.99    $49.98
------------------------------------------------------------

Subtotal:                           $138.90
Discount:                             $0.00
Total:                              $138.90

Thank you for your business!               Have a great day!
```
### Example 2: Customizing Receipt Properties
```java
ReceiptCreator<Book> receiptCreator = ReceiptCreator.<Book>builder()
        .customerName("Jane Doe")
        .customerAddress("789 Oak St")
        .cashierName("John Smith")
        .receiptNumber(2)
        .storeName("XYZ Bookstore")
        .storeAddress("789 Maple Ave")
        .storePhoneNumber("123-456-7890")
        .discount(0.1f)
        .build();

String receiptString = receiptCreator.generateReceiptString();
System.out.println(receiptString);
```
```apache
Output:

XYZ Bookstore
789 Maple Ave
123-456-7890

Jane Doe                   10/09/2023
789 Oak St                  Receipt #2
N/A                         Cashier: John Smith

------------------------------------------------------------
Item                   Qty    Price   Subtotal
------------------------------------------------------------
Book 1                      2    $19.99    $39.98
Book 2                      1    $14.99    $14.99
Book 3                      3    $29.99    $89.97
------------------------------------------------------------

Subtotal:                            $144.94
Discount:                            $14.49
Total:                              $130.45

Thank you for your business!               Have a great day!
```

### Example 3: Handling Custom Item Objects
```java
ReceiptCreator<Product> receiptCreator = ReceiptCreator.<Product>builder()
        .customerName("Alice Smith")
        .customerAddress("456 Pine St")
        .cashierName("Bob Johnson")
        .receiptNumber(3)
        .storeName("XYZ Store")
        .storeAddress("789 Oak St")
        .storePhoneNumber("987-654-3210")
        .propertyExtractor(Product::toReceiptProperties)
        .items(Arrays.asList(
                new Product("Product 1", 2, 9.99f),
                new Product("Product 2", 3, 12.99f),
                new Product("Product 3", 1, 24.99f)
        ))
        .build();

String receiptString = receiptCreator.generateReceiptString();
System.out.println(receiptString);
```

```apache
Output:

XYZ Store
789 Oak St
987-654-3210

Alice Smith                10/09/2023
456 Pine St                 Receipt #3
N/A                         Cashier: Bob Johnson

------------------------------------------------------------
Item                   Qty    Price   Subtotal
------------------------------------------------------------
Product 1                   2     $9.99    $19.98
Product 2                   3    $12.99    $38.97
Product 3                   1    $24.99    $24.99
------------------------------------------------------------

Subtotal:                            $83.94
Discount:                             $0.00
Total:                              $83.94

Thank you for your business!               Have a great day!
```


## Authors

- [ammardev](https://www.github.com/ammardevz)

