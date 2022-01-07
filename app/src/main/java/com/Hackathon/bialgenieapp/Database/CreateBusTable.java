package com.Hackathon.bialgenieapp.Database;

public class CreateBusTable {

    String[] kiab10aa = new String[]{"04:00","05:00","06:00","08:00","09:00","10:00","11:00","13:45","14:35","15:45","16:45","18:15","19:15","20:15"};
    String a1t = "Departure     Arrival\n04:00     05:45\n"+
            "04:00     05:45\n" +
            "05:00     06:45\n" +
            "06:00     07:45\n" +
            "08:00     09:45\n" +
            "09:00     10:45\n" +
            "10:00     11:45\n" +
            "11:00     12:45\n" +
            "13:45     15:30\n" +
            "14:35     16:20\n" +
            "15:45     17:30\n" +
            "16:45     18:30\n" +
            "18:15     20:00\n" +
            "19:15     21:00\n" +
            "20:15     22:00";
       String a2t = "Departure     Arrival\n" +
               "06:00     07:45\n" +
               "07:00     08:45\n" +
               "08:00     09:45\n" +
               "10:00     11:45\n" +
               "11:00     12:45\n" +
               "12:00     13:45\n" +
               "13:00     14:45\n" +
               "16:00     17:45\n" +
               "17:00     18:45\n" +
               "18:00     19:45\n" +
               "19:00     20:45\n" +
               "20:30     22:15\n" +
               "21:30     23:15\n" +
               "22:30     00:15";

       String a1s = "Mysuru Road Bus Station (MCTC)\n" +
               "\n" +
               "Vijayanagar\n" +
               "\n" +
               "West of Chord Road\n" +
               "\n" +
               "Yeshavanthapura\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Kempegowda International Airport";

       String a2s = "Kempegowda International Airport\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Yeshavanthapura\n" +
               "\n" +
               "West of Chord Road\n" +
               "\n" +
               "Vijayanagar\n" +
               "\n" +
               "Mysuru Road Bus Station (MCTC)";

       String b1t = "Departure     Arrival\n" +
               "06:30     08:20\n" +
               "07:30     09:20\n" +
               "08:30     10:20\n" +
               "09:30     11:20\n" +
               "11:00     12:50\n" +
               "12:00     13:50\n" +
               "19:50     21:40\n" +
               "20:50     22:40\n" +
               "21:50     23:40\n" +
               "22:50     00:40";

       String b2t = "Departure     Arrival\n" +
               "05:30     07:20\n" +
               "06:30     08:20\n" +
               "08:50     10:40\n" +
               "09:50     11:40\n" +
               "10:50     12:40\n" +
               "12:30     14:20\n" +
               "17:30     19:20\n" +
               "18:35     20:25\n" +
               "19:35     21:25\n" +
               "20:35     22:25\n" +
               "22:00     23:50\n" +
               "23:30     01:20";

       String b2s = "Kempegowda International Airport\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Shanthinagar TTMC\n" +
               "\n" +
               "Billekahalli\n" +
               "\n" +
               "DLF Apartment";
       String b1s = "DLF Apartment\n" +
               "\n" +
               "Billekahalli\n" +
               "\n" +
               "Shanthinagar TTMC\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Kempegowda International Airport";
       String c1t = "Departure     Arrival\n" +
               "06:10     08:00\n" +
               "07:10     09:00\n" +
               "09:20     11:10\n" +
               "17:30     19:20\n" +
               "19:00     20:50\n" +
               "22:10     00:00";
       String c2t = "Departure     Arrival\n" +
               "07:00     08:50\n" +
               "15:00     16:50\n" +
               "16:30     18:20\n" +
               "19:20     21:10\n" +
               "20:40     22:30\n" +
               "22:00     23:50";
       String c1s = "HAL\n" +
               "\n" +
               "Indiranagar KFC\n" +
               "\n" +
               "Halasur Lake\n" +
               "\n" +
               "Taj Residency\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Kempegowda International Airport";
       String c2s = "Kempegowda International Airport\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Taj Residency\n" +
               "\n" +
               "Halasur Lake\n" +
               "\n" +
               "Indiranagar KFC\n" +
               "\n" +
               "HAL";

