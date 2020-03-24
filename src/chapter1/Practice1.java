package chapter1;

import javafx.application.Application;
import javafx.stage.Stage;

public class Practice1 extends Application {
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage){
		stage.setTitle("はじめてのGUIアプリ");
		stage.setWidth(600);
		stage.setHeight(400);

		stage.show();
	}
}
