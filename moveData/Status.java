package moveData;

/**
 * Stores the status information of a move.
 * 
 * @author Aleksandr Fritz
 */
public class Status {
	private HitStatus hitStat, counterHitStat;
	private BlockStatus blockStat, justGuardStat;
	
	/**
	 * Creates a Status object that stores the status information of a move.
	 * 
	 * @param hitStat
	 * @param counterHitStat
	 * @param blockStat
	 * @param justGuardStat
	 */
	public Status(HitStatus hitStat, HitStatus counterHitStat, BlockStatus blockStat, BlockStatus justGuardStat) {
		this.hitStat = hitStat;
		this.counterHitStat = counterHitStat;
		this.blockStat = blockStat;
		this.justGuardStat = justGuardStat;
	}

	public HitStatus getHitStat() {
		return hitStat;
	}

	public HitStatus getCounterHitStat() {
		return counterHitStat;
	}

	public BlockStatus getBlockStat() {
		return blockStat;
	}

	public BlockStatus getJustGuardStat() {
		return justGuardStat;
	}
}
