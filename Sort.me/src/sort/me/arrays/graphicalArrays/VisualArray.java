package sort.me.arrays.graphicalArrays;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import sort.me.Statistics;
import sort.me.StopThreadException;
import sort.me.arrays.virtualArrays.VirtualArray;

public class VisualArray {
	
	private VirtualArray virtualArray;
	private ArrayState[] virtualArrayState;
	private volatile Statistics statistics;
	
	private volatile boolean requestStop = false;
	
	private final static int barScale = 7;
	private ArrayCanvas canvas;
	private Graphics graphics;
	
	private final static Color[] Colors = {
		Color.GRAY,
		Color.LIGHT_GRAY,
		Color.BLUE,
		Color.GREEN,
		
	};
	
	private final static int animationDelay = 20;
	private int stepsToExecute = 1;
	private int stepsSinceRepaint = 0;
	
	public VisualArray(VirtualArray virtualArray) {
		this.virtualArray = virtualArray;
		virtualArrayState = new ArrayState[virtualArray.getSize()];
		Arrays.fill(virtualArrayState, ArrayState.ACTIVE);
		
		statistics = new Statistics();
		
		canvas = new ArrayCanvas(barScale * virtualArray.getSize());
		graphics = canvas.getBufferedGraphics();
		redraw(0, getArraySize());
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public int getArraySize() {
		return virtualArray.getSize();
	}
	
	public Statistics getStatistics() {
		return statistics;
	}
	
	public String getName() {
		return virtualArray.getName();
	}
	
	public int getIndexValue(int index) {
		return virtualArray.getIndexValue(index);
	}
	
	public void setIndexValue(int index, int value) {
		virtualArray.setIndexValue(index, value);
	}
	
	public void countCompare() {
		statistics.countCompare();
	}
	
	public void countSwap() {
		statistics.countSwap();
	}
	
	public void requestStop() {
		requestStop = true;
	}
	
	public void assertSorted() {
		for (int i = 1; i < getArraySize(); ++i)
			if (virtualArray.getIndexValue(i - 1) > virtualArray.getIndexValue(i))
				throw new AssertionError();
		redraw(0, getArraySize());
		canvas.repaint();
	}
	
	public boolean compare(int i, int j) {
		if (requestStop)
			throw new StopThreadException();
		
		changeState(i, ArrayState.COMPARING);
		changeState(j, ArrayState.COMPARING);
		requestRepaint();
		
		changeState(i, ArrayState.ACTIVE);
		changeState(j, ArrayState.ACTIVE);
		
		if (virtualArray.getIndexValue(i) < virtualArray.getIndexValue(j)) 
			return true;
		else 
			return false;
	}
	
	public void compareAndSwap(int i, int j) {
		if (requestStop)
			throw new StopThreadException();
		
		statistics.countCompare();
		
		changeState(i, ArrayState.COMPARING);
		changeState(j, ArrayState.COMPARING);
		requestRepaint();
		if (virtualArray.swap(i, j))
			statistics.countSwap();
		
		changeState(i, ArrayState.ACTIVE);
		changeState(j, ArrayState.ACTIVE);
		requestRepaint();
	}
	
	public void changeState(int index, ArrayState state) {
		if (virtualArrayState[index] == ArrayState.SORTED)
			return;
		virtualArrayState[index] = state;
	}
	
	public void changeState(int start, int end, ArrayState state) {
		for (int i = start; i < end; ++i)
			changeState(i, state);
		redraw(start, end);
	}
	
	private void redraw(int start, int end) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, start * barScale, getArraySize() * barScale,
				(end - start) * barScale);
		
		for (int i = start; i < end; ++i) {
			graphics.setColor(Colors[virtualArrayState[i].getValue()]);
			graphics.fillRect(0, i * barScale, (virtualArray.getIndexValue(i) + 1) * barScale,
					barScale);
		}
	}
	
	private void requestRepaint() {
		++stepsSinceRepaint;
		if (stepsSinceRepaint >= stepsToExecute) {
			canvas.repaint();
			redraw(0, getArraySize());
			try {
				Thread.sleep(animationDelay);
			} catch (InterruptedException e) {}
			
			stepsSinceRepaint = 0;
		}
	}
}
