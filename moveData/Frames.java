package moveData;

/**
 * Stores the frame information of a move.
 * 
 * @author Aleksandr Fritz
 */
public class Frames {
	private Integer impact, hitFrames, counterHitFrames, blockFrames, justGuardFrames;

	/**
	 * Creates a Frame object that stores the frame information of a move.
	 * 
	 * @param impact
	 * @param hitFrames
	 * @param counterHitFrames
	 * @param blockFrames
	 * @param justGuardFrames
	 */
	public Frames(Integer impact, Integer hitFrames, Integer counterHitFrames, Integer blockFrames,
			Integer justGuardFrames) {
		this.impact = impact;
		this.hitFrames = hitFrames;
		this.counterHitFrames = counterHitFrames;
		this.blockFrames = blockFrames;
		this.justGuardFrames = justGuardFrames;
	}

	public Integer getImpact() {
		return impact;
	}

	public Integer getHitFrames() {
		return hitFrames;
	}

	public Integer getCounterHitFrames() {
		return counterHitFrames;
	}

	public Integer getBlockFrames() {
		return blockFrames;
	}

	public Integer getJustGuardFrames() {
		return justGuardFrames;
	}
}
