package main;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectGame extends Application  {
	
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle("ProjectGame");
        stage.setWidth(1300);
		stage.setHeight(900);
		
		StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        Canvas canvas = new Canvas(700, 700);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        setup(gc);
        
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                update(gc);
            }
        }.start();
        
        stage.show();
    }
    
    private void setup(GraphicsContext gc) {
    	gc.setFill( Color.BLACK );
        gc.fillRect(0, 0, 700, 700);
    }
    
    private void update(GraphicsContext gc) {
    	gc.setFill( Color.BLACK );
        gc.fillRect(0, 0, 700, 700);
    	gc.setFill( Color.RED );
        gc.fillRect(Math.random()* 200 + 200,  400, 100, 100);
    }
}