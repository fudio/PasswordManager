package Main;

import java.awt.EventQueue;

import GuiNetbean.guiMain;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiMain().setVisible(true);
            }
        });
    }
}