       String d1t = "Departure     Arrival\n" +
               "12:40     14:40\n" +
               "13:50     15:50\n" +
               "14:30     16:30\n" +
               "16:00     18:00";
       String d1s = "White Field TTMC\n" +
               "\n" +
               "Indiranagar KFC\n" +
               "\n" +
               "Halasur Lake\n" +
               "\n" +
               "Taj Residency\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Kempegowda International Airport";
       String d2t = "Departure      Arrival\n" +
               "08:30      10:30\n" +
               "09:40      11:40\n" +
               "10:40      12:40\n" +
               "12:10      14:10";
       String d2s = "Kempegowda International Airport\n" +
               "\n" +
               "Hebbal\n" +
               "\n" +
               "Mekri Circle\n" +
               "\n" +
               "Taj Residency\n" +
               "\n" +
               "Halasur Lake\n" +
               "\n" +
               "Indiranagar KFC\n" +
               "\n" +
               "White Field TTMC";

    String e1t = "Departure     Arrival\n" +
            "05:30     07:20\n" +
            "06:30     08:20\n" +
            "07:30     09:20\n" +
            "08:30     10:20\n" +
            "09:30     11:20\n" +
            "10:40     12:30\n" +
            "11:40     13:30\n" +
            "12:40     14:30\n" +
            "13:40     16:50\n" +
            "15:00     17:50\n" +
            "16:00     18:50\n" +
            "16:30     19:50\n" +
            "17:00     20:50\n" +
            "17:30     21:50\n" +
            "18:00     22:50\n" +
            "18:30     23:50";
    String e1s = "Banashankari TTMC\n" +
            "\n" +
            "JP Nagar 6th Phase\n" +
            "\n" +
            "Jayanagar 4th Block\n" +
            "\n" +
            "Shanthinagar TTMC\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Mekri Circle\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String e2t = "Departure     Arrival\n" +
            "00:05     01:55\n" +
            "07:30     09:20\n" +
            "08:30     10:20\n" +
            "09:30     11:20\n" +
            "10:30     12:20\n" +
            "12:00     13:50\n" +
            "13:00     14:50\n" +
            "14:00     15:50\n" +
            "15:00     16:50\n" +
            "17:00     18:50\n" +
            "18:00     19:50\n" +
            "19:00     20:50\n" +
            "20:00     21:50\n" +
            "21:00     22:50\n" +
            "22:00     23:50\n" +
            "23:00     00:50";
    String e2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Mekri Circle\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Shanthinagar TTMC\n" +
            "\n" +
            "Jayanagar 4th Block\n" +
            "\n" +
            "JP Nagar 6th Phase\n" +
            "\n" +
            "Banashankari TTMC";

    String f1t = "Departure\tArrival\n" +
            "07:50\t10:00\n" +
            "20:30\t22:40";
    String f1s = "Kadugodi Bus Station\n" +
            "\n" +
            "Hope Farm\n" +
            "\n" +
            "White Field\n" +
            "\n" +
            "Marthahalli\n" +
            "\n" +
            "Domalur\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String f2t = "Departure      Arrival\n" +
            "05:30     07:40\n" +
            "18:00     20:10";
    String f2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Domalur\n" +
            "\n" +
            "Marthahalli\n" +
            "\n" +
            "White Field\n" +
            "\n" +
            "Hope Farm\n" +
            "\n" +
            "Kadugodi Bus Station";

    String g1t = "Departure     Arrival\n" +
            "05:25     07:15\n" +
            "06:40     08:30\n" +
            "09:20     11:10\n" +
            "10:10     12:00\n" +
            "11:00     12:50\n" +
            "14:50     16:40\n" +
            "16:50     18:40\n" +
            "17:55     19:45\n" +
            "18:55     20:45\n" +
            "21:40     23:30";
    String g1s = "HSR Layout BDA Complex\n" +
            "\n" +
            "Sony World Signal\n" +
            "\n" +
            "Domalur\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Shivajinagar Bus Station\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String g2t = "Departure     Arrival\n" +
            "07:10     09:00\n" +
            "08:40     10:30\n" +
            "11:20     12:10\n" +
            "13:00     14:50\n" +
            "16:50     18:40\n" +
            "19:00     20:50\n" +
            "20:50     22:40\n" +
            "23:35     01:25";
    String g2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Shivajinagar Bus Station\n" +
            "\n" +
            "MG Road\n" +
            "\n" +
            "Domalur\n" +
            "\n" +
            "Sony World Signal\n" +
            "\n" +
            "HSR Layout BDA Complex";

