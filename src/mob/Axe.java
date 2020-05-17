package Mob;

public class Axe extends Item {
	public Axe(int x, int y, int price) {
		super(x,y,price);
	}
	public void use(Player p) {
		int damage = ((int) (Math.random() *4)) + 1;
		p.getAttackPoint() = damage;
	}
}
