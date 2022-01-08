package com.Hackathon.bialgenieapp.Models;

public class FAQ_db {
    private String partisionkey,rowkey,q,ans;

    public FAQ_db(String partisionkey, String rowkey, String q, String ans) {
        this.partisionkey = partisionkey;
        this.rowkey = rowkey;
        this.q = q;
        this.ans = ans;
    }

    public String getPartisionkey() {
        return partisionkey;
    }

    public void setPartisionkey(String partisionkey) {
        this.partisionkey = partisionkey;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
