package com.Hackathon.bialgenieapp.Models;

import java.util.ArrayList;

public class StoryModel {

    private ArrayList<storyDetails> storiesList;

    public ArrayList<storyDetails> getStoriesList() {
        return storiesList;
    }

    public void setStoriesList(ArrayList<storyDetails> storiesList) {
        this.storiesList = storiesList;
    }

     public static class storyDetails{
         String image;
         String description;

          public String getImage() {
              return image;
          }

         public storyDetails(String image, String description) {
             this.image = image;
             this.description = description;
         }

         public void setImage(String image) {
              this.image = image;
          }

          public String getDescription() {
              return description;
          }

          public void setDescription(String description) {
              this.description = description;
          }
      }

}
