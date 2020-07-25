package fle.toolBox.navBarManagement;

public class NavBarOptions {

	private String name;
	private String icon;
	private String href;
	private Integer position;

	public NavBarOptions(String name, String icon, String href, Integer position) {
		this.name = name;
		this.icon = icon;
		this.href = href;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}
