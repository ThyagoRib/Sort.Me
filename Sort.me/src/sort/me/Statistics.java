package sort.me;

public class Statistics {
	private int swap;
	private int compare;
	
	public Statistics() {
		swap = 0;
		compare = 0;
	}
	
	public void countSwap() {
		++swap;
	}
	
	public void countCompare() {
		++compare;
	}
	
	public int getSwaps() {
		return swap;
	}
	
	public int getComparisons() {
		return compare;
	}
}
