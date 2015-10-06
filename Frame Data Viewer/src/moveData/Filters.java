package moveData;

/**
 * Stores the filter properties of a move.
 * 
 * @author Aleksandr Fritz
 */
public class Filters {
	private Boolean horizontal, vertical, stab, body, slash, techCrouch, techJump, superTechCrouch, superTechJump, forceCrouch;
	
	/**
	 * Creates the Filters object that stores the filter properties of a move.
	 * 
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
	public Filters(Boolean horizontal, Boolean vertical, Boolean stab, Boolean body, Boolean slash, Boolean techCrouch,
			Boolean techJump, Boolean superTechCrouch, Boolean superTechJump, Boolean forceCrouch) {
		this.horizontal = horizontal;
		this.vertical = vertical;
		this.stab = stab;
		this.body = body;
		this.slash = slash;
		this.techCrouch = techCrouch;
		this.techJump = techJump;
		this.superTechCrouch = superTechCrouch;
		this.superTechJump = superTechJump;
		this.forceCrouch = forceCrouch;
	}

	public Boolean getHorizontal() {
		return horizontal;
	}

	public Boolean getVertical() {
		return vertical;
	}

	public Boolean getStab() {
		return stab;
	}

	public Boolean getBody() {
		return body;
	}

	public Boolean getSlash() {
		return slash;
	}

	public Boolean getTechCrouch() {
		return techCrouch;
	}

	public Boolean getTechJump() {
		return techJump;
	}

	public Boolean getSuperTechCrouch() {
		return superTechCrouch;
	}

	public Boolean getSuperTechJump() {
		return superTechJump;
	}

	public Boolean getForceCrouch() {
		return forceCrouch;
	}
}
