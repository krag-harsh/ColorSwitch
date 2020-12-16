package sample;

import com.sun.prism.PhongMaterial;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class Ball {
    private int posX = 225;
    private int posY = 530;
    private float velocity = 0;
    private int color;
    private int starCount;
    private int score = -1;
    private Circle ball;
    //Timeline timeLine;

    double currentY;

    public float getVelocity() {
        return velocity;
    }



    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Circle getBall() {
        return ball;
    }

    public void setBall(Circle ball) {
        this.ball = ball;
    }

    public Ball(Group root, Scene gameplayScene, ImageView imageView){

            Color purpleColor = Color.rgb(141,20,249);
            Color yellowColor = Color.rgb(245,224,13);
            Color cyanColor = Color.rgb(54,225,243);
            Color magentaColor = Color.rgb(255,0,128);
            ball = new Circle(10.0f, Color.BLUE);
            ball.setLayoutX(posX);
            ball.setLayoutY(posY);
            ball.setFill(magentaColor);
            ball.setId("magenta");
            root.getChildren().add(ball);

            gameplayScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(score<0) {
                        Main.timeLine.play();
                        score = 0;
                        root.getChildren().remove(imageView);
                    }
                    if(keyEvent.getCode() == KeyCode.SPACE){
                        velocity = - 4;
                    }
                }
            });
            calculatePosition();


    }



    public int calculatePosition(){
        currentY = ball.getLayoutY();
       // System.out.println("CurrenY:"+currentY);
        Timeline updateCurrY = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentY = ball.getLayoutY();
            }
        }));
        updateCurrY.setCycleCount(Timeline.INDEFINITE);
        updateCurrY.play();

//        timeLine = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler <ActionEvent>() {
//
//
//            float ddy = 0.15f;//Acceleration due to gravity;
//
//            @Override
//            public void handle(ActionEvent t) {
//                //move the ball
//                //System.out.println("InCurrentY:" + ball.getLayoutY());
//                if(ball.getLayoutY() <= currentY-40){
//                    //System.out.println("Into If");
//                    for(Obstacle ob:obstacleArrayList){
//                        ob.moveDown();
//                    }
//                    Main.moveStars();
//                    currentY = ball.getLayoutY();
//                }
//
//                ball.setLayoutY(ball.getLayoutY() + velocity);
//                velocity = velocity + ddy;
//                if(ball.getLayoutY() >= 600){
//                    Main.endgameScreen(primaryStage);
//                    timeLine.stop();
//                }
//            }
//        }));
//        timeLine.setCycleCount(Timeline.INDEFINITE);
//
        return 0;
    }
    public void changePosition(){

    }

}
