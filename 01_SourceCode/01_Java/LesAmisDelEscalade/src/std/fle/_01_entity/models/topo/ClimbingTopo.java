package std.fle._01_entity.models.topo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;
import std.fle._01_entity.assetsClasses.States;
import std.fle._01_entity.models.users.UsersInfo;

@Entity
public class ClimbingTopo extends ENT {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9066782163940328678L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "edition_year")
	private LocalDate editionYear;
	
	@Column(name = "availabe")
	private Boolean available;
	
	@Column(name = "topo_description")
	private String topoDescription;
	
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_state_fk")
	private States state;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_info_fk")
	private UsersInfo userInfo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getEditionYear() {
		return editionYear;
	}

	public void setEditionYear(LocalDate editionYear) {
		this.editionYear = editionYear;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getTopoDescription() {
		return topoDescription;
	}

	public void setTopoDescription(String topoDescription) {
		this.topoDescription = topoDescription;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public UsersInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsersInfo userInfo) {
		this.userInfo = userInfo;
	}

}
