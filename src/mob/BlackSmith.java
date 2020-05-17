package Mob;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import Main.ProjectGame;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BlackSmith extends NPC {
	int cpt;
	int cpt2;
	int cpt3;
	private HashSet<Item> store;
	private ArrayList<Item> list = new ArrayList<>();
	public BlackSmith(ProjectGame game,int x, int y, String name) {
		super(game, x,y, name);
		FillStore();
		game.scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseClickedEventHandler);
	}
	
	
	public void FillStore() {
		Sword sword = new Sword(this.getx(),this.gety(),15);
		Axe axe = new Axe(this.getx(),this.gety(),8);
		Spear spear = new Spear(this.getx(),this.gety(),10);
		list.add(sword);
		list.add(axe);
		list.add(spear);
		this.store = new HashSet<Item>();
		Random random = new Random();
		for(int i=0; i<10; i++) {
			store.add(list.get(random.nextInt(list.size())));
		}
	}
	
	public String getName() {
		return(this.name);
	}
	private EventHandler<MouseEvent> mouseClickedEventHandler = (event -> {
		Stage newWindow = new Stage(); 
		newWindow.setTitle("Magasin");
		VBox root = new VBox(10); 
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25));
		Label label = new Label("Bienvenue dans mon magasin !".toUpperCase());
		
		for(Item obj : store) {
			if(obj instanceof Sword) {
				cpt++;
			}
			else if(obj instanceof Axe) {
				cpt2++;
			}
			else if(obj instanceof Spear) {
				cpt3++;
			}
		}
			
		Button SwordButton = new Button("Epée : Prix -> "+15+" | Nombre article restant -> "+cpt);
		Button AxeButton = new Button("Hache : Prix -> "+8+" | Nombre article restant -> "+cpt2);
		Button SpearButton = new Button("Lance : Prix -> "+10+" | Nombre article restant -> "+cpt3);
		SwordButton.setOnAction(e -> {
			if(e.getSource() == SwordButton) {
				if(cpt>=0) {
					cpt = cpt-1;
					SwordButton.setText("Epée : Prix -> "+15+" | Nombre article restant -> "+cpt);
				}
				for(Item obj : store) {
					if(obj instanceof Sword) {
						store.remove(obj);
						break;
					}
				}
			}else if(e.getSource() == AxeButton) {
				if(cpt2>=0) {
					cpt2 = cpt2-1;
					AxeButton.setText("Hache : Prix -> "+8+" | Nombre article restant -> "+cpt2);	
				}
				for(Item obj : store) {
					if(obj instanceof Axe) {
						store.remove(obj);
						break;
					}
				}
			}
			else if(e.getSource() == SpearButton) {
				if(cpt3>=0) {
					cpt3 = cpt3-1;
					SpearButton.setText("Lance : Prix -> "+10+" | Nombre article restant -> "+cpt3);
				}
				for(Item obj : store) {
					if(obj instanceof Spear) {
						store.remove(obj);
						break;
					}
				}
			}
		});
		root.getChildren().addAll(label,SwordButton,AxeButton,SpearButton);
		Scene scene =new Scene(root);
		newWindow.setScene(scene);
		newWindow.show();
		
	});
}
