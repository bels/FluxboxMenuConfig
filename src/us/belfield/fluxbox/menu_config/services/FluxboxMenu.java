package us.belfield.fluxbox.menu_config.services;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.belfield.fluxbox.menu_config.models.ExecItem;
import us.belfield.fluxbox.menu_config.models.Menu;
import us.belfield.fluxbox.menu_config.models.SubMenu;

public class FluxboxMenu{

	private Pattern menuPattern = Pattern.compile("\\[begin\\]\\s*\\((.+)\\).*",Pattern.DOTALL);
	private Pattern submenuPattern = Pattern.compile("\\[submenu\\]\\s*\\((.+)\\).*",Pattern.DOTALL);
	private Pattern execPattern = Pattern.compile("\\[exec\\]\\s*\\((.+)\\).*",Pattern.DOTALL);
	private Pattern executablePattern = Pattern.compile("\\{(.+)\\}.*",Pattern.DOTALL);
	private Pattern encodingPattern = Pattern.compile("\\[encoding\\]\\s*\\{(.+)\\}.*",Pattern.DOTALL);
	private Pattern endPattern = Pattern.compile("\\[end\\].*",Pattern.DOTALL);
	private ArrayList<String> rawMenu;
	public FluxboxMenu() {
		
	}

	public Menu newMenu(ArrayList<String> raw) {
		Menu menu = new Menu();

		rawMenu = raw;

		for (int i = 0; i <= rawMenu.size(); i++) {
			String line = rawMenu.get(i);
			Matcher menuMatcher = menuPattern.matcher(line);
			Matcher subMenuMatcher = submenuPattern.matcher(line);
			Matcher execMatcher = execPattern.matcher(line);

			if(menuMatcher.find()) {
				String name = menuMatcher.group(1);
				menu.setName(name);
				String encoding = "UTF-8";
				for (String encodingLine : rawMenu) {
					Matcher encodingMatcher = encodingPattern.matcher(encodingLine);
					if(encodingMatcher.find()) {
						menu.setEncoding(encodingMatcher.group(1));
					}
				}

				if(menu.getEncoding() == null || menu.getEncoding().isEmpty()) {
					menu.setEncoding(encoding);
				}

			}
			if(subMenuMatcher.find()) {
				String name = subMenuMatcher.group(1);
				this.buildSubMenu(menu, name, i);
			}
			if(execMatcher.find()) {
				
			}
		}


		return menu;
	}

	public Menu getMenu() {
		Menu menu = new Menu();
		return menu;
	}

	public void buildSubMenu(Menu parentMenu, String name, int startIndex ) {
		SubMenu submenu = new SubMenu();
		
		submenu.setName(name);

		this._buildSubMenu(submenu,startIndex);
		parentMenu.addChild(submenu);
	}

	public void buildSubMenu(SubMenu parentMenu, String name, int startIndex ) {
		SubMenu submenu = new SubMenu();
		
		submenu.setName(name);

		this._buildSubMenu(submenu,startIndex);
		parentMenu.addChildren(submenu);
	}

	public void addSeparator() {
		
	}

	private void _buildSubMenu(SubMenu submenu, int startIndex) {
		
		for (int i = startIndex; i < rawMenu.size(); i++) {
			String line = rawMenu.get(i);
			Matcher subMenuMatcher = submenuPattern.matcher(line);
			Matcher endMenuMatcher = endPattern.matcher(line);
			Matcher execMatcher = execPattern.matcher(line);
			Matcher executableMatcher = executablePattern.matcher(line);

			if(subMenuMatcher.find()) {
				String submenuName = subMenuMatcher.group(1);
				this.buildSubMenu(submenu, submenuName, i);
			}
			if(endMenuMatcher.find()) {
				return;
			}
			if(execMatcher.find()) {
				String executable = executableMatcher.group(1);
				String name = execMatcher.group(1);
				ExecItem execItem = new ExecItem();
				execItem.setExecutable(executable); //maybe break out the path and executable later
				execItem.setName(name);
			}
		}

	}
}