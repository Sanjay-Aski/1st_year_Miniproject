/*
 * Created Passenger Class:

    Created Attributes :
    String name
    String address
    long int phone_num

    Created functionalities :
    Getter and Setter methods

*/

package Model.Passengers;

public class Passengers{
    private String Name;
    private String Address;
    private long Phone_Num;
    private long Aadhar_Num;

    public void setName(String name){
        this.Name = name;
    }

    public String getName(){
        return Name;
    }

    public void setAddress(String Address){
        this.Address = Address;
    }

    public void setAadhar(long Num){
        this.Aadhar_Num = Num;
    }

    public long getAadhar(){
        return Aadhar_Num;
    }
    public String Get_full_Address(){
        return Address;
    }
    public String getAddress(){
        if (Address.length() > 60) {
            return Address.substring(0, 55)+"...";
        }
        return Address;
    }

    public void setPhone_Num(long Phone_Num){
        this.Phone_Num = Phone_Num;
    }

    public long getPhone_Num(){
        return Phone_Num;
    }

    public void display_data(){
        if (getAddress() == null) {
            return;
        }
    System.out.println(" Name: "+getName());
    System.out.println(" Address: "+getAddress());
    System.out.println(" Mobile No: "+getPhone_Num());
    
    }
}