    String h1t = "Departure     Arrival\n" +
            "00:30     02:40\n" +
            "06:30     08:40\n" +
            "07:30     09:40\n" +
            "08:30     10:40\n" +
            "09:00     11:10\n" +
            "09:30     11:40\n" +
            "10:00     12:10\n" +
            "11:00     13:10\n" +
            "12:00     14:10\n" +
            "13:00     15:10\n" +
            "13:30     15:40\n" +
            "14:00     16:10\n" +
            "15:00     17:10\n" +
            "16:30     18:40\n" +
            "17:30     19:40\n" +
            "18:00     20:10\n" +
            "18:30     20:40\n" +
            "19:00     21:10\n" +
            "20:00     22:10\n" +
            "21:00     23:10\n" +
            "21:30     23:40\n" +
            "22:30     00:40\n" +
            "23:30     01:40";
    String h1s = "Electronic City\n" +
            "\n" +
            "Central Silk Board\n" +
            "\n" +
            "Marthahalli Bridge\n" +
            "\n" +
            "Tinfactory\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String h2t = "Departure     Arrival\n" +
            "00:30     02:40\n" +
            "06:00     08:10\n" +
            "07:00     09:10\n" +
            "08:00     10:10\n" +
            "09:00     11:10\n" +
            "10:00     12:10\n" +
            "10:30     12:40\n" +
            "11:00     13:10\n" +
            "11:30     13:40\n" +
            "12:00     14:10\n" +
            "13:00     15:10\n" +
            "14:00     16:10\n" +
            "16:00     18:10\n" +
            "17:00     19:10\n" +
            "18:00     20:10\n" +
            "19:00     21:10\n" +
            "20:00     22:10\n" +
            "20:30     22:40\n" +
            "21:30     23:40\n" +
            "22:30     00:40\n" +
            "23:00     01:10\n" +
            "23:35     01:45";
    String h2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Tinfactory\n" +
            "\n" +
            "Marthahalli Bridge\n" +
            "\n" +
            "Central Silk Board\n" +
            "\n" +
            "Electronic City";

    String i1t = "Departure     Arrival\n" +
            "08:00     11:00\n" +
            "09:00     12:00\n" +
            "19:00     22:00\n" +
            "20:30     23:30";
    String i1s = "Chandapura\n" +
            "\n" +
            "Electronic City\n" +
            "\n" +
            "Central Silk Board\n" +
            "\n" +
            "Marthahalli Bridge\n" +
            "\n" +
            "Tinfactory\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String i2t = "Departure     Arrival\n" +
            "04:00     07:00\n" +
            "05:00     08:00\n" +
            "15:30     18:30\n" +
            "17:00     20:00";
    String i2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Tinfactory\n" +
            "\n" +
            "Marthahalli Bridge\n" +
            "\n" +
            "Central Silk Board\n" +
            "\n" +
            "Electronic City\n" +
            "\n" +
            "Chandapura";

