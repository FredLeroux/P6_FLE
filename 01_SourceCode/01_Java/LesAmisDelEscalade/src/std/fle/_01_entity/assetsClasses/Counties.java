package std.fle._01_entity.assetsClasses;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "french_counties",schema = "cliff")
public class Counties extends ENT implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4250534379898825356L;
	
	@Id
	private Integer id;
	
	@Column(name = "county_number")
	private String countyNumber;
	
	@Column(name = "county_name")
	private String countyName;
	
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "french_state_fk")
	private States state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountyNumber() {
		return countyNumber;
	}

	public void setCountyNumber(String countyNumber) {
		this.countyNumber = countyNumber;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	
	

}
