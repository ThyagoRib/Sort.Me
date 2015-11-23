package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class InsertionSort implements SortingAlgorithm {

	@Override
	public void sort(VisualArray array) {
		array.changeState(0, array.getArraySize(), ArrayState.INACTIVE);
		
		for (int i = 0; i < array.getArraySize(); ++i)
			for (int j = i; j >= 1; --j) {
				if (array.getIndexValue(j - 1) < array.getIndexValue(j) ) {
					array.countCompare();
					break;
				}
				else
					array.compareAndSwap(j, j - 1);
			}
		
		array.changeState(0, array.getArraySize(), ArrayState.SORTED);

	}

	@Override
	public String getName() {
		return "Insertion Sort";
	}

}
