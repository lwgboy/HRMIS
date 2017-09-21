package com.brainstrongtech.hrmis.test;

import java.io.UnsupportedEncodingException;
  
  import javax.crypto.Cipher;
  import javax.crypto.SecretKey;
  import javax.crypto.spec.SecretKeySpec;
  
   
 
 public class Tester {
  
     //��������㷨����DES��DESede(��3DES)��Blowfish
     private static final String Algorithm = "DESede";    
     private static final String PASSWORD_CRYPT_KEY = "2012PinganVitality075522628888ForShenZhenBelter075561869839";
     
     
     
     public static byte[] encryptMode(byte[] src) {
         try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);    //������Կ
              Cipher c1 = Cipher.getInstance(Algorithm);    //ʵ�����������/���ܵ�Cipher������
              c1.init(Cipher.ENCRYPT_MODE, deskey);    //��ʼ��Ϊ����ģʽ
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
             c1.init(Cipher.DECRYPT_MODE, deskey);    //��ʼ��Ϊ����ģʽ
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
         byte[] key = new byte[24];    //����һ��24λ���ֽ����飬Ĭ�����涼��0
         byte[] temp = keyStr.getBytes("UTF-8");    //���ַ���ת���ֽ�����
         
       
         if(key.length > temp.length){
             //���temp����24λ���򿽱�temp�����������ȵ����ݵ�key������
             System.arraycopy(temp, 0, key, 0, temp.length);
         }else{
             //���temp����24λ���򿽱�temp����24�����ȵ����ݵ�key������
             System.arraycopy(temp, 0, key, 0, key.length);
         }
         return key;
    } 
     
     public static void main(String[] args) {
    	         String msg = "3DES���ܽ��ܰ���";
    	         System.out.println("������ǰ����" + msg);
    	         
             //����
    	         byte[] secretArr = Tester.encryptMode(msg.getBytes());    
             System.out.println("�����ܺ󡿣�" + new String(secretArr));
    	         
    	         //����
    	         byte[] myMsgArr = Tester.decryptMode(secretArr);  
    	         System.out.println("�����ܺ󡿣�" + new String(myMsgArr));
    	     }
 }