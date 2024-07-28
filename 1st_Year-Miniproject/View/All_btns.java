
package View;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class All_btns {
    public Button ExitBtn(JPanel p,JFrame F){
        Button Exit = new Button("Exit");
        p.add(Exit);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                F.dispose();
            }
        });
        return Exit;
    }

    public JButton HomeBtn(JPanel p){
        JButton Home = new JButton("Home");
        p.add(Home);
        return Home;
    }

           
    public JButton DetailsBtn(JPanel p){
        JButton Details = new JButton("All Details");
        p.add(Details);
        return Details;
    }

    public JButton SearchBtn(JPanel p){
        JButton Search = new JButton("Search");
        p.add(Search);
        return Search;
    }

    public JButton EditBtn(JPanel p){
        JButton edit= new JButton("Edit");
        p.add(edit);
        return edit;
    }
    public JButton deleteBtn(JPanel p){
        JButton Delete = new JButton("Delete");
        p.add(Delete);
        return Delete;
    }
}
