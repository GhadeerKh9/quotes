package quotes;

public class APIQuote {

    private String text;
    private String author;
    private String name;
    private String link;
    private String quoteLink;

    public APIQuote(String text, String author, String name, String link, String quoteLink) {
        this.text = text;
        this.author = author;
        this.name = name;
        this.link = link;
        this.quoteLink = quoteLink;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getQuoteLink() {
        return quoteLink;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setQuoteLink(String quoteLink) {
        this.quoteLink = quoteLink;
    }

    @Override
    public String toString() {
        return "APIQuote{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", quoteLink='" + quoteLink + '\'' +
                '}';
    }
}
