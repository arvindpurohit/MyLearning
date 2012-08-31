/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incture.demo;

import com.inc.bcc.crypto.util.PkcsEncryptionSign;
import com.inc.bcc.sftp.util.SftpUtil;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import sun.applet.Main;

public class FileUploadThread extends Thread {

    private javax.swing.JProgressBar progressBar;
    private File uploadDir = null;
    private Long waitTime;
    private String host;
    private String userId;
    private String password;
    private String destDir;
    private Long dirSize = 0l;

    public void run() {
        System.out.println("------------------------ Thread run method ------------------------");
        System.out.println("Thread name in run method " + Thread.currentThread().getName());
        File out = new File("D:\\out.txt");
        boolean status;
        long byteUploaded = 0;
        try {
            Writer output = new BufferedWriter(new FileWriter(out));
            if (uploadDir != null) {
                File[] listOfFiles = uploadDir.listFiles();
                dirSize = countDirSize(listOfFiles);
                for (int i = 0; i < listOfFiles.length && this.getState() != java.lang.Thread.State.TERMINATED; i++) {
                    if (listOfFiles[i].isFile()) {
                        try {
                            PkcsEncryptionSign.signAndEncrypt(listOfFiles[i]);
                            //status = SftpUtil.uploadFile(is, "Test.txt", "/Testing", "192.168.1.153", "honey", "abcd1234");
                            status = SftpUtil.uploadFile("src\\resources\\" + listOfFiles[i].getName(), host, userId , password,destDir);
                            System.out.println("File\t\t" + listOfFiles[i].getAbsolutePath() + "\tTransfer status " + status + " Byte uploaded " + (int) (byteUploaded * 100 / dirSize));
                            output.append(("File\t\t" + listOfFiles[i].getAbsolutePath() + "\tTransfer status " + status + "\tByte uploaded " + (int) (byteUploaded * 100 / dirSize) + "\n"));
//                            File file = new File("src\\resources\\" + listOfFiles[i].getName());
//                            file.delete();
                            //PROGRESS BAR SETTING
                            byteUploaded += listOfFiles[i].length();
                            progressBar.setValue((int) (byteUploaded * 100 / dirSize));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUploadThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setUploadDir(File dir) {
        uploadDir = dir;
    }

    public void setProgressBar(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    private Long countDirSize(File[] listOfFiles) {
        long size = 0;
        for (int i = 0; i < listOfFiles.length; i++) {
            size += listOfFiles[i].length();
        }
        return size;
    }
    
    public void setHost(String host) {
        this.host = host ;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setPassword(String password) {
        this.password = password;
    }
     public void setDestination(String destDir) {
        this.destDir = destDir ;
    }
    
}
