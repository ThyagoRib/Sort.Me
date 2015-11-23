package sort.me;

import java.awt.Component;

import javax.swing.JFrame;

final class AnimationFrame extends JFrame {
	
	private AnimationThread thread;

	public AnimationFrame(String name, Component component, AnimationThread thread) {
		super(name);
		this.thread = thread;
		add(component);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
