package mob;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.GameObject;

public abstract class Mob extends GameObject {
	
	private Color color;
	protected int speed;

	public Mob(Scene scene, String name, int x, int y, int width, int height, Color color, int speed) {
		super(scene, name, x, y, width, height);
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
		gc.fillRect(x, y, width, height);
	}

}
