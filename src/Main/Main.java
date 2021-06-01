package Main;

import java.awt.EventQueue;

import GUI.GuiMain;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GuiMain().setVisible(true);
			}
		});
	}
}
