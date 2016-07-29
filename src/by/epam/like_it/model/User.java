package by.epam.like_it.model;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class User extends Entity {

	private Role role;

	private String login;
	private String password;
	private String email;

	private String lastName;
	private String firstName;

	private Timestamp createdDate;
	private Timestamp updatedDate;

	private boolean isBanned;

	@NotNull
	private List<Post> publishedPosts;

	@NotNull
	private List<Post> readedPosts;

	@NotNull
	private List<FavoritePost> favoritePosts;

	@NotNull
	private List<Tag> favoriteTags;

	@NotNull
	private List<Answer> answers;

	public User() {}

	public User(int id) {
		super(id);
		favoriteTags = new ArrayList<>();
		readedPosts = new ArrayList<>();
		favoritePosts = new ArrayList<>();
		publishedPosts = new ArrayList<>();
		answers = new ArrayList<>();
	}

	public User(int id, Role role, String login, String password,
				String email, Timestamp createdDate) {
		this(id);
		this.role = role;
		this.login = login;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
	}

	public User(int id, Role role, String login, String password, String email, String lastName, String firstName,
				Timestamp createdDate, Timestamp updatedDate, boolean isBanned) {

		this(id, role, login, password, email, createdDate);
		this.lastName = lastName;
		this.firstName = firstName;
		this.updatedDate = updatedDate;
		this.isBanned = isBanned;
	}

	public User(int id, Role role, String login, String password, String email, String lastName, String firstName,
				Timestamp createdDate, Timestamp updatedDate, boolean isBanned, List<Post> publishedPosts,
				List<Post> readedPosts, List<FavoritePost> favoritePosts, List<Tag> favoriteTags) {

		this(id, role, login, password, email, lastName, firstName,
				createdDate, updatedDate, isBanned);
		this.publishedPosts = publishedPosts;
		this.readedPosts = readedPosts;
		this.favoritePosts = favoritePosts;
		this.favoriteTags = favoriteTags;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public boolean isBanned() {
		return isBanned;
	}

	public void setBanned(boolean banned) {
		isBanned = banned;
	}


	public List<Post> getPublishedPosts() {
		return publishedPosts;
	}


	public void setPublishedPosts(List<Post> publishedPosts) {
		this.publishedPosts = publishedPosts;
	}

	public List<Post> getReadedPosts() {
		return readedPosts;
	}


	public void setReadedPosts(List<Post> readedPosts) {
		this.readedPosts = readedPosts;
	}

	public List<FavoritePost> getFavoritePosts() {
		return favoritePosts;
	}


	public void setFavoritePosts(List<FavoritePost> favoritePosts) {
		this.favoritePosts = favoritePosts;
	}

	public List<Tag> getFavoriteTags() {
		return favoriteTags;
	}

	public void setFavoriteTags(List<Tag> favoriteTags) {
		this.favoriteTags = favoriteTags;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public boolean addFavoriteTags(Tag tag){
		return favoriteTags.add(tag);
	}

	public boolean removeFavoriteTags(Tag tag){
		return favoriteTags.remove(tag);
	}

	public boolean addReadedPosts(Post post){
		return readedPosts.add(post);
	}

	public boolean removeReadedPosts(Post post){
		return readedPosts.remove(post);
	}

	public boolean addPublishedPosts(Post post){
		return publishedPosts.add(post);
	}

	public boolean removePublishedPosts(Post post){
		return publishedPosts.remove(post);
	}

	public boolean addFavoritePosts(FavoritePost post){
		return favoritePosts.add(post);
	}

	public boolean removeFavoritePosts(FavoritePost post){
		return favoritePosts.remove(post);
	}

	public boolean addAnswers(Answer answer){
		return answers.add(answer);
	}

	public boolean removeAnswers(Answer answer){
		return answers.remove(answer);
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

		User user = (User) o;

		if (isBanned != user.isBanned) {
			return false;
		}
		if (role != null ? !role.equals(user.role) : user.role != null) {
			return false;
		}
		if (login != null ? !login.equals(user.login) : user.login != null) {
			return false;
		}
		if (password != null ? !password.equals(user.password) : user.password != null) {
			return false;
		}
		if (email != null ? !email.equals(user.email) : user.email != null) {
			return false;
		}
		if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) {
			return false;
		}
		if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) {
			return false;
		}
		if (createdDate != null ? !createdDate.equals(user.createdDate) : user.createdDate != null) {
			return false;
		}
		if (updatedDate != null ? !updatedDate.equals(user.updatedDate) : user.updatedDate != null) {
			return false;
		}
		if (!publishedPosts.equals(user.publishedPosts)) {
			return false;
		}
		if (!readedPosts.equals(user.readedPosts)) {
			return false;
		}
		if (!favoritePosts.equals(user.favoritePosts)) {
			return false;
		}
		if (!favoriteTags.equals(user.favoriteTags)) {
			return false;
		}
		return answers.equals(user.answers);

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (role != null ? role.hashCode() : 0);
		result = 31 * result + (login != null ? login.hashCode() : 0);
		result = 31 * result + (password != null ? password.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
		result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
		result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
		result = 31 * result + (isBanned ? 1 : 0);
		result = 31 * result + publishedPosts.hashCode();
		result = 31 * result + readedPosts.hashCode();
		result = 31 * result + favoritePosts.hashCode();
		result = 31 * result + favoriteTags.hashCode();
		result = 31 * result + answers.hashCode();
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append(super.toString());
		sb.append(" ");
		sb.append("role=").append(role);
		sb.append(", login='").append(login).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", email='").append(email).append('\'');
		sb.append(", lastName='").append(lastName).append('\'');
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", createdDate=").append(createdDate);
		sb.append(", updatedDate=").append(updatedDate);
		sb.append(", isBanned=").append(isBanned);
		sb.append(", publishedPosts=").append(publishedPosts);
		sb.append("\n, readedPosts=").append(readedPosts);
		sb.append("\n, favoritePosts=").append(favoritePosts);
		sb.append("\n, favoriteTags=").append(favoriteTags);
		sb.append("\n, answers=").append(answers);
		sb.append('}');
		return sb.toString();
	}




}