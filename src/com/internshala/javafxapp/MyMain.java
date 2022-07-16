package com.internshala.javafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application {
	public static void main(String[] args) {
		System.out.println("MAIN 1");
		launch(args);
		System.out.println("MAIN 2");
	}

	@Override
	public void init() throws Exception {  //initialise application
		super.init();
		System.out.println("INIT");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {  //start application
		System.out.println("START");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
        MenuBar menuBar=createmenu();
        rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.setFullScreen(false);
		primaryStage.show();
	}
     private MenuBar createmenu() {
	     Menu fm =new Menu("File");   //file menu
	     MenuItem fm1 = new MenuItem("New");
	     //do action after clicking new
	     fm1.setOnAction(event -> System.out.println("File --> New Clicked"));
	     MenuItem fm2 = new MenuItem("Open");
	     MenuItem fm3=new MenuItem("Save");
	     SeparatorMenuItem sp= new SeparatorMenuItem();
	     MenuItem fm4=new MenuItem("Exit");
	     fm4.setOnAction(event -> {
		     System.exit(0);                  // shut down from whole project, status shows exit code

	     });
	     fm.getItems().addAll(fm1,fm2,fm3,sp, fm4);

	     Menu hm = new Menu("Help"); //help
	     MenuItem hm1=new MenuItem("Updates");
	     MenuItem hm2=new MenuItem("Features");
	     MenuItem hm3 =new MenuItem("Feedback");
	     SeparatorMenuItem sp1= new SeparatorMenuItem();
	     MenuItem hm4 =new MenuItem("About");
	     hm4.setOnAction(event -> about());
	     hm.getItems().addAll(hm1,hm2,hm3,sp1, hm4);

	     Menu em = new Menu("Edit"); //edit
	     MenuItem em1=new MenuItem("Cut");
	     MenuItem em2 = new MenuItem("Copy");
	     MenuItem em3 = new MenuItem("Paste");
	     SeparatorMenuItem sp2= new SeparatorMenuItem();
	     MenuItem em4 = new MenuItem("Find");
	     MenuItem em5 = new MenuItem("Delete");
	     em.getItems().addAll(em1,em2,em3,sp2, em4,em5);

	     Menu vm = new Menu("View"); //view
	     MenuItem vm1=new MenuItem("Font Size");
	     MenuItem vm2=new MenuItem("Font Colour");
	     SeparatorMenuItem sp3= new SeparatorMenuItem();
	     MenuItem vm3=new MenuItem("Theme");
	     MenuItem vm4=new MenuItem("File info");
	     vm.getItems().addAll(vm1,vm2,sp3,vm3,vm4);

	     Menu rm = new Menu("Run"); //run
	     MenuBar menubar=new MenuBar();

	     menubar.getMenus().addAll(fm,em,vm,rm,hm);
	     return menubar;
     }

	private void about() {
		Alert alertdialog = new Alert(Alert.AlertType.INFORMATION);
				alertdialog.setTitle("About");
				alertdialog.setHeaderText("About our App Temperature Converter");

		alertdialog.show();

				alertdialog.setContentText("This app is developed by NISHANT ROHILLA in JUNE 2021");

		}

	@Override
	public void stop() throws Exception { //run after closing application
		System.out.println("STOP");
		super.stop();
	}
}
