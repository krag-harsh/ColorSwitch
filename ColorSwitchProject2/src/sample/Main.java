package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<ImageView> Stars = new ArrayList<>();
    public static Timeline timeLine;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //Importing and Loading the image on main screen;
        mainMenu(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
    public static void mainMenu(Stage primaryStage) throws FileNotFoundException {
        //System.out.println(System.getProperty("user.dir"));
        Image image = new Image(new FileInputStream("library/logo.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(-78);
        imageView.setY(-30);
        imageView.setFitHeight(450);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);

        Image playlogo = new Image(new FileInputStream("library/playLogo.png"));
        ImageView imageView2 = new ImageView(playlogo);
        imageView2.setX(175);
        imageView2.setY(150);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);
        imageView2.setPreserveRatio(true);
        Group root =   new Group(imageView);
        root.getChildren().add(imageView2);
        //Creating a scene for the mainScreen;
        Scene mainScreen = new Scene(root,450,650);
        Color backgroundColor = Color.rgb(41,41,41);
        mainScreen.setFill(backgroundColor);
        //Play Button
//        Circle c = new Circle(50.0f,Color.rgb(93,93,93));
//        c.setLayoutX(225);
//        c.setLayoutY(200);
//        root.getChildren().add(c);
        //doubleCircle c1 = new doubleCircle(225,250,null,null);
        menuAnimation c1 = new menuAnimation(225,200);
        root.getChildren().addAll(c1.circleObstacle1,c1.circleObstacle2,c1.circleObstacle3);
//        Polygon triangle = new Polygon();
//        triangle.getPoints().addAll(255.0,200.00,
//                185.0,175.0,
//                185.0,225.0);
//        triangle.setFill(Color.WHITE);
//        triangle.setSmooth(true);
//        root.getChildren().add(triangle);
        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setMinSize(200,48);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               // System.out.println("Hello");
                try {
                    gameStart(primaryStage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        playButton.setLayoutX(132);
        playButton.setLayoutY(350);
        playButton.setStyle("-fx-background-color: #8d13fa;-fx-font-size: 1.5em; ");
        root.getChildren().add(playButton);


        //Resume Button
        Button resumeButton = new Button();
        resumeButton.setText("Resume");
        resumeButton.setMinSize(200,48);
        resumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Hello2");
                savedStateScene(primaryStage);
            }
        });
        resumeButton.setLayoutX(132);
        resumeButton.setLayoutY(450);
        resumeButton.setStyle("-fx-background-color: #f6df0b;-fx-font-size: 1.5em;  ");
        root.getChildren().add(resumeButton);

        //Exit Button
        Button exitButton = new Button();
        exitButton.setText("Exit");
        exitButton.setMinSize(200,48);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Exiting");
                System.exit(0);
            }
        });
        exitButton.setLayoutX(132);
        exitButton.setLayoutY(550);
        exitButton.setStyle("-fx-background-color: #ff0080; -fx-font-size: 1.5em;");


        root.getChildren().add(exitButton);
        primaryStage.setTitle("Color Switch:Main Menu");
        primaryStage.setScene(mainScreen);
        primaryStage.show();
    }
    public static void gameStart(Stage primaryStage) throws FileNotFoundException {
        ArrayList<Obstacle> obstacleArrayList = new ArrayList<>();
        primaryStage.setTitle("GamePlay");
        Group root =   new Group();
        //Creating a scene for the gameplayScreen;
        Scene gamePlayScene = new Scene(root,450,650);
        Color backgroundColor = Color.rgb(41,41,41);
        gamePlayScene.setFill(backgroundColor);
        //Adding Score Label
        Text score = new Text("Score:0");
        score.setFont(Font.font("WHITE", FontWeight.BOLD, FontPosture.REGULAR,20));
        score.setFill(Color.WHITE);
        score.setLayoutX(10);
        score.setLayoutY(20);
        score.setStrokeWidth(500);
        root.getChildren().add(score);
        //System.out.println(System.getProperty("user.dir"));
        Image finger = new Image(new FileInputStream("library/finger.jpeg"));
        ImageView imageView = new ImageView(finger);
        imageView.setX(135);
        imageView.setY(550);
        imageView.setFitHeight(50);
        imageView.setFitWidth(600);
        imageView.setPreserveRatio(true);
        root.getChildren().add(imageView);

        Ball gameBall = new Ball(primaryStage,root,gamePlayScene,imageView,obstacleArrayList);

        CircleObstacle obstacle1 = new CircleObstacle(225,200, null,gameBall);
        doubleCircle obstacle2 = new doubleCircle(225,-200,null,gameBall);
        tripleCircle obstacle3 = new tripleCircle(225,-600,null,gameBall);
        Plus obstacle4 = new Plus(150,-200,null,gameBall);
        root.getChildren().add(obstacle1.circleObstacle);
        root.getChildren().add(obstacle4.plusObstacle);
        root.getChildren().add(obstacle3.tripleCircleObstacle);
        obstacleArrayList.add(obstacle1);
        obstacleArrayList.add(obstacle4);
        obstacleArrayList.add(obstacle3);

        //Adding Star
        Image star = new Image(new FileInputStream("library/star.jpeg"));
        ImageView imageViewStar1 = new ImageView(star);
        imageViewStar1.setLayoutX(obstacle1.getPosX() - 20);
        imageViewStar1.setLayoutY(obstacle1.getPosY() - 20);
        imageViewStar1.setFitHeight(40);
        imageViewStar1.setFitWidth(40);
        imageViewStar1.setPreserveRatio(true);
        root.getChildren().add(imageViewStar1);
        Stars.add(imageViewStar1);
        //Adding PauseGame Button;
        Button pauseButton = new Button();
        pauseButton.setText("PauseGame");
        pauseButton.setMinSize(50,30);
//        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("GamePaused");
//            }
//        });
        pauseButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode() == KeyCode.P){
                    //System.out.println("Game Paused");
                    timeLine.pause();
                    pauseScreen(primaryStage,gamePlayScene,gameBall);
                }
            }
        });
        pauseButton.setLayoutX(370);
        pauseButton.setLayoutY(0);
        pauseButton.setStyle("-fx-background-color: #ff0080; -fx-font-size: 1em;");
        root.getChildren().add(pauseButton);

