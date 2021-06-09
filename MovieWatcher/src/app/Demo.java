package app;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
