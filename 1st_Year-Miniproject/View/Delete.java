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

public class Delete {
    public Delete(JFrame Main_win , JPanel Main){
        JPanel p2 = new JPanel();
        JLabel delete_text = new JLabel("Select from the Option to Delete ");
        String[] delete_option = {"Select","Name","Ticket_ID","Aadhar_Num","Phone"};
        JComboBox<String> type1 = new JComboBox<>(delete_option);
        TextField text = new TextField(30);
        JButton ok = new JButton("OK");
        p2.add(delete_text);
        p2.add(type1);
        p2.add(ok);
        Main.add(p2);
        Main_win.revalidate();
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
                okay.addActionListener((ActionListener) new ActionListener() {
                    @SuppressWarnings("static-access")
                    public void actionPerformed (ActionEvent e){
                        Main.removeAll();
                        Main.revalidate();
                        c.delete(type1.getSelectedItem().toString(),text.getText());
                        Main_win.dispose();
                        new Main().main(new String[1]);
                    }
                });
            }
        });
    }
}
