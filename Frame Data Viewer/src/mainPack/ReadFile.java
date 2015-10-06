package mainPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import moveData.BlockStatus;
import moveData.BreakProperty;
import moveData.HitStatus;
import moveData.Move;
import moveData.MoveCategory;

public class ReadFile {

	public static String[] getCharacterList(String fileLocation, Integer numberOfLines) {
		String[] fileInfo;
		String fileLine;
		Integer index;
		BufferedReader buffer;
		
		index = 1;
		
		try {
			buffer = new BufferedReader(new FileReader(fileLocation));
			
			//initialize fileInfo and put a "None" default value in first
			fileInfo = new String[numberOfLines + 1];
			fileInfo[0] = "None";
			
			while ((fileLine = buffer.readLine()) != null) {
				fileInfo[index] = fileLine;
				index++;
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			//Throw up error window and quit
			fileInfo = new String[1];
		} catch (IOException e) {
			//Throw up error window and quit
			fileInfo = new String[1];
		}
		
		return fileInfo;
	}
	
	public static Integer getCharacterListLength(String fileLocation) {
		Integer listLength;
		BufferedReader buffer;

		listLength = 1;
		
		try {
			buffer = new BufferedReader(new FileReader(fileLocation));
			
			//read number of lines to find out how large the array should be
			while (buffer.readLine() != null) {
				listLength++;
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			//Throw up error window and quit
		} catch (IOException e) {
			//Throw up error window and quit
		}
		
		return listLength;
	}
	
	public static ArrayList<Move> getMoveListInfo(String fileLocation) {
		ArrayList<Move> moveList = new ArrayList<Move>();
		String fileLine = new String();
		String[] data;
		Move currentMove;
		BufferedReader buffer;
		
		try {
			buffer = new BufferedReader(new FileReader(fileLocation));
			
			//skip two lines
			buffer.readLine();
			buffer.readLine();
			
			while ((fileLine = buffer.readLine()) != null) {
				data = fileLine.split(",");
				
				/*
				 * 0-2 are strings
				 * 3-7 are booleans
				 * 8-9 are integers
				 * 10 is HitStatus
				 * 11 is an integer
				 * 12 is HitStatus
				 * 13 is an integer
				 * 14 is a BreakProperty
				 * 15 is a Double
				 * 16 is a String
				 * 17 is BlockStatus
				 * 18 is an integer
				 * 19 is BlockStatus
				 * 20 is an integer
				 * 21 is MoveCategory
				 * 22-31 are booleans
				 */
				currentMove = new Move(data[0], data[1], data[2], Boolean.parseBoolean(data[3]), Boolean.parseBoolean(data[4]),
										Boolean.parseBoolean(data[5]), Boolean.parseBoolean(data[6]), Boolean.parseBoolean(data[7]),
										Integer.parseInt(data[8]), Integer.parseInt(data[9]), HitStatus.valueOf(data[10]),
										Integer.parseInt(data[11]), HitStatus.valueOf(data[12]), Integer.parseInt(data[13]),
										BreakProperty.valueOf(data[14]), Double.parseDouble(data[15]), data[16], BlockStatus.valueOf(data[17]),
										Integer.parseInt(data[18]), BlockStatus.valueOf(data[19]), Integer.parseInt(data[20]),
										MoveCategory.valueOf(data[21]), Boolean.parseBoolean(data[22]), Boolean.parseBoolean(data[23]),
										Boolean.parseBoolean(data[24]), Boolean.parseBoolean(data[25]), Boolean.parseBoolean(data[26]),
										Boolean.parseBoolean(data[27]), Boolean.parseBoolean(data[28]),	Boolean.parseBoolean(data[29]),
										Boolean.parseBoolean(data[30]), Boolean.parseBoolean(data[31]));
				
				moveList.add(currentMove);
			}
		} catch (FileNotFoundException e) {
			//Throw up error window and quit
		} catch (IOException e) {
			//Throw up error window and quit
		}
		
		return moveList;
	}
}
