import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
public class MainFrame extends JPanel {
	
	private MainMenu mainMenu;
	private JPanel currentView;
	public MainFrame(BlockBreaker9000 bb) {
		setLayout (new BorderLayout());
		mainMenu = new MainMenu(bb);
		add(mainMenu, BorderLayout.CENTER);
		currentView = mainMenu;
	}
	public void setView(JPanel view){
		remove(currentView);
		currentView=view;
		add(currentView);
		//currentView.requestFocusInWindow();
		revalidate();
		repaint();
	}
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}
}