package sort.me.arrays.virtualArrays;

public final class RandomArray extends VirtualArray {

	@Override
	public void generate(int size) {
		super.values = new int[size];
		
		for (int i = 0; i < size; ++i) {
			super.values[i] = i + 1;
		}
		
		shuffle(super.values);
		
	}
	
	@Override
	public String getName() {
		return "Random Array";
	}
}
