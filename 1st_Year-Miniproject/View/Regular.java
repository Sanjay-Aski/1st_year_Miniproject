package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Passengers.Tickets;

public class Regular  {
    public Regular(JPanel Main , JFrame Main_win, String[] stationArray) throws IOException{
        JPanel Ingredents = new JPanel();
        JPanel sbp6 = new JPanel();

        sbp6.add(new JLabel("Enter  Boarding"));
        JComboBox<String> Type1 = new JComboBox<>(stationArray);
        sbp6.add(Type1);

        JPanel sbp7 = new JPanel();
        sbp7.add(new JLabel("Enter Destination"));
        JComboBox<String> Type2 = new JComboBox<>(stationArray);
        sbp7.add(Type2);

        JPanel sbp9 = new JPanel();
        sbp9.add(new JLabel("Select Class"));
        String clas[] = {"1","2"};
        JComboBox<String> Type3 = new JComboBox<>(clas);
        sbp9.add(Type3);

        JButton submit = new JButton("Print");
        submit.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String Boarding = (String)Type1.getSelectedItem();
                String cls = (String) Type3.getSelectedItem();
                String Dest =(String) Type2.getSelectedItem();

                Tickets t= new Tickets("", "", 000000000000000, 0000000000000000000,"", Boarding, Dest,Integer.parseInt(cls));
                try {
                    Controller c = new Controller();
                    c.add_json(t);
                    Main.removeAll();
                    Main.revalidate();
                    new Print(t, Main_win);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }});
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main_win.dispose();
                View.Main.main(clas);
            }
        });



        Ingredents.add(sbp6);
        Ingredents.add(sbp7);
        Ingredents.add(sbp9);
        Ingredents.add(submit);
        Ingredents.add(back);
        Main.add(Ingredents);
        Main_win.revalidate();
    }

    
}
