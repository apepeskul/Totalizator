package com.comedyClub.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Story implements Serializable {
	private static final long serialVersionUID = 4567457456746767665L;
	
	private Long id;
	private String title;
	private User user;
	private String content;
	private boolean isPublic;
	private Set<Rating> ratings = new HashSet<Rating>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
		
	public boolean getIsPublic() {
		return isPublic;
	}
	
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	public Set<Rating> getRatings() {
		return ratings;
	}
	
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public void addRating(Rating rating) {
		this.ratings.add(rating);
		rating.setStory(this);
	}
	
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.getTitle())
					.append(this.getContent())
					.append(this.getIsPublic()).toString();
	}
	
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if  (!(obj instanceof Story)) {
			return false;
		}
		
		Story story =  (Story) obj;
		return new EqualsBuilder()
					.append(this.getTitle(), story.getTitle())
					.append(this.getContent(), story.getContent())
					.append(this.getIsPublic(), story.getIsPublic()).isEquals();		
	}

	public int hashCode() {
		
		return new HashCodeBuilder(7, 31)
					.append(this.getTitle())
					.append(this.getContent())
					.append(this.getIsPublic()).toHashCode();
	}
}
