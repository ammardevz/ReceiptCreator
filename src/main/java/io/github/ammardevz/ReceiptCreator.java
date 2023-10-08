package io.github.ammardevz;

import lombok.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReceiptCreator<T> {
    private List<T> items;
    private Function<T, Map<String, Object>> propertyExtractor;
    @NonNull
    private String customerName;
    @NonNull
    private String customerAddress;
    private String customerPhoneNumber;
    private float discount;
    @NonNull
    private String cashierName;
    private int receiptNumber;
    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;

    public String generateReceiptString() {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Error generating receipt: items list cannot be null or empty.");
        }

        if (customerName.isBlank()) {
            throw new IllegalArgumentException("Error generating receipt: customer name cannot be null or blank.");
        }

        if (discount < 0) {
            throw new IllegalArgumentException("Error generating receipt: discount cannot be negative.");
        }

        String storeName = this.storeName == null ? "Store name not provided" : this.storeName;
        String storeAddress = this.storeAddress == null ? "Store address not provided" : this.storeAddress;

        String formattedCustomerPhoneNumber = customerPhoneNumber == null ? "N/A" : customerPhoneNumber;
        String formattedStorePhoneNumber = storePhoneNumber == null ? "N/A" : storePhoneNumber;

        StringBuilder sb = new StringBuilder();
        sb.append(storeName).append("\n");
        sb.append(storeAddress).append("\n");
        sb.append(formattedStorePhoneNumber).append("\n\n");
        sb.append(customerName).append("\t\t\t\t").append(getFormattedDate()).append("\n");
        sb.append(customerAddress).append("\t\t\t\t").append("Receipt #").append(receiptNumber).append("\n");
        sb.append(formattedCustomerPhoneNumber).append("\t\t\t\t").append("Cashier: ").append(cashierName).append("\n\n");

        sb.append("------------------------------------------------------------\n");
        sb.append("Item                   Qty    Price   Subtotal\n");
        sb.append("------------------------------------------------------------\n");

        float subtotal = 0.0f;
        for (T item : items) {
            Map<String, Object> itemProperties = getItemProperties(item);
            float itemPrice = (float) itemProperties.get("price");
            int itemQuantity = (int) itemProperties.get("quantity");
            float itemSubtotal = itemPrice * itemQuantity;
            subtotal += itemSubtotal;
            sb.append(String.format("%-20s%6d%10s%10s\n", itemProperties.get("name"), itemQuantity,
                    getFormattedPrice(itemPrice), getFormattedPrice(itemSubtotal)));
        }

        sb.append("------------------------------------------------------------\n\n");

        float total = subtotal - (subtotal * discount);

        sb.append(String.format("Subtotal:\t\t\t\t%s\n", getFormattedPrice(subtotal)));
        sb.append(String.format("Discount:\t\t\t\t%s\n", getFormattedPrice(subtotal * discount)));
        sb.append(String.format("Total:\t\t\t\t\t%s\n\n", getFormattedPrice(total)));

        sb.append("Thank you for your business!\t\t\tHave a great day!");

        return sb.toString();
    }

    private Map<String, Object> getItemProperties(T item) {
        Map<String, Object> itemProperties = propertyExtractor.apply(item);
        if (!itemProperties.containsKey("price")) {
            try {
                throw new ReceiptGenerationException("Error generating receipt: missing 'price' property.");
            } catch (ReceiptGenerationException e) {
                throw new RuntimeException(e);
            }
        }
        return itemProperties;
    }

    private static String getFormattedPrice(float value) {
        return String.format("$%.2f", value);
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(new Date());
    }
}