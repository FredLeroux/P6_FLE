package std.fle._01_entity._01_01_assetsClasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;

@Entity
@Table(name = "french_climbing_level")
public class ClimbingLevels extends ENT implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -42199337324760169L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cotation_level")
	private String cotationLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCotationLevel() {
		return cotationLevel;
	}

	public void setCotationLevel(String cotationLevel) {
		this.cotationLevel = cotationLevel;
	}
	
	

}
