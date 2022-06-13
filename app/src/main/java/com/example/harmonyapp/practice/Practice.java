package com.example.harmonyapp.practice;

public class Practice {
    private String name;
    private String description;
    private int imageId;
    //private boolean isComplited;

    public Practice(String name, String description, int imageId) {
        this.name = name;
        this.description = description;
        this.imageId = imageId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}
