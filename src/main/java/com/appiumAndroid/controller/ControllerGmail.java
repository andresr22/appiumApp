package com.appiumAndroid.controller;

import java.net.MalformedURLException;

import com.appiumAndroid.classes.Gmail;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControllerGmail {
	
	@FXML private Button btnStart;
    @FXML private JFXTextField tfVersion;
    @FXML private JFXTextField tfTo;
    @FXML private JFXTextField tfSubject;
    @FXML private JFXTextField tfCompose;
    
    private Gmail gmail = new Gmail();
    private String version;
    private String to;
    private String subject;
    private String compose;
    
    public void initialize() {
        //btnStart.setDisable(true);
    }
	
	public void setValues(String v) {
		version = v;
		tfVersion.setText(version);
		tfVersion.setEditable(false);
	}
	
	public void keyReleasedProperty() {
		
		to = tfTo.getText();
		subject = tfSubject.getText();
		compose = tfCompose.getText();
		
    }
    
	@FXML void showMessage(ActionEvent event) throws InterruptedException {
		
		System.out.println("Version: " + version + "\nTo:" + to + "\nSubject:" + subject + "\nCompose email: " + compose);
		
		try {
			
			gmail.setup(version);
			gmail.testGmail(to, subject, compose);
			Thread.sleep(10000);
			gmail.tearDown();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
    }

}
