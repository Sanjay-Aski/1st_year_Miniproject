
package Model.Passengers;

public class Tickets extends Passengers{
    private Boolean student_concession = false;
    private int Duration =0;
    private String destination;
    private String src;
    private int price;
    private int tClass;
    private String gender = "U";
    private String startdate;
    private String enddate;
    private int ID = (int)(Math.random()*999999999);
    public Tickets(String Name , String Address ,int i, int j,String gender, String src , String Des,int cl){
        super.setName(Name);
        super.setAddress(Address);
        super.setPhone_Num((long)j);
        super.setAadhar(i);
        this.gender = gender;
        this.src = src;
        this.destination = Des;
        this.tClass = cl;
    };

    public Tickets(String Name , String Address ,Long aadhar, Long Phone_Num,String gender,String date , String End, String src , String Des,int Dur,int cl){
        super.setName(Name);
        super.setAddress(Address);
        super.setAadhar(aadhar);
        super.setPhone_Num((long)Phone_Num);
        this.gender = gender;
        this.startdate = date;
        this.enddate = End;
        this.src = src;
        this.destination = Des;
        this.Duration = Dur;
        this.tClass = cl;
    };

    private String stationArray[] = {
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

    public void set_ticketid(int id){
        this.ID = id;
    }
    public void setclass(int c){
        this.tClass = c;
    }
    public void setgender(String gen ){
        this.gender = gen;
    }

    public void setsrc(String src){
        this.src = src;
    }

    public void setDestination(String Des){
        this.destination = Des;
    }

    public void setDuration(int Months){
        this.Duration = Months;
    }

    public int get_ticketid(){
        return ID;
    }

    public String get_start(){
        return startdate;
    }

    public String get_End(){
        return enddate;
    }

    public int get_class(){
        return tClass;
    }

    public int getDuration(){
        return Duration;
    }

    public String getgender(){
        return gender;
    }

    public String getBoarding(){
        return src;
    }

    public String getDestination(){
        return destination;
    }


    public int getSingleFare(String src , String destination){
        int start = 0; int des = 0;
        for (int i = 0; i < stationArray.length; i++) {
            if (stationArray[i] == src) {
                start = i;
            }
            if (stationArray[i] == destination) {
                des = i;
            }
            if (des < start) {
                int temp = start;
                start = des;
                des = temp;
            }
        }
        int diff = des - start;
        if (tClass == 1) {
            if (diff <= 5) return 15;
        else if(diff <= 10) return 30;
        else if(diff <= 15) return 50;
        else if(diff <= 20) return 80;
        else  return 100;
        }
        else{
            if (diff <= 5) return 5;
        else if(diff <= 10) return 10;
        else if(diff <= 15) return 15;
        else if(diff <= 20) return 20;
        else  return 30;
        }
    }

    public void applied_student_concession(){
        this.student_concession = true;
    }

    public int getPrice(){
        if (Duration == 0) {
            return getSingleFare(this.src,this.destination);
        }else  {PassPrice(this.src, this.destination); return this.price;}
    }

    public void PassPrice(String source, String dest) {
        if (student_concession) {
            if (Duration == 1) {
                this.price = (int) ((getSingleFare(src ,dest) * 0.5) * 30);
            } else {
                this.price = (int) ((getSingleFare(src ,dest) * 0.5) * 90);
            }
        } else {
            if (Duration == 1) {
                this.price = (int) ((getSingleFare(src ,dest) * 0.65) * 30);
            } else {
                this.price = (int) ((getSingleFare(src ,dest) * 0.6) * 90);
            }
        }
    }
    
}
