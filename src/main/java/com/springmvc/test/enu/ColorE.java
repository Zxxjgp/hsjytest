package com.springmvc.test.enu;

public class ColorE {
    /**
	 * 枚举名称
	 */
	private final String name = "";
	
	public String getName() {
		return name;
	}

	public static final ColorE blue = new ColorE() {
		public String getName() {
			return "blue";
		};
		
	};
}