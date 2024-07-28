package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import  javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.Controller;
import Model.Passengers.Tickets;


public class Main extends JFrame{

    static String stationArray[] = {
        "Select Station",
        "Karjat Junction",
        "Bhivpuri Road",
        "Neral Junction",
        "Shelu",
        "Vangani",
        "Badlapur",
        "Ambernath",
        "Ulhasnagar",
        "Vithalwadi",
        "Kalyan Junction",
        "Thakurli",
        "Dombivli",
        "Kopar",
        "Diva Junction",
        "Mumbra",
        "Kalva",
        "Thane",
        "Mulund",
        "Nahur",
        "Bhandup",
        "Kanjur Marg",
        "Vikhroli",
        "Ghatkopar",
        "Vidyavihar",
        "Kurla",
        "Sion",
        "Matunga",
        "Dadar",
        "Parel",
        "Currey Road",
        "Chinchpokli",
        "Byculla",
        "Sandhurst Road",
        "Masjid",
        "Mumbai Chhatrapati Shivaji Terminus"
        };

    public static void Home(JPanel Main , JFrame Main_win){
        JPanel Ingredents = new JPanel();
        JLabel label = new JLabel("Pass Application");
        Main.add(label);
        JPanel sbp1 = new JPanel();
        sbp1.add(new JLabel("Enter Full Name"));
        TextField text = new TextField(20);
        sbp1.add(text);

        JPanel sbp2 = new JPanel();
        sbp2.add(new JLabel("Enter Phone"));
        TextField text2 = new TextField(20);
        sbp2.add(text2);

        JPanel sbp3 = new JPanel();
        sbp3.add(new JLabel("Enter Address"));
        TextField text3 = new TextField(50);
        sbp3.add(text3);

        JPanel sbp4 = new JPanel();
        sbp4.add(new JLabel("Enter Gender"));
        TextField text4 = new TextField(2);
        sbp4.add(text4);

        JPanel sbp5 = new JPanel();
        sbp5.add(new JLabel("Enter Aadhar Num"));
        TextField text5 = new TextField(20);
        sbp5.add(text5);

        JPanel sbp6 = new JPanel();
        sbp6.add(new JLabel("Enter  Boarding"));
        JComboBox<String> Type1 = new JComboBox<>(stationArray);
        sbp6.add(Type1);

        JPanel sbp7 = new JPanel();
        sbp7.add(new JLabel("Enter Destination"));
        JComboBox<String> Type2 = new JComboBox<>(stationArray);
        sbp7.add(Type2);

        JPanel sbp8 = new JPanel();
        sbp8.add(new JLabel("Enter Months"));
        String duration[] = {"1","3"};
        JComboBox<String> Type4 = new JComboBox<>(duration);
        sbp8.add(Type4);

        JPanel sbp9 = new JPanel();
        sbp9.add(new JLabel("Select Class"));
        String clas[] = {"1","2"};
        JComboBox<String> Type3 = new JComboBox<>(clas);
        sbp9.add(Type3);


        Ingredents.setLayout(new BoxLayout(Ingredents,BoxLayout.Y_AXIS));
        Ingredents.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        
        JButton submit = new JButton("Print");
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Main_win.dispose();
                main(clas);
            }
        });     
        submit.setLocation(400,600);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String name = text.getText();
                String Phone = text2.getText();
                String Address = text3.getText();
                String gender = text4.getText();
                String Aadhar = text5.getText();
                String Boarding = (String)Type1.getSelectedItem();
                String Dest =(String) Type2.getSelectedItem();
                String Duration = (String) Type4.getSelectedItem();
                String cls = (String) Type3.getSelectedItem();
                Tickets t= new Tickets(name, Address,Long.parseLong(Aadhar), Long.parseLong(Phone), gender,LocalDate.now().toString(),LocalDate.now().plusDays(30*Integer.parseInt(Duration)).toString(), Boarding, Dest,Integer.parseInt(Duration),Integer.parseInt(cls));
                Controller c = new Controller();
                try {
                    c.add_json(t);
                    Main_win.remove(Main);

                    new Print(t, Main_win);
                } catch (IOException e1) {
                    
                    e1.printStackTrace();
                }
                System.out.println("submit clicked");
                Main_win.dispose();
                main(clas);
            }

        });
        Ingredents.add(sbp1);
        Ingredents.add(sbp2);
        Ingredents.add(sbp3);
        Ingredents.add(sbp4);
        Ingredents.add(sbp5);
        Ingredents.add(sbp6);
        Ingredents.add(sbp7);
        Ingredents.add(sbp8);
        Ingredents.add(sbp9);
        Ingredents.add(submit);
        Main.add(Ingredents);
        Main_win.revalidate();
    }

    

    public static void main(String[] args) {
      All_btns Gb = new All_btns();
      JFrame Main_win = new JFrame("Railway Systems");
      JPanel Main = new JPanel();
      JPanel SubPanel = new JPanel();
      Gb.HomeBtn(SubPanel).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            JPanel p = new JPanel();
            JButton ok = new JButton("OK");
            p.add(new JLabel("Enter Type"));
            String[] Option = {"Select","Regular", "Pass"};
            JComboBox<String> Type = new JComboBox<>(Option);
            p.add(Type); 
            p.add(ok);
            Main.add(p);
            Type.setSize(new Dimension(10,15));
            Main.add(new Panel());
            Main_win.validate();
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String selected = (String) Type.getSelectedItem();
                    Main.removeAll();
                    if (selected == "Pass") {
                        Home(Main, Main_win);
                    }
                    else{
                        try {
                           new Regular(Main,Main_win,stationArray);
                        } catch (IOException e1) {
                            
                            e1.printStackTrace();
                        }
                        System.out.println("Normal selected");
                    }
                    Main_win.validate();
                    ok.setEnabled(false);
                }
            });     
        }
      });
      
      Gb.SearchBtn(SubPanel).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            Main.removeAll();
            Main.add(SubPanel);
            new Search().search(Main, Main_win);
        }
      });;

      Gb.DetailsBtn(SubPanel).addActionListener(new ActionListener() {
        @SuppressWarnings("static-access")
        public void actionPerformed(ActionEvent e){
            new Controller().getAll(Main_win);
        }});;
      Gb.deleteBtn(SubPanel).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            new Delete(Main_win, Main);
        }
      });;
      Gb.EditBtn(SubPanel).addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent E ){
            new Edit(Main_win, Main);
        }
      });
      Gb.ExitBtn(SubPanel,Main_win);
      Main.add(SubPanel);
      
      Main.setLayout(new BoxLayout(Main,BoxLayout.Y_AXIS));
      Main_win.add(Main);
      Main_win.pack();
      Main_win.setSize(700,500);
      Main_win.setVisible(true);
      Main_win.add(new JPanel());
      Main_win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Main_win.setBackground(Color.BLACK);
    }
}