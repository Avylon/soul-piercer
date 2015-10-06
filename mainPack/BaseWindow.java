package mainPack;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import moveData.Character;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class BaseWindow {

	private JFrame frmSoulPiercer;
	private DefaultTableModel tblFrameDataModel;
	private JTable tblFrameData;

	public JFrame getFrame() {
		return frmSoulPiercer;
	}

	/**
	 * Create the application.
	 */
	public BaseWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSoulPiercer = new JFrame();
		frmSoulPiercer.setTitle("Soul Piercer");
		frmSoulPiercer.setIconImage(Toolkit.getDefaultToolkit().getImage(BaseWindow.class.getResource("/mainPack/Avylon Small A.png")));
		frmSoulPiercer.setBounds(100, 100, 1273, 489);
		frmSoulPiercer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoulPiercer.getContentPane().setLayout(null);
		
		//non generated initializations
		Character[] characterList;
		
		characterList = BaseWindow.readCharacterFile();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 902, 329);
		frmSoulPiercer.getContentPane().add(scrollPane);
		
		tblFrameDataModel = new DefaultTableModel(TableInformation.getEMPTY_TABLE(), TableInformation.getTABLE_HEADER());
		tblFrameData = new JTable(tblFrameDataModel);
		scrollPane.setViewportView(tblFrameData);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(922, 11, 325, 429);
		frmSoulPiercer.getContentPane().add(panel);
		panel.setLayout(null);
		JComboBox<String> cboCharacterList = new JComboBox<String>();
		cboCharacterList.setBounds(10, 36, 115, 20);
		panel.add(cboCharacterList);
		
		JComboBox<String> cboFirstSort = new JComboBox<String>();
		cboFirstSort.setBounds(10, 171, 115, 20);
		panel.add(cboFirstSort);
		
		JComboBox<String> cboSecondSort = new JComboBox<String>();
		cboSecondSort.setBounds(10, 227, 115, 20);
		panel.add(cboSecondSort);
		
		JComboBox<String> cboThirdSort = new JComboBox<String>();
		cboThirdSort.setBounds(10, 283, 115, 20);
		panel.add(cboThirdSort);
		
		JComboBox<String> cboFirstFilter = new JComboBox<String>();
		cboFirstFilter.setBounds(200, 171, 115, 20);
		panel.add(cboFirstFilter);
		
		JComboBox<String> cboSecondFilter = new JComboBox<String>();
		cboSecondFilter.setBounds(200, 227, 115, 20);
		panel.add(cboSecondFilter);
		
		JComboBox<String> cboThirdFilter = new JComboBox<String>();
		cboThirdFilter.setBounds(200, 283, 115, 20);
		panel.add(cboThirdFilter);
		
		/*
		 * Populate Comboboxes
		 */
		for(int i = 0; i < characterList.length; i++) {
			cboCharacterList.addItem(characterList[i].toString());
		}
		
		for(int i = 0; i < TableInformation.getSORT_OPTIONS().length; i++) {
			cboFirstSort.addItem(TableInformation.getSORT_OPTIONS()[i]);
		}
		
		for(int i = 0; i < TableInformation.getSORT_OPTIONS().length; i++) {
			cboSecondSort.addItem(TableInformation.getSORT_OPTIONS()[i]);
		}
		
		for(int i = 0; i < TableInformation.getSORT_OPTIONS().length; i++) {
			cboThirdSort.addItem(TableInformation.getSORT_OPTIONS()[i]);
		}
		
		for(int i = 0; i < TableInformation.getFILTER_OPTIONS().length; i++) {
			cboFirstFilter.addItem(TableInformation.getFILTER_OPTIONS()[i]);
		}
		
		for(int i = 0; i < TableInformation.getFILTER_OPTIONS().length; i++) {
			cboSecondFilter.addItem(TableInformation.getFILTER_OPTIONS()[i]);
		}
		
		for(int i = 0; i < TableInformation.getFILTER_OPTIONS().length; i++) {
			cboThirdFilter.addItem(TableInformation.getFILTER_OPTIONS()[i]);
		}
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(10, 395, 305, 23);
		panel.add(btnRefresh);
		
		JLabel lblCharacter = new JLabel("Character");
		lblCharacter.setBounds(10, 11, 115, 14);
		panel.add(lblCharacter);
		
		JLabel lblSortingOptions = new JLabel("Sorting Options");
		lblSortingOptions.setBounds(10, 121, 115, 14);
		panel.add(lblSortingOptions);
		
		JLabel lblSort1 = new JLabel("First Category");
		lblSort1.setBounds(10, 146, 115, 14);
		panel.add(lblSort1);
		
		JLabel lblSort2 = new JLabel("Second Category");
		lblSort2.setBounds(10, 202, 115, 14);
		panel.add(lblSort2);
		
		JLabel lblSort3 = new JLabel("Third Category");
		lblSort3.setBounds(10, 258, 115, 14);
		panel.add(lblSort3);
		
		JLabel lblFilterOptions = new JLabel("Filter Options");
		lblFilterOptions.setBounds(200, 121, 115, 14);
		panel.add(lblFilterOptions);
		
		JLabel lblFilter1 = new JLabel("Filter 1");
		lblFilter1.setBounds(200, 146, 46, 14);
		panel.add(lblFilter1);
		
		JLabel lblFilter2 = new JLabel("Filter 2");
		lblFilter2.setBounds(200, 202, 46, 14);
		panel.add(lblFilter2);
		
		JLabel lblFilter3 = new JLabel("Filter 3");
		lblFilter3.setBounds(200, 258, 46, 14);
		panel.add(lblFilter3);
		
		//Reloads the table based on the current character (in development), current sorts (in development), and current filters (in dev)
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tblFrameDataModel = BaseWindow.loadTable((String) cboCharacterList.getSelectedItem(), characterList,
														(String) cboFirstSort.getSelectedItem(),
														(String) cboSecondSort.getSelectedItem(),
														(String) cboThirdSort.getSelectedItem(),
														(String) cboFirstFilter.getSelectedItem(),
														(String) cboSecondFilter.getSelectedItem(),
														(String) cboThirdFilter.getSelectedItem());
				tblFrameData.setModel(tblFrameDataModel);
			}
		});
	}
	
	/**
	 * Reads the character file and instantiates
	 * 
	 * @author Aleksandr Fritz
	 * @return arrayOfCharacters
	 */
	public static Character[] readCharacterFile() {
		Character[] arrayOfCharacters;
		Integer listLength;
		String[] characterNames;
		
		listLength = ReadFile.getCharacterListLength("Frame Data/Character List.txt");
		arrayOfCharacters = new Character[listLength];
		characterNames = ReadFile.getCharacterList("Frame Data/Character List.txt", listLength);
		
		for(int i = 0; i < listLength; i++) {
			arrayOfCharacters[i] = new Character(characterNames[i]);
		}
		
		return arrayOfCharacters;
	}
	
	public static DefaultTableModel loadTable(String currentCharacterSelected, Character[] characterList, String firstSortCat,
												String secondSortCat, String thirdSortCat, String firstFilter, String secondFilter,
												String thirdFilter) {
		DefaultTableModel newTableModel;
		Character characterToLoad;
		
		//in case the search fails, load the none character
		characterToLoad = new Character("None");
		
		for (int i = 0; i < characterList.length; i++) {
			if(currentCharacterSelected == characterList[i].toString()) {
				characterToLoad = characterList[i];
			}
		}
		newTableModel = TableLoader.replaceTable(characterToLoad.getMoveList(), firstSortCat, secondSortCat, thirdSortCat, firstFilter,
												secondFilter, thirdFilter);
		
		return newTableModel;
	}
}
