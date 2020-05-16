package mob;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import main.ProjectGame;

public class Player extends Mob {
	
	private int[] controls = { 0, 0, 0, 0 };

	public Player(ProjectGame game, int x, int y) {
		super(game, "Player", x, y, ProjectGame.CELLSIZE, ProjectGame.CELLSIZE, Color.RED, 2);
		game.scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
		game.scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
	}
	
	private EventHandler<KeyEvent> keyPressedEventHandler = (event -> {
    	switch (event.getCode().ordinal()) {
    		case 16: controls[0] = 1; break;
    		case 17: controls[1] = 1; break;
    		case 18: controls[2] = 1; break;
    		case 19: controls[3] = 1; break;
    	}
    });

    private EventHandler<KeyEvent> keyReleasedEventHandler = (event -> {
    	switch (event.getCode().ordinal()) {
			case 16: controls[0] = 0; break;
			case 17: controls[1] = 0; break;
			case 18: controls[2] = 0; break;
			case 19: controls[3] = 0; break;
	}
    });


	@Override
	public void move() {
		int newX = x + (controls[2] - controls[0]) * speed;
		int newY = y + (controls[3] - controls[1]) * speed;
		if (game.getCurrentRoom().canMoveTo(calculBorder(newX, newY))) {
			x = newX;
			y = newY;
		}
	}

}
