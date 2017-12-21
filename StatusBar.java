import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class StatusBar extends JPanel {
	private JLabel balLabel;
	private JLabel scoreLabel;
	private JLabel levelLabel;
	private int score =0;
	private int balls = 5;
	private int level = 1;
	public StatusBar(final BlockBreaker9000 bb) {
		Dimension size = getPreferredSize();
		size.width = 600;
		size.height = 50;
		setPreferredSize(size);
		setLayout(new GridLayout(1,4));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(Color.black);
		scoreLabel = new JLabel("Score: " + score);
		balLabel = new JLabel("Balls: " + balls);
		levelLabel = new JLabel("Level: " + level);
		JButton menuButton = new JButton("Main Menu");
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
		scoreLabel.setForeground(Color.ORANGE);
		balLabel.setFont(new Font("Arial", Font.BOLD, 20));
		balLabel.setForeground(Color.ORANGE);
		levelLabel.setFont(new Font("Arial", Font.BOLD, 20));
		levelLabel.setForeground(Color.ORANGE);
		menuButton.setBackground(Color.BLACK);
		menuButton.setForeground(Color.ORANGE);
		menuButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		add(scoreLabel);
		add(balLabel);
		add(levelLabel);
		add(menuButton);
		
		menuButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu menu = new MainMenu(bb);
				
				//bb.getMf().getMainMenu().updateView();
				bb.getMf().getMainMenu().getPaf().getPa().getTimer().stop();
				setBalls(5);
				bb.getMf().setView(menu);
				
				
				
			}
		});
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
		scoreLabel.setText("Score: " + score);
		scoreLabel.repaint();
	}
	public int getBalls() {
		return balls;
	}
	public void setBalls(int balls) {
		this.balls = balls;
		balLabel.setText("Balls: " + balls);
		balLabel.repaint();
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		levelLabel.setText("Level: " + level);
		levelLabel.repaint();
	}
}