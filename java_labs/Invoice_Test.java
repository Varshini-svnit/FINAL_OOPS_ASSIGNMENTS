package java_labs;


    class Invoice {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;
    	
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity=quantity; 
        this.pricePerItem=pricePerItem; 

    }
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    // Setter and Getter for partDescription
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public String getPartDescription() {
        return partDescription;
    }

    // Setter and Getter for quantity
    public void setQuantity(int quantity) {
        this.quantity = (quantity > 0) ? quantity : 0;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter and Getter for pricePerItem
    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = (pricePerItem > 0) ? pricePerItem : 0.0;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    // Method to calculate invoice amount
    public double getInvoiceAmount() {
        return quantity * pricePerItem;
    }
}

public class Invoice_Test {
    public static void main(String[] args) {
        
        Invoice i = new Invoice("1234", "telephone", 3, 100.99);

        // Display invoice details
        System.out.println("Part Number: " + i.getPartNumber());
        System.out.println("Part Description: " + i.getPartDescription());
        System.out.println("Quantity: " + i.getQuantity());
        System.out.printf("Price per Item: "+ i.getPricePerItem());
        System.out.printf("Invoice Amount: "+ i.getInvoiceAmount());

        // Test with invalid quantities and prices
        i.setQuantity(-5);
        i.setPricePerItem(-10);

        System.out.println("\nAfter setting invalid values:");
        System.out.println("Quantity: " + i.getQuantity());
        System.out.printf("Price per Item: "+ i.getPricePerItem());
        System.out.printf("Invoice Amount: "+ i.getInvoiceAmount());
    }
}

