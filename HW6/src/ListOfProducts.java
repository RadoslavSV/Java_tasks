import java.util.*;

public class ListOfProducts <E extends Product>{
    private ArrayList<E> products = new ArrayList<>();

    public ArrayList<E> getProducts() {
        return products;
    }

    public void addProduct(Product p1) {
        products.add((E) p1);
    }

    public void setProducts(ArrayList<E> products) {
        this.products = products;
    }

    public String[] toArray() {
        String[] strArr = new String[10];
        for(int i=0; i<10; i++) {
            strArr[i] = products.get(i).toString();
        }

        return strArr;
    }

    public void setup() {
        Random rand = new Random();
        ArrayList<Product> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            int INV_N = rand.nextInt(0, 101);
            String descr = "descr No. " + Integer.toString(i);
            Product.Category cat;
            if( INV_N%4==0 ) cat = Product.Category.B;
            else if( INV_N%5==0 ) cat = Product.Category.C;
            else if( INV_N%7==0 ) cat = Product.Category.D;
            else cat = Product.Category.A;
            double prc = rand.nextDouble(0, 1001);

            Product p1 = new Product(INV_N, descr, cat, prc);
            list.add((E) p1);
        }

        setProducts((ArrayList<E>) list);
    }

    public double averagePrice() {
        double sum = 0;
        for(var x : products) {
            sum += x.getPrice();
        }
        return sum/products.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for(var x : products) {
            res.append(x.toString());
            res.append(",");
        }
        res.setCharAt(res.length()-1, ']');

        return res.toString();
    }

    public static void main(String[] args)
    {
        ListOfProducts<Product> list = new ListOfProducts<Product>();
        list.setup();

        Product p1 = new Product(24, "descrrrrr", Product.Category.D, 6.50);
        list.addProduct(p1);

        System.out.println(list);
        System.out.printf("Average price = %.2f", list.averagePrice());
    }
}
