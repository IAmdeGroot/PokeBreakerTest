import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class MainMenu extends JPanel{
	
	
	private PlayAreaFrame paf;
	private HighscoreFrame hf;
	private PlayArea pa;
	private BlockBreaker9000 bb;
	
	
	public MainMenu(final BlockBreaker9000 bb) {
		
	
		this.bb=bb;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setBackground(Color.BLACK);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Dimension size = getPreferredSize();
		size.width = 800;
		size.height = 600;
		setPreferredSize(size);
		ImageIcon Ditto = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/Ditto.png");
		ImageIcon Weepinbell = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/Weepinbell.png");
		ImageIcon Dugtrio = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/Dugtrio.png");
		ImageIcon Psyduck = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/Psyduck.png");
		ImageIcon Logo = new ImageIcon("/Users/johandegroot/Documents/workspace/BlockBreaker/src/BLOCKTHEBREAK.png");
		
		
		JButton play = new JButton("PLAY");
		play.setForeground(Color.ORANGE);
		play.setBackground(Color.BLACK);
		play.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		play.setFont(new Font("Playbill", Font.BOLD, 30));
		
		
		JButton highscore = new JButton("HIGH SCORE");
		highscore.setForeground(Color.ORANGE);
		highscore.setBackground(Color.BLACK);
		highscore.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		highscore.setFont(new Font("Playbill", Font.BOLD, 30));
		
		
		
		JLabel PsyduckLabel = new JLabel(Psyduck);
		JLabel LogoLabel = new JLabel(Logo);
		JLabel DittoLabel = new JLabel(Ditto);
		JLabel WeepinBellLabel = new JLabel(Weepinbell);
		JLabel DugtrioLabel = new JLabel(Dugtrio);
		
	
		
		this.setLayout(new FlowLayout());
		this.add(LogoLabel);
		this.add(PsyduckLabel);
		this.add(play);
		this.add(DittoLabel);
		this.setBackground(Color.BLACK);
		this.add(WeepinBellLabel);
		this.add(highscore);
		this.add(DugtrioLabel);
		
		
		
		
		play.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				PlayAreaFrame game = new PlayAreaFrame(bb);
				paf = game;
				game.updateView();
				//pa.initPlayArea();
				
				
			}
		});
		
		
		highscore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				HighscoreFrame highscoreFrame = new HighscoreFrame(bb);
			}
		});
		
	}
	
		
	
		
		
		
		
		
		
//		int i = 3;
//		int j = 3;
//			
//
//
//		JPanel[][] paneHolder = new JPanel[i][j];
//		setLayout(new GridLayout(i,j));
//		for (int m = 0; m<j; m++) {
//			for (int n = 0; n<j; n++) {
//				paneHolder[m][n] = new JPanel();
//				paneHolder[m][n].setBackground(Color.BLACK);
//				add(paneHolder[m][n]);
//
//			}
//		}
        
		
//		 ImageIcon Breaker = new ImageIcon("/home/johde234/TDDE10/BlockBreaker9000/src/BREAKER.png");
//		    
//		 JLabel Breaker_ = new JLabel(Breaker);
//		 paneHolder[0][1].add(Breaker_);
//		
		
//		JLabel block = new JLabel("BLOCKBREAKER 9000");
//		block.setForeground(Color.cyan);
//		block.setBackground(Color.BLACK);
//		block.setFont(new Font("Playbill", Font.BOLD, 20));
//		paneHolder[0][1].add(block);
//
//		JButton play = new JButton("PLAY");
//		play.setForeground(Color.ORANGE);
//		play.setBackground(Color.BLACK);
//		play.setBorder(BorderFactory.createLineBorder(Color.black, 5));
//		play.setFont(new Font("Playbill", Font.BOLD, 30));
//		//paneHolder[20][1].add(new JLabel("BLOCKBREAKER 9000"));
//		paneHolder[1][1].add(play);
//
//		JButton highscore = new JButton("HIGH SCORE");
//		highscore.setForeground(Color.ORANGE);
//		highscore.setBackground(Color.BLACK);
//		highscore.setBorder(BorderFactory.createLineBorder(Color.black, 5));
//		highscore.setFont(new Font("Playbill", Font.BOLD, 30));
//		paneHolder[2][1].add(highscore);
//		
		
		
//		play.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				PlayAreaFrame game = new PlayAreaFrame(bb);
//				paf = game;
//				game.updateView();
//				//pa.initPlayArea();
//				
//				
//			}
//		});
//		
//		
//		highscore.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				HighscoreFrame highscoreFrame = new HighscoreFrame(bb);
//			}
//		});
//		
//		
//	}
		
		//		JLabel logo = new JLabel("             BLOCKBREAKER 9000");
		//		logo.setForeground(Color.RED);
		//		add(logo);
		//		
		//		
		//		JButton play = new JButton("PLAY");
		//		play.setBackground(Color.RED);
		//		add(play, BorderLayout.CENTER);
		//		
		//		
		//		JButton highscore = new JButton("HIGH SCORE");
		//		highscore.setBackground(Color.RED);
		//		add(highscore, BorderLayout.SOUTH);
		public PlayAreaFrame getPaf() {
			return paf;
		}
		public void setPaf(PlayAreaFrame paf) {
			this.paf = paf;
		}
		public HighscoreFrame getHf() {
			return hf;
		}
		public void setHf(HighscoreFrame hf) {
			this.hf = hf;
		}
		
		public void updateView() {
			
			bb.getMf().setView(this);
			
			
		}
	}
