package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class controller implements  Initializable {
	@FXML
	public Label WelcomeLabel;
	@FXML
    public ChoiceBox<String> choicebox;
	@FXML
	public Button button;
	@FXML
	public TextField input;
	private static final String cf="Celsius to Fahrenheit",fc="Fahrenheit to Celsius ";
	private boolean is_cf = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choicebox.getItems().add(cf);
		choicebox.getItems().add(fc);
		choicebox.setValue(cf);
		choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(cf)) {
				is_cf=true;                            //celsius to fahrenheit
			}
			else
			{is_cf=false;}});                             //fahrenheit to celsius
		button.setOnAction(event -> {
		convert();
		}
		);
	}

	private void convert() {
		String val=input.getText();
		float tempin=0.0f;
		try {
			tempin=Float.parseFloat(val);
		} catch (Exception exp) {
			warnuser();
			return;
		}
		float newtemp=0.0f;
		if (is_cf) {
			newtemp=(tempin*9/5)+32;
		}
		else {
			newtemp=(tempin-32)*5/9;
		}
		display(newtemp);
	}

	private void warnuser() {
		Alert warn=new Alert(Alert.AlertType.ERROR);
		warn.setTitle("ERROR");
		warn.setHeaderText("Invalid temperature");
		warn.setContentText("Please enter valid temperature");
		warn.show();
	}

	private void display(float newtemp) {
		Alert result= new Alert(Alert.AlertType.INFORMATION);
		result.setTitle("RESULT");
		result.setHeaderText("RESULT");
		String unit =is_cf? "F":"C";
		result.setContentText("Temp after conversion is:= "+newtemp+unit);
		result.show();
		System.out.println("Temp after conversion is:= "+newtemp+unit);
	}
}
