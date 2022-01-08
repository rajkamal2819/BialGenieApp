package com.Hackathon.bialgenieapp.Models;

public class FAQ_Model {
    private String q,ans,tags;
    private boolean expandable;


    public FAQ_Model(String q, String ans) {
        this.q = q;
        this.ans = ans;
        //this.tags = tags;
        this.expandable=false;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
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

//    public String getTags() {
//        return tags;
//    }
//
//    public void setTags(String tags) {
//        this.tags = tags;
//    }

    @Override
    public String toString() {
        return "FAQ_Model{" +
                "q='" + q + '\'' +
                ", ans='" + ans + '\'' +
//                ", tags='" + tags + '\'' +
                '}';
    }
}
