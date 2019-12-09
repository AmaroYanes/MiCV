package dad.javafx.miCV.app;

import dad.javafx.miCV.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class miCVApp extends Application {

	MainController controller; 
	
	public void start(Stage primaryStage) throws Exception {
		controller = new MainController();
		Scene scene = new Scene(controller.getView(),800,600);
		primaryStage.setTitle("Curriculum Vitae");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
