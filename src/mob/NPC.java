package Mob;
import java.lang.Math;

import Main.ProjectGame;
import javafx.scene.paint.Color;

public class NPC extends Mob {
	public final String name;
	public NPC (ProjectGame game, int x, int y, String name) {
		super(game, "NPC", x, y, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, Color.GREEN, 2);
		this.name = name;
	}
	
	public double distance(Player p) {
		return(Math.sqrt(Math.pow(p.getx()-this.x, 2)+Math.pow(p.gety()-this.y, 2)));
	}

	public String getname() {
		return(this.name);
	}
	
	public int getx() {
		return(this.x);
	}
	public int gety() {
		return(this.y);
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
