package Task1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

import java.util.TimerTask;

public class Dopolnit extends TimerTask {
    private JPanel[] panel;
    public int i;

    public Dopolnit(JPanel[] panel, int i) {
        this.panel = panel;
        this.i = i;
    }

    public void run() {
        while (i>-1){
            if (i == 0){
                panelSettingsMethodRed(panel[0]);
                panelSettingsWithout3D(panel[4]);
                panelSettingsMethod(panel[3]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie)
                {
                    System.out.println("Scanning...");
                }
                i++;
            }
            if (i == 1) {
                panelSettingsWithout3D(panel[0]);
                panelSettingsMethodRed(panel[1]);
                panelSettingsMethod(panel[4]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            if (i == 2) {
                panelSettingsWithout3D(panel[1]);
                panelSettingsMethodRed(panel[2]);
                panelSettingsMethod(panel[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie)
                {
                    System.out.println("Scanning...");
                }
                i++;
            }
            if (i == 3){
                panelSettingsWithout3D(panel[2]);
                panelSettingsMethodRed(panel[3]);
                panelSettingsMethod(panel[1]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie)
                {
                    System.out.println("Scanning...");
                }
                i++;
            }
            if (i == 4){
                panelSettingsWithout3D(panel[3]);
                panelSettingsMethodRed(panel[4]);
                panelSettingsMethod(panel[2]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie)
                {
                    System.out.println("Scanning...");
                }
                i=0;
            }
        }
    }

    public static void panelSettingsMethodRed(JPanel panel) {

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createMatteBorder(25, 25, 25, 25, Color.RED)));
    }

    public static void panelSettingsMethod(JPanel panel) {

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)));
    }

    public static void panelSettingsWithout3D(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}