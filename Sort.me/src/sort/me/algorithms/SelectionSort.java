package sort.me.algorithms;

import sort.me.Statistics;
import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class SelectionSort implements SortingAlgorithm {

	@Override
	public void sort(VisualArray array) {
		for (int i = 0; i < array.getArraySize(); ++i) {
			int minIndex = i;
			for (int j = i; j < array.getArraySize(); ++j) {
				array.countCompare();
				if (array.compare(j, minIndex))
					minIndex = j;
			}
			swap(array, i, minIndex);
			array.changeState(i, ArrayState.SORTED);
		}
		
	}
	
	private void swap(VisualArray array, int i, int j) {
		array.countSwap();
		
		int temp = array.getIndexValue(i);
		array.setIndexValue(i, array.getIndexValue(j));
		array.setIndexValue(j, temp);
	}

	@Override
	public String getName() {
		return "Selection Sort";
	}

}
