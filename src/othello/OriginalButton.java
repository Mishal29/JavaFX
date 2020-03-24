package othello;

import javafx.scene.control.Button;

public class OriginalButton extends Button{
	private int x;
	private int y;



	public OriginalButton(String str ,int x, int y) {
		super(str);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
