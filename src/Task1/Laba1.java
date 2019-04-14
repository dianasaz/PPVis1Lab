package Task1;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import java.awt.TextField;
import java.util.Timer;
import javax.swing.border.BevelBorder;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Laba1{
        private Container container;
        private JPanel task1;
        private JPanel task2;+
        private JPanel task3;
        private JPanel task4;
        private JFrame frame;
        public JButton buttonStart;
        public JButton buttonStop;
        Task5 task5;
        private Timer timer;
        private Dopolnit task;
        private int saveSignificance;
        private boolean move;

        public Laba1() {

            frame = new JFrame();
            frame.setTitle("Lab1");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            container = frame.getContentPane();

            buttonStart = new JButton("Start changing");
            buttonStop = new JButton("STOP");

            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            task1();
            task2();
            task3();
            task4();
            task5 = new Task5();

            container.add(task5.getPanel());

            dop();
            frame.setVisible(true);

        }

        public void dop(){
            JPanel[] pan = new JPanel[]{task1, task2, task3, task4, task5.getPanel()};

            buttonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startMoving(pan);
                }
            });

            buttonStop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopMoving();
                }
            });

            container.add(buttonStart);
            container.add(buttonStop);
        }

        public void startMoving(JPanel[] panel){

            if (!move) {
                timer = new Timer();
                task = new Dopolnit(panel, saveSignificance);
                if (task.i == -78) {
                    task.i = saveSignificance;
                }
                timer.schedule(task, 1000);
                move = true;
            }
        }

        public void stopMoving(){
            if (move) {
                timer.cancel();
                timer.purge();
                saveSignificance = task.i;
                task.i = -78;
                move = false;
            }
        }

        public void panelSettingsMethod(JPanel panel){
            panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createBevelBorder(BevelBorder.RAISED),
                    BorderFactory.createEmptyBorder(25, 25, 25, 25)));
        }

    private void task1() {
        task1 = new JPanel();

        panelSettingsMethod(task1);

        JComboBox<String> box = new JComboBox<String>();
        JButton button = new JButton("Press to save the text");
        JTextField textOne = new JTextField();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textOne.getText() != null) {
                    for (int i = 0; i < box.getItemCount(); i++) {
                        if (textOne.getText().equals(box.getItemAt(i))) {
                            JOptionPane.showMessageDialog(null, "This text already in ComboBox", "Error", JOptionPane.PLAIN_MESSAGE);
                            return;
                        }
                    }
                    box.addItem(textOne.getText());
                }
            }
        });

        task1.setLayout(new BoxLayout(task1, BoxLayout.Y_AXIS));

        task1.add(textOne);
        task1.add(button);
        task1.add(box);
        container.add(task1);

    }

    private void task2(){
        task2 = new JPanel();

        panelSettingsMethod(task2);

        JButton button1 = new JButton("Press to save the text");
        JButton button2 = new JButton();
        JTextField textOne2 = new JTextField();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               button2.setText(textOne2.getText());
                }
            });

        button2.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          String temp = null;
                                          temp = button1.getText();
                                          button1.setText(button2.getText());
                                          button2.setText(temp);
                                      }
                                  });

        task2.setLayout(new BoxLayout(task2, BoxLayout.Y_AXIS));
        task2.add(textOne2);
        task2.add(button1);
        task2.add(button2);
        container.add(task2);
    }

    public void task3 (){
            task3 = new JPanel();
            panelSettingsMethod(task3);
            TextField textThree = new TextField();
            JButton button = new JButton("Tap");
            JRadioButton rButton1 = new JRadioButton("3", false);
            JRadioButton rButton2 = new JRadioButton("24", false);
            JRadioButton rButton3 = new JRadioButton("1", false);

            ButtonGroup bg = new ButtonGroup();
            bg.add(rButton1);
            bg.add(rButton2);
            bg.add(rButton3);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int t = 0;
                    if (textThree.getText().equals(rButton1.getText())) {
                        rButton1.setSelected(true);
                        t = 1;
                    }
                    if (textThree.getText().equals(rButton2.getText())){
                        rButton2.setSelected(true);
                        t = 1;
                    }
                    if (textThree.getText().equals(rButton3.getText())) {
                        rButton3.setSelected(true);
                        t = 1;
                    }
                    if ( t == 0 )JOptionPane.showMessageDialog(null, "Invalid name", "Error", JOptionPane.PLAIN_MESSAGE);                }
        });

        task3.setLayout(new BoxLayout(task3, BoxLayout.Y_AXIS));
        task3.add(textThree);
        task3.add(button);
        task3.add(rButton1);
        task3.add(rButton2);
        task3.add(rButton3);
        container.add(task3);
        }

    public void task4(){
        task4 = new JPanel();
        panelSettingsMethod(task4);
        JButton button = new JButton("Push me");
        TextField textFour = new TextField();
        JCheckBox check1 = new JCheckBox("89");
        JCheckBox check2 = new JCheckBox("123");
        JCheckBox check3 = new JCheckBox("56");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = textFour.getText();
                String[] newStr;
                newStr = str.split(" ");
                for (int i = 0; i < newStr.length; i++) {

                    if (newStr[i].equals(check1.getText())&& check1.isSelected()==true) {
                        check1.setSelected(false);
                    } else if (newStr[i].equals(check1.getText())&&check1.isSelected()==false) check1.setSelected(true);

                    if (newStr[i].equals(check2.getText())&&check2.isSelected()==true) {
                        check2.setSelected(false);
                    } else if (newStr[i].equals(check2.getText())&&check2.isSelected()==false) check2.setSelected(true);

                    if (newStr[i].equals(check3.getText())&&check3.isSelected()==true) {
                        check3.setSelected(false);
                    } else if (newStr[i].equals(check3.getText())&&check3.isSelected()==false) check3.setSelected(true);

                    if (!newStr[i].equals(check3.getText()) && !newStr[i].equals(check2.getText()) && !newStr[i].equals(check1.getText()))
                        JOptionPane.showMessageDialog(null, "You wrote invalid word", "Error", JOptionPane.PLAIN_MESSAGE);

                }}
        });
        task4.setLayout(new BoxLayout(task4, BoxLayout.Y_AXIS));
        task4.add(textFour);
        task4.add(button);
        task4.add(check1);
        task4.add(check2);
        task4.add(check3);
        container.add(task4);
    }

        public static void main(String[] args) {
            Laba1 app = new Laba1();

        }

    public String[] length(){
        return length();
    }

    }