package Mob;

public class Sword extends Item{
	public Sword(int x, int y, int price) {
		super(x,y,price);
	}
	public void use(Player p) {
		int damage = ((int) (Math.random() *7)) + 1;
		p.getAttackPoint() = damage;
	}
}
