package sample;

import com.sun.prism.PhongMaterial;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball {
    private int posX = 225;
    private int posY = 430;
    private float velocity = 0;
    private int color;
    private int starCount;
    private int score;
    Circle ball;
    Timeline timeLine;


    public Ball(Stage primaryStage, Group root, Scene gameplayScene){
            Color purpleColor = Color.rgb(141,20,249);
            Color yellowColor = Color.rgb(245,224,13);
            Color cyanColor = Color.rgb(54,225,243);
            Color magentaColor = Color.rgb(255,0,128);
            ball = new Circle(13.0f, Color.BLUE);
            ball.setLayoutX(posX);
            ball.setLayoutY(posY);
            ball.setFill(magentaColor);
            root.getChildren().add(ball);
        gameplayScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.SPACE){
                    velocity = velocity - 5;
                }
            }
        });
        timeLine = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler <ActionEvent>() {


            float ddy = 0.1f;//Acceleration due to gravity;

            @Override
            public void handle(ActionEvent t) {
                //move the ball
                ball.setLayoutY(ball.getLayoutY() + velocity);
                velocity = velocity + ddy;
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        timeLine.play();

    }



    public int calculatePosition(){
        return 0;
    }
    public void changePosition(){

    }

}
