package mainPack;

import javax.swing.table.DefaultTableModel;

import moveData.BreakProperty;
import moveData.Move;
import moveData.MoveCategory;

import java.util.ArrayList;

public class TableLoader {
	
	public static Object[][] loadMoveList(ArrayList<Move> moveList) {
		Object[][] moveTable;
		int listSize;
		
		listSize = moveList.size();
		moveTable = new Object[listSize][11];
				
		for (int i = 0; i < listSize; i++){
			moveTable[i][0] = moveList.get(i).getName();
			moveTable[i][1] = moveList.get(i).getInput();
			moveTable[i][2] = moveList.get(i).getHeightInfo().getHeightList();
			moveTable[i][3] = Integer.toString(moveList.get(i).getDamage());
			moveTable[i][4] = "i" + Integer.toString(moveList.get(i).getFrameInfo().getImpact());
			
			switch(moveList.get(i).getStatInfo().getJustGuardStat()) {
			case NORMAL: moveTable[i][5] = Integer.toString(moveList.get(i).getFrameInfo().getJustGuardFrames());
						break;
			case UNSLOGGABLE: moveTable[i][5] = "UB";
						break;
			case THROW: moveTable[i][5] = "TH";
						break;
			}
			
			switch(moveList.get(i).getStatInfo().getBlockStat()) {
			case NORMAL: moveTable[i][6] = Integer.toString(moveList.get(i).getFrameInfo().getBlockFrames());
						break;
			case UNSLOGGABLE: moveTable[i][6] = "UB";
						break;
			case THROW: moveTable[i][6] = "TH";
						break;
			}
			
			switch(moveList.get(i).getStatInfo().getHitStat()) {
			case NORMAL: moveTable[i][7] = Integer.toString(moveList.get(i).getFrameInfo().getHitFrames());
						break;
			case KNOCKDOWN: moveTable[i][7] = "KND";
						break;
			case STUN: moveTable[i][7] = "STN";
						break;
			case LAUNCH: moveTable[i][7] = "LNC";
			}
			
			switch(moveList.get(i).getStatInfo().getCounterHitStat()) {
			case NORMAL: moveTable[i][8] = Integer.toString(moveList.get(i).getFrameInfo().getCounterHitFrames());
						break;
			case KNOCKDOWN: moveTable[i][8] = "KND";
						break;
			case STUN: moveTable[i][8] = "STN";
						break;
			case LAUNCH: moveTable[i][8] = "LNC";
			}
			
			moveTable[i][9] = Double.toString(moveList.get(i).getBurstInfo().getGuardDamage());
			moveTable[i][10] = moveList.get(i).getNotes();
		}
		
		return moveTable;
	}

	public static DefaultTableModel replaceTable(ArrayList<Move> moveList, String firstSortCat, String secondSortCat, String thirdSortCat,
												String firstFilter, String secondFilter, String thirdFilter) {
		DefaultTableModel newModel;
		Object[][] tableArray;
		ArrayList<Move> clonedMoveList;
		
		//clone the move list so we can load the original with every refresh
		clonedMoveList = (ArrayList<Move>) moveList.clone();
		
		//filter
		clonedMoveList = TableLoader.listFilter(FilterOption.valueOf(firstFilter), clonedMoveList);
		clonedMoveList = TableLoader.listFilter(FilterOption.valueOf(secondFilter), clonedMoveList);
		clonedMoveList = TableLoader.listFilter(FilterOption.valueOf(thirdFilter), clonedMoveList);
		
		//sort, do last sort first to have the correct order
		clonedMoveList = TableLoader.listSorter(SortOption.valueOf(thirdSortCat), clonedMoveList);
		clonedMoveList = TableLoader.listSorter(SortOption.valueOf(secondSortCat), clonedMoveList);
		clonedMoveList = TableLoader.listSorter(SortOption.valueOf(firstSortCat), clonedMoveList);
		
		//load the list into the table array
		tableArray = TableLoader.loadMoveList(clonedMoveList);
		
		newModel = new DefaultTableModel(tableArray, TableInformation.getTABLE_HEADER());
		
		return newModel;
	}
	
