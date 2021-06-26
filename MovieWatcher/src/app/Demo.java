package app;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Utilities;

public class Demo extends Application {

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		conn = Utilities.connect();
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM moviesandshows");
		
//		while (rs.next()) {		//uncomment out to see all movies and rating
//System.out.println("Movie Name: " + rs.getString("movieName") + ", Rating: " + rs.getInt("rating"));
//		}

		statement.setQueryTimeout(30); // not required, if DB doesnt respond in 30 seconds, it will quit. not
										// required by good to have
		launch(args);

	}

	@Override
	public void start(Stage pStage) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("src/view/Main.fxml");
		Parent root = FXMLLoader.load(file.toURI().toURL());
		Scene scene = new Scene(root, 550, 300);
		pStage.setScene(scene);
		pStage.show();
	}

}