    String j1t = "Departure     Arrival\n" +
            "00:10     01:20\n" +
            "00:40     01:50\n" +
            "06:10     07:20\n" +
            "06:40     07:50\n" +
            "07:10     08:20\n" +
            "07:40     08:50\n" +
            "08:10     09:20\n" +
            "08:40     09:50\n" +
            "09:05     10:15\n" +
            "09:30     10:40\n" +
            "10:00     11:10\n" +
            "10:30     11:40\n" +
            "11:00     12:10\n" +
            "11:30     12:40\n" +
            "12:00     13:10\n" +
            "12:30     13:40\n" +
            "13:00     14:10\n" +
            "13:40     14:50\n" +
            "14:35     15:45\n" +
            "15:30     16:40\n" +
            "16:00     17:10\n" +
            "16:30     17:40\n" +
            "17:00     18:10\n" +
            "17:30     18:40\n" +
            "18:00     19:10\n" +
            "18:25     19:35\n" +
            "18:50     20:00\n" +
            "19:15     20:25\n" +
            "19:40     20:50\n" +
            "20:10     21:20\n" +
            "20:40     21:50\n" +
            "21:10     22:20\n" +
            "21:40     22:50\n" +
            "22:10     23:20\n" +
            "22:40     23:50\n" +
            "23:10     00:20\n" +
            "23:40     00:50";
    String j1s = "Kempegowda Bus Station\n" +
            "\n" +
            "Shivananda Circle\n" +
            "\n" +
            "Mekri Circle\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Kempegowda International Airport";
    String j2t = "Departure     Arrival\n" +
            "05:20     06:30\n" +
            "05:50     07:00\n" +
            "06:20     07:30\n" +
            "06:50     08:00\n" +
            "07:20     08:30\n" +
            "07:45     08:55\n" +
            "08:10     09:20\n" +
            "08:40     09:50\n" +
            "09:10     10:20\n" +
            "09:40     10:50\n" +
            "10:05     11:15\n" +
            "10:30     11:40\n" +
            "10:55     12:05\n" +
            "11:20     12:30\n" +
            "11:50     13:00\n" +
            "12:20     13:30\n" +
            "12:50     14:00\n" +
            "13:20     14:30\n" +
            "13:50     15:00\n" +
            "14:20     15:30\n" +
            "14:50     16:00\n" +
            "15:50     17:00\n" +
            "16:45     17:55\n" +
            "17:15     18:25\n" +
            "17:45     18:55\n" +
            "18:15     19:25\n" +
            "18:45     19:55\n" +
            "19:15     20:25\n" +
            "19:40     20:50\n" +
            "20:05     21:15\n" +
            "20:30     21:40\n" +
            "20:55     22:05\n" +
            "21:25     22:35\n" +
            "21:55     23:05\n" +
            "22:25     23:35\n" +
            "22:55     00:05\n" +
            "23:25     00:35";
    String j2s = "Kempegowda International Airport\n" +
            "\n" +
            "Hebbal\n" +
            "\n" +
            "Mekri Circle\n" +
            "\n" +
            "Shivananda Circle\n" +
            "\n" +
            "Kempegowda Bus Station";

    String a1 = "Departure     Arrival" +
            "\n" +
            "19:00       05:00";

    String a2 = "Departure       Arrival\n" +

            "21:00       06:30";
    String b1 = "Departure     Arrival\n" +

            "08:30       15:30\n" +

            "20:30       03:30";
    String b2 = "Departure      Arrival\n"+
            "01:00       07:30\n" +
            "11:30       18:30";

    String c1 = "Departure      Arrival\n" +
                "01:31        05:30\n"+
                "04:00        08:00\n"+
                "06:01        10:00\n"+
                "07:32        11:30\n"+
                "09:32        13:30\n"+
                "11:30        15:30\n"+
                "13:02        17:00\n"+
                "15:31        19:45\n"+
                "18:02        22:00\n"+
                "21:02        01:00\n"+
                "22:03        02:00\n"+
                "23:01        03:00\n"+
                "23:30        03:30\n"+
                "23:55        03:55\n";
    String c2 = "Departure      Arrival\n" +
            "01:00        05:00\n"+
            "02:02        06:00\n"+
            "03:01        07:00\n"+
            "04:03        08:00\n"+
            "08:02        12:15\n"+
            "10:03        14:00\n"+
            "11:30        15:30\n"+
            "13:02        17:00\n"+
            "15:01        19:00\n"+
            "16:32        20:30\n"+
            "18:01        22:00\n"+
            "19:15        23:15\n"+
            "21:15        01:15\n"+
            "23:30        03:30\n";






    BusTables b = new BusTables();

