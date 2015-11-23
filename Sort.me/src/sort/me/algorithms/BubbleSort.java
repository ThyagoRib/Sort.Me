package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class BubbleSort implements SortingAlgorithm {

	@Override
	public void sort(VisualArray array) {
		for (int i = array.getArraySize() - 1; i >= 1; --i) {
			for (int j = 0; j < i; ++j) {
				array.compareAndSwap(j + 1, j);
			}
			array.changeState(i, ArrayState.SORTED);
		}
		array.changeState(0, ArrayState.SORTED);

	}

	@Override
	public String getName() {
		return "Bubble Sort";
	}

}
