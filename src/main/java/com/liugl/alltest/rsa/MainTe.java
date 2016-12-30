package com.liugl.alltest.rsa;

import java.util.Map;

public class MainTe {

	private static String keypublicss = "";
	private static String keyprivate = "";

//	private static String toenstr = "jzgliugl";
	private static String toenstr = "jzgliugl中国精真估";
	
	private static byte[] tmp ;
	private static byte[] tmpde ;
	
	private static String result;
	private static String deresult;
	
	public static void main(String[] args) {
		 try {
			Map<String,Object> keymap = RSAUtils.initKey();
			keypublicss = RSAUtils.getPublicKey(keymap);
			keyprivate = RSAUtils.getPrivateKey(keymap);
			
			tmp = RSAUtils.encryptByPublicKey(toenstr.getBytes(), keypublicss);
			deresult = new String(tmp);
			System.out.println("加密result = " + deresult);
			tmpde = RSAUtils.decryptByPrivateKey(tmp, keyprivate);
			
			result = new String(tmpde);
			
			System.out.println("解密result = " + result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
