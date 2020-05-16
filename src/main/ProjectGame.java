package main;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import mob.Player;
import room.Room;

public class ProjectGame extends Application  {
	
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 900;
	public static final int CELLSIZE = 50;
	public static final String NAME = "ProjectGame";

	public static class Debug {
		public static boolean DRAWCOLLISIONSHAPE = true;
	}
	
	private Room currentRoom;

	private ArrayList<GameObject> objects = new ArrayList<>();
	private Player player;
	public Scene scene;
	
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle(ProjectGame.NAME);
        stage.setWidth(ProjectGame.WIDTH);
		stage.setHeight(ProjectGame.HEIGHT);
		
		StackPane root = new StackPane();
        scene = new Scene(root);
        stage.setScene(scene);
        
        Canvas canvas = new Canvas(ProjectGame.WIDTH, ProjectGame.HEIGHT);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        setup(scene, gc);
        
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                update(gc);
            }
        }.start();
        
        stage.show();
    }
    
    private void setup(Scene scene, GraphicsContext gc) {
    	currentRoom = new Room(this, 12);
    	player = new Player(this, ProjectGame.WIDTH/2 - ProjectGame.CELLSIZE/2, ProjectGame.HEIGHT/2 - ProjectGame.CELLSIZE/2);
    	//objects.add(player);
    }
    
    private void update(GraphicsContext gc) {
    	gc.setFill( Color.BLACK );
        gc.fillRect(0, 0, ProjectGame.WIDTH, ProjectGame.HEIGHT);
        currentRoom.render(gc);
        for (GameObject obj: objects) {
        	obj.update();
        	obj.render(gc);
        	obj.drawCollisionShape(gc);
        }
    }
    
    public Room getCurrentRoom() {
		return currentRoom;
	}

}