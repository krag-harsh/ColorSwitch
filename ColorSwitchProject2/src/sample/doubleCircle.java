package sample;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.security.Key;

public class doubleCircle extends Obstacle{
    Group doubleCircleObstacle;
    Arc Arcs[];

    public doubleCircle(int posX,int posY,Object Orientation,Ball gameBall){
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
        arc1.setId("purple");
        arc1.setStrokeWidth(10);
        arc1.setCenterX(posX);
        arc1.setCenterY(posY);
        arc1.setRadiusX(90.0f);
        arc1.setRadiusY(90.0f);
        arc1.setStartAngle(270.0f);
        arc1.setLength(90.0f);
        arc1.setFill(Color.TRANSPARENT);
        arc1.setType(ArcType.OPEN);

        Arc arc1a =new Arc();
        arc1a.setStroke(purpleColor);
        arc1a.setId("purple");
        arc1a.setStrokeWidth(10);
        arc1a.setCenterX(posX);
        arc1a.setCenterY(posY);
        arc1a.setRadiusX(110.0f);
        arc1a.setRadiusY(110.0f);
        arc1a.setStartAngle(270.0f);
        arc1a.setLength(90.0f);
        arc1a.setFill(Color.TRANSPARENT);
        arc1a.setType(ArcType.OPEN);

        Arc arc2 = new Arc();
        arc2.setStroke(yellowColor);
        arc2.setId("yellow");
        arc2.setStrokeWidth(10);
        arc2.setCenterX(posX);
        arc2.setCenterY(posY);
        arc2.setRadiusX(90.0f);
        arc2.setRadiusY(90.0f);
        arc2.setStartAngle(180.0f);
        arc2.setLength(90.0f);
        arc2.setFill(Color.TRANSPARENT);
        arc2.setType(ArcType.OPEN);

        Arc arc2a = new Arc();
        arc2a.setStroke(yellowColor);
        arc2a.setId("yellow");
        arc2a.setStrokeWidth(10);
        arc2a.setCenterX(posX);
        arc2a.setCenterY(posY);
        arc2a.setRadiusX(110.0f);
        arc2a.setRadiusY(110.0f);
        arc2a.setStartAngle(180.0f);
        arc2a.setLength(90.0f);
        arc2a.setFill(Color.TRANSPARENT);
        arc2a.setType(ArcType.OPEN);

        Arc arc3 = new Arc();
        arc3.setStroke(cyanColor);
        arc3.setId("cyan");
        arc3.setStrokeWidth(10);
        arc3.setCenterX(posX);
        arc3.setCenterY(posY);
        arc3.setRadiusX(90.0f);
        arc3.setRadiusY(90.0f);
        arc3.setStartAngle(90.0f);
        arc3.setLength(90.0f);
        arc3.setFill(Color.TRANSPARENT);
        arc3.setType(ArcType.OPEN);


        Arc arc3a = new Arc();
        arc3a.setStroke(cyanColor);
        arc3a.setId("cyan");
        arc3a.setStrokeWidth(10);
        arc3a.setCenterX(posX);
        arc3a.setCenterY(posY);
        arc3a.setRadiusX(110.0f);
        arc3a.setRadiusY(110.0f);
        arc3a.setStartAngle(90.0f);
        arc3a.setLength(90.0f);
        arc3a.setFill(Color.TRANSPARENT);
        arc3a.setType(ArcType.OPEN);

        Arc arc4 = new Arc();
        arc4.setStroke(magentaColor);
        arc4.setId("magenta");
        arc4.setStrokeWidth(10);
        arc4.setCenterX(posX);
        arc4.setCenterY(posY);
        arc4.setRadiusX(90.0f);
        arc4.setRadiusY(90.0f);
        arc4.setStartAngle(0.0f);
        arc4.setLength(90.0f);
        arc4.setFill(Color.TRANSPARENT);
        arc4.setType(ArcType.OPEN);

        Arc arc4a = new Arc();
        arc4a.setStroke(magentaColor);
        arc4a.setId("magenta");
        arc4a.setStrokeWidth(10);
        arc4a.setCenterX(posX);
        arc4a.setCenterY(posY);
        arc4a.setRadiusX(110.0f);
        arc4a.setRadiusY(110.0f);
        arc4a.setStartAngle(0.0f);
        arc4a.setLength(90.0f);
        arc4a.setFill(Color.TRANSPARENT);
        arc4a.setType(ArcType.OPEN);

        Arcs = new Arc[8];
        Arcs[0] = arc1;
        Arcs[1] = arc1a;
        Arcs[2] = arc2;
        Arcs[3] = arc2a;
        Arcs[4] = arc3;
        Arcs[5] = arc3a;
        Arcs[6] = arc4;
        Arcs[7] = arc4a;




//        doubleCircleObstacle = new Group();
//        doubleCircleObstacle.getChildren().addAll(arc1,arc1a,arc2,arc2a,arc3,arc3a,arc4,arc4a);
//        Rotate rotate = new Rotate(5,posX,posY);
//        //rotate.setAngle(50);
//        circleObstacle.getTransforms().add(rotate);
//        Timeline timeline = new Timeline();
////        KeyFrame key1 = new KeyFrame(
////                new javafx.util.Duration(0),
////                new KeyValue(rotate.angleProperty(),0)
////        );
//        KeyFrame key2 =new KeyFrame(
//                new javafx.util.Duration(2500),
//                new KeyValue(rotate.angleProperty(),360)
//        );
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.getKeyFrames().addAll(key2);
//        timeline.playFromStart();
        Rotate rotate = new Rotate(15.0f,posX,posY);
        //rotate.setAngle(50);
//        squareObstacle.getTransforms().add(rotate);
        arc1.getTransforms().add(rotate);
        arc2.getTransforms().add(rotate);
        arc3.getTransforms().add(rotate);
        arc4.getTransforms().add(rotate);
        arc1a.getTransforms().add(rotate);
        arc2a.getTransforms().add(rotate);
        arc3a.getTransforms().add(rotate);
        arc4a.getTransforms().add(rotate);

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

        checkCollision();
    }
    @Override
    public void moveDown(){
        //System.out.println("Calling Move down");
        for(Arc arc:Arcs){
            arc.setLayoutY(arc.getLayoutY() + 20);
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
        Arcs[0].boundsInParentProperty().addListener((ChangeListener<? super Bounds>) new ChangeListener<Bounds>(){

            @Override
            public void changed(ObservableValue<? extends Bounds> observableValue, Bounds bounds, Bounds t1) {
                //System.out.println("Changed");
                for(Arc arc:Arcs){
                    if(((Path) Shape.intersect(getGameBall().getBall(),arc)).getElements().size() > 0){
                        System.out.println("Collision With " + arc.getId());
                    }
                }
            }
        });
        return null;
    }
}
