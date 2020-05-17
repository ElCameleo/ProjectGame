package room;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import main.Assets;

public class RoomGenerator {
	
	private  ArrayList<ArrayList<Cell>> grid = new ArrayList<>();
	private ArrayList<int[]> spawnPosition = new ArrayList<>();
	
	public RoomGenerator (int pattern, int min, int max, int size) {

		class Destroyed extends ArrayList<int[]> {
			public boolean exist (int x, int y) {
				for (int i = 0 ; i < this.size() ; i++) {
					if (this.get(i)[0] == x && this.get(i)[1] == y) return true;
				}
				return false;
			}
		};
		int numbers = (int) (Math.random() * (max - min)) + min;
		Destroyed destroyed = new Destroyed();
		int x, y;
		for (int i = 0 ; i < numbers ; i++) {
			do {
				x = (int) (Math.random() * pattern);
				y = (int) (Math.random() * pattern);
			} while (destroyed.exist(x, y));
			destroyed.add(new int[] { x , y });
		}
		
		if (destroyed.exist(0, 1) && destroyed.exist(1, 0)) destroyed.add(new int[] { 0 , 0 });
		if (destroyed.exist(0, pattern - 2) && destroyed.exist(1, pattern - 1)) destroyed.add(new int[] { 0 , pattern - 1 });
		if (destroyed.exist(pattern - 2, 0) && destroyed.exist(pattern - 1, 1)) destroyed.add(new int[] { pattern - 1 , 0 });
		if (destroyed.exist(pattern - 2, pattern - 1) && destroyed.exist(pattern - 1, pattern - 2)) destroyed.add(new int[] { pattern - 1 , pattern - 1});
		
		for (int i = 0 ; i < size ; i++) {
			ArrayList<Cell> line = new ArrayList<>();
			for (int j = 0 ; j < size ; j++) {
				line.add(new Cell(destroyed.exist(i * pattern / size, j * pattern / size) ? 0 : 1));
			}
			grid.add(line);
		}
		
		for (int i = 0 ; i < pattern ; i++) {
			for (int j = 0 ; j < pattern ; j++) {
				if (!destroyed.exist(i, j)) spawnPosition.add(new int[] { (int) ((i+0.5) * size / pattern) , (int) ((j+0.5) * size / pattern) });
			}
		}
	}
	
	public  ArrayList<ArrayList<Cell>> getGrid () {
		return grid;
	}
	
	public ArrayList<int[]> getSpawnPosition () {
		return spawnPosition;
	}

}
