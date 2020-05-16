package room;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.GameObject;
import main.ProjectGame;

public class Room extends GameObject {
	
	private int size;

	public Room (Scene scene, int size) {
		super(scene, "ROOM", (ProjectGame.WIDTH - size * ProjectGame.CELLSIZE) / 2, (ProjectGame.HEIGHT - size * ProjectGame.CELLSIZE) / 2);
		this.size = size;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GraphicsContext gc) {
		
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);

		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				gc.fillRect(x + i * ProjectGame.CELLSIZE, y + j * ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE);
				gc.strokeRect(x + i * ProjectGame.CELLSIZE, y + j * ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE);
			}
		}
		
	}
	
}
