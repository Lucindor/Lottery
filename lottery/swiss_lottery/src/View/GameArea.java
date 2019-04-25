package View;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameArea extends VBox {

    private Label lblTitle = new Label("Choose 6 numbers and one lucky number.");
    private GridPane numbers = new GridPane();
    public Button[] buttons = new Button[42];
    private Label spacer = new Label();
    private Label lblLuckyNumbers = new Label("Lucky numbers");
    private HBox hBoxLuckyNumbers = new HBox();
    public Button[] btnLuckyNumber = new Button[6];
    private Label spacer2 = new Label();

    public Button btnRandomNumbers = new Button("Generate random numbers");
    public Button btnConfirm = new Button("Confirm");

    private HBox hBoxButtons = new HBox(btnRandomNumbers, btnConfirm);


    public GameArea(){
        super();

        btnConfirm.setDisable(true);

        /** creating all 42 buttons for the numbers */
        for(int x = 0; x < buttons.length; x++){
            buttons[x]= new Button(Integer.toString(x+1));
            buttons[x].getStyleClass().add("numbers");
        }


        /**adding all 42 buttons to the gridpane */
        for(int i = 1; i <= buttons.length; i++){
            numbers.add((buttons[i-1]), (i-1)%6,(i-1)/6);
        }


        /**adding the 6 lucky numbers and add them to the HBox */

        for(int l = 0; l<btnLuckyNumber.length; l++){
            btnLuckyNumber[l] = new Button(Integer.toString(l+1));
            btnLuckyNumber[l].getStyleClass().add("luckyNumbers");
            hBoxLuckyNumbers.getChildren().add(btnLuckyNumber[l]);

        }


        getChildren().addAll(lblTitle, numbers, spacer,lblLuckyNumbers, hBoxLuckyNumbers, spacer2, hBoxButtons);


        /** adding styles */
        lblTitle.getStyleClass().add("test");
        this.getStyleClass().add("gameArea");
    }






}
