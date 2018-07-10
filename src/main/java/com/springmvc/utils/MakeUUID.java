package com.springmvc.utils;

import java.util.UUID;

public class MakeUUID {

	public static String makerandomuuid (){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}
}
