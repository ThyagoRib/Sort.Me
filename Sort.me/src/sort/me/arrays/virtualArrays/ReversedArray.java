package sort.me.arrays.virtualArrays;

public final class ReversedArray extends VirtualArray {

	@Override
	public void generate(int size) {
		values = new int[size];
		
		for (int i = 0; i < size; ++i)
			values[i] = size - i;

	}
	
	@Override
	public String getName() {
		return "Reversed Array";
	}

}
