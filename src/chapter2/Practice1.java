package chapter2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Practice1 extends Application{
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage) throws Exception{
		stage.setWidth(300);
		stage.setHeight(200);

		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

		String[] direction = {"北", "西", "南", "東"};
		Button[] buttonArray = new Button[direction.length];
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i] = new Button(direction[i]);
			buttonArray[i].setPrefSize(100, 50);
		}
		//GridPane
		root.setConstraints(buttonArray[0], 2, 1);		//グリッド配置(コントロールインスタンス, 列, 行)
		root.setConstraints(buttonArray[1], 1, 2);
		root.setConstraints(buttonArray[2], 2, 3);
		root.setConstraints(buttonArray[3], 3, 2);
		for(int i = 0; i < buttonArray.length; i++){
			root.getChildren().add(buttonArray[i]);
		}
	}
}