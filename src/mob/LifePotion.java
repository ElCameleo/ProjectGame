package Mob;

public class LifePotion extends Item {
	public LifePotion(int x, int y, int price) {
		super(x,y,price);
	}
	public void apply(Player player) {
		int l = ((int) (Math.random() *3)) + 1;
		player.addLife(l);
	}
}
