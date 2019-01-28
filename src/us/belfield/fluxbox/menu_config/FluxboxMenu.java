package us.belfield.fluxbox.menu_config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FluxboxMenu{

	private ArrayList<String> menu = new ArrayList<String>();
	private String menu_location = new String("~/.fluxbox/menu");
	private FileReader reader;

	public FluxboxMenu(){
		
	}

	private void readMenu(){
		try{
			reader = new FileReader(menu_location);
		} catch(FileNotFoundException e){
			System.out.println(String.join(" ", "Could not find menu file:", menu_location));
		}
		BufferedReader br = new BufferedReader(reader);

		String line;
		try{
			while((line = br.readLine()) != null){
				menu.add(line);
			}
		}catch(IOException ioError){
			System.out.println("Error reading menu file");
		}
	}

	public HashMap<String,String> getMenu(){
		HashMap<String, String> organizedMenu = new HashMap<String,String>();
		readMenu();

		return organizedMenu;
	}

	public void SaveMenu(){
		
	}
}