//メインメソッド・盤面表示

package othello;

import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{
	Board board;
	OriginalButton[][] buttonArray;
	static int turn = 1;


	public static void main(String[] args) {
		launch();
	}


	//ウィンドウ表示
	public void start(Stage stage) throws Exception{
		stage.setTitle("オセロ");
		stage.setWidth(620);
		stage.setHeight(440);

		buttonArray = new OriginalButton[8][8];
		Button skipButton = new Button("スキップ");
		board = new Board();

		BorderPane root = new BorderPane();
		GridPane mainPane = new GridPane();
		VBox subPane = new VBox(70);

		Label label = new Label("プレイヤー１白：" + board.whiteCnt + " \nプレイヤー２黒：" + board.blackCnt + " \n\n黒のターン");

		subPane.getChildren().addAll(label, skipButton);
		root.setCenter(mainPane);
		root.setRight(subPane);
		Scene scene = new Scene(root);
		stage.setScene(scene);

		stage.show();


		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){

				//初期盤面
				if((i == 3 && j == 3) || (i == 4 && j == 4)){
					buttonArray[i][j] = new OriginalButton("〇",i,j);
					board.bordStatus[i + 1][j + 1] = 1;
					GridPane.setConstraints(buttonArray[i][j], j, i);
					mainPane.getChildren().add(buttonArray[i][j]);
				}else if((i == 3 && j == 4) || (i == 4 && j == 3)){
					buttonArray[i][j] = new OriginalButton("●",i,j);
					board.bordStatus[i + 1][j + 1] = -1;
					GridPane.setConstraints(buttonArray[i][j], j, i);
					mainPane.getChildren().add(buttonArray[i][j]);
				}else{
					buttonArray[i][j] = new OriginalButton("　",i,j);
					board.bordStatus[i + 1][j + 1] = 0;
					GridPane.setConstraints(buttonArray[i][j], j, i);
					mainPane.getChildren().add(buttonArray[i][j]);
				}

				//コントロール表示設定
				label.setFont(new Font(20));
				buttonArray[i][j].setFont(new Font(22));
				buttonArray[i][j].setStyle("-fx-background-color:#00A500");
				buttonArray[i][j].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
				skipButton.setPrefSize(90, 40);
				skipButton.setFont(new Font(20));

				//ボタン押下イベント
				buttonArray[i][j].setOnAction(event -> buttonAction(event, label));
				skipButton.setOnAction(event -> skipButtonAction(label));
			}
		}
	}
	public void buttonAction(ActionEvent event, Label playerLabel){

		OriginalButton btn = (OriginalButton)event.getSource();

		int iIndex = btn.getX() + 1;
		int jIndex = btn.getY() + 1;

		if(board.bordStatus[iIndex][jIndex] == 0){
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					board.prevStatus[i][j] = board.bordStatus[i][j];
				}
			}

			board.turnOver(iIndex, jIndex);

			if(!Arrays.deepEquals(board.bordStatus, board.prevStatus)){
				for(int k = 1; k < 9; k++){
					for(int l = 1; l < 9; l++){
						if(board.bordStatus[k][l] == 1){
							buttonArray[k - 1][l - 1].setText("○");
						}else if(board.bordStatus[k][l] == -1){
							buttonArray[k - 1][l - 1].setText("●");
						}else{
							buttonArray[k - 1][l - 1].setText("　");
						}
					}
				}
				if((board.whiteCnt + board.blackCnt) >= 64 || board.whiteCnt == 0 || board.blackCnt == 0){
					resultAlert();
					return;
				}
				turn++;
				if(turn % 2 == 0){
					playerLabel.setText("プレイヤー１白：" + board.whiteCnt + " \nプレイヤー２黒：" + board.blackCnt + " \n\n白のターン");
				}else{
					playerLabel.setText("プレイヤー１白：" + board.whiteCnt + " \nプレイヤー２黒：" + board.blackCnt + " \n\n黒のターン");
				}
			}else{
				errorAlert();
			}

		}else{
			errorAlert();
		}
	}


	void skipButtonAction(Label playerLabel){
		turn++;
		if(turn % 2 == 0){
			playerLabel.setText("プレイヤー１白：" + board.whiteCnt + " \nプレイヤー２黒：" + board.blackCnt + " \n\n白のターン");
		}else{
			playerLabel.setText("プレイヤー１白：" + board.whiteCnt + " \nプレイヤー２黒：" + board.blackCnt + " \n\n黒のターン");
		}
	}


	void errorAlert(){
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setHeaderText("有効なマスではありません");
		errorAlert.setContentText("空白のマスを指定してください");
		errorAlert.show();
	}


	void resultAlert(){
		Alert resultAlert = new Alert(AlertType.INFORMATION);
		resultAlert.setTitle("勝敗");
		if(board.whiteCnt == board.blackCnt){
			resultAlert.setHeaderText("引き分け");
		}else if(board.whiteCnt > board.blackCnt){
			resultAlert.setHeaderText("白の勝ち");
		}else{
			resultAlert.setHeaderText("黒の勝ち");
		}
		resultAlert.setContentText("白:" + board.whiteCnt + "　対　黒:" + board.blackCnt);
		resultAlert.show();
	}
}
