package org.zihao.SMRShop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.zihao.SMRShop.util.ifs.Encryption;

public class MD5Encryption implements Encryption 
{
	@Override
	public String encrypt(String text) 
	{
		try 
		{
			//根据MD5算法生成MessageDigest对象  
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			 byte[] srcBytes = text.getBytes();  
		        //使用srcBytes更新摘要  
		        md5.update(srcBytes);  
		        //完成哈希计算，得到result  
		        byte[] resultBytes = md5.digest();  
		        
		        return new String(resultBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Deprecated
	@Override
	public String decrypt(String entext)
	{
		return null;
	}

}
