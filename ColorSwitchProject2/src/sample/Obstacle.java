package sample;

import javafx.animation.*;
public abstract class Obstacle {
    private int posX;
    private int posY;
    private Object Orientation;
    private Ball gameBall;
    public Timeline rotationTimeline;
    public abstract void moveDown();
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Object getOrientation() {
        return Orientation;
    }

    public void setOrientation(Object orientation) {
        Orientation = orientation;
    }

    public Ball getGameBall() {
        return gameBall;
    }

    public void setGameBall(Ball gameBall) {
        this.gameBall = gameBall;
    }

    public void pauseTimeline(){
        this.rotationTimeline.pause();
    }
    public void resumeTimeline(){
        this.rotationTimeline.play();
    }

    public abstract Object getPosition();
    public abstract Object getNewOrientation();
    public abstract Boolean checkCollision();
}
