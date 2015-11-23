package sort.me.arrays.virtualArrays;

import java.util.Random;

import sort.me.Statistics;

public abstract class VirtualArray {
	
	protected int[] values;
	
	public void shuffle(int[] array) {
		Random seed = new Random();
		
		for (int i = 0; i < values.length; ++i) {			
			int index = seed.nextInt(values.length);
			
			int temp = values[index];
			values[index] = values[i];
			values[i] = temp;
		}
	}
	
	public boolean swap(int i, int j) {
		if (values[i] < values[j]) {
			int tmp = values[i];
			values[i] = values[j];
			values[j] = tmp;
			return true;
		} else
			return false;
		
	}
	
	public void setIndexValue(int index, int value) {
		values[index] = value;
	}
	
	public int getSize() {
		return values.length;
	}
	
	public int getIndexValue(int index) {
		return values[index];
	}

	public abstract void generate(int size);
	
	public abstract String getName();
	
}
