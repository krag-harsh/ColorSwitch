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

import java.io.Serializable;
import java.util.ArrayList;

class ballSerialize implements Serializable{
    int posY;
    int score;
    String color;
    public ballSerialize(int posY,int score,String color){
        this.posY = posY;
        this.score = score;
        this.color = color;
    }
}
public class Ball {

    private int posX = 225;
    private int posY;
    private float velocity = 0;
    private int color;
    private int score = 0;
    private int start = -1;
    private Circle ball;
    public static Color purpleColor = Color.rgb(141,20,249);
    public static Color yellowColor = Color.rgb(245,224,13);
    public static Color cyanColor = Color.rgb(54,225,243);
    public static Color magentaColor = Color.rgb(255,0,128);
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

    public Ball(Group root, Scene gameplayScene, ImageView imageView,int posY,String Color){

            this.posY = posY;
            ball = new Circle(10.0f);
            ball.setLayoutX(posX);
            ball.setLayoutY(posY);
            ball.setId(Color);
            switch (Color) {
                case "magenta" -> ball.setFill(magentaColor);
                case "cyan" -> ball.setFill(cyanColor);
                case "purple" -> ball.setFill(purpleColor);
                case "yellow" -> ball.setFill(yellowColor);
            }
            root.getChildren().add(ball);

            gameplayScene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    if(start<0) {
                        Main.timeLine.play();
                        start = 0;
                        if(imageView != null) {
                            root.getChildren().remove(imageView);
                        }
                    }
                    Main.timeLine.play();
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
    public ballSerialize getSerializableObject(){
        ballSerialize b = new ballSerialize((int)this.ball.getLayoutY(),this.getScore(),this.ball.getId());
        return b;
    }

}
