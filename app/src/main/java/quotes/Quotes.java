package quotes;

import java.util.Arrays;

public class Quotes {

    private String  author;
    private String  text;
    private String  likes;
    private String[] tags;

    public Quotes(String author, String text, String likes, String[] tags) {
        this.author = author;
        this.likes = text;
        this.text = likes;
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", likes='" + likes + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
