package com.brainstrongtech.hrmis.test;

import java.io.UnsupportedEncodingException;
  
  import javax.crypto.Cipher;
  import javax.crypto.SecretKey;
  import javax.crypto.spec.SecretKeySpec;
  
   
 
 public class Tester {
  
     //定义加密算法，有DES、DESede(即3DES)、Blowfish
     private static final String Algorithm = "DESede";    
     private static final String PASSWORD_CRYPT_KEY = "2012PinganVitality075522628888ForShenZhenBelter075561869839";
     
     
     
     public static byte[] encryptMode(byte[] src) {
         try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);    //生成密钥
              Cipher c1 = Cipher.getInstance(Algorithm);    //实例化负责加密/解密的Cipher工具类
              c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
              return c1.doFinal(src);
          } catch (java.security.NoSuchAlgorithmException e1) {
              e1.printStackTrace();
          } catch (javax.crypto.NoSuchPaddingException e2) {
              e2.printStackTrace();
          } catch (java.lang.Exception e3) {
              e3.printStackTrace();
          }
          return null;
      }
     
     
     
     public static byte[] decryptMode(byte[] src) {      
         try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
             Cipher c1 = Cipher.getInstance(Algorithm);
             c1.init(Cipher.DECRYPT_MODE, deskey);    //初始化为解密模式
             return c1.doFinal(src);
         } catch (java.security.NoSuchAlgorithmException e1) {
             e1.printStackTrace();
         } catch (javax.crypto.NoSuchPaddingException e2) {
             e2.printStackTrace();
         } catch (java.lang.Exception e3) {
             e3.printStackTrace();
         }
         return null;
      }
     
     
     
     public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException{
         byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
         byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组
         
       
         if(key.length > temp.length){
             //如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
             System.arraycopy(temp, 0, key, 0, temp.length);
         }else{
             //如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
             System.arraycopy(temp, 0, key, 0, key.length);
         }
         return key;
    } 
     
     public static void main(String[] args) {
    	         String msg = "3DES加密解密案例";
    	         System.out.println("【加密前】：" + msg);
    	         
             //加密
    	         byte[] secretArr = Tester.encryptMode(msg.getBytes());    
             System.out.println("【加密后】：" + new String(secretArr));
    	         
    	         //解密
    	         byte[] myMsgArr = Tester.decryptMode(secretArr);  
    	         System.out.println("【解密后】：" + new String(myMsgArr));
    	     }
 }