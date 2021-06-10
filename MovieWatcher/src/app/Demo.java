package app;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Utilities;

public class Demo extends Application{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		conn = Utilities.getConnection();
		try {
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(30); // not required, if DB doesnt respond in 30 seconds, it will quit. not
											// required by good to have

//			Statement s = conn.createStatement();
//			boolean flag = s.execute("insert into item(name, price) values('Reuben Sandwhich',5.00)");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Utilities.closeConnection(conn);
		}
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
