package application.main;

import application.addProduct.AddProductWindow;
import application.products.Product;
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
    private static Button showAllButton;
    private static Button beansButton;
    private static Button nutsButton;
    private static Button flourButton;
    private static Button pastaButton;
    private static Button riceButton;
    private static Button grainsButton;
    private static Button fruitButton;
    private static Button chocolateButton;
    private static Button[] productToggleButtons;
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
        updateProductListByType("all");
        addProductWindow.closeWindow();
        addProductWindow = null;    // for garbage collection
    }

    /**
     * Disables the Add Product button
     */
    public static void disableAddProductButton() {
        addProductButton.setDisable(false);
    }

    /**
     * Toggles products displayed by type.
     * @param type The product category to be displayed
     */
    private static void updateProductListByType(String type) {
        productList.toggleProducts(type);
        for (Button button : productToggleButtons) {
            if (button.getText().equals(type.substring(0, 1).toUpperCase() + type.substring(1))) {
                button.setDisable(true);
            } else {
                button.setDisable(false);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;

        showAllButton = new Button("Show All");
        showAllButton.setOnAction(e -> updateProductListByType("all"));
        beansButton = new Button("Beans");
        beansButton.setOnAction(e -> updateProductListByType("beans"));
        nutsButton = new Button("Nuts");
        nutsButton.setOnAction(e -> updateProductListByType("nuts"));
        flourButton = new Button("Flour");
        flourButton.setOnAction(e -> updateProductListByType("flour"));
        pastaButton = new Button("Pasta");
        pastaButton.setOnAction(e -> updateProductListByType("pasta"));
        riceButton = new Button("Rice");
        riceButton.setOnAction(e -> updateProductListByType("rice"));
        grainsButton = new Button("Grains");
        grainsButton.setOnAction(e -> updateProductListByType("grains"));
        fruitButton = new Button("Fruit");
        fruitButton.setOnAction(e -> updateProductListByType("fruit"));
        chocolateButton = new Button("Chocolate");
        chocolateButton.setOnAction(e -> updateProductListByType("chocolate"));

        productToggleButtons = new Button[] {showAllButton, beansButton, nutsButton, flourButton, pastaButton,
                riceButton, grainsButton, fruitButton, chocolateButton};

        for (Button button : productToggleButtons) {
            button.setMinWidth(50);
            button.setMaxWidth(150);
            button.setMinHeight(30);
            button.setMaxHeight(30);
            button.setId("productButton");
        }

        Pane toggleButtonsBox = new HBox(10);
        toggleButtonsBox.getChildren().addAll(showAllButton, beansButton, nutsButton, flourButton, pastaButton,
                riceButton, grainsButton, fruitButton, chocolateButton);
        toggleButtonsBox.setPadding(padding);

        addProductButton = new Button("Add Product");
        addProductButton.setOnAction(this::openAddProductWindow);

        for (Button button : new Button[] {addProductButton}) {
            button.setMinWidth(200);
            button.setMaxWidth(200);
            button.setMinHeight(40);
            button.setMaxHeight(40);
            button.setId("topButton");
        }

        Pane addProductBox = new HBox(addProductButton);
        addProductBox.setPadding(padding);

        HBox list = new HBox(productList);
        list.setMaxHeight(300);
        list.setMaxWidth(800);

        Pane topMenu = new BorderPane(toggleButtonsBox, null, null, null, null);

        root = new BorderPane(list, topMenu, null, addProductBox, null);
        root.setPrefSize(900, 450);

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
