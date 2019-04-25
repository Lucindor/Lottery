package View;


import Model.LotteryModel;
import javafx.animation.*;
import javafx.scene.control.Button;


import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.ArrayList;


public class BottomArea extends VBox {

    private Ball ball;
    public Button btnPlay = new Button("Play");
    private LotteryModel model;



    public BottomArea(){
        super();
        model = new LotteryModel();

        this.getChildren().addAll(btnPlay);
        this.getStyleClass().add("bottomArea");

    }

    public void animation(ArrayList<Integer> numbers, ArrayList<Integer> lucky){

        StackPane stackPane = new StackPane();

        /** in case the user plays several times, the drawn balls disappear */
        getChildren().clear();
        getChildren().add(btnPlay);
        stackPane.getChildren().clear();

        /** Generating the 6 balls */
        for(int i = 0; i < numbers.size();i++){
            ball = new Ball(numbers.get(i), Color.WHITE);
            PathElement path1 = new MoveTo((800+(i*60)), 35);
            PathElement path2 = new LineTo(100+(i*60), 35);
            animationBall(stackPane, ball, path1, path2);

        }

        /** Generating the lucky number ball */
        Ball luckyBall = new Ball(lucky.get(0), Color.YELLOW);
            PathElement path1 = new MoveTo((800+(numbers.size()*60)), 35);
            PathElement path2 = new LineTo(100+(numbers.size()*60), 35);

        animationBall(stackPane, luckyBall, path1, path2);
        getChildren().add(stackPane);
    }

    private void animationBall(StackPane stackPane, Ball luckyBall, PathElement path1, PathElement path2) {
        Path path = new Path();
        path.getElements().add(path1);
        path.getElements().add(path2);
        RotateTransition rt = new RotateTransition(Duration.millis(500), luckyBall);
        rt.setByAngle(-360);
        rt.setCycleCount(8);
        rt.setAutoReverse(false);

        PathTransition move = new PathTransition(Duration.millis(4000), path, luckyBall);

        move.setAutoReverse(false);
        move.setCycleCount(1);
        rt.play();
        move.play();
        stackPane.getChildren().add(luckyBall);
    }
}

