package us.belfield.fluxbox.menu_config;

public class MenuItem{

	private String name;
	private Integer level;
	private String parent;
	private ArrayList<MenuItem> children;
	private String executable;
	private String encoding;

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

	public String getEncoding(){
		return encoding;
	}

	public void setEncoding(String encoding){
		this.encoding = encoding;	
	}

	public ArrayList<MenuItem> getChildren(){
		return children;
	}

	public void addChild(MenuItem child){
		this.children.add(child);
	}

	public void setChildren(ArrayList<MenuItem> children){
		this.children = children;
	}

	public void deleteChild(MenuItem childToRemove){
		this.children.remove(childToRemove);
	}

	public String getExecutable(){
		return executable;
	}

	public void setExecutable(String exec){
		this.executable = exec;
	}
}
