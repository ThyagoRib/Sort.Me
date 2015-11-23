package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class CocktailSort implements SortingAlgorithm {

	@Override
	public void sort(VisualArray array) {
		int left = 0;
		int right = array.getArraySize() - 1;
		int i = left;
		
		while (left < right) {
			for (; i + 1 < right; ++i)
				array.compareAndSwap(i + 1, i);
			array.changeState(i, ArrayState.SORTED);
			--right;
			++i;
			
			if (left == right)
				break;
			
			for (; i > left; --i)
				array.compareAndSwap(i, i - 1);
			array.changeState(i, ArrayState.SORTED);
			++left;
			++i;
		}
		
		array.changeState(0, array.getArraySize(), ArrayState.SORTED);

	}

	@Override
	public String getName() {
		return "Cocktail Sort";
	}

}
