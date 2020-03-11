package std.fle._01_entity._01_03_model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fle.toolBox.classType.ENT;
import std.fle._01_entity._01_01_assetsClasses.ClimbingLevels;
import std.fle._01_entity._01_01_assetsClasses.Counties;
import std.fle._01_entity._01_01_assetsClasses.States;
//@Entity
//@Table(name = "users_info")
public class UsersInfo extends ENT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8778656555947368495L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Integer age;
	private States state;
	
	
	private Counties county;
	
	
	private ClimbingLevels climbingLevel;
	
	@OneToOne(mappedBy = "users_info", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private UsersAccountInfo userAccountInfo;
	
}
