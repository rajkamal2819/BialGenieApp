package com.Hackathon.bialgenieapp.Models;

public class ParkingChargesData {
    String mainTitle,lTitle,rTitle,t1,t2,t3,t4,t5,f1,f2,f3,f4,f5;

    public ParkingChargesData(String mainTitle, String lTitle, String rTitle,
                              String t1, String t2, String t3, String t4, String t5,
                              String f1, String f2, String f3, String f4, String f5) {
        this.mainTitle = mainTitle;
        this.lTitle = lTitle;
        this.rTitle = rTitle;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.t5 = t5;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
        this.f4 = f4;
        this.f5 = f5;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getlTitle() {
        return lTitle;
    }

    public String getrTitle() {
        return rTitle;
    }

    public String getT1() {
        return t1;
    }

    public String getT2() {
        return t2;
    }

    public String getT3() {
        return t3;
    }

    public String getT4() {
        return t4;
    }

    public String getT5() {
        return t5;
    }

    public String getF1() {
        return f1;
    }

    public String getF2() {
        return f2;
    }

    public String getF3() {
        return f3;
    }

    public String getF4() {
        return f4;
    }

    public String getF5() {
        return f5;
    }
}
