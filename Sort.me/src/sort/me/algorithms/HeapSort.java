package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class HeapSort implements SortingAlgorithm {

	@Override
	public void sort(VisualArray array) {
		array.changeState(0, array.getArraySize(), ArrayState.INACTIVE);
		
		for (int i = array.getArraySize() - 1; i >= 0; --i)
			siftDown(array, i, array.getArraySize());
		
		for (int i = array.getArraySize() - 1; i >= 0; --i) {
			swap(array, 0, i);
			array.changeState(i, ArrayState.SORTED);
			siftDown(array, 0, i);
		}
	}
	
	private void siftDown(VisualArray array, int start, int end) {
		while (start * 2 + 1 < end) {
			int child = start * 2 + 1;
			array.countCompare();
			if (child + 1 < end && array.compare(child, child + 1))
				++child;
			if (array.compare(start, child))
				array.compareAndSwap(start, child);
			else {
				array.countCompare();
				break;
			}
			start = child;
				
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
		return "Heap Sort";
	}

}
