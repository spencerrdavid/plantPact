package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The main class of the stock control system builds and displays the application
 * GUI and initializes all other components.
 *
 * @author David Spencer
 * @version 1.0
 */
public class Main extends Application {

    private static Stage stage;
    private static BorderPane root;

    private Insets padding = new Insets(5, 5, 5, 5);

    @Override
    public void start(Stage primaryStage) throws Exception{

        stage = primaryStage;

        Button newProduct = new Button("New Product");

        for (Button button : new Button[] {newProduct}) {
            button.setMinWidth(200);
            button.setMaxWidth(200);
            button.setMinHeight(40);
            button.setMaxHeight(40);
            button.setId("topButton");
        }

        Pane addProduct = new HBox(newProduct);
        addProduct.setPadding(padding);

        Pane topMenu = new BorderPane(addProduct, null, null, null, null);

        root = new BorderPane(null, topMenu, null, null, null);
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
