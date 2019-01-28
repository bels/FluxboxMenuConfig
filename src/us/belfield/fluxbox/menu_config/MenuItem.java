package us.belfield.fluxbox.menu_config;

public class MenuItem{

	private String name;
	private Integer level;
	private String parent;

	public MenuItem(){
	
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getParent(){
		return parent;
	}

	public void setParent(String parent){
		this.parent = parent;
	}

	public Integer getLevel(){
		return level;
	}

	public void setLevel(Integer level){
		this.level = level;
	}
}
