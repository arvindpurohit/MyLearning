package com.inc.bcc.sftp.util.test;

import com.inc.bcc.sftp.util.SftpUtil;

public class SftpTest {

    public static void main(String[] args) {

        if (SftpUtil.checkConfiguration("192.168.1.153", "honey", "abcd1234", "/SftpTesting")) {
            System.out.println("--------- TRYING TO UPLOAD ----------");
        }
//	System.out.println("Status :"+SftpUtil.uploadFile("D:\\out.txt", "192.168.1.140", "incture", "abcd1234"));
        //System.out.println("Status :"+SftpUtil.downloadFile("uploadme.txt","192.168.1.153","honey","abcd1234","D:\\ECLIPSE-WORKSPACE"));

    }
}
