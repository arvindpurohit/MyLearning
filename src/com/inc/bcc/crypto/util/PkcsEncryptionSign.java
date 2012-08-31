/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inc.bcc.crypto.util;

import java.io.*;

import java.security.cert.X509Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Arrays;
import org.bouncycastle.cms.*;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Arvind
 */
public class PkcsEncryptionSign {

    public static void signAndEncrypt(File file) throws Exception {
        try {
            KeyStore kStore = KeyStoreUtil.loadKeyStore();
            PkcsEncryptionSign pes = new PkcsEncryptionSign();
            byte[] encryptedData = pes.signData(kStore, file.getAbsolutePath());
            encryptedData = encryptData(kStore, encryptedData);
            String temp = new String(Base64.encode(encryptedData));
            encryptedData = (ConfigurationClass.INPUT_START_XML + temp + ConfigurationClass.INPUT_END_XML).getBytes();
            writeToFile("src\\resources\\" + file.getName(), encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static KeyStore loadKeyStore() {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            InputStream is = new FileInputStream(new File(ConfigurationClass.JAVA_KEY_STORE_PATH));
            keyStore.load(is, ConfigurationClass.KEY_STORE_PASSWORD.toCharArray());
            is.close();
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decryptData(KeyStore keyStore, byte[] encryptedData, String writeToFile) throws Exception {

        CMSEnvelopedDataParser envelopedDataParser = new CMSEnvelopedDataParser(
                new ByteArrayInputStream(encryptedData));
        PrivateKey key = (PrivateKey) keyStore.getKey(
                ConfigurationClass.END_ENTITY_ALIAS,
                ConfigurationClass.PRIVATE_KEY_PASSWORD.toCharArray());
        Certificate[] chain = keyStore.getCertificateChain(ConfigurationClass.END_ENTITY_ALIAS);
        X509Certificate cert = (X509Certificate) chain[0];

        CMSEnvelopedData enveloped = new CMSEnvelopedData(encryptedData);

        // look for our recipient identifier
        RecipientId recId = new RecipientId();

        recId.setSerialNumber(cert.getSerialNumber());
        recId.setIssuer(cert.getIssuerX500Principal().getEncoded());

        RecipientInformationStore recipients = enveloped.getRecipientInfos();
        RecipientInformation recipient = recipients.get(recId);

        if (recipient != null) {
            // decrypt the data
            byte[] recData = recipient.getContent(key, "BC");
            if (writeToFile != null) {
                writeToFile(writeToFile, recData);
            }
            return recData;
        } else {
            System.out.println("could not find a matching recipient");
            return null;
        }


    }

    public static byte[] encryptData(KeyStore keyStore, byte[] dataToEncrypt) throws Exception {



        PrivateKey key = (PrivateKey) keyStore.getKey(ConfigurationClass.END_ENTITY_ALIAS, ConfigurationClass.PRIVATE_KEY_PASSWORD.toCharArray());
        Certificate[] chain = keyStore.getCertificateChain(ConfigurationClass.END_ENTITY_ALIAS);
        X509Certificate cert = (X509Certificate) chain[0];

        // set up the generator
        CMSEnvelopedDataGenerator gen = new CMSEnvelopedDataGenerator();

        gen.addKeyTransRecipient(cert);

        // create the enveloped-data object
        //byte[] dataToEncrypt = MyUtils.readFile(dataToEncrypt);
        CMSProcessable data = new CMSProcessableByteArray(dataToEncrypt);

        CMSEnvelopedData enveloped = gen.generate(data, CMSEnvelopedDataGenerator.AES128_CBC, "BC");

        byte[] outByte = enveloped.getEncoded();

        //MyUtils.writeToFile(MyUtils.SIGNED_ENCRYPTED_DATA_PATH , outByte);
        return outByte;





    }

    public static byte[] signData(KeyStore keyStore, String inputFilePath) throws Exception {

        PrivateKey key = (PrivateKey) keyStore.getKey(ConfigurationClass.END_ENTITY_ALIAS, ConfigurationClass.PRIVATE_KEY_PASSWORD.toCharArray());

        Certificate[] chain = keyStore.getCertificateChain(ConfigurationClass.END_ENTITY_ALIAS);
        CertStore certsAndCRLs = CertStore.getInstance("Collection", new CollectionCertStoreParameters(Arrays.asList(chain)), "BC");
        X509Certificate cert = (X509Certificate) chain[0];

        // set up the generator
        CMSSignedDataGenerator gen = new CMSSignedDataGenerator();
        gen.addSigner(key, cert, CMSSignedDataGenerator.DIGEST_SHA224);
        gen.addCertificatesAndCRLs(certsAndCRLs);

        // create the signed-data object
        byte[] originatorMessage = readFile(inputFilePath);

        //Create a predefined XML 

        //originatorMessage = (ConfigurationClass.INPUT_START_XML+new String(originatorMessage)+ConfigurationClass.INPUT_END_XML).getBytes();
        //System.out.println("\n\nFormed xml ::\n"+new String(originatorMessage));

        CMSProcessable data = new CMSProcessableByteArray(originatorMessage);
        CMSSignedData signed = gen.generate(data, true, "BC");

        // recreate
        signed = new CMSSignedData(data, signed.getEncoded());

        //Write signed data to file
        //MyUtils.writeToFile(MyUtils.SIGNED_DATA_PATH, signed.getEncoded());

        return signed.getEncoded();



    }

    public static byte[] verifySign(KeyStore keyStore, byte[] encryptedData) throws Exception {



//		byte[] encryptedData = MyUtils.readFile(MyUtils.DECRYPTED_DATA_FILE_PATH);

        CMSSignedData signed = new CMSSignedData(encryptedData);
        X509Certificate rootCert = (X509Certificate) keyStore.getCertificate(ConfigurationClass.ROOT_ALIAS);
        if (KeyStoreUtil.isValidSignature(signed, rootCert)) {
            System.out.println("verification succeeded");

            CMSProcessable signedContent = signed.getSignedContent();
            byte[] originalContent = (byte[]) signedContent.getContent();
            // System.out.println(new String(originalContent));
            //writeToFile(MyUtils.RESULT_DATA_FILE_PATH, new String(originalContent));
            return originalContent;

        } else {
            System.out.println("verification failed");
        }
        return null;
    }

    public static byte[] readFile(String filePath) throws Exception {
        File file = new File(filePath);
        byte[] bytes = new byte[(int) file.length()];
        InputStream is = new FileInputStream(file);
        is.read(bytes);
        is.close();
        return bytes;
    }

    public static void writeToFile(String filePath, byte[] bytes) throws Exception {
//        System.out.println("\n--------------- writeToFile byte -------------------");
        OutputStream os = new FileOutputStream(new File(filePath));
        os.write(bytes);
        os.flush();
        os.close();
//        System.out.println("\n--------------- writeToFile byte done success-------------------");
    }

    public static void writeToFile(String filePath, String str) throws Exception {
//        System.out.println("\n--------------- writeToFile  with st-------------------");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(str);
        writer.flush();
        writer.close();

    }

    public static InputStream byteToInputStream(byte[] byts) throws Exception {
        InputStream stream = new ByteArrayInputStream(byts);
        return stream;
    }

    private static byte[] inputStreamToByte(InputStream is) throws Exception {
        if (is != null) {
            return is.toString().getBytes();
        }
        return null;

    }
}