	public static ArrayList<Move> listFilter(FilterOption category, ArrayList<Move> moveList) {
		Move currentMove;
		ArrayList<Integer> deleteList = new ArrayList<Integer>();
		MoveCategory filterCategory;
		
		for(int i = 0; i < moveList.size(); i++) {
			currentMove = moveList.get(i);
			
			switch(category) {
			case NONE:
				break;
			case HIGH:
				if(!currentMove.getHeightInfo().getHigh()) {
					deleteList.add(i);
				}
				break;
			case MID:
				if(!currentMove.getHeightInfo().getMid()) {
					deleteList.add(i);
				}
				break;
			case LOW:
				if(!currentMove.getHeightInfo().getLow()) {
					deleteList.add(i);
				}
				break;
			case SPECIAL_MID:
				if(!currentMove.getHeightInfo().getSpecialMid()) {
					deleteList.add(i);
				}
				break;
			case SPECIAL_LOW:
				if(!currentMove.getHeightInfo().getSpecialLow()) {
					deleteList.add(i);
				}
				break;
			case GUARD_CRUSH:
				if(currentMove.getBurstInfo().getCanBreak() != BreakProperty.UNKNOWN) {
					deleteList.add(i);
				}
				break;
			case MOVE_A:
				filterCategory = MoveCategory.A;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_B:
				filterCategory = MoveCategory.B;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_K:
				filterCategory = MoveCategory.K;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_SIMULTANEOUS:
				filterCategory = MoveCategory.SIMULTANEOUS;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_EIGHTWAYRUN:
				filterCategory = MoveCategory.EIGHTWAYRUN;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_THROW:
				filterCategory = MoveCategory.THROW;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
			case MOVE_EDGE:
				filterCategory = MoveCategory.EDGE;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case MOVE_STANCE:
				filterCategory = MoveCategory.STANCE;
				if(currentMove.getCategory() != filterCategory) {
					deleteList.add(i);
				}
				break;
			case HORIZONTAL:
				if(!currentMove.getFilterInfo().getHorizontal()) {
					deleteList.add(i);
				}
				break;
			case VERTICAL:
				if(!currentMove.getFilterInfo().getVertical()) {
					deleteList.add(i);
				}
				break;
			case STAB:
				if(!currentMove.getFilterInfo().getStab()) {
					deleteList.add(i);
				}
				break;
			case BODY:
				if(!currentMove.getFilterInfo().getBody()) {
					deleteList.add(i);
				}
				break;
			case TECH_CROUCH:
				if(!currentMove.getFilterInfo().getTechCrouch()) {
					deleteList.add(i);
				}
				break;
			case TECH_JUMP:
				if(!currentMove.getFilterInfo().getTechJump()) {
					deleteList.add(i);
				}
				break;
			case SUPER_TECH_CROUCH:
				if(!currentMove.getFilterInfo().getSuperTechCrouch()) {
					deleteList.add(i);
				}
				break;
			case SUPER_TECH_JUMP:
				if(!currentMove.getFilterInfo().getSuperTechJump()) {
					deleteList.add(i);
				}
				break;
			case FORCE_CROUCH:
				if(!currentMove.getFilterInfo().getForceCrouch()) {
					deleteList.add(i);
				}
				break;
			}
		}
		
		for(int i = deleteList.size() - 1; i > -1; i--) {
			moveList.remove(deleteList.get(i).intValue());
		}
		
		return moveList;
	}
	
	public static ArrayList<Move> listSorter(SortOption category, ArrayList<Move> moveList) {
		int index;
		boolean leave;
		Move temporaryMove, currentMove;
		ArrayList<Move> temporaryList = new ArrayList<Move>();
		
		switch(category) {
		case NONE:
			temporaryList = moveList;
			break;
		case DAMAGE:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getDamage() > temporaryMove.getDamage()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case IMPACT:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getFrameInfo().getImpact() > temporaryMove.getFrameInfo().getImpact()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case JUST_GUARD:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getFrameInfo().getJustGuardFrames() > temporaryMove.getFrameInfo().getJustGuardFrames()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case BLOCK:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getFrameInfo().getBlockFrames() > temporaryMove.getFrameInfo().getBlockFrames()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case HIT:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getFrameInfo().getHitFrames() > temporaryMove.getFrameInfo().getHitFrames()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case COUNTER_HIT:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getFrameInfo().getCounterHitFrames() > temporaryMove.getFrameInfo().getCounterHitFrames()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		case GUARD_BREAK:
			for (int i = 0; i < moveList.size(); i++) {
				leave = false;
				currentMove = moveList.get(i);
				temporaryList.add(currentMove);
				index = temporaryList.indexOf(currentMove);
				
				while (index != 0 && !leave) {
					temporaryMove = temporaryList.get(index - 1);
					
					if(currentMove.getBurstInfo().getGuardDamage() > temporaryMove.getBurstInfo().getGuardDamage()){
						temporaryList.set(index - 1, currentMove);
						temporaryList.set(index, temporaryMove);
						index--;
					}
					else {
						leave = true;
					}
				}
			}
			break;
		}
		
		moveList = temporaryList;
		
		return moveList;
	}
}