package mob;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.GameObject;
import main.ProjectGame;

public abstract class Mob extends GameObject {
	
	private Color color;
	protected int speed;

	public Mob(ProjectGame game, String name, int x, int y, int width, int height, Color color, int speed) {
		super(game, name, x, y, width, height);
		this.color = color;
		this.speed = speed;
	}
	
	public abstract void move ();

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(color);
		gc.fillRect(x - width/2, y - height/2, width, height);
	}
	

}
