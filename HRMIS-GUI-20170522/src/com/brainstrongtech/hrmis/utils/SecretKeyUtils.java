package com.brainstrongtech.hrmis.utils;

import java.io.UnsupportedEncodingException;
  
  import javax.crypto.Cipher;
  import javax.crypto.SecretKey;
  import javax.crypto.spec.SecretKeySpec;
  
   
 /**
  * 3DES加密算法
 * @author 田宇
 *
 */
public class SecretKeyUtils {
  
     //定义加密算法，有DES、DESede(即3DES)、Blowfish
     private static final String Algorithm = "DESede";    
     private static final String PASSWORD_CRYPT_KEY = "2012PinganVitality075522628888ForShenZhenBelter075561869839";
     
     
     
     /**
     * 加密
     * @param src 需要加密的字节数组
     * @return 加密后的字节数组
     */
    public static byte[] encryptMode(byte[] src) {
         try {
             SecretKey deskey = new SecretKeySpec(build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);    //生成密钥
              Cipher c1 = Cipher.getInstance(Algorithm);    //实例化负责加密/解密的Cipher工具类
              c1.init(Cipher.ENCRYPT_MODE, deskey);    //初始化为加密模式
              return c1.doFinal(src);   //按单部分操作加密或解密数据，或者结束一个多部分操作。数据将被加密或解密（具体取决于此 Cipher 的初始化方式）。
          } catch (java.security.NoSuchAlgorithmException e1) {
              e1.printStackTrace();
          } catch (javax.crypto.NoSuchPaddingException e2) {
              e2.printStackTrace();
          } catch (java.lang.Exception e3) {
              e3.printStackTrace();
          }
          return null;
      }
     
     
     
     /**
      * 解密
     * @param src 需要解密的字节数组
     * @return 原密码
     */
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
     
     
     
     /**
      * 通过一段字符生成3des 钥密
     * @param keyStr 字符
     * @return 钥密
     * @throws UnsupportedEncodingException 不支持编码异常
     */
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
    
 }