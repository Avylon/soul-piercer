package moveData;

/**
 * Stores the guard burst properties of a move.
 * 
 * @author Aleksandr Fritz
 */
public class GuardBurst {
	private BreakProperty canBreak;
	private Double guardDamage;
	
	/**
	 * Creates a GuardBurst object that stores the guard burst properties of a move.
	 * 
	 * @param canBreak
	 * @param guardDamage
	 */
	public GuardBurst(BreakProperty canBreak, Double guardDamage) {
		this.canBreak = canBreak;
		this.guardDamage = guardDamage;
	}

	public BreakProperty getCanBreak() {
		return canBreak;
	}

	public Double getGuardDamage() {
		return guardDamage;
	}
}
