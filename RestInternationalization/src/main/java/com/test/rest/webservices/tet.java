package com.test.rest.webservices;

public class tet {
	
	
	public static void main(String args[]) {
		compareUserIds("NiceGuy39", "NiceGuy69");
	}

	
	public static boolean compareUserIds(String userId, String friendUserId) {

		if(userId.length() > friendUserId.length()) {
			return true;
		}else if(userId.length() < friendUserId.length()) {
			return false;
		}else {
			for(int i=0;i<=userId.length()-1;i++) {
				System.out.println("dafasdfas "+userId.charAt(i));
				System.out.println("padosi  "+friendUserId.charAt(i));
				if(userId.charAt(i) > friendUserId.charAt(i)) {
					return true;
				}
			}
		//logger.info("Incorrect userID ["+userId+"] and frndUsedID : ["+friendUserId+"]");
		return false;
		}
	}
}
