package main;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GameObject {

	protected String name;
	protected int x, y;
	protected int width, height;
	protected Scene scene;
	
	public GameObject(Scene scene, String name, int x, int y, int width, int height) {
		this.scene = scene;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject(Scene scene, String name, int x, int y) {
		this.scene = scene;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void render(GraphicsContext gc);
	
	public void drawCollisionShape (GraphicsContext gc) {
		if (ProjectGame.Debug.DRAWCOLLISIONSHAPE) {
			gc.setStroke(Color.GREEN);
			gc.strokeRect(x, y, width, height);
		}
	}
	
	
}
