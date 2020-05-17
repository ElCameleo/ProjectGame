package room;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import main.GameObject;
import main.ProjectGame;

public class Room extends GameObject {
	
	private int size;
	private ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
	private ArrayList<int[]> spawnPosition = new ArrayList<>();

	public Room (ProjectGame game, int size) {
		super(game, "ROOM", (ProjectGame.WIDTH - size * ProjectGame.CELLSIZE) / 2, (ProjectGame.HEIGHT - size * ProjectGame.CELLSIZE) / 2);
		this.size = size;
		
		RoomGenerator roomGenerator = new RoomGenerator(6, 4, 4, size);
		grid = roomGenerator.getGrid();
		spawnPosition = roomGenerator.getSpawnPosition();
	}
	
	private boolean checkBorders (int x, int y) {
		int nx = (x - this.x) / ProjectGame.CELLSIZE;
		int ny = (y - this.y) / ProjectGame.CELLSIZE;
		return (x - this.x) > 0 && (y - this.y) > 0 && nx >= 0 && nx < size && ny >= 0 && ny < size && grid.get(nx).get(ny).value == 1;
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
	
	private int[] roomToCart (int x, int y) {
		return new int[] {
				this.x + x * ProjectGame.CELLSIZE,
				this.y + y * ProjectGame.CELLSIZE,
		};
	}
	
	public int[] getAvaiblePos() {
		int randX, randY;
		int[] pos = spawnPosition.get((int) (Math.random() * spawnPosition.size()));
		spawnPosition.remove(pos);
		return roomToCart(pos[0], pos[1]);
	}

	@Override
	public void render(GraphicsContext gc) {
		
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.WHITE);
		gc.setLineWidth(2);

		for (int i = 0 ; i < size ; i++) {
			for (int j = 0 ; j < size ; j++) {
				if (grid.get(i).get(j).value == 1) {
					gc.drawImage((Image) grid.get(i).get(j).img, x + i * ProjectGame.CELLSIZE, y + j * ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE);
				}
			}
		}
		
	}
	
}
