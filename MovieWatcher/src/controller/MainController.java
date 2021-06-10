package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Utilities;

public class MainController implements Initializable{
@FXML private TextField movieBox;
@FXML private ComboBox<String> ratingBox;


public void insert() throws Exception {
	String movie = movieBox.getText();
	String rating = ratingBox.getSelectionModel().getSelectedItem().toString();
	
	Date date = new Date(); // This object contains the current date value
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	System.out.println(movie + " "  + rating);
	
	Connection conn = Utilities.getConnection();

	try {
	Statement statement = conn.createStatement();
	
	statement.execute("INSERT INTO moviesAndShows(movieName, rating, timeWatched)" + "VALUES('" + movie  + rating + date + "')");

	} catch (SQLException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		Utilities.closeConnection(conn);
	}
}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	ratingBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
	}
}
