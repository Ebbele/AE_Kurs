package application;
	
import java.net.URL;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

public class Main extends Application {
	@Override
	public void start(final Stage stage) throws Exception {
		try {
			final URL fxmlUrl = getClass().getResource("LoginWindow.fxml");
			final FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
			fxmlLoader.setController(new MyController());
			final Parent root = fxmlLoader.load();
			stage.setScene(new Scene(root, 450, 175));
			stage.setTitle("LogIn");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
