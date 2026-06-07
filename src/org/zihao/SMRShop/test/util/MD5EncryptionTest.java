package org.zihao.SMRShop.test.util;

import java.lang.reflect.Method;

import org.zihao.SMRShop.test.DefaultUnitTest;
import org.zihao.SMRShop.util.MD5Encryption;

public class MD5EncryptionTest extends DefaultUnitTest<MD5Encryption>
{

	public MD5EncryptionTest()
	{
		super();
	}

	public MD5EncryptionTest(String className)
	{
		super(className);
	}
	public void encryptTest() throws NoSuchMethodException, SecurityException
	{
		Method method = classType.getDeclaredMethod("encrypt", String.class);
		String text = (String)getPara("text", "s");
		startTest(method, text);
	}
}
