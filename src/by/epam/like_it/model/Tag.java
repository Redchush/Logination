package by.epam.like_it.model;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Tag extends Entity {

    private String name;

    @NotNull
    private List<Post> posts;

    @NotNull
    private List<Category> categories;

    @NotNull
    private List<User> users;

    public Tag() {}

    public Tag(int id, String name) {
        super(id);
        this.name = name;
        posts = new ArrayList<>();
        categories = new ArrayList<>();
        users = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean addCategories(Category category) {
        return categories.add(category);
    }

    public boolean removeCategories(Category category) {
        return categories.remove(category);
    }

    public boolean addPosts(Post post) {
        return posts.add(post);
    }

    public boolean removePosts(Post post) {
        return posts.remove(post);
    }

    public boolean addUsers(User user) {
        return users.add(user);
    }

    public boolean removeUsers(User user) {
        return users.remove(user);
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

        Tag tag = (Tag) o;

        if (name != null ? !name.equals(tag.name) : tag.name != null) {
            return false;
        }
        if (!posts.equals(tag.posts)) {
            return false;
        }
        if (!categories.equals(tag.categories)) {
            return false;
        }
        return users.equals(tag.users);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + posts.hashCode();
        result = 31 * result + categories.hashCode();
        result = 31 * result + users.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tag{");
        sb.append(super.toString()).append(" ");
        sb.append("name='").append(name).append('\'');
        sb.append(", posts=").append(posts);
        sb.append(", categories=").append(categories);
        sb.append(", users=").append(users);
        sb.append('}');
        return sb.toString();
    }


}
