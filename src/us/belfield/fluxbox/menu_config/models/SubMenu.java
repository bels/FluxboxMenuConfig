package us.belfield.fluxbox.menu_config.models;

import java.util.ArrayList;

public class SubMenu{

	private String name;
	private Boolean root_menu;
	private SubMenu parent;
	private ArrayList<SubMenu> children = new ArrayList<SubMenu>;
	private ArrayList<ExecItem> programs = new ArrayList<ExecItem>;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRootMenu() {
		return root_menu;
	}

	public void setRootMenu(Boolean root_menu) {
		this.root_menu = root_menu;
	}

	public SubMenu getParent() {
		return parent;
	}

	public void setParent(SubMenu parent) {
		this.parent = parent;
	}

	public ArrayList<SubMenu> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<SubMenu> children) {
		this.children = children;
	}

	public void addChildren(SubMenu child) {
		this.children.add(child);
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