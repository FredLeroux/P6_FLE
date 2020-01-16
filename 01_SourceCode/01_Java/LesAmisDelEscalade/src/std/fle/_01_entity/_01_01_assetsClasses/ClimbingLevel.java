package std.fle._01_entity._01_01_assetsClasses;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fle.toolBox.classType.ENT;

public class ClimbingLevel extends ENT implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -42199337324760169L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "cotation_level")
	private String CotationLevel;

}
