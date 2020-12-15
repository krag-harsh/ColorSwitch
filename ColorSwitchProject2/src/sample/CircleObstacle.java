package sample;

import javafx.animation.*;
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

public class CircleObstacle extends Obstacle{
    Group circleObstacle;
    Arc Components[];
    public CircleObstacle(int posX, int posY, Object Orientation, Ball gameBall){
        Color purpleColor = Color.rgb(141,20,249);
        Color yellowColor = Color.rgb(245,224,13);
        Color cyanColor = Color.rgb(54,225,243);
        Color magentaColor = Color.rgb(255,0,128);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setOrientation(Orientation);
        this.setGameBall(gameBall);
        Arc arc1 =new Arc();
        arc1.setStroke(purpleColor);
        arc1.setStrokeWidth(10);
        arc1.setCenterX(posX);
        arc1.setCenterY(posY);
        arc1.setRadiusX(90.0f);
        arc1.setRadiusY(90.0f);
        arc1.setStartAngle(270.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setType(ArcType.OPEN);
        arc1.setId("purple");

        Arc arc2 = new Arc();
        arc2.setStroke(yellowColor);
        arc2.setStrokeWidth(10);
        arc2.setCenterX(posX);
        arc2.setCenterY(posY);
        arc2.setRadiusX(90.0f);
        arc2.setRadiusY(90.0f);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setType(ArcType.OPEN);
        arc2.setId("yellow");

        Arc arc3 = new Arc();
        arc3.setStroke(cyanColor);
        arc3.setStrokeWidth(10);
        arc3.setCenterX(posX);
        arc3.setCenterY(posY);
        arc3.setRadiusX(90.0f);
        arc3.setRadiusY(90.0f);
        arc3.setStartAngle(90.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setType(ArcType.OPEN);
        arc3.setId("cyan");

        Arc arc4 = new Arc();
        arc4.setStroke(magentaColor);
        arc4.setStrokeWidth(10);
        arc4.setCenterX(posX);
        arc4.setCenterY(posY);
        arc4.setRadiusX(90.0f);
        arc4.setRadiusY(90.0f);
        arc4.setStartAngle(0.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setType(ArcType.OPEN);
        arc4.setId("magenta");

        Components = new Arc[4];
        Components[0] = arc1;
        Components[1] = arc2;
        Components[2] = arc3;
        Components[3] = arc4;
//        arc1.setLayoutX(posX);
//        arc1.setLayoutY(posY);
//        arc2.setLayoutX(posX);
//        arc2.setLayoutY(posY);
//        arc3.setLayoutX(posX);
//        arc3.setLayoutY(posY);
//        arc4.setLayoutX(posX);
//        arc4.setLayoutY(posY);

        parts = new Group();
        parts.getChildren().addAll(arc1,arc2,arc3,arc4);
        Rotate rotate = new Rotate(15.0f,posX,posY);
        //rotate.setAngle(50);
//        squareObstacle.getTransforms().add(rotate);
        arc1.getTransforms().add(rotate);
        arc2.getTransforms().add(rotate);
        arc3.getTransforms().add(rotate);
        arc4.getTransforms().add(rotate);
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
//        rotate.setNode(circleObstacle);
//        rotate.play();



        checkCollision();
    }
    @Override
    public void moveDown(){
        for(Arc arc:Components){
            arc.setLayoutY(arc.getLayoutY() + this.downValue);
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
        Components[0].boundsInParentProperty().addListener((ChangeListener<? super Bounds>) new ChangeListener<Bounds>(){

            @Override
            public void changed(ObservableValue<? extends Bounds> observableValue, Bounds bounds, Bounds t1) {
                //System.out.println("Changed");
                for(Arc arc:Components){
                    if(((Path)Shape.intersect(getGameBall().getBall(),arc)).getElements().size() > 0){
                        //System.out.println("Collision With " + arc.getId());
                        if(!getGameBall().getBall().getId().equals(arc.getId())){
                            System.out.println("Dead");
                        }
                    }
                }
            }
        });
        return null;
    }
}
