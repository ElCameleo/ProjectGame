package Mob;

public class Item {
	private int x;
	private int y;
	private int price;
	public Item(int x, int y, int price) {
		this.x=x;
		this.y=y;
		this.price=price;
	}
	public int getx() {
		return(this.x);
	}
	public int gety() {
		return(this.y);
	}
	public int getprice() {
		return(this.price);
	}
	public void setprice(int price) {
		this.price=price;
	}
}
