package Futronic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@OneToMany(cascade = CascadeType.ALL)

	@JoinColumn(name = "user_id",referencedColumnName = "id")
	List<Fingers> fingers = new ArrayList<>();

	public Users() {}

	public Users( String name, String username) {
		super();
		this.name = name;
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Fingers> getFingers() {
		return fingers;
	}

	public void setFingers(List<Fingers> fingers) {
		this.fingers = fingers;
	}
}
