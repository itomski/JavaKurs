package jpafirststeps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50)
	private String firstname;
	
	@Column(length = 50)
	private String lastname;
	
	private LocalDate birthDate;
	
	// mappedBy = Name der Eigenschaft im Comment, über die eine Verbindung möglich ist
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
	private List<Comment> comments = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public List<Comment> getComments() {
		return Collections.unmodifiableList(comments);
	}
	public void addComment(Comment comment) {
		if(!this.comments.contains(comment)) {
			this.comments.add(comment);
			comment.setUser(this);
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof User)) {
			return false;
		}
		
		return new EqualsBuilder().append(this.id, ((User)obj).id).isEquals();
	}
}
