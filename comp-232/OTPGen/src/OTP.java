
// BorderLayout: https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class OTP extends JFrame implements ActionListener {

    JButton new_OTP;
    JLabel resultLabel;

    OTP() {
        new_OTP = new JButton("Refresh");
        resultLabel = new JLabel("Your OTP Code");
        // do some action on click
        new_OTP.addActionListener(this);

        // UX setup
        setLayout(new BorderLayout()); // many layouts available, this is the one we chose
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        add(new_OTP, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.CENTER); // organization of components within frame
        setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE)); // allows close operation
        setLocation(250,100); // controls position of the window
        setVisible(true); // shows the window
        setSize(600,350); // controls size of window
    }

    static char[] generate(int length) {
        System.out.println("Generating OTP using random():");
        String numbers = "0123456789";
        Random rnd_choose = new Random();
        char[] otp = new char[length];
        // choose a random index in the numbers string and put it in otp char array
        for (int i=0; i<length; i++) {
            otp[i] = numbers.charAt(rnd_choose.nextInt(numbers.length()));
        }
        return otp;
    }

    public void actionPerformed(ActionEvent e) {
        int length = 6;
        resultLabel.setText(String.valueOf(OTP.generate(length)));
    }

    public static void main(String[] args) {
        new OTP();
    }
}
