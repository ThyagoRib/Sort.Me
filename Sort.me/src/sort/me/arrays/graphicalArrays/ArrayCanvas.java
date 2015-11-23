package sort.me.arrays.graphicalArrays;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ArrayCanvas extends Canvas {
	
	private BufferedImage bufferedImage;
	private Graphics bufferedGraphics;
	
	public ArrayCanvas(int size){
		setSize(size, size);
		bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_BGR);
		bufferedGraphics = bufferedImage.getGraphics();
	}
	
	public Graphics getBufferedGraphics() {
		return bufferedGraphics;
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(bufferedImage, 0, 0, this);
	}
}
