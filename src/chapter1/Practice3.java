package chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Practice3 extends Application {
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage){
		stage.setWidth(160);
		stage.setHeight(70);

		stage.show();

		FlowPane root = new FlowPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		String[] colors = {"赤", "青", "黄"};
		Button[] buttonArray = new Button[3];
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i] = new Button(colors[i]);
			root.getChildren().add(buttonArray[i]);
			buttonArray[i].setPrefSize(50, 30);
		}
		buttonArray[0].setStyle("-fx-background-color:#FF0000");
		buttonArray[1].setStyle("-fx-background-color:#0000FF");
		buttonArray[2].setStyle("-fx-background-color:#FFFF00");
	}
}
