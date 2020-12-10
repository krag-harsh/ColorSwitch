package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Rhombus extends Obstacle{
    Group rhombusObstacle;
    public Rhombus(int posX, int posY, Object Orientation, Ball gameBall){
        Color purpleColor = Color.rgb(141,20,249);
        Color yellowColor = Color.rgb(245,224,13);
        Color cyanColor = Color.rgb(54,225,243);
        Color magentaColor = Color.rgb(255,0,128);
        this.setPosX(posX);
        this.setPosY(posY);
        this.setOrientation(Orientation);
        this.setGameBall(gameBall);

        Line line1 = new Line();
        line1.setStrokeWidth(10);
        line1.setStroke(purpleColor);
        line1.setStartY(posY+90);
        line1.setEndY(posY-90);
        line1.setStartX(posX + 90);
        line1.setEndX(posX + 120);

        Line line2 = new Line();
        line2.setStrokeWidth(10);
        line2.setStroke(yellowColor);
        line2.setStartY(posY+90);
        line2.setEndY(posY+90);
        line2.setStartX(posX + 90);
        line2.setEndX(posX - 90);

        Line line3 = new Line();
        line3.setStrokeWidth(10);
        line3.setStroke(cyanColor);
        line3.setStartY(posY+90);
        line3.setEndY(posY-90);
        line3.setStartX(posX - 90);
        line3.setEndX(posX - 60);

        Line line4 = new Line();
        line4.setStrokeWidth(10);
        line4.setStroke(magentaColor);
        line4.setStartY(posY-90);
        line4.setEndY(posY-90);
        line4.setStartX(posX + 120);
        line4.setEndX(posX - 60);


        rhombusObstacle = new Group();
        rhombusObstacle.getChildren().addAll(line1,line2,line3,line4);
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
        rotate.setNode(rhombusObstacle);
        rotate.play();
    }
    @Override
    public void moveDown(){
        //System.out.println("Calling Move down");
        rhombusObstacle.setLayoutY(rhombusObstacle.getLayoutY() + 20);

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
