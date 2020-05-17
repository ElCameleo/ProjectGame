package mob;

import javafx.scene.paint.Color;
import main.ProjectGame;

public class Soldier extends Mob {

	public Soldier(ProjectGame game, int x, int y) {
		super(game, "Soldier", x, y, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, Color.DARKGREEN, 1);
	}

	@Override
	public void move() {
		
	}

}
