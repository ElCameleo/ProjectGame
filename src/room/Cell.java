package room;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import main.Assets;

class Cell {
	public int value;
	public Image img;
	public Cell (int value) {
		this.value = value;
		if (this.value == 1) {
			int crop = (int) (Math.random() * 2);
			PixelReader reader = Assets.GROUND.getPixelReader();
			img = new WritableImage(reader, 0, crop * 16, 16, 16);
		}
	}
}