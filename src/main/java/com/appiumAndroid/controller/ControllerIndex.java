package com.appiumAndroid.controller;

import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

public class ControllerIndex {
	
	@FXML private ControllerGmap controllergmap;
	@FXML private Button btnStart;
    @FXML private JFXTextField tfVersion;
    @FXML private JFXComboBox<String> cbApp;
    
    private String version;
    private String app;
    ObservableList<String> apps = FXCollections.observableArrayList("Google Maps", "Gmail");
    
	@FXML private void initialize() {
        btnStart.setDisable(true);
        cbApp.setItems(apps);
    }
    
	@FXML public void keyReleasedProperty() {
    	version = tfVersion.getText();
    	//version += " ";
    	app = cbApp.getSelectionModel().getSelectedItem();
    	
    	if (app != null) {
    		boolean isDisabled = (version.isEmpty() || version.trim().isEmpty()) || (app.isEmpty() || app.trim().isEmpty());
    		btnStart.setDisable(isDisabled);
    	}
    }
    
    @FXML public void showMessage(ActionEvent event) throws Exception {
    	
    	System.out.println("Version: " + version);
    	System.out.println("App: " + app);
    	
    	if (app == "Google Maps") {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Gmap.fxml"));
    		Parent root = (Parent) loader.load();
    		
    		ControllerGmap secController = loader.getController();
    		secController.setValues(version);
    		
    		// Stage stage = new Stage();
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.show();
        	
    	} else if (app == "Gmail") {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Gmail.fxml"));
    		Parent root = (Parent) loader.load();
    		
    		ControllerGmail secController = loader.getController();
    		secController.setValues(version);
    		
    		// Stage stage = new Stage();
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.show();
    	}
    	
    	
    }
    
    public static void regexChecker(String theRegex, String str2Check) {
    	Pattern checkRegex = Pattern.compile(theRegex);
    	Matcher regexMatcher = checkRegex.matcher( str2Check );
    	while ( regexMatcher.find() ){
    		if (regexMatcher.group().length() != 0){
    			System.out.println( regexMatcher.group().trim() );
    			System.out.println( "Start Index: " + regexMatcher.start());
    			System.out.println( "Start Index: " + regexMatcher.end());
    			}
    		}
    	}
    
}
