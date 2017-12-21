import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class HighscoreFrame extends JPanel {
private BlockBreaker9000 bb;
	public HighscoreFrame(BlockBreaker9000 bb){
		this.bb = bb;
		bb.getMf().setView(this);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.black);
		Dimension size = getPreferredSize();
		size.width = 700;
		size.height = 500;
		setPreferredSize(size);
		TopBar topbar = new TopBar(bb);
		add(topbar, BorderLayout.NORTH);
	}
	
public void updateView() {
		
		bb.getMf().setView(this);
		
		
	}
	
	
	class TopBar extends JPanel {
		public TopBar(final BlockBreaker9000 bb){
			Dimension size = getPreferredSize();
			size.width = 700;
			size.height = 50;
			setPreferredSize(size);
			setBackground(Color.BLACK);
			setLayout(new GridLayout(1,3));
			JLabel highscore = new JLabel("HIGH SCORE");
			JButton mainMenu = new JButton("Main Menu");
			JPanel dummyPanel = new JPanel();
			mainMenu.setFont(new Font("Arial", Font.BOLD, 20));
			mainMenu.setForeground(Color.ORANGE);
			mainMenu.setBackground(Color.BLACK);
			highscore.setFont(new Font("Arial", Font.BOLD, 20));
			highscore.setForeground(Color.ORANGE);
			highscore.setBackground(Color.BLACK);
			dummyPanel.setBackground(Color.BLACK);
			add(dummyPanel);
			add(highscore);
			add(mainMenu);
			
			mainMenu.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					MainMenu menu = new MainMenu(bb);
					bb.getMf().setView(menu);
				}
			});
		}
	}
}