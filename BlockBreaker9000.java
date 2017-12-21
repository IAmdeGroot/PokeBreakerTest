import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
public class BlockBreaker9000 {
	
	private MainFrame mf;
	
	private JFrame frame;
	
	
	public BlockBreaker9000() {
		frame = new JFrame ("BlockBreaker 9000");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(825,800));
		frame.setResizable(false);
		
		MainFrame mainFrame = new MainFrame(this);
		frame.add(mainFrame);
		mf=mainFrame;
		frame.pack();
		frame.setVisible(true);
		
	}
	public MainFrame getMf() {
		return mf;
	}
	
	public static void main(String[] args) {
		BlockBreaker9000 game = new BlockBreaker9000();
			
	}
	
}