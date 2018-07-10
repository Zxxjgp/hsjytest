package com.springmvc.test.enu;

public enum Gender {
    MAN(0,"男"), WOMEN(1,"女");
	
	private final int value;
	private final String name;
	
	Gender(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
}