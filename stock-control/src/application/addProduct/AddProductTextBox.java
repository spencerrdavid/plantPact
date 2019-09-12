package application.addProduct;

import application.products.Product;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 * A text box with a label.
 *
 * @author David Spencer
 * @version 1.0
 */
class AddProductTextBox extends HBox
{
    private TextField textField;

    /**
     * Constructor for AddProductTextBox
     *
     * @param name The name of the field
     * @param newProduct The Product object being created
     * @param type The type of the text field
     */
    public AddProductTextBox(String name, Product newProduct, AddProductEnum type)
    {
        super();

        Label nameLabel = new Label();
        nameLabel.setText(name);
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setMinWidth(180);

        textField = new TextField();
        HBox.setHgrow(textField, Priority.ALWAYS);
        textField.textProperty().addListener((observable, oldValue, newValue) ->
                newProduct.setFieldFromInput(newValue, type));

        setAlignment(Pos.CENTER);

        this.getChildren().addAll(nameLabel, textField);
    }
}
