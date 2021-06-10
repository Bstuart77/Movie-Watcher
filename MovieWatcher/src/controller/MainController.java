package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainController implements Initializable{
@FXML private TextField movieBox;
@FXML private ComboBox<String> ratingBox;


public void insert() {
	String movie = movieBox.getText();
	String rating = ratingBox.getSelectionModel().getSelectedItem().toString();
	System.out.println(movie + " "  + rating);
}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	ratingBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
}
}
