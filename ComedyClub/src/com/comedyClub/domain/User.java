package com.comedyClub.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
	
	private static final long serialVersionUID = 8143116004661990405L;
	
	private Long id;
	private String name;
	private String password;    
    private Set<Story> stories = new HashSet<Story>();
	private Set<User> friends = new HashSet<User> ();
	
	public User() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Story> getStories() {
		return stories;
	}
	
	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}
	
	public void addStory(Story story) {
		this.getStories().add(story);
		story.setUser(this);
	}
	
	public Set<User> getFriends() {
		return friends;
	}
	
	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}
	
	public void addFriend(User friend) {
		this.getFriends().add(friend);
	}
	
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.getName())
					.toString();
	}
	
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if  (!(obj instanceof User)) {
			return false;
		}
		
		User user =  (User) obj;
		
		return new EqualsBuilder().append(this.getName(), user.getName())
							.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.getName()).toHashCode();
	}

}
