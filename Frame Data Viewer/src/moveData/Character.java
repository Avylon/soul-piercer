package moveData;
import java.util.ArrayList;

import mainPack.ReadFile;

/**
 * A character's information and move list.
 * 
 * @author Aleksandr Fritz
 */
public class Character {
	private String name = new String();
	private ArrayList<Move> moveList;
	
	/**
	 * Creates the character with their name.
	 * 
	 * @param name
	 */
	public Character(String name) {
		this.name = name;
		
		moveList = ReadFile.getMoveListInfo("Frame Data/" + name + " Data.csv");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Move> getMoveList() {
		return moveList;
	}

	public void setMoveList(ArrayList<Move> moveList) {
		this.moveList = moveList;
	}
	
	public String toString() {
		return name;
	}
}
