package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Passengers.Tickets;
import View.Main;
import View.Print;

public class Controller {
    private static final String JSON_FILE_PATH = "1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/Pass.json";

    public void add_json(Tickets buyer) throws IOException {
        if (buyer.getDuration() != 0) {
            JSONObject obj = new JSONObject();
            obj.put("Ticket_ID",buyer.get_ticketid());
            obj.put("Name",buyer.getName());
            obj.put("Phone",buyer.getPhone_Num());
            obj.put("Address",buyer.getAddress());
            obj.put("Gender",buyer.getgender());
            obj.put("Date",buyer.get_start());
            obj.put("End",buyer.get_End());
            obj.put("Aadhar_Num", buyer.getAadhar());
            obj.put("Boarding",buyer.getBoarding());
            obj.put("Destination",buyer.getDestination());
            obj.put("Class", buyer.get_class());
            obj.put("Duration",buyer.getDuration());
            obj.put("Ticket_Price",buyer.getPrice());
            obj.put("Thoughts","Have A Nice Day");

            try {
                // Append JSON string to file
                FileWriter file = new FileWriter(JSON_FILE_PATH, true);
                file.write(obj.toJSONString() + "\n");
                file.flush();
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/TripsOnPrice.json"));
                String line;
                
                if ((line = br.readLine()) != null) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(line);
                JSONObject jsonObject = (JSONObject) obj;
                String count = "Count(Ticket_Price : ("+buyer.getPrice()+")";
                System.out.println(count);
                int intcount = ((Long) jsonObject.get(count)).intValue();
                int total_coll = ((Long) jsonObject.get("Total_Collection")).intValue();
                jsonObject.put(count, intcount+1);
                jsonObject.put("Total_Collection", total_coll+buyer.getPrice());
                FileWriter file = new FileWriter("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/TripsOnPrice.json");
                        file.write(jsonObject.toJSONString() + "\n");
                        file.flush();
                        file.close();
                    } 
                br.close();

            } catch (Exception e) {
                System.out.println("Error occurred while updating ticket count.");
                e.printStackTrace();
            }
        }
    }

    public static void getit(String key, String data,JFrame Main_win , JPanel Main){
        try {
         BufferedReader br = new BufferedReader(new FileReader("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/Pass.json"));
         String line;
         boolean done = false;
         while ((line = br.readLine()) != null) {
                 JSONParser parser = new JSONParser();
                 Object obj = parser.parse(line);
                 JSONObject jsonObject = (JSONObject) obj;
                 System.out.println("/"+key + "/"+data + "/"+jsonObject.get(key));
                 if (data.equals(jsonObject.get(key).toString())) {
                    System.out.println(""+jsonObject.get("Name"));
                    Tickets t = new Tickets(""+jsonObject.get("Name"), ""+jsonObject.get("Address"),Long.parseLong(""+jsonObject.get("Aadhar_Num")), Long.parseLong(""+jsonObject.get("Phone")),""+ jsonObject.get("Gender"),""+jsonObject.get("Date"),""+jsonObject.get("End"), ""+jsonObject.get("Boarding"), ""+jsonObject.get("Destination"), Integer.parseInt(""+jsonObject.get("Duration")),Integer.parseInt(""+jsonObject.get("Class")));
                    t.set_ticketid(Integer.parseInt(jsonObject.get("Ticket_ID")+""));
                    Main.removeAll();
                    new Print(t, Main_win);
                    done = true;
                 }
                 Main.revalidate();
         }
         if (!done) {
            SwingUtilities.invokeLater(() -> {
                Main.removeAll();
                Main.add(new JLabel("Not found"));
                JButton b = new JButton("Back");
                Main.add(b);
                Main_win.add(Main);
                Main_win.revalidate();

                b.addActionListener(e -> {
                    Main m = new Main();
                    m.main(new String[0]);
                    Main_win.revalidate();
                    Main_win.dispose();
                });

                Main.revalidate();
            });
        }

         br.close();
        } catch (Exception e) {
         System.out.println(e);
        }
     }

    public static ArrayList<Tickets> getAll(JFrame Main) {
        ArrayList<Tickets> ticketList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/Pass.json"));
            String line;

            while ((line = br.readLine()) != null) {
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(line);
                JSONObject jsonObject = (JSONObject) obj;

                Tickets t = new Tickets(
                        "" + jsonObject.get("Name"),
                        "" + jsonObject.get("Address"),
                        Long.parseLong("" + jsonObject.get("Aadhar_Num")),
                        Long.parseLong("" + jsonObject.get("Phone")),
                        "" + jsonObject.get("Gender"),
                        "" + jsonObject.get("Date"),
                        "" + jsonObject.get("End"),
                        "" + jsonObject.get("Boarding"),
                        "" + jsonObject.get("Destination"),
                        Integer.parseInt("" + jsonObject.get("Duration")),
                        Integer.parseInt("" + jsonObject.get("Class"))
                );
                t.set_ticketid(Integer.parseInt(jsonObject.get("Ticket_ID").toString()));

                ticketList.add(t);
            }
            new Print().printMultipleTickets(ticketList,Main);
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return ticketList;
    }


    public void delete(String Key ,String Data) {
        JSONObject jsonObject = new JSONObject() ;
        ArrayList<JSONObject> updatedObjects = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/Pass.json"));
            
            String line;
            while ((line = br.readLine()) != null) {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(line);
                    jsonObject = (JSONObject) obj;
                    if (Data.equals(jsonObject.get(Key).toString())) {
                        continue;
                    }
                    else{
                        updatedObjects.add(jsonObject);
                    }
            }
            try {
                FileWriter file = new FileWriter(JSON_FILE_PATH);
                for (JSONObject updatedObject : updatedObjects) {
                    file.write(updatedObject.toJSONString() + "\n");
                }
                file.flush();
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            
   
            br.close();
           } catch (Exception e) {
            System.out.println(e);
           }
    }


    public void update(String Key , String  Data ,String updated) throws ParseException{
        JSONObject jsonObject = new JSONObject() ;
        ArrayList<JSONObject> updatedObjects = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("1st_year_Miniproject/1st_Year-Miniproject/Model/JSON/Pass.json"));
            
            String line;
            while ((line = br.readLine()) != null) {
                    JSONParser parser = new JSONParser();
                    Object obj = parser.parse(line);
                    jsonObject = (JSONObject) obj;
                    if (Data.equals(jsonObject.get("Ticket_ID").toString())) {
                        jsonObject.put(Key,updated);
                        System.out.println("Succedfully Updated");
                    }
                        updatedObjects.add(jsonObject);
            }
            try {
                FileWriter file = new FileWriter(JSON_FILE_PATH);
                for (JSONObject updatedObject : updatedObjects) {
                    file.write(updatedObject.toJSONString() + "\n");
                }
                file.flush();
                file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        };
}
}