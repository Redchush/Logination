package by.epam.like_it.model;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Answer extends Entity {

    private String content;
    private Timestamp createdDate;
    private boolean isBanned;

    //parameter can be null//
    private Timestamp updatedDate;

    private User author;
    private Post parent;

    //parameter that can be null in db, but in orm represents by empty list//
    @NotNull
    private List<Comment> comments;

    @NotNull
    private List<Rating> rating;

    public Answer() {}

    public Answer(int id) {
        super(id);
        comments = new ArrayList<>();
        rating = new ArrayList<>();
    }

    public Answer(int id, User author, Post parent, String content, Timestamp createdDate,
                  Timestamp updatedDate, boolean banned) {
        super(id);
        this.author = author;
        this.parent = parent;
        this.content = content;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.isBanned = banned;
    }

    public Answer(int id, User author, Post parent, String content, Timestamp createdDate,
                  Timestamp updatedDate, boolean banned, List<Comment> comments) {
        this(id, author, parent, content, createdDate,updatedDate, banned);
        this.comments = comments;
    }

    public Answer(int id, User author, Post parent, String title, String content, Timestamp createdDate,
                  Timestamp updatedDate, boolean isBanned,  List<Comment> comments, List<Rating> rating) {
        this(id, author, parent, content, createdDate, updatedDate, isBanned, comments);
        this.rating = rating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

   public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComments(Comment comment){
        comments.add(comment);
    }

    public void removeComments(Comment comment){
        comments.add(comment);
    }

    public void addRaiting(Rating rate){
        rating.add(rate);
    }

    public void removeRaiting(Rating rate){
        rating.add(rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Answer answer = (Answer) o;

        if (isBanned != answer.isBanned) {
            return false;
        }
        if (content != null ? !content.equals(answer.content) : answer.content != null) {
            return false;
        }
        if (createdDate != null ? !createdDate.equals(answer.createdDate) : answer.createdDate != null) {
            return false;
        }
        if (updatedDate != null ? !updatedDate.equals(answer.updatedDate) : answer.updatedDate != null) {
            return false;
        }
        if (author != null ? !author.equals(answer.author) : answer.author != null) {
            return false;
        }
        if (parent != null ? !parent.equals(answer.parent) : answer.parent != null) {
            return false;
        }
        if (comments != null ? !comments.equals(answer.comments) : answer.comments != null) {
            return false;
        }
        return rating != null ? rating.equals(answer.rating) : answer.rating == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (isBanned ? 1 : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Answer{");
        sb.append(super.toString()).append(" ");

        sb.append("content='").append(content).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", isBanned=").append(isBanned);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", author=").append(author);
        sb.append(", parent=").append(parent);
        sb.append(", comments=").append(comments);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }


}
