package View;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class InformationArea extends VBox {

    private Label lblTicketsUsed = new Label("Tickets used: ");


    public InformationArea(){
        super();

        this.getChildren().addAll(lblTicketsUsed);

        this.getStyleClass().add("informationArea");

    }
}
