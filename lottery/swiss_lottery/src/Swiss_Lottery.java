import Controller.LotteryController;
import Model.LotteryModel;
import View.LotteryView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Swiss_Lottery extends Application {

    private LotteryModel model;
    private LotteryView view;
    private LotteryController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        model = new LotteryModel();
        view = new LotteryView(primaryStage, model);
        controller = new LotteryController(model, view);
    }
}
