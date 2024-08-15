public class Book {
    private String name;
    private String author;
    private String publisher;
    private String number;
    private String date;
    private int pageNum;
    private String summary;

    public Book(String name, String author, String publisher, String number, String date, int pageNum,
                String summary) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.number = number;
        this.date = date;
        this.pageNum = pageNum;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public int getPageNum() {
        return pageNum;
    }

    public String getSummary() {
        return summary;
    }
}
