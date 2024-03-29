/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incture.demo;

import com.inc.bcc.sftp.util.SftpUtil;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import org.omg.PortableServer.POAManagerPackage.State;

/**
 *
 * @author Arvind
 */
public class BccUi extends javax.swing.JFrame {

    /**
     * Creates new form BccUi
     */
    public BccUi() {
        initComponents();
        init();
    }

    private void init() {
        patern = Pattern.compile(IPADDRESS_PATTERN);
        startStopFlag = false;


    }

    private boolean isValidHost(String host) {
        matcher = patern.matcher(host);
        return matcher.matches();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        tabPan = new javax.swing.JTabbedPane();
        setupTabPanel = new javax.swing.JPanel();
        sftpConfigPanel = new javax.swing.JPanel();
        ipLabel = new javax.swing.JLabel();
        destinationLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();
        destinationTextField = new javax.swing.JTextField();
        userNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        verifyHostConfig = new javax.swing.JButton();
        keyPanel = new javax.swing.JPanel();
        publicKeyLabel = new javax.swing.JLabel();
        privateKeyLabel = new javax.swing.JLabel();
        publicKeyBrowseButton = new javax.swing.JButton();
        privateKeyBrowseButton = new javax.swing.JButton();
        publicKeyfileNameLabel = new javax.swing.JLabel();
        privateKeyFileNameLabel = new javax.swing.JLabel();
        errSetupLabel = new javax.swing.JLabel();
        setupErrorLabel = new javax.swing.JLabel();
        uploadTabPanel = new javax.swing.JPanel();
        singleUploadPanel = new javax.swing.JPanel();
        browseSFLabel = new javax.swing.JLabel();
        fileUploadSFLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        browseSingleFileButton = new javax.swing.JButton();
        scheduleUploadPanel = new javax.swing.JPanel();
        timeIntervalLabel = new javax.swing.JLabel();
        selectFolderLabel = new javax.swing.JLabel();
        scheduleUploadButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        timeTextField = new javax.swing.JTextField();
        minuitsLabel = new javax.swing.JLabel();
        errUploadLabel = new javax.swing.JLabel();
        uploadTabErrorLabel = new javax.swing.JLabel();
        ecnAndUploadProgressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPan.setBackground(new java.awt.Color(153, 153, 153));

        sftpConfigPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SFTP Configuration", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        ipLabel.setText("Host IP");

        destinationLabel.setText("Destination");

        userNameLabel.setText("User name");

        passwordLabel.setText("Password");

        verifyHostConfig.setText("Verify");
        verifyHostConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyHostConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sftpConfigPanelLayout = new javax.swing.GroupLayout(sftpConfigPanel);
        sftpConfigPanel.setLayout(sftpConfigPanelLayout);
        sftpConfigPanelLayout.setHorizontalGroup(
            sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sftpConfigPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verifyHostConfig)
                    .addGroup(sftpConfigPanelLayout.createSequentialGroup()
                        .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(destinationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(112, 112, 112)
                        .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ipTextField)
                            .addComponent(destinationTextField)
                            .addComponent(userNameTextField)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sftpConfigPanelLayout.setVerticalGroup(
            sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sftpConfigPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinationLabel)
                    .addComponent(destinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sftpConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(verifyHostConfig)
                .addGap(19, 19, 19))
        );

        keyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Keys", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        publicKeyLabel.setText("Public key");

        privateKeyLabel.setText("Private key");

        publicKeyBrowseButton.setText("Browse");
        publicKeyBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicKeyBrowseButtonActionPerformed(evt);
            }
        });

        privateKeyBrowseButton.setText("Browse");
        privateKeyBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privateKeyBrowseButtonActionPerformed(evt);
            }
        });

        publicKeyfileNameLabel.setText("publicKeyfileName");

        privateKeyFileNameLabel.setText("privateKeyFileName");

        javax.swing.GroupLayout keyPanelLayout = new javax.swing.GroupLayout(keyPanel);
        keyPanel.setLayout(keyPanelLayout);
        keyPanelLayout.setHorizontalGroup(
            keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(publicKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(privateKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(keyPanelLayout.createSequentialGroup()
                        .addComponent(privateKeyFileNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(privateKeyBrowseButton))
                    .addGroup(keyPanelLayout.createSequentialGroup()
                        .addComponent(publicKeyfileNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(publicKeyBrowseButton)))
                .addGap(40, 40, 40))
        );
        keyPanelLayout.setVerticalGroup(
            keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicKeyLabel)
                    .addComponent(publicKeyBrowseButton)
                    .addComponent(publicKeyfileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(keyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(privateKeyLabel)
                    .addComponent(privateKeyBrowseButton)
                    .addComponent(privateKeyFileNameLabel))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout setupTabPanelLayout = new javax.swing.GroupLayout(setupTabPanel);
        setupTabPanel.setLayout(setupTabPanelLayout);
        setupTabPanelLayout.setHorizontalGroup(
            setupTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupTabPanelLayout.createSequentialGroup()
                .addGroup(setupTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setupTabPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(setupTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sftpConfigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(keyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errSetupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(setupTabPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(setupErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        setupTabPanelLayout.setVerticalGroup(
            setupTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setupTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errSetupLabel)
                .addGap(28, 28, 28)
                .addComponent(setupErrorLabel)
                .addGap(18, 18, 18)
                .addComponent(sftpConfigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(keyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        tabPan.addTab("Setup", setupTabPanel);

        singleUploadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Single upload", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        browseSFLabel.setText("Browse file ");

        fileUploadSFLabel.setText("File Upload");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        browseSingleFileButton.setText("Browse");
        browseSingleFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSingleFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout singleUploadPanelLayout = new javax.swing.GroupLayout(singleUploadPanel);
        singleUploadPanel.setLayout(singleUploadPanelLayout);
        singleUploadPanelLayout.setHorizontalGroup(
            singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleUploadPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileUploadSFLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseSFLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(browseSingleFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        singleUploadPanelLayout.setVerticalGroup(
            singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singleUploadPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseSFLabel)
                    .addComponent(browseSingleFileButton))
                .addGap(18, 18, 18)
                .addGroup(singleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileUploadSFLabel)
                    .addComponent(okButton))
                .addGap(23, 23, 23))
        );

        scheduleUploadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schedule upload", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 51, 255))); // NOI18N

        timeIntervalLabel.setText("Time interval");

        selectFolderLabel.setText("Select folder");

        scheduleUploadButton.setText("Browse");
        scheduleUploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleUploadButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        minuitsLabel.setText("minuits");

        javax.swing.GroupLayout scheduleUploadPanelLayout = new javax.swing.GroupLayout(scheduleUploadPanel);
        scheduleUploadPanel.setLayout(scheduleUploadPanelLayout);
        scheduleUploadPanelLayout.setHorizontalGroup(
            scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleUploadPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeIntervalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectFolderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton))
                .addGap(55, 55, 55)
                .addGroup(scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scheduleUploadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeTextField)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(minuitsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        scheduleUploadPanelLayout.setVerticalGroup(
            scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleUploadPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeIntervalLabel)
                    .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuitsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectFolderLabel)
                    .addComponent(scheduleUploadButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(scheduleUploadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(stopButton))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout uploadTabPanelLayout = new javax.swing.GroupLayout(uploadTabPanel);
        uploadTabPanel.setLayout(uploadTabPanelLayout);
        uploadTabPanelLayout.setHorizontalGroup(
            uploadTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadTabPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(uploadTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singleUploadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleUploadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(errUploadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uploadTabErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ecnAndUploadProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        uploadTabPanelLayout.setVerticalGroup(
            uploadTabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadTabPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(errUploadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(uploadTabErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ecnAndUploadProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(singleUploadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(scheduleUploadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tabPan.addTab("Upload", uploadTabPanel);

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPan)
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPan)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        fileUploadThread = new FileUploadThread();
        System.out.println("\n------------------------\tstartButtonActionPerformed\t------------------------");
        System.out.println("Time" + System.currentTimeMillis() + "\tThread stat " + fileUploadThread.getState());
        fileUploadThread.setUploadDir(uploadDirectory);
        fileUploadThread.setHost(ipTextField.getText());
        fileUploadThread.setUserId(userNameTextField.getText());
        fileUploadThread.setPassword(new String(passwordField.getPassword()));
        fileUploadThread.setDestination(destinationTextField.getText());
        System.out.println("\nUpload Dir in start method" + uploadDirectory.getAbsolutePath());
        //ecnAndUploadProgressBar = new  JProgressBar();
        ecnAndUploadProgressBar.setMaximum(100);
        ecnAndUploadProgressBar.setMinimum(0);
        ecnAndUploadProgressBar.setStringPainted(true);
        fileUploadThread.setProgressBar(ecnAndUploadProgressBar);


        try {
            if (fileUploadThread.getState() != java.lang.Thread.State.RUNNABLE.NEW) {
                fileUploadThread = new FileUploadThread();
                fileUploadThread.start();
                ecnAndUploadProgressBar.setMinimum(0);
            } else {
                fileUploadThread.start();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Thread stat " + fileUploadThread.getState());


    }//GEN-LAST:event_startButtonActionPerformed

    private void publicKeyBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicKeyBrowseButtonActionPerformed
        System.out.println("\n------------------------\tpublicKeyBrowseButtonActionPerformed\t------------------------");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String choosertitle = null;
        fileChooser.setDialogTitle(choosertitle);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
            //System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
            publicKeyFile = fileChooser.getSelectedFile();
        } else {
            publicKeyFile = null;
            System.out.println("No Selection ");
        }

    }//GEN-LAST:event_publicKeyBrowseButtonActionPerformed

    private void privateKeyBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privateKeyBrowseButtonActionPerformed
        System.out.println("\n------------------------\tprivateKeyBrowseButtonActionPerformed\t------------------------");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String choosertitle = null;
        fileChooser.setDialogTitle(choosertitle);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
            //System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
            privateKeyFile = fileChooser.getSelectedFile();
        } else {
            privateKeyFile = null;
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_privateKeyBrowseButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed

    private void scheduleUploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleUploadButtonActionPerformed

        System.out.println("\n------------------------\tscheduleUploadButtonActionPerformed\t------------------------");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String choosertitle = null;
        fileChooser.setDialogTitle(choosertitle);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            uploadDirectory = fileChooser.getSelectedFile();
            System.out.println("Upload dir " + uploadDirectory.getAbsolutePath());
        } else {
            uploadDirectory = null;
            System.out.println("No directory has been selected ");
        }

    }//GEN-LAST:event_scheduleUploadButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        System.out.println("\n------------------------\tstopButtonActionPerformed\t------------------------");
        System.out.println("Thread state " + fileUploadThread.getState() + "\tThread name " + fileUploadThread.getName());
        if (fileUploadThread.getState() == java.lang.Thread.State.RUNNABLE || fileUploadThread.getState() == java.lang.Thread.State.NEW || fileUploadThread.getState() == java.lang.Thread.State.WAITING || fileUploadThread.getState() == java.lang.Thread.State.BLOCKED || fileUploadThread.getState() == java.lang.Thread.State.TIMED_WAITING) {
            try {
                System.out.println("MAKING THREAD WAIT INDEFINIT ");
                fileUploadThread.interrupt();
                fileUploadThread.yield();
                fileUploadThread.stop();
                fileUploadThread.join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        ecnAndUploadProgressBar.setValue(0);
        System.out.println("Thread state " + fileUploadThread.getState());
    }//GEN-LAST:event_stopButtonActionPerformed

    private void browseSingleFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSingleFileButtonActionPerformed
        System.out.println("\n------------------------\tbrowseSingleFileButtonActionPerformed\t------------------------");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new java.io.File("."));
        String choosertitle = null;
        fileChooser.setDialogTitle(choosertitle);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            uploadDirectory = fileChooser.getSelectedFile();
        } else {
            uploadDirectory = null;
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_browseSingleFileButtonActionPerformed

    private void verifyHostConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyHostConfigActionPerformed
        System.out.println("\n------------------------\tverifyHostConfigActionPerformed\t------------------------");
        if (SftpUtil.checkConfiguration(ipTextField.getText(), userNameTextField.getText(), passwordField.getText(), destinationTextField.getText())) {
            errSetupLabel.setText("Seems to be ok");
            errSetupLabel.setForeground(Color.BLUE);
        } else {
            errSetupLabel.setText("Please Fill correct Entry");
            errSetupLabel.setForeground(Color.RED);
        }
    }//GEN-LAST:event_verifyHostConfigActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BccUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BccUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BccUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BccUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            BccUi bccUi = new BccUi();

            public void run() {
                bccUi.setVisible(true);
                ImageIcon img = new ImageIcon("C:\\Users\\Arvind\\Desktop\\BCCImage.png");
                UIManager.put("ProgressBar.background", Color.YELLOW);
                UIManager.put("ProgressBar.foreground", Color.RED);
                bccUi.setIconImage(img.getImage());

                //bccUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel browseSFLabel;
    private javax.swing.JButton browseSingleFileButton;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JTextField destinationTextField;
    private javax.swing.JProgressBar ecnAndUploadProgressBar;
    private javax.swing.JLabel errSetupLabel;
    private javax.swing.JLabel errUploadLabel;
    private javax.swing.JLabel fileUploadSFLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JPanel keyPanel;
    private javax.swing.JLabel minuitsLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton privateKeyBrowseButton;
    private javax.swing.JLabel privateKeyFileNameLabel;
    private javax.swing.JLabel privateKeyLabel;
    private javax.swing.JButton publicKeyBrowseButton;
    private javax.swing.JLabel publicKeyLabel;
    private javax.swing.JLabel publicKeyfileNameLabel;
    private javax.swing.JButton scheduleUploadButton;
    private javax.swing.JPanel scheduleUploadPanel;
    private javax.swing.JLabel selectFolderLabel;
    private javax.swing.JLabel setupErrorLabel;
    private javax.swing.JPanel setupTabPanel;
    private javax.swing.JPanel sftpConfigPanel;
    private javax.swing.JPanel singleUploadPanel;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JTabbedPane tabPan;
    private javax.swing.JLabel timeIntervalLabel;
    private javax.swing.JTextField timeTextField;
    private javax.swing.JLabel uploadTabErrorLabel;
    private javax.swing.JPanel uploadTabPanel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JButton verifyHostConfig;
    // End of variables declaration//GEN-END:variables
    private Pattern patern;
    private Matcher matcher;
    private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
            + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private File publicKeyFile;
    private File privateKeyFile;
    private File uploadDirectory;
    private File singleUploadFile;
    private boolean startStopFlag;
    FileUploadThread fileUploadThread;
}
