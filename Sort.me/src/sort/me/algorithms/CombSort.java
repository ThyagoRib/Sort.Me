package sort.me.algorithms;

import sort.me.arrays.graphicalArrays.ArrayState;
import sort.me.arrays.graphicalArrays.VisualArray;

public final class CombSort implements SortingAlgorithm {
	
	private final double shrinkFactor = 1.247330950103979;
	private volatile boolean swaped = true;
	
	@Override
	public void sort(VisualArray array) {
		array.changeState(0, array.getArraySize(), ArrayState.INACTIVE);
		
		int gap = array.getArraySize();
		
		while (gap > 1 || swaped) {
			if (gap > 1)
				gap = (int) (gap/shrinkFactor);
			
			int i = 0;
			swaped = false;
			
			while (gap + i < array.getArraySize()) {
				
				if (array.compare(i + gap, i)) {
					array.compareAndSwap(i + gap, i);
					swaped = true;
				} else
					array.countCompare();
				
				++i;
			}
		}
		
		array.changeState(0, array.getArraySize(), ArrayState.SORTED);
		
	}

	@Override
	public String getName() {
		return "Comb Sort";
	}

}
