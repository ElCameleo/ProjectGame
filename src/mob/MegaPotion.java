package Mob;

public class MegaPotion extends Item {
	public MegaPotion (int x, int y, int price) {
		super(x,y,price);
	}
	public void apply(Player player) {
		int l = ((int) (Math.random() *7)) + 3;
		player.addLife(l);
	}
}
