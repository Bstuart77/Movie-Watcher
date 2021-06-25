package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Utilities;

public class MainController implements Initializable {
	@FXML
	private TextField movieBox;
	@FXML
	private ComboBox<String> ratingBox;

	public void insert(ActionEvent event) throws Exception {

		if (movieBox.getText().isBlank()) {
			Alert alert = new Alert(AlertType.WARNING, "INVALID MOVIE NAME");
			alert.showAndWait();
		} else if (ratingBox.getSelectionModel().isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING, "INVALID RATING");
			alert.showAndWait();
		}

		String movie = movieBox.getText();
		String rating = ratingBox.getSelectionModel().getSelectedItem().toString();

		Connection conn = Utilities.connect();
		try {
			Statement statement = conn.createStatement();

			statement.execute("INSERT INTO moviesAndShows(movieName, rating)" + "VALUES('" + movie + "','" + rating + "')");

			
			movieBox.setText("");
			ratingBox.getSelectionModel().clearSelection();;
			System.out.println(movie + " " + rating + " inputted");
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
		ratingBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
	}
}
