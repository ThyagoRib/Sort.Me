package sort.me.arrays.virtualArrays;

import java.util.Random;

public final class FewUniqueArray extends VirtualArray {

	@Override
	public void generate(int size) {
		values = new int[size];
		
		Random seed = new Random();
		int temp = seed.nextInt(9);
		
		while (temp == 0 || temp == 1)
			temp = seed.nextInt(9);		
		
		for (int i = 0; i < size; ++i) {
			values[i] = (1 + i / (size / temp) ) * (size / temp);
		}
		
		shuffle(values);
	}
	
	@Override
	public String getName() {
		return "Few Unique Array";
	}

}
