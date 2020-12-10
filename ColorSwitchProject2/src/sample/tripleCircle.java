package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.security.Key;

public class tripleCircle extends Obstacle{
    Group tripleCircleObstacle;
    public tripleCircle(int posX,int posY,Object Orientation,Ball gameBall){
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

        Arc arc1a =new Arc();
        arc1a.setStroke(purpleColor);
        arc1a.setStrokeWidth(10);
        arc1a.setCenterX(posX);
        arc1a.setCenterY(posY);
        arc1a.setRadiusX(110.0f);
        arc1a.setRadiusY(110.0f);
        arc1a.setStartAngle(270.0f);
        arc1a.setLength(90.0f);
        arc1a.setFill(Color.TRANSPARENT);
        arc1a.setType(ArcType.OPEN);

        Arc arc1b =new Arc();
        arc1b.setStroke(purpleColor);
        arc1b.setStrokeWidth(10);
        arc1b.setCenterX(posX);
        arc1b.setCenterY(posY);
        arc1b.setRadiusX(130.0f);
        arc1b.setRadiusY(130.0f);
        arc1b.setStartAngle(270.0f);
        arc1b.setLength(90.0f);
        arc1b.setFill(Color.TRANSPARENT);
        arc1b.setType(ArcType.OPEN);

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

        Arc arc2a = new Arc();
        arc2a.setStroke(yellowColor);
        arc2a.setStrokeWidth(10);
        arc2a.setCenterX(posX);
        arc2a.setCenterY(posY);
        arc2a.setRadiusX(110.0f);
        arc2a.setRadiusY(110.0f);
        arc2a.setStartAngle(180.0f);
        arc2a.setLength(90.0f);
        arc2a.setFill(Color.TRANSPARENT);
        arc2a.setType(ArcType.OPEN);

        Arc arc2b = new Arc();
        arc2b.setStroke(yellowColor);
        arc2b.setStrokeWidth(10);
        arc2b.setCenterX(posX);
        arc2b.setCenterY(posY);
        arc2b.setRadiusX(130.0f);
        arc2b.setRadiusY(130.0f);
        arc2b.setStartAngle(180.0f);
        arc2b.setLength(90.0f);
        arc2b.setFill(Color.TRANSPARENT);
        arc2b.setType(ArcType.OPEN);

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


        Arc arc3a = new Arc();
        arc3a.setStroke(cyanColor);
        arc3a.setStrokeWidth(10);
        arc3a.setCenterX(posX);
        arc3a.setCenterY(posY);
        arc3a.setRadiusX(110.0f);
        arc3a.setRadiusY(110.0f);
        arc3a.setStartAngle(90.0f);
        arc3a.setLength(90.0f);
        arc3a.setFill(Color.TRANSPARENT);
        arc3a.setType(ArcType.OPEN);

        Arc arc3b = new Arc();
        arc3b.setStroke(cyanColor);
        arc3b.setStrokeWidth(10);
        arc3b.setCenterX(posX);
        arc3b.setCenterY(posY);
        arc3b.setRadiusX(130.0f);
        arc3b.setRadiusY(130.0f);
        arc3b.setStartAngle(90.0f);
        arc3b.setLength(90.0f);
        arc3b.setFill(Color.TRANSPARENT);
        arc3b.setType(ArcType.OPEN);

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

        Arc arc4a = new Arc();
        arc4a.setStroke(magentaColor);
        arc4a.setStrokeWidth(10);
        arc4a.setCenterX(posX);
        arc4a.setCenterY(posY);
        arc4a.setRadiusX(110.0f);
        arc4a.setRadiusY(110.0f);
        arc4a.setStartAngle(0.0f);
        arc4a.setLength(90.0f);
        arc4a.setFill(Color.TRANSPARENT);
        arc4a.setType(ArcType.OPEN);

        Arc arc4b = new Arc();
        arc4b.setStroke(magentaColor);
        arc4b.setStrokeWidth(10);
        arc4b.setCenterX(posX);
        arc4b.setCenterY(posY);
        arc4b.setRadiusX(130.0f);
        arc4b.setRadiusY(130.0f);
        arc4b.setStartAngle(0.0f);
        arc4b.setLength(90.0f);
        arc4b.setFill(Color.TRANSPARENT);
        arc4b.setType(ArcType.OPEN);

        tripleCircleObstacle = new Group();
        tripleCircleObstacle.getChildren().addAll(arc1,arc1a,arc2,arc2a,arc3,arc3a,arc4,arc4a,arc1b,arc2b,arc3b,arc4b);
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
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE);
        rotate.setAutoReverse(false);
        rotate.setRate(0.10);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setNode(tripleCircleObstacle);
        rotate.play();
    }
    @Override
    public void moveDown(){
        //System.out.println("Calling Move down");
        tripleCircleObstacle.setLayoutY(tripleCircleObstacle.getLayoutY() + 20);

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
        return null;
    }
}
