package com.example.test.pojo;

public enum SexEnum {
	MAN(1,"man"),WOMAN(2,"woman")
	;
	private int value;

	SexEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	public static  SexEnum getEnumValueById(int id){
		for(SexEnum sexEnum:SexEnum.values()){
			if(sexEnum.getValue()==id){
				return sexEnum;
			}
		}
		return null;

	}

}
