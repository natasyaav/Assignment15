import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
/**
 * Natasya Virgichalia
 * Date: 11/19/2017
 * Professor Tanes Kanchanawanchai
 * CSC-201.
 * Assignment 15.27
 * A program that displays a moving text from left to right circularly.
 * when it disappears in the right, it reappears from the left.
 * it pauses when the mouse is pressed
 */

public class movingText extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        int height = 500;
        int width = 500;
        Scene scene = new Scene (pane, width, height);
        double radius = Math.min(width, height) * 0.25;
        Circle round = new Circle(250, 250, radius, Color.TRANSPARENT);
        round.setStroke(Color.RED);
        round.setRotate(180);
        Text words = new Text("Programming is fun:)");
        PathTransition path = new PathTransition(Duration.seconds(10), round,words);
        path.setCycleCount(Timeline.INDEFINITE);
        path.play();
        FadeTransition fade = new FadeTransition(Duration.seconds(5), words);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.setAutoReverse(true);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.play();
        pane.setOnMousePressed(e-> {
            path.pause();
            fade.pause();
        });
        pane.setOnMouseReleased(e-> {
            path.play();
            fade.play();
        });

        pane.getChildren().addAll(words);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Moving Text");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}