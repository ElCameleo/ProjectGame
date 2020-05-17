package Mob;

public class PowerPotion extends Item {
	public PowerPotion(int x, int y, int price) {
		super(x,y,price);
	}
	public void apply(Player player) {
		int a = ((int) (Math.random() *3)) + 1;
		player.addAttack(a);
	}
}
