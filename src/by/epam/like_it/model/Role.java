package by.epam.like_it.model;


import java.util.ArrayList;
import java.util.List;

public class Role extends Entity {

    private String name;
    private List<User> users;


    public Role() {}

    public Role(int id) {
        super(id);
        users = new ArrayList<>();
    }

    public Role(int id, String name) {
        this(id);
        this.name = name;
    }

    public String getName() {
         return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUsers(User element) {
        users.add(element);
    }

    public void removeUsers(User element) {
        users.remove(element);
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

        Role role = (Role) o;

        if (name != null ? !name.equals(role.name) : role.name != null) {
            return false;
        }
        return users != null ? users.equals(role.users) : role.users == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
