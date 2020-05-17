package Mob;

public class Spear extends Item {
	public Spear(int x, int y, int price) {
		super(x,y,price);
	}
	public void use(Player p) {
		int damage = ((int) (Math.random() *5)) + 1;
		p.getAttackPoint() = damage;
	}
}
