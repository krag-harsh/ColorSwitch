package sample;

import javafx.animation.*;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


import java.security.Key;

public class Square extends Obstacle{
    Group squareObstacle;
    Line line1,line2,line3,line4;
    Line Lines[];
    public Square(int posX, int posY, Object Orientation, Ball gameBall){
        Color purpleColor = Color.rgb(141,20,249);
        Color yellowColor = Color.rgb(245,224,13);
        Color cyanColor = Color.rgb(54,225,243);
        Color magentaColor = Color.rgb(255,0,128);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setOrientation(Orientation);
        this.setGameBall(gameBall);

        line1 = new Line();
        line1.setStrokeWidth(10);
        line1.setStroke(purpleColor);
        line1.setStartY(posY+90);
        line1.setEndY(posY-90);
        line1.setStartX(posX + 90);
        line1.setEndX(posX + 90);
        line1.setId("purple");

        line2 = new Line();
        line2.setStrokeWidth(10);
        line2.setStroke(yellowColor);
        line2.setStartY(posY+90);
        line2.setEndY(posY+90);
        line2.setStartX(posX + 90);
        line2.setEndX(posX - 90);
        line2.setId("yellow");

        line3 = new Line();
        line3.setStrokeWidth(10);
        line3.setStroke(cyanColor);
        line3.setStartY(posY+90);
        line3.setEndY(posY-90);
        line3.setStartX(posX - 90);
        line3.setEndX(posX - 90);
        line3.setId("cyan");

        line4 = new Line();
        line4.setStrokeWidth(10);
        line4.setStroke(magentaColor);
        line4.setStartY(posY-90);
        line4.setEndY(posY-90);
        line4.setStartX(posX + 90);
        line4.setEndX(posX - 90);
        line4.setId("magenta");

        Lines= new Line[4];
        Lines[0] = line1;
        Lines[1] = line2;
        Lines[2] = line3;
        Lines[3] = line4;
//        squareObstacle = new Group();
//        squareObstacle.getChildren().addAll(Lines[0],line2,line3,line4);
        Rotate rotate = new Rotate(15.0f,posX,posY);
        //rotate.setAngle(50);
//        squareObstacle.getTransforms().add(rotate);
        line1.getTransforms().add(rotate);
        line2.getTransforms().add(rotate);
        line3.getTransforms().add(rotate);
        line4.getTransforms().add(rotate);
        rotationTimeline = new Timeline();
        KeyFrame key1 = new KeyFrame(
                new javafx.util.Duration(0),
                new KeyValue(rotate.angleProperty(),0)
        );
        KeyFrame key2 =new KeyFrame(
                new javafx.util.Duration(2800),
                new KeyValue(rotate.angleProperty(),360)
        );
        rotationTimeline.setCycleCount(Animation.INDEFINITE);
        rotationTimeline.getKeyFrames().addAll(key1,key2);
        rotationTimeline.playFromStart();
//        RotateTransition rotate = new RotateTransition();
//        rotate.setAxis(Rotate.Z_AXIS);
//        rotate.setByAngle(360);
//        rotate.setCycleCount(Animation.INDEFINITE);
//        rotate.setDuration(Duration.INDEFINITE);
//        rotate.setAutoReverse(false);
//        rotate.setRate(0.10);
//        rotate.setInterpolator(Interpolator.LINEAR);
//        rotate.setNode(squareObstacle);
//        rotate.play();

        checkCollision();
    }
    @Override
    public void moveDown(){
        //System.out.println("Calling Move down");
        //squareObstacle.setLayoutY(squareObstacle.getLayoutY() + 20);
        for(Line line:Lines){
            line.setLayoutY(line.getLayoutY() + 20);
        }
    }
    @Override
    public Object getPosition() {

        return null;
    }

    @Override
    public Object getNewOrientation() {
        return null;
    }

    @Override
    public Boolean checkCollision() {

        line1.boundsInParentProperty().addListener((ChangeListener<? super Bounds>) new ChangeListener<Bounds>(){

            @Override
            public void changed(ObservableValue<? extends Bounds> observableValue, Bounds bounds, Bounds t1) {
                //System.out.println("Changed");
                for(Line line:Lines){
                    if(((Path)Shape.intersect(getGameBall().getBall(),line)).getElements().size() > 0){
                        System.out.println("Collision With " + line.getId());
                    }
                }
            }
        });
        return null;

    }
}
