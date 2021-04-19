package entity;

import java.sql.Date;

public class Post {
	
    int _id;
    String author;
    String subject;
    String body;
    Date createdDate;
    int likes;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdTime) {
        this.createdDate = createdTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "_id=" + _id +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", createdDate=" + createdDate +
                ", likes=" + likes +
                '}';
    }
}