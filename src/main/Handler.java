package main;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import mob.Soldier;

public class Handler extends ArrayList<GameObject> {
	
	private ProjectGame game;
	
	public Handler (ProjectGame game) {
		this.game = game;
	}
	
	public GameObject exist (int[] pos) {
		for (GameObject obj: this) {
			if (pos[0] == obj.getX() && pos[1] == obj.getY()) return obj;
		}
		return null;
	}

	public void process(GraphicsContext gc) {
		for (GameObject obj: this) {
        	obj.update();
        	obj.render(gc);
        	obj.drawCollisionShape(gc);
        }
	}
	
	public void spawn (String name, int nb) {
		for (int i = 0 ; i < nb ; i++) {
			int[] pos = game.getCurrentRoom().getAvaiblePos();
			switch (name) {
				case "Soldier": this.add(new Soldier(game, pos[0], pos[1]));
			}
		}
	}
	
}
