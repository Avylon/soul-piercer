package moveData;

/**
 * Stores the height information of a move.
 * 
 * @author Aleksandr Fritz
 */
public class Height {
	private String heightList;
	private Boolean high, mid, low, specialMid, specialLow;
	
	/**
	 * Creates a Height object that stores the height information of the move.
	 * 
	 * @param heightList
	 * @param high
	 * @param mid
	 * @param low
	 * @param specialMid
	 * @param specialLow
	 */
	public Height(String heightList, Boolean high, Boolean mid, Boolean low, Boolean specialMid, Boolean specialLow) {
		this.heightList = heightList;
		this.high = high;
		this.mid = mid;
		this.low = low;
		this.specialMid = specialMid;
		this.specialLow = specialLow;
	}
	
	public String getHeightList() {
		return heightList;
	}

	public Boolean getHigh() {
		return high;
	}

	public Boolean getMid() {
		return mid;
	}

	public Boolean getLow() {
		return low;
	}

	public Boolean getSpecialMid() {
		return specialMid;
	}

	public Boolean getSpecialLow() {
		return specialLow;
	}
}