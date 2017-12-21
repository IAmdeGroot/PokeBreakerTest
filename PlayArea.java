import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
//import Board.ScheduleTask;
//import Board.TAdapter;
public class PlayArea extends JPanel implements ObjectInfo, ActionListener {
	private Brick bricks[];
	private Timer timer;
	private ArrayList <Ball> ball = new ArrayList <Ball>();
	//private Background background;
	private boolean newBall = false;
	private Paddle paddle;
	private boolean inGame = true;
	BlockBreaker9000 bb;
	private int delay = 8;
	private int numberofBalls = 0;
	private int numberofBricks;
	private int numberofDestroyedBricks = 0;
	int blockColums = 8;
	int blockRow = 0;
	public PlayArea(BlockBreaker9000 bb){
		this.bb = bb;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.black);
		Dimension size = getPreferredSize();
		size.width = 825;
		size.height = 800;
		setPreferredSize(size);
		initPlayArea();
	}
	public void initPlayArea() {
		System.out.println(" INIT PLAY AREA!!!!!!!");
		addKeyListener(new ArrowKeys());
		blockRow += 1;
		numberofBricks = blockColums * blockRow;
		bricks = new Brick [numberofBricks];
		numberofDestroyedBricks = 0;
		paddle = new Paddle();
		ball.add(new Ball());
		setDoubleBuffered(true);
		int k = 0;
		for (int i = 0; i < blockRow; i++) {
			for (int j = 0; j < blockColums; j++) {
				bricks[k] = new Brick(j * 100 + 30, i * 25 + 50);
				k++;
			}
		}
		blockRow += 1;
		timer = new Timer(delay, (ActionListener) this);
		timer.start(); 
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (bb.getMf().getMainMenu().getPaf().getSb().getBalls() > 0 ) { drawObjects(g2d); 
		}else {
			gameOver(g2d);
		}
	}
	public void drawObjects (Graphics2D g2d) {
		//g2d.drawImage(background.getImage(), background.getX(), background.getY(), background.getWidth(), background.getHeight(), this);
		for (int b = 0; b<= numberofBalls; b++) {
			g2d.drawImage(ball.get(b).getImage(), ball.get(b).getX(), ball.get(b).getY(),
					ball.get(b).getWidth(), ball.get(b).getHeight(), this);
		}
		g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
				paddle.getWidth(), paddle.getHeight(), this);
		for (int i = 0; i < numberofBricks; i++) {
			if (!bricks[i].isDestroyed()) {
				if (i <= 8) {
					bricks[i].paintBricks(g2d, Color.GREEN);
				}else if (i>8 && i<=16) {
					bricks[i].paintBricks(g2d, Color.MAGENTA);
					//}
				}else if (i>16 && i <=24) {
					bricks[i].paintBricks(g2d, Color.CYAN);
				}else if (i>24 && i<=32) {
					bricks[i].paintBricks(g2d, Color.YELLOW);
				}else if (i>32 && i<=40) {
					bricks[i].paintBricks(g2d, Color.RED);
				}else if (i>40) {
					bricks[i].paintBricks(g2d, Color.BLUE);
				}else if (i >48) {
					bricks[i].paintBricks(g2d, Color.PINK);
				}else if (i>56) {
					bricks[i].paintBricks(g2d, Color.ORANGE);
				}else if (i>64) {
					bricks[i].paintBricks(g2d, Color.GREEN);
				}
			}
		}
	}
	private class ArrowKeys extends KeyAdapter {	
		@Override
		public void keyReleased(KeyEvent e) {
			paddle.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			paddle.keyPressed(e);
		}
	}
	public void actionPerformed(ActionEvent e) {
		this.setFocusable(true);
		this.requestFocusInWindow();
		timer.start();
		for (int b = 0; b<= numberofBalls; b++) {
			ball.get(b).move();
		}
		paddle.move();
		Collision();
		repaint();
	}
	public void bottomEdgeHit(int b) {
		int i = bb.getMf().getMainMenu().getPaf().getSb().getBalls();
		i--;
		if (b == 0) {
			bb.getMf().getMainMenu().getPaf().getSb().setBalls(i);
			ball.get(b).respawnBall();
			repaint();
		}
	}
	private void gameOver(Graphics2D g2d) {
		Font font = new Font("Verdana", Font.BOLD, 75);
		FontMetrics metr = this.getFontMetrics(font);
		String gameover = ("GAME OVER");
		g2d.setColor(Color.ORANGE);
		g2d.setFont(font);
		g2d.drawString(gameover,(ObjectInfo.FONTWIDTH - metr.stringWidth(gameover)) / 2,ObjectInfo.FONTHEIGHT / 2);
		System.out.println("GAME VER RINTED");
		JOptionPane HS = new JOptionPane();
		timer.stop();
		// HS.showInputDialog("Name :", HS.);
		String inputValue = HS.showInputDialog("Name: ");
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	private void nextLevel() {
		int lev = bb.getMf().getMainMenu().getPaf().getSb().getLevel();
		lev++;
		bb.getMf().getMainMenu().getPaf().getSb().setLevel(lev);
		System.out.println("NEXT LEVEL ACTIVE");
		initPlayArea();
	}
	private void extraBall() {
		Ball bonusBall = new Ball();
		bonusBall.setXDir(1.5);
		ball.add(bonusBall);
		numberofBalls +=1;
		newBall = true;
	}
	private void Collision() {
		for (int b = 0; b<= numberofBalls; b++) {
			if (ball.get(b).getRect().getMaxY() > BOTTOM_EDGE)  {
				bottomEdgeHit(b);
			}
			if ((ball.get(b).getRect()).intersects(paddle.getRect())) {
				System.out.println("INTERSCT PADDLE");
				//extraBall();
				int paddleLPos = (int) paddle.getRect().getMinX();
				int ballLPos = (int) ball.get(b).getRect().getMinX();
				int megafirst = paddleLPos + 16;
				int superfirst = paddleLPos + 32;
				int first = paddleLPos + 48;
				int second = paddleLPos + 64;
				int third = paddleLPos + 80;
				int fourth = paddleLPos + 96;
				int last = paddleLPos + 112;
				int verylast = paddleLPos + 128;
				if (ballLPos < megafirst) {
					ball.get(b).setXDir(-1.84);
					ball.get(b).setYDir(-0.78);
				}
				if (ballLPos >= megafirst && ballLPos < superfirst) {
					ball.get(b).setXDir(-1.4);
					ball.get(b).setYDir(-1.4);
				}
				if (ballLPos >= superfirst && ballLPos < first) {
					ball.get(b).setXDir(-0.80);
					ball.get(b).setYDir(-1.84);// * ball.getYDir());;
					// Om bollen träffar hitbox 0-7 flyger bollen åt vänster/uppåt. 45 grader.
				}
				if (ballLPos >= first && ballLPos < second) {
					ball.get(b).setXDir(0);
					ball.get(b).setYDir(-2);
					// Om ballPos är mindre än eller = 8 och mindre än 16. Flyger bollen 26.5 grader till vänster/uppåt.
					// Då Ydir i det här fallet är 2. Vilket gör att bollen flyger i högre hastighet uppåt.
				}
				if (ballLPos >= second && ballLPos < third) {
					ball.get(b).setXDir(0);
					ball.get(b).setYDir(-2);//0.12 * ball.getYDir());
				}
				if (ballLPos >= third && ballLPos < fourth) {
					ball.get(b).setXDir(1.8);
					ball.get(b).setYDir(-1.84);
					// Om bollen träffar hitbox mellan third och fourth flyger bollen 26.5 grader till höger/uppåt.
					// Då Ydir i det här fallet är 2. Vilket gör att bollen flyger i högre hastighet uppåt.
				}
				if (ballLPos >= fourth && ballLPos < last) {
					ball.get(b).setXDir(1.4);
					ball.get(b).setYDir(-1.4);
				}
				if (ballLPos >= last && ballLPos < verylast) {
					ball.get(b).setXDir(2.84);
					ball.get(b).setYDir(-0.78);
					// Om bollen träffar hitbox 24-31 flyger bollen åt höger/uppåt. 45 grader.
				}
			}
			for (int i = 0; i < numberofBricks; i++) {	
				//if (ball.getRect().intersects(bricks[i].getRect())) {
				if(ball.get(b).getBounds().intersects(bricks[i].getBounds())){
					if(!bricks[i].isDestroyed()){
						int ballLeft = (int) ball.get(b).getRect().getMinX();
						int ballHeight = (int) ball.get(b).getRect().getHeight();
						int ballWidth = (int) ball.get(b).getRect().getWidth();
						int ballTop = (int) ball.get(b).getRect().getMinY();
						Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
						Point pointLeft = new Point(ballLeft - 1, ballTop);
						Point pointTop = new Point(ballLeft, ballTop - 1);
						Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);
						//if (!bricks[i].isDestroyed()) {
						if (bricks[i].getBounds().contains(pointRight)) {
							ball.get(b).setXDir(-2);
						}if (bricks[i].getBounds().contains(pointLeft)) {
							ball.get(b).setXDir(2);
						}if (bricks[i].getBounds().contains(pointTop)) {
							ball.get(b).setYDir(2);
						}if (bricks[i].getBounds().contains(pointBottom)) {
							ball.get(b).setYDir(-2);
						}
						bricks[i].setDestroyed(true);
						numberofDestroyedBricks += 1;
						addScore(i);
						Random ran = new Random();
						int x = ran.nextInt(10);
						System.out.println(x);
						if (x == 5) {
							extraBall();
						}
					}
				}
			}
		}
	}
	private void addScore(int i) {
		int x = bb.getMf().getMainMenu().getPaf().getSb().getScore();
		if (bricks[i].isDestroyed()){
			if(bricks[i].getColor()==Color.yellow){
				x+=60;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
			if(bricks[i].getColor()==Color.green){
				x+=50;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
			if(bricks[i].getColor()==Color.red){
				x+=40;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
			if(bricks[i].getColor()==Color.magenta){
				x+=30;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
			if(bricks[i].getColor()==Color.cyan){
				x+=20;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
			if(bricks[i].getColor()==Color.blue){
				x+=10;
				bb.getMf().getMainMenu().getPaf().getSb().setScore(x);
			}
		}
		if (numberofDestroyedBricks == numberofBricks) {
			timer.stop();
			nextLevel();
		}
	}
}
