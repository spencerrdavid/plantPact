package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * The AddProductWindow class creates a new window for adding a product.
 *
 * @author David Spencer
 * @version 1.0
 */
public class AddProductWindow extends Application
{
    private Product newProduct;

    /**
     * Method used to add the new product to the application.
     * @param event the event that caused this call
     */
    private void save(ActionEvent event)
    {
        try {

        }
        catch (NullPointerException exception) {
            System.err.println("Something went wrong!");
        }
     }

    @Override
    public void start(Stage stage)
    {
        Label title = new Label("Add product:");
        title.setId("title");

        TextField name = new TextField();
        Button addButton = new Button("Add Product");
        addButton.setOnAction(this::save);
        addButton.setMinHeight(50);
        addButton.setMaxHeight(50);
        addButton.setMaxWidth(300);
        addButton.setMinWidth(300);
        addButton.setId("add-button");

        HBox buttonHBox = new HBox(addButton);
        buttonHBox.setId("button-hbox");
        buttonHBox.setAlignment(Pos.CENTER);

        BorderPane contents = new BorderPane();

        Scene scene = new Scene(contents, 700, 800);
//        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Add Product");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

}
