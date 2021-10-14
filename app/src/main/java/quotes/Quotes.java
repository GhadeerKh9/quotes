package quotes;

import java.util.ArrayList;

public class Quotes {

    private ArrayList<String> tags;

    private String text;
    private String author;



    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "Quotes{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}