//        gamePlayScene.setOnMousePressed(e ->{
//            root.getChildren().remove(imageView);
//        });
//        gamePlayScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if(gameBall.getScore() < 0){
//                    gameBall.timeLine.play();
//                    gameBall.setScore(0);
//                    root.getChildren().remove(imageView);
//                }
//            }
//        });


        primaryStage.setScene(gamePlayScene);
        primaryStage.show();


    }
    public static void pauseScreen(Stage primaryStage,Scene gameplayScene,Ball gameBall){
        primaryStage.setTitle("Pause Screen");
        Group root = new Group();
        Scene pauseScene = new Scene(root,450,650);
        Color backgroundColor = Color.rgb(41,41,41);
        pauseScene.setFill(backgroundColor);
        //Resume Button
        Button resumeButton = new Button();
        resumeButton.setText("Resume");
        resumeButton.setMinSize(200,48);
//        resumeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                resumeGame(primaryStage,gameplayScene,gameBall);
//            }
//        });
        resumeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                resumeGame(primaryStage,gameplayScene,gameBall);
            }
        });
        resumeButton.setLayoutX(132);
        resumeButton.setLayoutY(250);
        resumeButton.setStyle("-fx-background-color: #f6df0b; -fx-font-size: 1.5em;");
        root.getChildren().add(resumeButton);

        Text score = new Text("Score:0");
        score.setFont(Font.font("WHITE", FontWeight.BOLD, FontPosture.REGULAR,20));
        score.setFill(Color.WHITE);
        score.setLayoutX(10);
        score.setLayoutY(20);
        score.setStrokeWidth(500);
        root.getChildren().add(score);
        //Save State Button
        Button saveButton = new Button();
        saveButton.setText("Save State");
        saveButton.setMinSize(200,48);