        public void create()
        {
            b.create_Table();

            b.set_Values("KIAB-10A","Mysuru Bus Station (MCTC)","Kempegowda International Airport",7,49.02,250.0);
            b.setArrivalDeparture("KIAB-10A",a1t,a1s);
            b.set_Values("KIAB-10B","Kempegowda International Airport","Mysuru Bus Station (MCTC)",7,49.02,250.0);
            b.setArrivalDeparture("KIAB-10B",a2t,a2s);

            b.set_Values("KIAB-14B","Kempegowda International Airport","DLF Apartment",6,48.06 ,290.0);
            b.setArrivalDeparture("KIAB-14B",b1t,b1s);
            b.set_Values("KIAB-14A","DLF Apartment","Kempegowda International Airport",6,48.06 ,290.0);
            b.setArrivalDeparture("KIAB-14A",b2t,b2s);

            b.set_Values("KIAB-4A","HAL","Kempegowda International Airport",7,44.41,260.0);
            b.setArrivalDeparture("KIAB-4A",c1t,c1s);
            b.set_Values("KIAB-4B","Kempegowda International Airport","HAL",7,44.41,260.0);
            b.setArrivalDeparture("KIAB-4B",c2t,c2s);

            b.set_Values("KIAB-4AA","White Field TTMC","Kempegowda International Airport",7,54.84,280.0);
            b.setArrivalDeparture("KIAB-4AA",d1t,d1s);
            b.set_Values("KIAB-4AB","Kempegowda International Airport","White Field TTMC",7,54.84,280.0);
            b.setArrivalDeparture("KIAB-4AB",d2t,d2s);

            b.set_Values("KIAB-5A","Banashankari TTMC","Kempegowda International Airport",8,48.33,270.0);
            b.setArrivalDeparture("KIAB-5A",e1t,e1s);
            b.set_Values("KIAB-5B","Kempegowda International Airport","Banashankari TTMC",8,48.33,270.0);
            b.setArrivalDeparture("KIAB-5B",e2t,e2s);

            b.set_Values("KIAB-6A","Kadugodi Bus Station","Kempegowda International Airport",8,55.23,280.0);
            b.setArrivalDeparture("KIAB-6A",f1t,f1s);
            b.set_Values("KIAB-6B","Kempegowda International Airport","Kadugodi Bus Station",8,55.23,280.0);
            b.setArrivalDeparture("KIAB-6B",f2t,f2s);

            b.set_Values("KIAB-7AA","HSR Layout BDA Complex","Kempegowda International Airport",7,50,250.0);
            b.setArrivalDeparture("KIAB-7AA",g1t,g1s);
            b.set_Values("KIAB-7AB","Kempegowda International Airport","HSR Layout BDA Complex",7,50,250.0);
            b.setArrivalDeparture("KIAB-7AB",g2t,g2s);

            b.set_Values("KIAB-8A","Electronic City","Kempegowda International Airport",6,65.55,330.0);
            b.setArrivalDeparture("KIAB-8A",h1t,h1s);
            b.set_Values("KIAB-8B","Kempegowda International Airport","Electronic City",6,65.55,330.0);
            b.setArrivalDeparture("KIAB-8B",h2t,h2s);

            b.set_Values("KIAB-8CA","Chandapura","Kempegowda International Airport",7,71.64,350.0);
            b.setArrivalDeparture("KIAB-8CA",i1t,i1s);
            b.set_Values("KIAB-8CB","Kempegowda International Airport","Chandapura",7,71.64,350.0);
            b.setArrivalDeparture("KIAB-8CB",i2t,i2s);

            b.set_Values("KIAB-9A","Kempegowda Bus Station","Kempegowda International Airport",5,34.48,240.0);
            b.setArrivalDeparture("KIAB-9A",j1t,j1s);
            b.set_Values("KIAB-9B","Kempegowda International Airport","Kempegowda Bus Station",5,34.48,240.0);
            b.setArrivalDeparture("KIAB-9B",j2t,j2s);
        }
  public void set_city()
  {
      b.set_city("10A","Kundapura - KIAL","Kundapura","KIAL",a1,"428 km");
      b.set_city("10B","KIAL - Kundapura","KIAL","Kundapura",a2,"428 km");

      b.set_city("20A","Madikeri - KIAL","Madikeri","KIAL",b1,"286 km");
      b.set_city("20B","KIAL - Madikeri","KIAL","Madikeri",b2,"286 km");

      b.set_city("30A","Mysuru - KIAL","Mysuru","KIAL",c1,"209 km");
      b.set_city("30B","KIAL - Mysuru","KIAL","Mysuru",c2,"209 km");


  }


}
