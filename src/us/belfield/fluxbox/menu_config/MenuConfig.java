package us.belfield.fluxbox.menu_config;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuConfig extends Application{

	private FluxboxMenu fbMenu = new FluxboxMenu();
	
	public MenuConfig(){

	}

	@Override public void start(Stage stage){
		Scene scene = new Scene(new Group()); 

        stage.setTitle("Fluxbox Menuconfig");
        stage.setHeight(600);
        stage.setWidth(600);
        stage.setScene(scene); 
         
        stage.show(); 
	}

	public static void main(String[] args) {
        Application.launch(args);
    }

	private TreeView constructMenuTree(){
		ArrayList<MenuItem> menu = fbMenu.getMenu();
		//TreeItem<String> rootItem = new TreeItem<String>(menu.get(0));
		TreeItem<String> rootItem = new TreeItem<String>("Menu");
		rootItem.setExpanded(true);
		TreeView<String> tree = new TreeView<String>(rootItem);

		for(MenuItem m : menu){
			//first lets figure out what type of entry this is.
			if(m. .contains("SubMenu")){
				
			}
		}
		return tree;
	}
}
