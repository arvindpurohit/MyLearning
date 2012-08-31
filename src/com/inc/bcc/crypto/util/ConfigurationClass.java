/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inc.bcc.crypto.util;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Arvind
 */
public class ConfigurationClass {

    public static String JAVA_KEY_STORE_PATH = null;
    public static String KEY_STORE_PASSWORD = null;
    public static String END_ENTITY_ALIAS = null;
    public static String PRIVATE_KEY_PASSWORD = null;
    public static String DECRYPTED_DATA_FILE_PATH = null;
    public static String ROOT_ALIAS = null;
    public static String RESULT_DATA_FILE_PATH = null;
    public static final long VALIDITY_PERIOD = 365 * 24 * 60 * 60 * 1000;
    public static String INTERMEDIATE_ALIAS = null;
    public static String INPUT_START_XML = null;
    public static String INPUT_END_XML = null;

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src\\resources\\BccConfiguration.properties"));
            JAVA_KEY_STORE_PATH = props.getProperty("JKS.Keystore.path");
            KEY_STORE_PASSWORD = props.getProperty("JKS.Keystore.password");
            END_ENTITY_ALIAS = props.getProperty("Alias.end");
            PRIVATE_KEY_PASSWORD = props.getProperty("JKS.Keystore.password");
            DECRYPTED_DATA_FILE_PATH = props.getProperty("JKS.Keystore.password");
            ROOT_ALIAS = props.getProperty("Alias.root");
            RESULT_DATA_FILE_PATH = props.getProperty("JKS.Keystore.password");
            INTERMEDIATE_ALIAS = props.getProperty("Alias.intermediate");
            INPUT_START_XML = props.getProperty("Xml.input.start");
            INPUT_END_XML = props.getProperty("Xml.input.end");

        } catch (Exception e) {
            e.printStackTrace();;
        }

    }
}
