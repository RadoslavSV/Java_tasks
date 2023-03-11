import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    private static ListOfProducts<Product> listOfProducts;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addToList;

    @FXML
    private Button averagePrice;

    @FXML
    private TextField categoryField;

    @FXML
    private TextField descriptionField;

    @FXML
    private TextArea dispField;

    @FXML
    private Button groupByCategory;

    @FXML
    private TextField priceField;

    @FXML
    private Button showProducts;

    @FXML
    private Button sortProducts;

    @FXML
    void clickAddToList(ActionEvent event) {
        Random rand = new Random();

        int INV = rand.nextInt(0, 101);

        String descr = String.valueOf(descriptionField.getCharacters());

        Product.Category cat = Product.Category.A;
        String catStr = String.valueOf(categoryField.getCharacters());
        if(catStr.equals("B")) cat = Product.Category.B;
        if(catStr.equals("C")) cat = Product.Category.C;
        if(catStr.equals("D")) cat = Product.Category.D;

        double prc = 0;
        try {
            prc = Double.parseDouble(String.valueOf(priceField.getCharacters()));
        } catch (NumberFormatException x) {
            System.out.println("Error: " + x.getMessage());
        }

        Product p1 = new Product(INV, descr, cat, prc);
        listOfProducts.addProduct(p1);

//        System.out.println(listOfProducts);
    }

    @FXML
    void clickSortProducts(ActionEvent event) {
        List<Product> list1 = listOfProducts.getProducts().stream().sorted(Comparator.comparing(Product::getPrice)).toList();
        ArrayList<Product> arr1 = new ArrayList<>(list1);
        listOfProducts.setProducts(arr1);

//        System.out.println(listOfProducts);
    }

    @FXML
    void clickAveragePrice(ActionEvent event) {
        double avgPrc = listOfProducts.averagePrice();
        dispField.setText(String.format("Average price of all products is %.2f\n", avgPrc));
    }

    @FXML
    void clickGroupByCategory(ActionEvent event) {
        List<Product> list1 =
                listOfProducts.getProducts().stream().sorted(Comparator.comparing(Product::getCategory).reversed()).toList();
        ArrayList<Product> arr1 = new ArrayList<>(list1);

        String res = "";
        for(var x : arr1) {
            res += String.format("Category: " + x.getCategory() + " | " + x.toString());
        }

        dispField.setText(res);
    }

    @FXML
    void clickShowProducts(ActionEvent event) {
        if(listOfProducts.getProducts().isEmpty()) {
            Platform.exit();
        }

        double currPrice = Double.parseDouble(String.valueOf(priceField.getCharacters()));
        ArrayList<Product> arr1 = listOfProducts.getProducts().stream().filter(x -> x.getPrice() > currPrice).collect(Collectors.toCollection(ArrayList::new));

        dispField.setText(arr1.toString());
    }

    @FXML
    void writeCategoryField(ActionEvent event) {}
    @FXML
    void writeDescriptionField(ActionEvent event) {}
    @FXML
    void writePriceField(ActionEvent event) {}

    @FXML
    void initialize() {
        assert addToList != null : "fx:id=\"addToList\" was not injected: check your FXML file 'hw6.fxml'.";
        assert averagePrice != null : "fx:id=\"averagePrice\" was not injected: check your FXML file 'hw6.fxml'.";
        assert categoryField != null : "fx:id=\"categoryField\" was not injected: check your FXML file 'hw6.fxml'.";
        assert descriptionField != null : "fx:id=\"descriptionField\" was not injected: check your FXML file 'hw6.fxml'.";
        assert dispField != null : "fx:id=\"dispField\" was not injected: check your FXML file 'hw6.fxml'.";
        assert groupByCategory != null : "fx:id=\"groupByCategory\" was not injected: check your FXML file 'hw6.fxml'.";
        assert priceField != null : "fx:id=\"priceField\" was not injected: check your FXML file 'hw6.fxml'.";
        assert showProducts != null : "fx:id=\"showProducts\" was not injected: check your FXML file 'hw6.fxml'.";
        assert sortProducts != null : "fx:id=\"sortProducts\" was not injected: check your FXML file 'hw6.fxml'.";

        listOfProducts = new ListOfProducts<>();
    }

}
