package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Passengers.Tickets;

public class Print {
        public Print(){};
        public Print(Tickets t, JFrame Main) {
        JLabel nameLabel = new JLabel("Name: " + t.getName());
        JLabel addressLabel = new JLabel("Address: " + t.getAddress());
        JLabel srcLabel = new JLabel("Boarding: " + t.getBoarding() + " To " + t.getDestination());
        JLabel genderLabel = new JLabel("Gender: " + t.getgender());
        JLabel ticketIdLabel = new JLabel("Ticket ID: " + t.get_ticketid());
        JLabel Clas = new JLabel("Class :" + t.get_class());
        JLabel Date = new JLabel("Valid From "+t.get_start()+" Till " + t.get_End());
        JLabel phoneLabel = new JLabel("Phone Number: " + t.getPhone_Num());
        JLabel aadharLabel = new JLabel("Aadhar Number: " + t.getAadhar());
        JLabel thoughtsLabel = new JLabel("Have A Nice Day :)");
        Main.dispose();
        Main = new JFrame("Ticket");
        JPanel P1 = new JPanel();
        P1.setBounds(200,200,200,300);
        P1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        JPanel detailsPanel = new JPanel();
    
        if (t.getDuration() == 0) {
            detailsPanel.add(ticketIdLabel);
            detailsPanel.add(srcLabel);
            detailsPanel.add(Clas);
            detailsPanel.add(new JLabel(t.get_start()+""));
            detailsPanel.add(thoughtsLabel);
            
        }
        else{
            detailsPanel.add(ticketIdLabel);
            detailsPanel.add(nameLabel);
            detailsPanel.add(addressLabel);
            detailsPanel.add(srcLabel);
            detailsPanel.add(Clas);
            detailsPanel.add(Date);
            detailsPanel.add(genderLabel);
            detailsPanel.add(phoneLabel);
            detailsPanel.add(aadharLabel);
            detailsPanel.add(thoughtsLabel);
        }
        detailsPanel.setLayout(new BoxLayout(detailsPanel,BoxLayout.PAGE_AXIS));
        detailsPanel.setBounds(100,100,200,300);
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
        P1.add(detailsPanel);
        Main.add(P1);
        Main.setVisible(true);
        Main.pack();
        Main.revalidate();
    }

    public void printMultipleTickets(ArrayList<Tickets> ticketList, JFrame mainFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    
        for (Tickets t : ticketList) {
            JPanel ticketPanel = new JPanel();
            ticketPanel.setPreferredSize(new Dimension(250,400)); 
            ticketPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            ticketPanel.setLayout(new BoxLayout(ticketPanel, BoxLayout.Y_AXIS));
    
            JLabel nameLabel = new JLabel("Name: " + t.getName());
            JLabel addressLabel = new JLabel("Address: " + t.getAddress());
            JLabel srcLabel = new JLabel("Boarding: " + t.getBoarding() + " To " + t.getDestination());
            JLabel genderLabel = new JLabel("Gender: " + t.getgender());
            JLabel ticketIdLabel = new JLabel("Ticket ID: " + t.get_ticketid());
            JLabel classLabel = new JLabel("Class: " + t.get_class());
            JLabel dateLabel = new JLabel("Valid From " + t.get_start() + " Till " + t.get_End());
            JLabel phoneLabel = new JLabel("Phone Number: " + t.getPhone_Num());
            JLabel aadharLabel = new JLabel("Aadhar Number: " + t.getAadhar());
            JLabel thoughtsLabel = new JLabel("Have A Nice Day :)");
    
            ticketPanel.add(ticketIdLabel);
            ticketPanel.add(nameLabel);
            ticketPanel.add(addressLabel);
            ticketPanel.add(srcLabel);
            ticketPanel.add(classLabel);
            ticketPanel.add(dateLabel);
            ticketPanel.add(genderLabel);
            ticketPanel.add(phoneLabel);
            ticketPanel.add(aadharLabel);
            ticketPanel.add(thoughtsLabel);
    
            mainPanel.add(ticketPanel);

        }
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getViewport().setViewPosition(new Point(0, 0));
        mainFrame.getContentPane().removeAll();
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        mainFrame.pack();
        mainFrame.revalidate();
    }
    
}

