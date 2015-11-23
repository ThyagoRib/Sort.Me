package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class ShellSort implements SortingAlgorithm {

	private final int[] gap = {701, 301, 132, 57, 23, 10, 4, 1};
	
	@Override
	public void sort(VisualArray array) {
		for (int h : gap) {
			array.changeState(0, array.getArraySize(), ArrayState.INACTIVE);
			
			for (int j = 0; j < array.getArraySize(); ++j)
				for (int k = j; k >= h; k -= h) {
					if (array.getIndexValue(k - h) < array.getIndexValue(k)) {
						array.countCompare();
						break;
					}
					else
						array.compareAndSwap(k, k - h);
				}
		}
		
		array.changeState(0, array.getArraySize(), ArrayState.SORTED);
		
	}

	@Override
	public String getName() {
		return "Shell Sort";
	}

}
