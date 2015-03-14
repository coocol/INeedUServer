package com.eethan.ineedu.encrypt;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

 




import com.eethan.ineedu.base64.BASE64Decoder;
import com.eethan.ineedu.base64.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
 

public class RsaKey {

	private static Cipher cipher;
	private static String modulus = "146395855535050456125855204798413551738769738474057765663421140420402819907160545904989644082546941497437481876534149060744742222079484071539627700048437150638822484922011731512348842729352662928228386469422003224460811903665869281469234746445092190321214075517119742878095570013804007047500148883521831061401";
	private static String publicExponent = "161531";
	private static String privateExponet = "43459895998119707812142156215824362175243298617890634224130562842919169837418635789922481769384040745284927155935653527247974839352059355062122856296455203791055887315403206599841869878167420651564158553159483898590928298644166175902380737994839332041642228973272930028706645963721556778582770817739756496671";

	public static ArrayList<Integer> blockNumList;
	private static Cipher getCipher()
	{
		if(cipher==null)
			try {
				cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cipher;
	}
      public PublicKey getPublicKey(String modulus,String publicExponent) throws Exception {

            BigInteger m = new BigInteger(modulus);

            BigInteger e = new BigInteger(publicExponent);

            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m,e);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            return publicKey;

      }

 

      public PrivateKey getPrivateKey(String modulus,String privateExponent) throws Exception {

            BigInteger m = new BigInteger(modulus);

            BigInteger e = new BigInteger(privateExponent);

            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m,e);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            return privateKey;

      }
 
  
      private static PublicKey getPublicKey() throws Exception
      {
    	  		RsaKey key = new RsaKey();
          PublicKey publicKey = key.getPublicKey(modulus, publicExponent);
          return publicKey;
      }
      private static PrivateKey getPrivateKey() throws Exception
      {
	    	  	RsaKey key = new RsaKey();
	    	  	PrivateKey privateKey = key.getPrivateKey(modulus, privateExponet);
	    	  	return privateKey;
      }
      private static boolean isChinese(char c) {
    	    Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
    	    if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
    	            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
    	            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
    	            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
    	            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
    	            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
    	        return true;
    	    }
    	    return false;
    	}
      public static String Encrypt(String plainText) throws InvalidKeyException, Exception
      {
    	  			  blockNumList = new ArrayList<Integer>();
    	  			  
    	  			  devideStringInBlock(plainText);
		          byte[]data=plainText.getBytes("UTF-8");
		           //加密
		          getCipher().init(Cipher.ENCRYPT_MODE, getPublicKey());
		          byte[] enBytes = null;
		          
		          int blockTime = 0;
		          for (int i = 0; i < data.length; i += blockNumList.get(blockTime++)) {  
		          // 注意要使用2的倍数，否则会出现加密后的内容再解密时为乱码
		              byte[] doFinal = getCipher().doFinal(ArrayUtils.subarray(data, i,i + blockNumList.get(blockTime)));  
		              enBytes = ArrayUtils.addAll(enBytes, doFinal);
		          }
		          BASE64Encoder enc = new BASE64Encoder();//将byte[] 转为中间码String
		  		  String cipherString = enc.encode(enBytes);
		          return cipherString;
      }
      
      private static void devideStringInBlock(String plainText) {
		// TODO Auto-generated method stub
    	  int byteNum = 0;
    	  for(int i =0;i<plainText.length();i++)
			  {
				  int thisCharByte = 0;
				  if(isChinese(plainText.charAt(i)))
				  {
					  thisCharByte = 3;
				  }
				  else
					  thisCharByte = 1;
				  if(byteNum + thisCharByte > 64)
				  {
					  blockNumList.add(byteNum);
					  byteNum = thisCharByte;
				  }
				  else
					  byteNum = byteNum + thisCharByte;
					  
			  }
			  blockNumList.add(byteNum);
	}
	public static String Decrypt(String cipherString) throws InvalidKeyException, Exception
      {
    	  	BASE64Decoder dec = new BASE64Decoder();
    	  	byte[] enBytes = dec.decodeBuffer(cipherString);
    	  
    	  	  getCipher().init(Cipher.DECRYPT_MODE, getPrivateKey());
           StringBuilder sb = new StringBuilder();
           
           int blockNum = 128;
           for (int i = 0; i < enBytes.length; i += blockNum) {
               byte[] doFinal = getCipher().doFinal(ArrayUtils.subarray(enBytes, i, i + blockNum));
               String result = new String(doFinal,"UTF-8");
               sb.append(result);
           }
           String dataReturn = sb.toString();
           return dataReturn;
      }
      
//	public static void main(String[] args) throws InvalidKeyException, Exception {
//		
//		String str = "大沙aaaa发上发大水东方航空阿萨德松岛枫挥洒东方红阿萨{a德飞海口市爱的dsf复;';合弓a特爱看人家ghrgfr}复活甲阿肯色分aew静gas安$%^#@^#$@架上的开发和阿克苏的@#附件和金额卡号就撒旦法了卡机了款到即发拉斯加分了就阿里大书法家拉斯克奖付款垃圾是颠覆了角色非了静安寺两地分居阿什利大富科技拉";
//		System.out.println(Encrypt(str));
//		System.out.println(Decrypt(Encrypt(str)));
//		if(str.equals(Decrypt(Encrypt(str))))
//			System.out.println("true");
//		else
//			System.out.println("false");
//		str = "asdfb这件事了的感觉ADS飞";
//		System.out.println(Decrypt(Encrypt(str)));
//	}
}

