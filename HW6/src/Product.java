public class Product {
    enum Category {
        A,
        B,
        C,
        D
    }

    private final int INV_NUMBER;
    private String invDescription;
    private Category category;
    private double price;

    public Product() {
        this.INV_NUMBER = 0;
        this.invDescription = "";
        this.category = Category.A;
        this.price = 0;
    }

    public Product(int INV_NUMBER, String invDescription, Category category, double price) {
        this.INV_NUMBER = INV_NUMBER;
        this.invDescription = invDescription;
        this.category = category;
        this.price = price;
    }

    public int getINV_NUMBER() {
        return INV_NUMBER;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = invDescription;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("INV_NUMBER: %d | Description: %s | Price is %.2f\n", INV_NUMBER, invDescription, price);
    }

//    public static void main(String[] args) {
//        Product p1 = new Product(6000, "Has this meaning", Category.D, 54.12);
//        System.out.println(p1);
//    }
}
