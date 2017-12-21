import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Brick extends Sprite {
	
	private int h = 20;
	private int w = 60;
	private Color color;
    private boolean destroyed;
    
    
    public Brick(int x, int y) {
        
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon("/home/johde234/TDDE10/Project/src/brick.png/");
        image = ii.getImage();
        i_width = image.getWidth(null);
        i_heigth = image.getHeight(null);
        destroyed = false;
    }
    
    public void paintBricks(Graphics g, Color c){
    	color = c;
		g.setColor(c);
    	g.fillRect(getX(), getY(), w, h);
		
		
	}
     
    public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isDestroyed() {
        
        return destroyed;
    }
    public void setDestroyed(boolean truefalse) {
        
        destroyed = truefalse;
    }
    public Rectangle getBounds(){
    	return new Rectangle(getX(), getY(), w, h);
    }
}