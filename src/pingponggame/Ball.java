
package pingponggame;

/**
 *
 * @author Özgür
 */
public class Ball {
    private int xPos = 0;
    private int yPos = 0;
    private int xCha = 2;
    private int yCha = 2;
    private final int WIDTH = 18;
    private final int HEIGHT = 18;

    public Ball(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void move(){
        setxPos(getxPos() + getxCha());
        setyPos(getyPos() + getyCha());
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getxCha() {
        return xCha;
    }

    public void setxCha(int xCha) {
        this.xCha = xCha;
    }

    public int getyCha() {
        return yCha;
    }

    public void setyCha(int yCha) {
        this.yCha = yCha;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
    
    
}
