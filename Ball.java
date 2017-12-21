import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Ball extends Sprite implements ObjectInfo {
    private double xdir;
    private double ydir;
    public Ball() {
        xdir = 0;
        ydir = -2;
        ImageIcon ii = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/ball.png");
        image = ii.getImage();
        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        resetState();
    }
    public void move() {
        
        x += xdir;
        y += ydir;
        if (x <= 0) {
            setXDir(2);
        }
        if (x >= WIDTH - i_width) {
            setXDir(-2);
        }
        if (y <= 0) {
            setYDir(2);
        }
       
    }
    public void resetState() {
        
        x = INIT_BALL_X;
        y = INIT_BALL_Y;
       
        
    }
    
 public void respawnBall() {
        
        x = INIT_BALL_X;
        y = INIT_BALL_Y;
        xdir=0;
        ydir=-2;
        
    }
    public void setXDir(double x) {
        xdir = x;
    }
    public void setYDir(double y) {
        ydir = y;
    }
    public double getXDir() {
    	return xdir;
    }
    
    public double getYDir() {
        return ydir;
    }
    public Rectangle getBounds(){
    	return new Rectangle(getX(), getY(), i_width, i_heigth);
    }
}