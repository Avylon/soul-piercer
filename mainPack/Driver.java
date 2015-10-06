package mainPack;

import java.awt.EventQueue;

public class Driver {
	
	public static void characterLoad() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseWindow window = new BaseWindow();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Woot! Didn't crash!");
	}

}