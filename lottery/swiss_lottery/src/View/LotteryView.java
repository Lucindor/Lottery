package View;

import Model.LotteryModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LotteryView {

    private LotteryModel model;
    private Scene scene;
    private GameArea gameArea;
    private InformationArea informationArea;
    private MenuArea menuArea;
    private TicketListArea ticketListArea;
    public BottomArea bottomArea;
    private Tip tip;
    private BorderPane root;

    public LotteryView(Stage stage, LotteryModel model){
        this.model = model;


        model = new LotteryModel();
        root = new BorderPane();
        gameArea = new GameArea();
        informationArea = new InformationArea();
        menuArea = new MenuArea();
        ticketListArea = new TicketListArea();
        bottomArea = new BottomArea();
        tip = new Tip();

        root.setLeft(informationArea);
        root.setCenter(gameArea);
        root.setTop(menuArea);
        root.setRight(ticketListArea);
        root.setBottom(bottomArea);

        //setting scene and stage
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("lottery.css").toExternalForm());
        stage.setTitle("Swiss Lottery");
        stage.setResizable(false);
        root.getStyleClass().add("root");

        stage.setScene(scene);
        stage.show();
    }


    public MenuItem getBtnDarkMode(){ return menuArea.darkMode;}

    public MenuItem getBtnLottoMode(){ return menuArea.lottoMode;}

    public MenuItem getBtnExit(){ return menuArea.exit;}

    public MenuItem getBtnOdds(){ return menuArea.odds;}

    public MenuItem getBtnReset(){ return menuArea.reset;}

    public Button[] getButtons(){ return gameArea.buttons;}

    public Button[] getLuckyNumbers(){ return gameArea.btnLuckyNumber;}

    public Button getBtnSaveTip(){return gameArea.btnConfirm;}

    public Button getBtnGenerateRandom(){return  gameArea.btnRandomNumbers;}

    public TicketListArea getTicketListArea() {
        return ticketListArea;
    }
    public Button getBtnDelete() {return tip.btnDelete;}

    public Button getBtnPlay(){ return bottomArea.btnPlay;}

    public Tip getTip() { return tip;}

    public LotteryModel getModel(){ return  model;}





    public BorderPane getRoot(){ return root;}


}
