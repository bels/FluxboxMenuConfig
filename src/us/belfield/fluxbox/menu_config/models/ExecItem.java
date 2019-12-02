package us.belfield.fluxbox.menu_config.models;

public class ExecItem{

	private String name;
	private String executable;
	private String path;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExecutable() {
		return executable;
	}
	public void setExecutable(String executable) {
		this.executable = executable;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}