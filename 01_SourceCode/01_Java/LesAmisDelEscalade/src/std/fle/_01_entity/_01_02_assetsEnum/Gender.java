package std.fle._01_entity._01_02_assetsEnum;

public enum Gender {

	FEMALE("female.name"), MALE("male.name");

	private String genderNameKey;

	public String getGenderNameKey() {
		return genderNameKey;
	}

	private Gender(String genderKey) {
		this.genderNameKey = genderKey;
	}

}
