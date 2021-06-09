import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OTP extends JFrame implements ActionListener {

    private static ArrayList<CompanyAuth> companyAuths = new ArrayList<CompanyAuth>();
    private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private static ArrayList<JButton> refreshButtons = new ArrayList<JButton>();


    private JButton addCompanyButton;
    private JTextField addCompanyText;

    public OTP() {
        addCompany();

        setLayout(new GridLayout(0, 2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(250, 100);
        this.setVisible(true);
        this.setSize(600, 350);
    }

    private void createLabel(String companyName) {
        CompanyAuth newCompany = new CompanyAuth(companyName);
        companyAuths.add(newCompany);

        JLabel label = new JLabel("<html>Company: " + companyName
                + "<br/>OTP: " + String.valueOf(newCompany.getOTP()) + "</html>");
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(label);
        labels.add(label);

        JButton refreshButton = new JButton("Refresh");
        this.add(refreshButton);
        refreshButtons.add(refreshButton);
        refreshButtons.get(refreshButtons.size() - 1).addActionListener(this);

        //Refreshes the page
        this.invalidate();
        this.validate();
        this.repaint();
    }

    private void addCompany() {
        addCompanyText = new JTextField();
        this.add(addCompanyText);
        addCompanyButton = new JButton("+");
        addCompanyButton.addActionListener(this);
        this.add(addCompanyButton);
    }

    private static void refreshOTP(int index) {
        companyAuths.get(index).newOTP();
        labels.get(index).setText("<html>Company: " + companyAuths.get(index).getCompanyName()
                + "<br/>OTP: " + String.valueOf(companyAuths.get(index).getOTP()) + "</html>");
    }

    public static void main(String[] args) {
        new OTP();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCompanyButton && !addCompanyText.getText().equals("")) {
            createLabel(addCompanyText.getText());
            addCompanyText.setText("");
            addCompanyText.grabFocus();
            return;
        }
        for(int i = 0; i < refreshButtons.size(); i++) {
            if (e.getSource() == refreshButtons.get(i)) {
                refreshOTP(i);
            }
        }
    }
}