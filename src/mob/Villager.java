package Mob;

import Main.ProjectGame;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Villager extends NPC{
	private int LifePoint;
	private int AttackPoint;
	public Villager(ProjectGame game, int x, int y, String name, int LifePoint, int AttackPoint) {
		super(game,x,y, name);
		this.LifePoint = LifePoint;
		this.AttackPoint = AttackPoint;
		game.scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseClickedEventHandler);
	}
	
	public String getname() {
		return(this.name);
	}
	public int getLifePoint() {
		return(this.LifePoint);
	}
	public int getAttackPoint() {
		return(this.AttackPoint);
	}
	private EventHandler<MouseEvent> mouseClickedEventHandler = (event -> {
		Stage newWindow = new Stage(); 
		newWindow.setTitle(this.getname());
		VBox root = new VBox(10); 
		HBox root2 = new HBox(10);
		HBox root3 = new HBox(10);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25));
		Label label = new Label("Bonjour voyageur, j'aurais une enigme à te poser si tu y réponds juste je t offrirai de l or, sinon tu devras m'affronter");
		label.setFont(Font.font("Avenir", 20));
		TextField enigme = new TextField("Qu'est ce qui monte et qui descend sans bouger ?");
		Button answer1Button = new Button("");
		Button answer2Button = new Button("Un escalier");
		Button answer3Button = new Button("");
		Button answer4Button = new Button("");
		
		answer1Button.setOnAction(e -> {
			if(e.getSource() == answer1Button || e.getSource() == answer3Button || e.getSource() == answer4Button) {
				newWindow.close();
				this.Attack(p);
			}
			else if (e.getSource() == answer2Button) {
				answer2Button.setText("Bravo tu as trouvé la bonne réponse");
				newWindow.close();
				p.getMoney() = p.getMoney() + 5;
			}
		});
		root2.getChildren().addAll(answer1Button,answer2Button);
		root3.getChildren().addAll(answer3Button,answer4Button);
		root.getChildren().addAll(label,root2,root3);
		Scene scene =new Scene(root);
		newWindow.setScene(scene);
		newWindow.show();
	});
}
