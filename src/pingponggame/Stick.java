
package pingponggame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Özgür
 */
public class Stick implements KeyListener {
    private int xPos = 150;
    private int yPos = 200;
    private final int WIDTH = 50;
    private final int HEIGHT = 10;
    
    @Override
    public void keyTyped(KeyEvent e) {       
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()== 'a'){
            setxPos(getxPos() - 4);
        }
        if(e.getKeyChar()== 'd'){
            setxPos(getxPos() + 4);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

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

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
    
    
}
