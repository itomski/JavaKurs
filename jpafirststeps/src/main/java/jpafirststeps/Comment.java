package jpafirststeps;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalDateTime created;
	
	@Column(length = 250)
	private String text;
	
	@ManyToOne
	private User user;
	
	public Comment() {
	}
	
	public Comment(LocalDateTime created, String text) {
		this.created = created;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		if(!this.user.equals(user)) {
			this.user = user;
			user.addComment(this);
		}
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Comment)) {
			return false;
		}
		
		return new EqualsBuilder().append(this.id, ((Comment)obj).id).isEquals();
	}
}
