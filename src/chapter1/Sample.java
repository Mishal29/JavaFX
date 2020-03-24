package chapter1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Sample extends Application {
	//mainメソッド
	public static void main(String[] args) {
		//GUIアプリケーションの起動
		launch();		//間接的にstartメソッドが呼び出される
	}

	//Applicationクラスからの継承
	public void start(Stage stage) throws Exception{		//launch()からstageインスタンスを受け取る
		//ウィンドウの設定
		stage.setTitle("JavaFX Example");
		stage.setWidth(300);
		stage.setHeight(200);

		//Stage > Scene > Paneの生成
		FlowPane root = new FlowPane();		//ルートペインの生成
		Scene scene = new Scene(root);		//ルートペインを乗せたシーンの生成
		stage.setScene(scene);				//シーンをステージの上に乗せる

		//ウィンドウ表示
		stage.show();

		//コントロールの配置
		Button button1 = new Button("ボタン１");
		root.getChildren().add(button1);		//button1インスタンスをrootペイン上に追加
		Button button2 = new Button("ボタン２");
		root.getChildren().add(button2);

		//コントロールのプロパティ変更
		Button sampleButton = new Button("サンプルボタン");
		root.getChildren().add(sampleButton);
		sampleButton.setText("変更後ボタンテキスト");	//ボタンのテキストの変更
		System.out.println(sampleButton.getText());		//ボタンのテキストの取得
		sampleButton.setPrefSize(100, 50);				//ボタンのサイズの変更
		sampleButton.setFont(new Font(7));				//ボタンのテキストフォントサイズの変更
		sampleButton.setStyle("-fx-background-color:#FF0000");	//ボタンの背景色の変更

	}
}
