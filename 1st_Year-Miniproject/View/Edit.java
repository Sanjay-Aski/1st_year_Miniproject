package View;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.json.simple.parser.ParseException;

import Controller.Controller;

public class Edit {
    static JComboBox<String> s = new JComboBox<>();
    public Edit(JFrame Main_win , JPanel Main){
        JPanel p2 = new JPanel();
        JLabel delete_text = new JLabel("Select from the Option to Update");
        String[] delete_option = {"Select","Name","Ticket_ID","Aadhar_Num","Phone","Boarding","Destination","Address","Gender","Duration","Class"};
        JComboBox<String> type1 = new JComboBox<>(delete_option);
        TextField text = new TextField(30);
        TextField old_text = new TextField(30);
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
                    
                    JLabel enter = new JLabel("Enter the Updated Name ");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Ticket_ID"){
                    JLabel enter = new JLabel("Enter the Updated Ticket_ID ");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Aadhar_Num"){
                    JLabel enter = new JLabel("Enter the Updated Aadhar_Num ");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }
                else if(type1.getSelectedItem().toString() == "Phone"){
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    JLabel enter = new JLabel("Enter the new Phone  Number");
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                else if(type1.getSelectedItem().toString() == "Boarding Place"){
                    JLabel enter = new JLabel("Enter the new Boarding Place ");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                else if(type1.getSelectedItem().toString() == "Destination"){
                    JLabel enter = new JLabel("Enter the New Destination");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                else if(type1.getSelectedItem().toString() == "Address"){
                    JLabel enter = new JLabel("Enter the New Address");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                else if(type1.getSelectedItem().toString() == "Gender"){
                    JLabel enter = new JLabel("Enter the Gender ");
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    P3.add(old_text);
                    p2.add(enter);
                    p2.add(text);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                else if(type1.getSelectedItem().toString() == "Class"){
                    String select[] = {"1","2"};
                    s = new JComboBox<>(select);
                    JPanel P3 = new JPanel();
                    JLabel old = new JLabel("Enter the Ticket_ID ");
                    P3.add(old);
                    p2.add(s);
                    p2.add(okay);
                    Main.add(P3);
                    Main.add(p2);
                    Main.revalidate();
                }

                okay.addActionListener((ActionListener) new ActionListener() {
                    @SuppressWarnings("static-access")
                    public void actionPerformed (ActionEvent e){
                        Main.removeAll();
                        Main.revalidate();
                        if (text.getText() == "") {
                        try {
                            new Controller().update(type1.getSelectedItem().toString(),text.getText(),s.getSelectedItem().toString());
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        }
                        else{
                            try {
                                new Controller().update(type1.getSelectedItem().toString(),old_text.getText(),text.getText());
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                        }
                        Main_win.dispose();
                        new Main().main(new String[1]);
                    }
                });
            }});
    }
}
