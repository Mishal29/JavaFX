//反転判定・反転

package othello;

public class Board {
	int[][] bordStatus = new int[10][10];
	int[][] prevStatus = new int[10][10];
	int blackCnt = 2;
	int whiteCnt = 2;


	public Board(){
		for(int i = 0; i < 10; i++){
			bordStatus[0][i] = 2;
			bordStatus[9][i] = 2;
			bordStatus[i][0] = 2;
			bordStatus[i][9] = 2;
		}
	}


	void turnOver(int i, int j){
		int myDisc;
		if(Main.turn % 2 == 0){ //白のターン
			myDisc = 1;
		}else{ //黒のターン
			myDisc = -1;
		}
		for(int k = -1; k <= 1; k++){
			for(int l = -1; l <= 1; l++){
				if(bordStatus[i + k][j + l] != myDisc && bordStatus[i + k][j + l] % 2 != 0){ //周囲が空・壁・同じ石ではない
					int k2 = i + k;
					int l2 = j + l;
					boolean flg = true;
					while(bordStatus[k2][l2] != myDisc){
						k2 += k;
						l2 += l;
						if(bordStatus[k2][l2] == 2 || bordStatus[k2][l2] == 0){
							flg = false;
							break;
						}
					}
					if(flg){
						k2 -= k;
						l2 -= l;
						while(!(i == k2 && j == l2)){
							bordStatus[k2][l2] = myDisc;
							k2 -= k;
							l2 -= l;
						}

						bordStatus[i][j] = myDisc;
						whiteCnt = 0;
						blackCnt = 0;
						for(int m = 0; m < bordStatus.length; m++){
							for(int n = 0; n < bordStatus[0].length; n++){
								if(bordStatus[m][n] == 1){
									whiteCnt++;
								}else if(bordStatus[m][n] == -1){
									blackCnt++;
								}
							}
						}
					}
				}
			}
		}
	}
}
