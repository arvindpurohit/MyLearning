package com.inc.bcc.sftp.util;

import com.zehon.FileTransferStatus;
import com.zehon.exception.FileTransferException;
import com.zehon.sftp.SFTP;
import java.io.InputStream;

public class SftpUtil {

//		private static final String destFolder = "/SftpTesting";
//		private static final String sourceFolder = "/SftpTesting";
    public static boolean uploadFile(String filePath, String host, String userId, String password, String destFolder) {
        try {
            int status = SFTP.sendFile(filePath, destFolder, host, userId, password);
            if (FileTransferStatus.SUCCESS == status) {
                return true;
            } else if (FileTransferStatus.FAILURE == status) {
                return false;
            }
        } catch (FileTransferException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean uploadFile(InputStream iStream, String nameOfFileToStore, String sftpDestFolder, String host, String userId, String password) {
        try {
            int status = SFTP.sendFile(iStream, nameOfFileToStore, sftpDestFolder, host, userId, password);
            if (FileTransferStatus.SUCCESS == status) {
                return true;
            } else if (FileTransferStatus.FAILURE == status) {
                return false;
            }
        } catch (FileTransferException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean downloadFile(String remoteFileName, String host, String userId, String password, String toLocalFolder, String sourceFolder) {
        try {
            int status = SFTP.getFile(remoteFileName, sourceFolder, host, userId, password, toLocalFolder);
            if (FileTransferStatus.SUCCESS == status) {
                return true;
            } else if (FileTransferStatus.FAILURE == status) {
                return false;
            }
        } catch (FileTransferException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkConfiguration(String host, String username, String password, String destination) {
        try {
            return SFTP.folderExists(destination, host, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
