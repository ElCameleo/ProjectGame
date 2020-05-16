package room;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.GameObject;
import main.ProjectGame;

public class Room extends GameObject {
	
	private int size;
	private ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

	public Room (ProjectGame game, int size) {
		super(game, "ROOM", (ProjectGame.WIDTH - size * ProjectGame.CELLSIZE) / 2, (ProjectGame.HEIGHT - size * ProjectGame.CELLSIZE) / 2);
		this.size = size;
		grid = RoomGenerator.generate(3, 2, 2, size);
	}
	
	private boolean checkBorders (int x, int y) {
		int nx = (x - this.x) / ProjectGame.CELLSIZE;
		int ny = (y - this.y) / ProjectGame.CELLSIZE;
		return (x - this.x) > 0 && (y - this.y) > 0 && nx >= 0 && nx < size && ny >= 0 && ny < size && grid.get(nx).get(ny) == 1;
	}
	
	public boolean canMoveTo (int[] borders) {
		
		boolean topLeft = checkBorders(borders[0], borders[2]);
		boolean topRight = checkBorders(borders[1], borders[2]);
		boolean downLeft = checkBorders(borders[0], borders[3]);
		boolean downRight = checkBorders(borders[1], borders[3]);
		
		return topRight && topLeft && downRight && downLeft ;
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
				if (grid.get(i).get(j) == 1) {
					gc.fillRect(x + i * ProjectGame.CELLSIZE, y + j * ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE);
					gc.strokeRect(x + i * ProjectGame.CELLSIZE, y + j * ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE);
				}
			}
		}
		
	}
	
}
