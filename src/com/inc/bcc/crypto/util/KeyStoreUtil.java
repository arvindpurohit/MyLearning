/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inc.bcc.crypto.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import javax.security.auth.x500.X500Principal;
import javax.security.auth.x500.X500PrivateCredential;

import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerId;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.x509.X509V1CertificateGenerator;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.bouncycastle.x509.extension.AuthorityKeyIdentifierStructure;
import org.bouncycastle.x509.extension.SubjectKeyIdentifierStructure;

/**
 *
 * @author Arvind
 */
public class KeyStoreUtil {

//	public static final char[] KEY_STORE_PASSWORD = "123456".toCharArray();
//	public static final long VALIDITY_PERIOD = 365 * 24 * 60 * 60 * 1000;
//	public static final char[] KEY_PASSWORD = "keyPassword".toCharArray();
//	public static String ROOT_ALIAS = "root";
//	public static String INTERMEDIATE_ALIAS = "intermediate";
//	public static String END_ENTITY_ALIAS = "end";
//	public static final String KEY_STORE_PATH = ConfigurationClass.JAVA_KEY_STORE_PATH;
//	public static final String SIGNED_DATA_PATH = "d:\\pkcs7\\SIGNED_DATA.sign";
//	public static final String SIGNED_ENCRYPTED_DATA_PATH = "d:\\pkcs7\\SIGNED_ENC_DATA.sign";
//	public static final String PLAIN_TEXT_FILE_PATH = "d:\\pkcs7\\PlainText.txt";
//	public static final String RESULT_DATA_FILE_PATH = "d:\\pkcs7\\ResultData.txt";
//	public static final String DECRYPTED_DATA_FILE_PATH = "d:\\pkcs7\\DECRYPTED_DATA.txt";
    public static KeyStore loadKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream is = new FileInputStream(new File(ConfigurationClass.JAVA_KEY_STORE_PATH));
        keyStore.load(is, ConfigurationClass.KEY_STORE_PASSWORD.toCharArray());
        is.close();
        return keyStore;
    }

    public static KeyStore createKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);

        X500PrivateCredential rootCredential = createRootCredential();
        X500PrivateCredential interCredential = createIntermediateCredential(
                rootCredential.getPrivateKey(), rootCredential.getCertificate());
        X500PrivateCredential endCredential = createEndEntityCredential(
                interCredential.getPrivateKey(),
                interCredential.getCertificate());

        keyStore.setCertificateEntry(rootCredential.getAlias(),
                rootCredential.getCertificate());
        keyStore.setKeyEntry(
                endCredential.getAlias(),
                endCredential.getPrivateKey(),
                ConfigurationClass.PRIVATE_KEY_PASSWORD.toCharArray(),
                new Certificate[]{endCredential.getCertificate(),
                    interCredential.getCertificate(),
                    rootCredential.getCertificate()});

        keyStore.store(new FileOutputStream(ConfigurationClass.JAVA_KEY_STORE_PATH), ConfigurationClass.KEY_STORE_PASSWORD.toCharArray());
        return keyStore;
    }

    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA", "BC");
        kpGen.initialize(1024, new SecureRandom());
        return kpGen.generateKeyPair();
    }

    /**
     * Generate a sample V1 certificate to use as a CA root certificate
     */
    public static X509Certificate generateCertificate(KeyPair pair)
            throws Exception {
        X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();
        certGen.setSerialNumber(BigInteger.valueOf(1));
        certGen.setIssuerDN(new X500Principal("CN=Test CA Certificate"));
        certGen.setNotBefore(new Date(System.currentTimeMillis()
                - ConfigurationClass.VALIDITY_PERIOD));
        certGen.setNotAfter(new Date(System.currentTimeMillis()
                + ConfigurationClass.VALIDITY_PERIOD));
        certGen.setSubjectDN(new X500Principal("CN=Test CA Certificate"));
        certGen.setPublicKey(pair.getPublic());
        certGen.setSignatureAlgorithm("SHA1WithRSAEncryption");
        return certGen.generateX509Certificate(pair.getPrivate(), "BC");
    }

    /**
     * Generate a sample V1 certificate to use as a CA root certificate
     */
    public static X509Certificate generateRootCert(KeyPair pair)
            throws Exception {
        X509V1CertificateGenerator certGen = new X509V1CertificateGenerator();

        certGen.setSerialNumber(BigInteger.valueOf(1));
        certGen.setIssuerDN(new X500Principal("CN=Test CA Certificate"));
        certGen.setNotBefore(new Date(System.currentTimeMillis()
                - ConfigurationClass.VALIDITY_PERIOD));
        certGen.setNotAfter(new Date(System.currentTimeMillis()
                + ConfigurationClass.VALIDITY_PERIOD));
        certGen.setSubjectDN(new X500Principal("CN=Test CA Certificate"));
        certGen.setPublicKey(pair.getPublic());
        certGen.setSignatureAlgorithm("SHA1WithRSAEncryption");

        return certGen.generateX509Certificate(pair.getPrivate(), "BC");
    }

    /**
     * Generate a sample V3 certificate to use as an end entity certificate
     */
    public static X509Certificate generateEndEntityCert(PublicKey entityKey,
            PrivateKey caKey, X509Certificate caCert) throws Exception {
        X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

        certGen.setSerialNumber(BigInteger.valueOf(1));
        certGen.setIssuerDN(caCert.getSubjectX500Principal());
        certGen.setNotBefore(new Date(System.currentTimeMillis()
                - ConfigurationClass.VALIDITY_PERIOD));
        certGen.setNotAfter(new Date(System.currentTimeMillis()
                + ConfigurationClass.VALIDITY_PERIOD));
        certGen.setSubjectDN(new X500Principal("CN=Test End Certificate"));
        certGen.setPublicKey(entityKey);
        certGen.setSignatureAlgorithm("SHA1WithRSAEncryption");

        certGen.addExtension(X509Extensions.AuthorityKeyIdentifier, false,
                new AuthorityKeyIdentifierStructure(caCert));
        certGen.addExtension(X509Extensions.SubjectKeyIdentifier, false,
                new SubjectKeyIdentifierStructure(entityKey));
        certGen.addExtension(X509Extensions.BasicConstraints, true,
                new BasicConstraints(false));
        certGen.addExtension(X509Extensions.KeyUsage, true, new KeyUsage(
                KeyUsage.digitalSignature | KeyUsage.keyEncipherment));

        return certGen.generateX509Certificate(caKey, "BC");
    }

    /**
     * Generate a X500PrivateCredential for the root entity.
     */
    public static X500PrivateCredential createRootCredential() throws Exception {
        KeyPair rootPair = generateRSAKeyPair();
        X509Certificate rootCert = generateRootCert(rootPair);

        return new X500PrivateCredential(rootCert, rootPair.getPrivate(),
                ConfigurationClass.ROOT_ALIAS);
    }

    /**
     * Generate a X500PrivateCredential for the intermediate entity.
     */
    public static X500PrivateCredential createIntermediateCredential(
            PrivateKey caKey, X509Certificate caCert) throws Exception {
        KeyPair interPair = generateRSAKeyPair();
        X509Certificate interCert = generateIntermediateCert(
                interPair.getPublic(), caKey, caCert);

        return new X500PrivateCredential(interCert, interPair.getPrivate(),
                ConfigurationClass.INTERMEDIATE_ALIAS);
    }

    /**
     * Generate a X500PrivateCredential for the end entity.
     */
    public static X500PrivateCredential createEndEntityCredential(
            PrivateKey caKey, X509Certificate caCert) throws Exception {
        KeyPair endPair = generateRSAKeyPair();
        X509Certificate endCert = generateEndEntityCert(endPair.getPublic(),
                caKey, caCert);

        return new X500PrivateCredential(endCert, endPair.getPrivate(),
                ConfigurationClass.END_ENTITY_ALIAS);
    }

    /**
     * Generate a sample V3 certificate to use as an intermediate CA certificate
     */
    public static X509Certificate generateIntermediateCert(PublicKey intKey,
            PrivateKey caKey, X509Certificate caCert) throws Exception {
        X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();

        certGen.setSerialNumber(BigInteger.valueOf(1));
        certGen.setIssuerDN(caCert.getSubjectX500Principal());
        certGen.setNotBefore(new Date(System.currentTimeMillis()));
        certGen.setNotAfter(new Date(System.currentTimeMillis()
                + ConfigurationClass.VALIDITY_PERIOD));
        certGen.setSubjectDN(new X500Principal(
                "CN=Test Intermediate Certificate"));
        certGen.setPublicKey(intKey);
        certGen.setSignatureAlgorithm("SHA1WithRSAEncryption");

        certGen.addExtension(X509Extensions.AuthorityKeyIdentifier, false,
                new AuthorityKeyIdentifierStructure(caCert));
        certGen.addExtension(X509Extensions.SubjectKeyIdentifier, false,
                new SubjectKeyIdentifierStructure(intKey));
        certGen.addExtension(X509Extensions.BasicConstraints, true,
                new BasicConstraints(0));
        certGen.addExtension(X509Extensions.KeyUsage, true, new KeyUsage(
                KeyUsage.digitalSignature | KeyUsage.keyCertSign
                | KeyUsage.cRLSign));

        return certGen.generateX509Certificate(caKey, "BC");
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
        OutputStream os = new FileOutputStream(new File(filePath));
        os.write(bytes);
        os.close();
    }

    public static void writeToFile(String filePath, String str) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(str);
        writer.close();

    }

    public static boolean isValidSignature(CMSSignedData signedData,
            X509Certificate rootCert) throws Exception {

        boolean[] bArr = new boolean[2];
        bArr[0] = true;
        CertStore certsAndCRLs = signedData.getCertificatesAndCRLs(
                "Collection", "BC");
        SignerInformationStore signers = signedData.getSignerInfos();
        Iterator it = signers.getSigners().iterator();

        if (it.hasNext()) {
            SignerInformation signer = (SignerInformation) it.next();
            SignerId signerConstraints = signer.getSID();
            signerConstraints.setKeyUsage(bArr);
            PKIXCertPathBuilderResult result = buildPath(rootCert,
                    signer.getSID(), certsAndCRLs);
            return signer.verify(result.getPublicKey(), "BC");
        }

        return false;
    }

    /**
     * Build a path using the given root as the trust anchor, and the passed in
     * end constraints and certificate store. <p> Note: the path is built with
     * revocation checking turned off.
     */
    public static PKIXCertPathBuilderResult buildPath(X509Certificate rootCert,
            X509CertSelector endConstraints, CertStore certsAndCRLs)
            throws Exception {
        CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", "BC");
        PKIXBuilderParameters buildParams = new PKIXBuilderParameters(
                Collections.singleton(new TrustAnchor(rootCert, null)),
                endConstraints);

        buildParams.addCertStore(certsAndCRLs);
        buildParams.setRevocationEnabled(false);

        return (PKIXCertPathBuilderResult) builder.build(buildParams);
    }
}
