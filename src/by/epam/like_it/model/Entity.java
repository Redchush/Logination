package by.epam.like_it.model;

public abstract class Entity {

	protected int id;

	public Entity() {}

	public Entity(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Entity entity = (Entity) o;
		return id == entity.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}