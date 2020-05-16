package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GameObject {

	protected String name;
	protected int x, y;
	protected int width, height;
	protected ProjectGame game;
	
	public GameObject(ProjectGame game, String name, int x, int y, int width, int height) {
		this.game = game;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject(ProjectGame game, String name, int x, int y) {
		this.game = game;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void render(GraphicsContext gc);
	
	public void drawCollisionShape (GraphicsContext gc) {
		if (ProjectGame.Debug.DRAWCOLLISIONSHAPE) {
			gc.setStroke(Color.GREEN);
			gc.strokeRect(x - width/2, y - height/2, width, height);
		}
	}
	
	public int[] calculBorder(int x, int y) {
		int[] borders = {
			x - width / 2,
			x + width / 2,
			y - height / 2,
			y + height / 2
		};
		return borders;
	}
	
	
}
