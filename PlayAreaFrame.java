import java.awt.BorderLayout;
import javax.swing.JPanel;
public class PlayAreaFrame extends JPanel {
	
	private StatusBar sb;
	private PlayArea pa;
	private BlockBreaker9000 bb;
	
	
	
	public PlayAreaFrame(BlockBreaker9000 bb) {
		this.bb = bb;
		setLayout(new BorderLayout());
		pa = new PlayArea(bb);
		bb.getMf().getMainMenu().setPaf(this);
		add(pa, BorderLayout.CENTER);
		sb = new StatusBar(bb);
		add(sb, BorderLayout.NORTH); 
		
		
	}
	
	public void updateView() {
		
		bb.getMf().setView(this);
		
		
	}
	
	public PlayArea getPa() {
		return pa;
	}
	public void setPa(PlayArea pa) {
		this.pa = pa;
	}
	
	
	
	public StatusBar getSb() {
		return sb;
	}
	public void setSb(StatusBar sb) {
		this.sb = sb;
	}
	
	
	
}