//        saveButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("State Saved");
//            }
//        });
        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("State Saved");
            }
        });
        saveButton.setLayoutX(132);
        saveButton.setLayoutY(450);
        saveButton.setStyle("-fx-background-color: #8d13fa; -fx-font-size: 1.5em;");
        root.getChildren().add(saveButton);
        primaryStage.setScene(pauseScene);
        primaryStage.show();
    }
    public static void resumeGame(Stage primaryStage,Scene gameplayScene,Ball gameBall){
        primaryStage.setScene(gameplayScene);
        timeLine.play();
        primaryStage.show();
    }
    public static void endgameScreen(Stage primaryStage){
        primaryStage.setTitle("EndGame Screen");
        Group root = new Group();
        Scene endgameScene = new Scene(root,450,650);
        Color backgroundColor = Color.rgb(41,41,41);
        endgameScene.setFill(backgroundColor);
        Text score = new Text("Score:0");
        score.setFont(Font.font("WHITE", FontWeight.BOLD, FontPosture.REGULAR,20));
        score.setFill(Color.WHITE);
        score.setLayoutX(10);
        score.setLayoutY(20);
        score.setStrokeWidth(500);
        root.getChildren().add(score);
        //Resume Button
        Button restartButton = new Button();
        restartButton.setText("Restart");
        restartButton.setMinSize(200,48);
//        restartButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                try {
//                    gameStart(primaryStage);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        restartButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    gameStart(primaryStage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        restartButton.setLayoutX(132);
        restartButton.setLayoutY(150);
        restartButton.setStyle("-fx-background-color: #f6df0b; -fx-font-size: 1.5em;");
        root.getChildren().add(restartButton);

        //Continue with points Button
        Button continueButton = new Button();
        continueButton.setText("Continue with Stars");
        continueButton.setMinSize(200,48);
//        continueButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Continuing with points...");
//            }
//        });
        continueButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Continuing with points...");
            }
        });
        continueButton.setLayoutX(132);
        continueButton.setLayoutY(250);
        continueButton.setStyle("-fx-background-color: #8d13fa; -fx-font-size: 1.5em;");
        root.getChildren().add(continueButton);

        //Main Menu Button
        Button menuButton = new Button();
        menuButton.setText("Main Menu");
        menuButton.setMinSize(200,48);
//        menuButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//               mainMenu(primaryStage);
//            }
//        });
        menuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    mainMenu(primaryStage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        menuButton.setLayoutX(132);
        menuButton.setLayoutY(350);
        menuButton.setStyle("-fx-background-color: #36e1f3; -fx-font-size: 1.5em;");
        root.getChildren().add(menuButton);
        primaryStage.setScene(endgameScene);
        primaryStage.show();
    }
    public static void moveStars(){
        for(ImageView star:Stars){
            star.setLayoutY(star.getLayoutY() + 20);
        }
    }
    public static void savedStateScene(Stage primaryStage){
        primaryStage.setTitle("Saved State Screen");
        Group root = new Group();
        Scene savedStateScene = new Scene(root,450,650);
        Color backgroundColor = Color.rgb(41,41,41);
        savedStateScene.setFill(backgroundColor);
        Text saveText = new Text("Reload from Saved State");
        saveText.setFont(Font.font("WHITE", FontWeight.BOLD, FontPosture.REGULAR,20));
        saveText.setFill(Color.WHITE);
        saveText.setLayoutX(120);
        saveText.setLayoutY(20);
        saveText.setStrokeWidth(500);
        root.getChildren().add(saveText);
        primaryStage.setScene(savedStateScene);
        primaryStage.show();
    }
    public static void startTimeline(Ball gameBall,Stage primaryStage){
        timeLine = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler <ActionEvent>() {


            float ddy = 0.15f;//Acceleration due to gravity;

            @Override
            public void handle(ActionEvent t) {
                //move the ball
                //System.out.println("InCurrentY:" + ball.getLayoutY());
                for(ImageView star:Stars){
                    System.out.println("Star" + (star.getLayoutY() + 20));
                    System.out.println("Ball" + gameBall.getBall().getLayoutY());
                    if((star.getLayoutY() + 20) >= gameBall.getBall().getLayoutY()){
                        star.setVisible(false);
                        //System.out.println("Test");
                    }
                }
                if(gameBall.getBall().getLayoutY() <= gameBall.getCurrentY()-40){
                    //System.out.println("Into If");
                    for(Obstacle ob:gameBall.getObstacleArrayList()){
                        ob.moveDown();
                    }
                    Main.moveStars();
                    gameBall.setCurrentY(gameBall.getBall().getLayoutY());
                }

                gameBall.getBall().setLayoutY(gameBall.getBall().getLayoutY() + gameBall.getVelocity());
                gameBall.setVelocity(gameBall.getVelocity() + ddy);
                if(gameBall.getBall().getLayoutY() >= 600){
                    Main.endgameScreen(primaryStage);
                    timeLine.stop();
                }
            }
        }));
        timeLine.setCycleCount(Timeline.INDEFINITE);

    }
}
