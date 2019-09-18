package application.main;

import application.addProduct.AddProductWindow;
import application.products.Product;
import application.products.ProductDataProcessor;
import application.products.ProductList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * The main class of the stock control system builds and displays the application
 * GUI and initializes all other components.
 *
 * @author David Spencer
 * @version 1.0
 */
public class Main extends Application
{
    private static Stage stage;
    private static BorderPane root;
    private static Button addProductButton;
    private static ProductList productList;
    private static AddProductWindow addProductWindow;

    private Insets padding = new Insets(5, 5, 5, 5);

    /**
     * Initializes the application.
     */
    public Main()
    {
        productList = new ProductList();
    }

    /**
     * Opens the AddProductWindow, from which a new product can be added to the list.
     * @param event The event that caused this method to be called
     */
    public void openAddProductWindow(Event event) {
        addProductWindow = new AddProductWindow();
        addProductWindow.start(new Stage());
        addProductButton.setDisable(true);
    }

    /**
     * Adds a product to the list of products.
     * @param product The product to be added.
     */
    public static void addProduct(Product product) {
        productList.addProduct(product);
        disableAddProductButton();
        addProductWindow.closeWindow();
        addProductWindow = null;    // for garbage collection
    }

    /**
     * Disables the Add Product button
     */
    public static void disableAddProductButton() {
        addProductButton.setDisable(false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        addProductButton = new Button("New Product");
        addProductButton.setOnAction(this::openAddProductWindow);

        for (Button button : new Button[] {addProductButton}) {
            button.setMinWidth(200);
            button.setMaxWidth(200);
            button.setMinHeight(40);
            button.setMaxHeight(40);
            button.setId("topButton");
        }

        Pane addProduct = new HBox(addProductButton);
        addProduct.setPadding(padding);

        HBox list = new HBox(productList);
        list.setMaxHeight(500);
        list.setMaxWidth(800);

        Pane topMenu = new BorderPane(addProduct, null, null, null, null);

        root = new BorderPane(list, topMenu, null, null, null);
        root.setPrefSize(900, 700);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

        stage.setTitle("PlantPact");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
