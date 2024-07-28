package View;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;

public class Search {
    public void search(JPanel Main , JFrame Main_Win){
        JPanel p2 = new JPanel();
        JLabel search_text = new JLabel("Select from the Option to Search ");
        String[] search_option = {"Select","Name","Ticket_ID","Aadhar_Num","Phone"};
        JComboBox<String> type1 = new JComboBox<>(search_option);
        TextField text = new TextField(30);
        JButton ok = new JButton("OK");
        p2.add(search_text);
        p2.add(type1);
        p2.add(ok);
        Main.add(p2);
        Main_Win.revalidate();
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Controller c = new Controller();
                JButton okay = new JButton("OK");
                Main.remove(p2);
                p2.removeAll();
                if (type1.getSelectedItem().toString() == "Name") {
                    JLabel enter = new JLabel("Enter the Name ");
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Ticket_ID"){
                    JLabel enter = new JLabel("Enter the Ticket_ID ");
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Aadhar_Num"){
                    JLabel enter = new JLabel("Enter the Aadhar_Num ");
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Phone"){
                    JLabel enter = new JLabel("Enter the Phone ");
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(p2);
                    Main.revalidate();
                }
                okay.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e){
                        Main.removeAll();
                        Main.revalidate();
                        c.getit(type1.getSelectedItem().toString(),text.getText(),Main_Win,Main);
                        Main_Win.revalidate();
                    }
                });
            }
        });
    }
}
