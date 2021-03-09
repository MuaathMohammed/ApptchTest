package com.example.loginwithwebapi.Models;

public class Blogs {
    public  int BlogID;
    public String BlogTitle;
    public String BlogCreator;
    public String BlogDescription;
    public String BlogImage;

    public Blogs(int blogID, String blogTitle, String blogCreator, String blogDescription, String blogImage) {
        BlogID = blogID;
        BlogTitle = blogTitle;
        BlogCreator = blogCreator;
        BlogDescription = blogDescription;
        BlogImage = blogImage;
    }

    public int getBlogID() {
        return BlogID;
    }

    public void setBlogID(int blogID) {
        BlogID = blogID;
    }

    public String getBlogTitle() {
        return BlogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        BlogTitle = blogTitle;
    }

    public String getBlogCreator() {
        return BlogCreator;
    }

    public void setBlogCreator(String blogCreator) {
        BlogCreator = blogCreator;
    }

    public String getBlogDescription() {
        return BlogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        BlogDescription = blogDescription;
    }

    public String getBlogImage() {
        return BlogImage;
    }

    public void setBlogImage(String blogImage) {
        BlogImage = blogImage;
    }

}
