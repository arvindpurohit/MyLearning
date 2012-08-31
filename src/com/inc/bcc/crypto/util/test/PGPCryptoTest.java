package com.inc.bcc.crypto.util.test;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.security.Security;
//
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.bouncycastle.openpgp.PGPPublicKey;

import com.inc.bcc.crypto.util.CryptoUtilPrevious;

public class PGPCryptoTest {

//	public static void test(String[] args) throws Exception{
//		Security.addProvider(new BouncyCastleProvider());
//
//		// Encrypt file and put into some location
//		String toBeEncryptedFilePath = "D:\\eclipse\\Test-folder\\InputPGP.txt";
//		String toBeDecryptedFilePath = "D:\\eclipse\\Test-folder\\EncryptedPGP.txt.asc";
//		String dcryptedFileName = "D:\\eclipse\\Test-folder\\DecryptedPGP.txt";
//		
//		String publicKeyRingFilePath = "C:\\Documents and Settings\\Incture\\Application Data\\gnupg\\pubring.gpg";
//		String privateKeyRingFilePath = "C:\\Documents and Settings\\Incture\\Application Data\\gnupg\\secring.gpg";
//		String passPhrase = "Inct@123";
//				
//		Security.addProvider(new BouncyCastleProvider());
//		RandomAccessFile inputFile = new RandomAccessFile(toBeEncryptedFilePath,"r");
//		
//		//GET DATA TO BE ENCRYPTED
//		byte[] original = new byte[(int)inputFile.length()];
//		inputFile.read(original);
//		
//		//READ PUBLIC KEY
//		FileInputStream pubKey = new FileInputStream(publicKeyRingFilePath);
//		PGPPublicKey pgpPublicKey = CryptoUtilPrevious.readPublicKey(pubKey);
//		
//		//ENCRYPT DATA AND GET BYTES AND WRITE TO SOME FILE
//		byte[] encrypted = CryptoUtilPrevious.encrypt(original, pgpPublicKey, null, true,true);
//		FileOutputStream dfis = new FileOutputStream(toBeDecryptedFilePath);
//		dfis.write(encrypted);
//		dfis.close();
//		
//		//READ FILE TO BE DECRYPTED
//		byte[] encFromFile = CryptoUtilPrevious.getBytesFromFile(new File(toBeDecryptedFilePath));
//		
//		//GET THE PRIVATE(SECRET) KEY
//		FileInputStream secKey = new FileInputStream(privateKeyRingFilePath);
//
//
//		//DECRYPT DATA AND WRITE RESULT TO SOME FILE  
//		byte[] decrypted = CryptoUtilPrevious.decrypt(encFromFile, secKey,passPhrase.toCharArray());
//		RandomAccessFile outPutFile = new RandomAccessFile(dcryptedFileName,"rw");
//		outPutFile.write(decrypted);
//		outPutFile.close();
//	}

}
