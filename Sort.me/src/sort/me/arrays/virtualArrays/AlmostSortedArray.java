package sort.me.arrays.virtualArrays;

public final class AlmostSortedArray extends VirtualArray {

	@Override
	public void generate(int size) {
		values = new int[size];
		
		for (int i = 0; i < size; ++i) {
			values[i] = i + 1;
		}
		
		for (int i = size/2; i < size; ++i) {
			values[i] = i + 2;
		}
		values[size - 1] = (size / 2) + 1;

	}
	
	@Override
	public String getName() {
		return "Almost Sorted Array";
	}

}
