package chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Practice2 extends Application {
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage){
		stage.setWidth(425);
		stage.setHeight(130);

		stage.show();

		FlowPane root = new FlowPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		String[] month = {"January", "February", "March", "April", "May", "June",
						  "July", "August", "September", "October", "November", "December"};
		Button[] buttonArray = new Button[12];
		for(int i = 0; i < 12; i++){
			buttonArray[i] = new Button(month[i]);
			root.getChildren().add(buttonArray[i]);
			buttonArray[i].setPrefSize(100, 30);
		}



	}
}
