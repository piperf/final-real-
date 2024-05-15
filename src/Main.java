import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.sql.SQLOutput;
import java.text.AttributedCharacterIterator;

public class Main {
    public static void main(String[] args) {




        //step 1, create a frame
        JFrame frame= new JFrame("Color game");
        frame.setSize(400,400);


        //step 2, create a panel
        JPanel panel= new JPanel();
//        panel.setBackground(new Color(255, 204, 223));
        panel.setLayout(new GridBagLayout());


        JPanel cpan = new JPanel();
        int r=(int)(Math.random()*255);
        int g=(int)(Math.random()*255);
        int b=(int)(Math.random()*255);
        System.out.println(r+" "+g+" "+b);



        cpan.setBackground(new Color(r,g,b));
        cpan.setPreferredSize(new Dimension(200,200));

        //step 3, create components
        JLabel label= new JLabel("What do you think this color is? (R,G,B)");

        JTextField textField = new JTextField(8);

        ImageIcon icon = new ImageIcon("Images/check");
        icon.setImage(icon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));

        ImageIcon incicon = new ImageIcon("Images/xmark");


        JLabel picLabel = new JLabel(icon);
        JLabel incPic= new JLabel(incicon);
        GridBagConstraints gc= new GridBagConstraints();
        JButton button = new JButton("press to enter");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                    String response = "";
                    String answer = textField.getText();
                    System.out.println(answer);

                    String ansr = "";
                    String ansg = "";
                    String ansb = "";
                    int start;
                    for (int i = 0; i < answer.length(); i++) {

                        if (answer.substring(i, i + 1).equals(",")) {
                            ansr += answer.substring(0, i);
                            start = i;
                            break;
                        }
                        for (int j = i; j < answer.length(); j++) {
                            if (answer.substring(j, j + 1).equals(",")) {
                                ansg += answer.substring(i, j);
                                ansb += answer.substring(j + 1);
                                break;
                            }
                        }
                    }
                    int numr = Integer.valueOf(ansr);
                    int numg = Integer.valueOf(ansg);
                    int numb = Integer.valueOf(ansg);


                    if (answer.equals(r + "," + g + "," + b)) {
//
                        JOptionPane.showMessageDialog(picLabel, "correct! Playing again");
                        response="";

                    }

                    else {
                        if (numr < 0 || numg < 0 || numb < 0) {
                            response += "invalid guess\n try again!";
                        }
System.out.println(r);
                        response="";
                        if (numr < r) {
                            response += "r is too low, ";

                        }
                        if (numr > r) {
                            response += "r is too high, ";

                        }
                        if (numr == r) {
                            response += "r is right, ";

                        }
                        System.out.println(g);
                        if (numg < g) {
                            response += "g is too low, ";

                        }
                        if (numg > g) {
                            response += "g is too high, ";

                        }
                        if (numg == g) {
                            response += "g is right, ";

                        }
                        System.out.println(b);
                        if (numb < b) {
                            response += "b is too low ";

                        }
                        if (numb > b) {
                            response += "b is too high ";

                        }
                        if (numb == b) {
                            response += "b is right ";

                        }
                        response += "\n try again!";
                        JOptionPane.showMessageDialog(incPic, response);
                    }

                }
        });



        //step 4, add components to panel
        picLabel.setSize(5,5);
        gc.gridx=7;
        gc.gridy=1;
        panel.add(picLabel);
        gc.gridx=1;
        gc.gridy=1;
        panel.add(label,gc);
        gc.gridx=3;
        gc.gridy=8;
        panel.add(button,gc);
        gc.gridx=3;
        gc.gridy=7;
        panel.add(textField,gc);
        gc.gridx=1;
        gc.gridy=7;
        panel.add(cpan,gc);
//        gc.gridx=7;
//        gc.gridy=7;
//        panel.add(picLabel);

        //step 5, add panel to frame
        frame.add(panel);

//        frame.add(cpan);
        frame.setBackground(Color.magenta);
        //step 6, set frame visible
        frame.setVisible(true);

    }
}