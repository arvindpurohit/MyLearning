/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inc.bcc.crypto.util.test;

import com.inc.bcc.crypto.util.ConfigurationClass;
import com.inc.bcc.crypto.util.KeyStoreUtil;
import com.inc.bcc.crypto.util.PkcsEncryptionSign;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import org.apache.commons.io.IOUtils;
import org.bouncycastle.util.encoders.*;

/**
 *
 * @author Arvind
 */
public class PkcsCryptoTest {

    public static void main(String args[]) throws Exception {
//        KeyStore ks = KeyStoreUtil.createKeyStore();
        KeyStore kStore = KeyStoreUtil.loadKeyStore();
        PkcsEncryptionSign pes = new PkcsEncryptionSign();
        byte[] bte = pes.signData(kStore, "C:\\Users\\Arvind\\Desktop\\ABCd\\A\\input.xml");
        bte = pes.encryptData(kStore, bte);
        bte = Base64.encode(bte);
        String x = new String(bte);
        x = "<?xml version=\"1.0\"?><employee><firstname>" + x + "</firstname></employee>";
        pes.writeToFile("C:\\Users\\Arvind\\Desktop\\ABCd\\A\\output.xml", x);
        bte = pes.readFile("C:\\Users\\Arvind\\Desktop\\ABCd\\A\\output.xml");
        x = new String(bte);
        System.out.println(new String(bte));

        x = x.substring(42, x.length() - 23);
        System.out.println("----------");
        System.out.println(x);
        System.out.println("----------");
        bte = x.getBytes();
        bte = Base64.decode(bte);
        bte = pes.decryptData(kStore, bte, null);
        bte = pes.verifySign(kStore, bte);
        pes.writeToFile("C:\\Users\\Arvind\\Desktop\\ABCd\\A\\final.xml", bte);
        System.out.println("---------- DONE -----------\n\n" + new String(bte));
    }
}
