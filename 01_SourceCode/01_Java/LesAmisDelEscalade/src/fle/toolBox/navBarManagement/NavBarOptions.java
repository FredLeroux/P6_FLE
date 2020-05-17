package fle.toolBox.navBarManagement;

public class NavBarOptions {

	private String name;
	private String href;
	private Integer position;

	public NavBarOptions(String name, String href, Integer position) {
		this.name = name;
		this.href = href;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
