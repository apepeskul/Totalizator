package com.comedyClub.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Rating implements Serializable {
	private static final long serialVersionUID = 3456882132891232175L;
	
	private Long id;
	private Integer rate;
	private User user;
	private Story story;
	
	public Rating() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getRate() {
		return rate;
	}
	
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public String toString() {
		return new ToStringBuilder(this)
					.append(this.getRate()).toString();
	}
	
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if  (!(obj instanceof Rating)) {
			return false;
		}
		
		Rating rating =  (Rating) obj;
	
		return new EqualsBuilder()
					.append(this.getRate(), rating.getRate())
					.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(5, 7)
					.append(this.getRate()).toHashCode();
	}

}
