
public class Wall extends Block {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	public Wall() {
		
	}
	public Wall(int x, int y, int width, int height) {
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
	}
	public int getX() {
		return xPos;
	}
	public int getY() {
		return yPos;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
