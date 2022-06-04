
package pingponggame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Özgür
 */
public class Build extends JPanel implements ActionListener{
    private final Ball ball;
    private final Stick stick;
    private final Timer timer = new Timer(5, this);
    private final JFrame frame = new JFrame("Ping Pong");

    public Build(){
        frame.setBounds(0,0, 300, 300);
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        int x = (frame.getWidth() - 50) / 2;
        int y = (frame.getHeight() - 50) / 2;
        ball = new Ball(x, y);
        
        stick = new Stick();
        frame.addKeyListener(stick);
        
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(ball.getxPos(), ball.getyPos(), ball.getWIDTH(), ball.getHEIGHT());
        
        g.setColor(Color.red);
        g.fillRect(stick.getxPos(), stick.getyPos(), stick.getWIDTH(), stick.getHEIGHT());
    }
    
    public void controlBall(){
        if(ball.getxPos() >= (frame.getWidth() - 30) || ball.getxPos() <= 0){
            ball.setxCha(-(ball.getxCha()));
        }
        if(ball.getyPos() <= 0){
            ball.setyCha(-(ball.getyCha()));                    
        }
        if(ball.getxPos() <= (stick.getxPos() + stick.getWIDTH()) && ball.getxPos() >= stick.getxPos() - 9 && 
                ball.getyPos() >= stick.getyPos() - 18){
            ball.setyCha(-(ball.getyCha()));        
        }
    }
    
    public void stickLimit(){
        if(stick.getxPos() <= 0){
            stick.setxPos(0);
        }
        if(stick.getxPos() >= frame.getWidth() - stick.getWIDTH() - 15){
            stick.setxPos(frame.getWidth() - stick.getWIDTH() - 15);
        }
    }
    
    public void winCheck(){
        if(ball.getyPos() >= stick.getyPos()){
            JOptionPane.showMessageDialog(frame, "KAYBETTİNİZ");
            System.exit(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            winCheck();
            stickLimit();
            controlBall();
            ball.move();
            repaint();
            sleep(25);
        } catch (InterruptedException ex) {
            Logger.getLogger(Build.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
