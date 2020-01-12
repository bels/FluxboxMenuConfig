package us.belfield.fluxbox.menu_config.models;

import java.util.ArrayList;

public class Menu{

	private String name;
	private String file_location;
	private String encoding;
	private ArrayList<String> includes = new ArrayList<String>();
	private ArrayList<SubMenu> children = new ArrayList<SubMenu>();
	private ArrayList<ExecItem> programs = new ArrayList<ExecItem>();

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Name: %s Encoding: %s", this.name,this.encoding);
	}

	public ArrayList<ExecItem> getPrograms() {
		return programs;
	}

	public void setPrograms(ArrayList<ExecItem> programs) {
		this.programs = programs;
	}

	public void addProgram(ExecItem program) {
		this.programs.add(program);
	}

	
}