package sort.me;

import javax.swing.JFrame;

public class SortMe extends JFrame {
		
	ControlPanel mainPanel;
	
	public SortMe() {
		super("Sort.Me");
		
	}

	public static void main(String[] args) {
		JFrame frame = new SortMe();
		ControlPanel mainPanel = ControlPanel.getPanelInstance();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(320, 180);
		frame.add(mainPanel);
		frame.setVisible(true);
	}

}
