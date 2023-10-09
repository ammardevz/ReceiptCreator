# Receipt Creator
The ReceiptCreator class is a utility class that allows you to generate formatted receipts based on a set of items and customer information. It provides methods for generating a receipt string and formatting the date.


## License

[MIT](https://github.com/ammardevz/ReceiptCreator/blob/master/LICENSE)


## Authors

- [@ammardevz](https://www.github.com/ammardevz)

## Example 1: Creating a Basic Receipt
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

apache
Copy
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
## Example 2: Customizing Receipt Properties
```java
Copy
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

apache
Copy
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
```java
Example 3: Handling Custom Item Objects
java
Copy
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

apache
Copy
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
