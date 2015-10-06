package mainPack;

public class TableInformation {
	private final static String[] TABLE_HEADER = {"Name", "Input", "Level", "Damage", "Impact", "Just Guard", "Block", "Hit", "Counter Hit",
											"Guard Burst", "Properties"};
	private final static String[][] EMPTY_TABLE = new String[0][0];
	private final static String[] SORT_OPTIONS = {"NONE","DAMAGE", "IMPACT", "JUST_GUARD", "BLOCK", "HIT", "COUNTER_HIT", "GUARD_BREAK"};
	private final static String[] FILTER_OPTIONS = {"NONE", "HIGH", "MID", "LOW", "SPECIAL_MID", "SPECIAL_LOW", "GUARD_CRUSH", "MOVE_A",
													"MOVE_B", "MOVE_K", "MOVE_SIMULTANEOUS", "MOVE_EIGHTWAYRUN", "MOVE_THROW", "MOVE_EDGE",
													"MOVE_STANCE", "HORIZONTAL", "VERTICAL", "STAB", "BODY", "TECH_CROUCH", "TECH_JUMP",
													"SUPER_TECH_CROUCH", "SUPER_TECH_JUMP", "FORCE_CROUCH"};

	public static String[] getTABLE_HEADER() {
		return TABLE_HEADER;
	}

	public static String[][] getEMPTY_TABLE() {
		return EMPTY_TABLE;
	}
	
	public static String[] getSORT_OPTIONS() {
		return SORT_OPTIONS;
	}
	
	public static String[] getFILTER_OPTIONS() {
		return FILTER_OPTIONS;
	}
}
