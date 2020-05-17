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

public class Dealer extends NPC {
	int cpt;
	int cpt2;
	int cpt3;
	private HashSet<Item> store;
	private ArrayList<Item> list = new ArrayList<>();
	public Dealer(ProjectGame game , int x, int y, String name) {
		super(game, x, y,name);
		FillStore();
		game.scene.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseClickedEventHandler);
	}
	
	
	public void FillStore() {
		LifePotion lp = new LifePotion(this.getx(),this.gety(),2);
		MegaPotion mp = new MegaPotion(this.getx(),this.gety(),5);
		PowerPotion pp = new PowerPotion(this.getx(),this.gety(),3);
		list.add(lp);
		list.add(mp);
		list.add(pp);
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
			if(obj instanceof LifePotion) {
				cpt++;
			}
			else if(obj instanceof MegaPotion) {
				cpt2++;
			}
			else if(obj instanceof PowerPotion) {
				cpt3++;
			}
		}
			
		Button LifePotionButton = new Button("Potion de vie : Prix -> "+2+" | Nombre article restant -> "+cpt);
		Button PowerPotionButton = new Button("Potion de puissance : Prix -> "+3+" | Nombre article restant -> "+cpt2);
		Button MegaPotionButton = new Button("Mega potion de vie : Prix -> "+5+" | Nombre article restant -> "+cpt3);
		LifePotionButton.setOnAction(e -> {
			if(e.getSource() == LifePotionButton) {
				if(cpt>=0) {
					cpt = cpt-1;
					LifePotionButton.setText("Potion de vie : Prix -> "+2+" | Nombre article restant -> "+cpt);
				}
				for(Item obj : store) {
					if(obj instanceof LifePotion) {
						store.remove(obj);
						break;
					}
				}
			}else if(e.getSource() == PowerPotionButton) {
				if(cpt2>=0) {
					cpt2 = cpt2-1;
					LifePotionButton.setText("Potion de vie : Prix -> "+3+" | Nombre article restant -> "+cpt2);	
				}
				for(Item obj : store) {
					if(obj instanceof PowerPotion) {
						store.remove(obj);
						break;
					}
				}
			}
			else if(e.getSource() == MegaPotionButton) {
				if(cpt3>=0) {
					cpt3 = cpt3-1;
					LifePotionButton.setText("Potion de vie : Prix -> "+5+" | Nombre article restant -> "+cpt3);
				}
				for(Item obj : store) {
					if(obj instanceof MegaPotion) {
						store.remove(obj);
						break;
					}
				}
			}
		});
		root.getChildren().addAll(label,LifePotionButton,PowerPotionButton,MegaPotionButton);
		Scene scene =new Scene(root);
		newWindow.setScene(scene);
		newWindow.show();
		
	});
}
