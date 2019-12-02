package us.belfield.fluxbox.menu_config.models;

import java.util.ArrayList;

public class Menu{

	private String file_location;
	private String encoding;
	private ArrayList<String> includes;
	private ArrayList<SubMenu> children;

	public String getFileLocation() {
		return file_location;
	}

	public void setFileLocation(String file_location) {
		this.file_location = file_location;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public ArrayList<String> getIncludes() {
		return includes;
	}

	public void setIncludes(ArrayList<String> includes) {
		this.includes = includes;
	} 

	public void addInclude(String include) {
		this.includes.add(include);
	}

	public ArrayList<SubMenu> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<SubMenu> children) {
		this.children = children;
	}

	public void addChild(SubMenu child) {
		this.children.add(child);
	}
}