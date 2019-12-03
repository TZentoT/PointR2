import javax.swing.*;
import java.awt.*;

public class UserWindow extends JFrame {
    Convex sample;

    public UserWindow(){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public UserWindow(Convex convex){
        this();
        sample = convex;
    }

    @Override
    public void paint(Graphics g){
        g.clearRect(0,0,2000,2000);
        g.translate(this.getWidth()/2,this.getHeight()/2);
        g.drawLine(-this.getWidth()/2,0,this.getWidth()/2,0);
        g.drawLine(0,getHeight()/2,0,-this.getHeight()/2);
        sample.draw(g);
    }
    
}
