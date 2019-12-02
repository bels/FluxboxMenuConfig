package us.belfield.fluxbox.menu_config;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import us.belfield.fluxbox.menu_config.models.*;
import us.belfield.fluxbox.menu_config.services.FluxboxMenu;
import us.belfield.fluxbox.menu_config.services.FluxboxFile;

public class MenuConfig extends Application{

	private Menu fbMenu = new Menu();
	private FluxboxMenu menuService = new FluxboxMenu();
	private FluxboxFile fileService = new FluxboxFile();
	
	public MenuConfig(){
		
	}

	@Override
	public void start(Stage stage){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid,500,700); 

        stage.setTitle("Fluxbox Menuconfig");
        stage.setHeight(600);
        stage.setWidth(600);
        stage.setScene(scene);

        Text applicationTitle = new Text("Fluxbox Menu Config");
        grid.add(applicationTitle,0,0,2,1);

        VBox buttonBox = new VBox();
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        Button newMenuButton = new Button("New Menu");
        Button saveMenuButton = new Button("Save Menu");
        Button addApplicationButton = new Button("Add Application");
        Button addSubMenuButton = new Button("Add Sub-Menu");

        buttonBox.getChildren().add(newMenuButton);
        buttonBox.getChildren().add(saveMenuButton);
        buttonBox.getChildren().add(addApplicationButton);
        buttonBox.getChildren().add(addSubMenuButton);

        VBox menuTreeBox = new VBox();
        menuTreeBox.setAlignment(Pos.TOP_CENTER);
        Text menuTreeTitle = new Text("Menu");
        menuTreeBox.getChildren().add(menuTreeTitle);

        grid.add(buttonBox, 0, 1);
        grid.add(menuTreeBox, 1, 1);

        stage.show();
	}

	public static void main(String[] args) {
        Application.launch(args);
    }

	private TreeView constructMenuTree(){
		this.fbMenu = menuService.getMenu();
		//TreeItem<String> rootItem = new TreeItem<String>(menu.get(0));
		TreeItem<String> rootItem = new TreeItem<String>("Menu");
		rootItem.setExpanded(true);
		TreeView<String> tree = new TreeView<String>(rootItem);

		for(SubMenu m : this.fbMenu.getChildren()){
			
		}
		return tree;
	}
}