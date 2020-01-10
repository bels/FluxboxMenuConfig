package us.belfield.fluxbox.menu_config.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.belfield.fluxbox.menu_config.models.Menu;
import us.belfield.fluxbox.menu_config.models.ExecItem;
import us.belfield.fluxbox.menu_config.models.SubMenu;

import us.belfield.fluxbox.menu_config.services.FluxboxMenu;

public class FluxboxFile{

	private final String menuFile = "~/.fluxbox/menu";

	public FluxboxFile() {
		
	}

	public void saveFile(Menu menu) {
		
	}

	public ArrayList<String> readFile(String file_location) {
		ArrayList<String> rawMenu = new ArrayList<String>();
	
		try {
			FileReader fileReader = new FileReader(file_location);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			

			while((line = bufferedReader.readLine()) != null) {
				rawMenu.add(line);
			}

			bufferedReader.close();
		} catch(FileNotFoundException ex) {
			//log this later
			System.out.println("Unable to open file: " + menuFile);
		} catch(IOException ex) {
			System.out.println("Error reading file: " + menuFile);
		}

		
		return rawMenu;
	}
}