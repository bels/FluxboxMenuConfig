package us.belfield.fluxbox.menu_config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import us.belfield.fluxbox.menu_config.models.*;
import us.belfield.fluxbox.menu_config.services.FluxboxMenu;
import us.belfield.fluxbox.menu_config.services.FluxboxFile;

public class MenuConfig extends Application{

	private Menu activeMenu = new Menu();
	TreeView<String> menuTree = new TreeView<String>();
	private FluxboxMenu menuService = new FluxboxMenu();
	private FluxboxFile fileService = new FluxboxFile();
	
	public MenuConfig(){
		
	}

	@Override
	public void start(Stage stage){

		FileChooser fileChooser = new FileChooser();

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
        Button loadMenuButton = new Button("Load Menu");
        Button addApplicationButton = new Button("Add Application");
        Button addSubMenuButton = new Button("Add Sub-Menu");

        //button actions
        loadMenuButton.setOnAction(
        	new EventHandler<ActionEvent>() {
        		@Override
        		public void handle(final ActionEvent e) {
        			File file = fileChooser.showOpenDialog(stage);
        			if(file != null) {
        				ArrayList<String> rawMenu = fileService.readFile(file.getPath());
        				activeMenu = menuService.newMenu(rawMenu);
        				
        				TreeItem<String> rootItem = new TreeItem<String>("Menu");
        				rootItem.setExpanded(true);

        				_constructMenuTree(rootItem);
        				menuTree.setRoot(rootItem);
        			}
        		}
        	}
        );
        buttonBox.getChildren().add(newMenuButton);
        buttonBox.getChildren().add(saveMenuButton);
        buttonBox.getChildren().add(loadMenuButton);
        buttonBox.getChildren().add(addApplicationButton);
        buttonBox.getChildren().add(addSubMenuButton);

        VBox menuTreeBox = new VBox();
        menuTreeBox.setAlignment(Pos.TOP_CENTER);
        Text menuTreeTitle = new Text("Menu");
        menuTreeBox.getChildren().add(menuTreeTitle);
        menuTreeBox.getChildren().add(menuTree);

        grid.add(buttonBox, 0, 1);
        grid.add(menuTreeBox, 1, 1);

        stage.show();
	}

	public static void main(String[] args) {
        Application.launch(args);
    }

	private void _constructMenuTree(TreeItem<String> rootItem){
		for(SubMenu m : activeMenu.getChildren()){
			this._buildTree(rootItem, m);
		}
		for(ExecItem e : activeMenu.getPrograms()) {
			//System.out.println(e.getName());
			rootItem.getChildren().add(new TreeItem<String>(e.getName()));
		}
	}

	private void _buildTree(TreeItem<String> parent, SubMenu menu) {
		
		for(SubMenu m : menu.getChildren()) {
			TreeItem<String> branch = new TreeItem<String>(m.getName());
			parent.getChildren().add(branch);
			this._buildTree(branch, m);
		}

		for(ExecItem e : menu.getPrograms()) {
			parent.getChildren().add(new TreeItem<String>(e.getName()));
		}
		
		return;
	}
}