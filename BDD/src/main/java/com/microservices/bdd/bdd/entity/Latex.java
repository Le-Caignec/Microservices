package com.microservices.bdd.bdd.entity;


import com.google.cloud.firestore.annotation.PropertyName;

public class Latex {
    private String id;
    private String resume;
    private String contents;

    public Latex(String id,String contents) {
        this.id=id;
        this.resume = Resume(contents);
        this.contents = contents;
    }

    public Latex(){}

    @PropertyName("id")
    public String getId() {
        return id;
    }

    @PropertyName("id")
    public void setId(String id) {
        this.id = id;
    }

    @PropertyName("resume")
    public String getResume() {
        return resume;
    }

    @PropertyName("resume")
    public void setResume(String resume) {
        this.resume = resume;
    }

    @PropertyName("contents")
    public String getContents() {
        return contents;
    }

    @PropertyName("contents")
    public void setContents(String contents) {
        this.contents = contents;
    }

    public String Resume(String contents){
        if (contents.length()<=30){
            return contents;
        }
        return contents.substring(0,20)+" ... ";
    }
}

