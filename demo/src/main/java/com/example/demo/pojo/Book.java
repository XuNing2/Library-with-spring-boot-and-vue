package com.example.demo.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

    @Column(name = "author")
    private String author;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "press")
    private String press;

    @Column(name = "date")
    private String date;

    public Book(){
        
    }

    public Book(String title, String author, String press, Category category)
    {
        this.title = title;
        this.author = author;
        this.press = press;
        this.category = category;
    }

    public void print(){
        System.out.print("bookid:"+ this.id+"\ntitle:"+this.title
        +"\ncate_id:"+this.category.getId()+"\ntypename:"+this.category.getName()
        +"\nadd_date:"+this.date+"\n");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}