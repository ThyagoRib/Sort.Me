package sort.me;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import sort.me.algorithms.SortingAlgorithm;
import sort.me.arrays.graphicalArrays.VisualArray;

final class AnimationThread extends Thread {
	
	private SortingAlgorithm algorithm;
	private VisualArray array;
	
	public AnimationThread(VisualArray array, SortingAlgorithm algorithm) {
		this.array = array;
		this.algorithm = algorithm;
		
		new AnimationFrame(this.algorithm.getName(), this.array.getCanvas(), this);
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
			algorithm.sort(array);
			try {
				
				array.assertSorted();
				
				JOptionPane.showMessageDialog(null, algorithm.getName() + ", " + array.getName() + " size " + array.getArraySize() + " : " + array.getStatistics().getComparisons() 
						+ " comparisons, " + array.getStatistics().getSwaps() + " swaps.");
				
				System.out.printf("%s, %s size %d: %d comparisons, %d swaps.\n", algorithm.getName(), array.getName(), array.getArraySize(),
						array.getStatistics().getComparisons(), array.getStatistics().getSwaps());
			} catch (AssertionError e) {}
		} 
		catch (InterruptedException e) {}
		catch (StopThreadException e) {}
	}
	
	public void requestStop() {
		interrupt();
		array.requestStop();
	}

}
