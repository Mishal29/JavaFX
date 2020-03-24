package chapter2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Practice2 extends Application{
	public static void main(String[] args) {
		launch();
	}

	public void start(Stage stage) throws Exception{
		stage.setTitle("カレンダー");
		stage.setWidth(500);
		stage.setHeight(500);

		GridPane root = new GridPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();

		//曜日表示
		String[] week = {"日", "月", "火", "水", "木", "金", "土"};
		Label[] weekLabel = new Label[week.length];
		for(int i = 0; i < weekLabel.length; i++){
			weekLabel[i] = new Label(week[i]);
			root.setConstraints(weekLabel[i], i + 1, 1);
			root.getChildren().add(weekLabel[i]);
			weekLabel[i].setPrefSize(50, 50);
		}


		//日付初期化
		Label[] date = new Label[35];
		for(int i = 0; i < date.length; i++){
			if(i < 3 || i == 34){
				date[i] = new Label("　");
			}else{
				date[i] = new Label(String.valueOf(i + 1));
			}
		}
		int cnt = 0;
		for(int i = 2; i <= 6; i++){
			for(int j = 1; j <= 7; i++){
				root.setConstraints(date[cnt], j, i);
				root.getChildren().add(date[cnt]);
				cnt++;
			}
		}
	}
}
