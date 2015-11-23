package sort.me.arrays.graphicalArrays;

public enum ArrayState {
	ACTIVE (0), INACTIVE (1), COMPARING (2), SORTED(3);
	
	public int value;
	
	ArrayState (int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
