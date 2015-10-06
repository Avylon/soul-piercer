package moveData;

/**
 * An individual move.
 * @author Aleksandr Fritz
 */

public class Move {
	//display only properties
	private String name, input, notes;
	private Integer damage;
	private Height heightInfo;
	private Frames frameInfo;
	private Status statInfo;
	private GuardBurst burstInfo;
	private Filters filterInfo;
	//this should be phased out eventually
	//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
	private MoveCategory category;
	
	/**
	 * Creates a character's individual move.
	 * 
	 * @param name
	 * @param input
	 * @param height
	 * @param high
	 * @param mid
	 * @param low
	 * @param specialMid
	 * @param specialLow
	 * @param damage
	 * @param impact
	 * @param hitStat
	 * @param hitFrames
	 * @param counterHitStat
	 * @param counterHitFrames
	 * @param canBreak
	 * @param guardDamage
	 * @param notes
	 * @param blockStat
	 * @param blockFrames
	 * @param justGuardStat
	 * @param justGuardFrames
	 * @param category
	 * @param horizontal
	 * @param vertical
	 * @param stab
	 * @param body
	 * @param slash
	 * @param techCrouch
	 * @param techJump
	 * @param superTechCrouch
	 * @param superTechJump
	 * @param forceCrouch
	 */
	public Move(String name, String input, String height, Boolean high, Boolean mid, Boolean low, Boolean specialMid,
			Boolean specialLow, Integer damage, Integer impact, HitStatus hitStat, Integer hitFrames, HitStatus counterHitStat,
			Integer counterHitFrames, BreakProperty canBreak, Double guardDamage, String notes, BlockStatus blockStat,
			Integer blockFrames, BlockStatus justGuardStat, Integer justGuardFrames, MoveCategory category,
			Boolean horizontal, Boolean vertical, Boolean stab, Boolean body, Boolean slash, Boolean techCrouch,
			Boolean techJump, Boolean superTechCrouch, Boolean superTechJump, Boolean forceCrouch) {
		super();
		this.name = name;
		this.input = input;
		heightInfo = new Height(height, high, mid, low, specialMid, specialLow);
		this.damage = damage;
		frameInfo = new Frames(impact, hitFrames, counterHitFrames, blockFrames, justGuardFrames);
		statInfo = new Status(hitStat, counterHitStat, blockStat, justGuardStat);
		burstInfo = new GuardBurst(canBreak, guardDamage);
		this.notes = notes;
		this.category = category;
		filterInfo = new Filters(horizontal, vertical, stab, body, slash, techCrouch, techJump, superTechCrouch, superTechJump,
				forceCrouch);
	}

	public String getName() {
		return name;
	}

	public String getInput() {
		return input;
	}

	public Height getHeightInfo() {
		return heightInfo;
	}

	public Integer getDamage() {
		return damage;
	}

	public Frames getFrameInfo() {
		return frameInfo;
	}
	
	public Status getStatInfo() {
		return statInfo;
	}

	public GuardBurst getBurstInfo() {
		return burstInfo;
	}

	public String getNotes() {
		return notes;
	}

	public MoveCategory getCategory() {
		return category;
	}

	public Filters getFilterInfo() {
		return filterInfo;
	}
}
