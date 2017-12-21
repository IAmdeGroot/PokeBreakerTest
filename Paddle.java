import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Paddle extends Sprite implements ObjectInfo {
	
	private int dir;
	
	
	public Paddle() {
		
		ImageIcon paddlePic = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/redpad.png/");
		image = paddlePic.getImage();
		i_width = image.getWidth(null);
		i_heigth = image.getHeight(null);
		setPositionPaddle();
		
	}
	public void keyPressed(KeyEvent d) {
	
		
		if (d.getKeyCode() == KeyEvent.VK_LEFT) {
			dir = -5;
		}
		
		if (d.getKeyCode() == KeyEvent.VK_RIGHT) {
			dir = 5;
		}
		
		
	}
	
	public void keyReleased(KeyEvent d) {
		
		
		if (d.getKeyCode() == KeyEvent.VK_LEFT) {
			dir = 0;
		}
		
		if (d.getKeyCode() == KeyEvent.VK_RIGHT) {
			dir = 0;
		}
		
	}
	
	
	  public void move() {
		
	        x += dir;
	        if (x <= 0) {
	            x = 0;
	        }
	        if (x >= WIDTH - i_width) {
	            x = WIDTH - i_width;
	        }
	    }
	
	
	  private void setPositionPaddle() {
	        x = INIT_PADDLE_X;
	        y = INIT_PADDLE_Y;
	    }
	  
	
	
	
//	public int getHeight() {
//		return height;
//	}
//
//	public void setHeight(int height) {
//		this.height = height;
//	}
//	public int getWidth() {
//		return width;
//	}
//
//	public void setWidth(int width) {
//		this.width = width;
//	}
	public int getX() {
		return x;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
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