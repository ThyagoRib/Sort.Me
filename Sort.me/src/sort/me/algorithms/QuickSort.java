package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class QuickSort implements SortingAlgorithm {
	
	
	@Override
	public void sort(VisualArray array) {
		sort(array, 0, array.getArraySize());
	}
	
	private void sort(VisualArray array, int start, int end) {
		if (start == end)
			return;
		
		array.changeState(start, end, ArrayState.INACTIVE);
		
		int splitPivot = start;
		int pivot = end - 1;
		
		for (int i = start; i < end - 1; ++i) {
			if (array.compare(i, pivot)) {	
				array.compareAndSwap(i, splitPivot);
				array.changeState(splitPivot, ArrayState.INACTIVE);
				++splitPivot;
			} else
				array.countCompare();
		}
		
		swap(array, pivot, splitPivot);
		pivot = splitPivot;
		array.changeState(pivot, ArrayState.SORTED);
		array.changeState(pivot + 1, end, ArrayState.INACTIVE);
		
		sort(array, start, pivot);
		sort(array, pivot + 1, end);
	}
	
	private void swap(VisualArray array, int i, int j) {
		array.countSwap();
		
		int temp = array.getIndexValue(i);
		array.setIndexValue(i, array.getIndexValue(j));
		array.setIndexValue(j, temp);
	}

	@Override
	public String getName() {
		return "Quick Sort (last element pivot)";
	}

}
