package com.appiumAndroid.controller;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.appiumAndroid.classes.Gmap;

public class ControllerGmap {
	
	@FXML private Button btnStart;
    @FXML private TextField tfVersion;
    @FXML private TextField tfSearch;
    
    private Gmap gmap = new Gmap();
    private String version;
    private String search;
    
	public void initialize() {
        btnStart.setDisable(true);
    }
	
	public void setValues(String v) {
		version = v;
		tfVersion.setText(version);
		tfVersion.setEditable(false);
	}
    
    public void keyReleasedProperty() {
    	search = tfSearch.getText();
    	//version += " ";
    	search += "\n";
    	
    	
    	boolean isDisabled = (version.isEmpty() || version.trim().isEmpty()) || (search.isEmpty() || search.trim().isEmpty());
    	btnStart.setDisable(isDisabled);
    }
    
    @FXML
    void showMessage(ActionEvent event) throws InterruptedException {
    	
    	System.out.println("Version: " + version + "\nSearch: " + search);
    	
    	try {
    		
			gmap.setup(version);
			gmap.testGmap(search);
			Thread.sleep(10000);
			gmap.tearDown();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
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
