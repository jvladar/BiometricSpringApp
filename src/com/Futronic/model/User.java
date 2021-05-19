package Futronic.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	List<Fingerprint> fingerprints = new ArrayList<>();

	public User() {}

	public User(String name, String username) {
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

	public List<Fingerprint> getFingers() {
		return fingerprints;
	}

	public void setFingers(List<Fingerprint> fingerprints) {
		this.fingerprints = fingerprints;
	}
}
