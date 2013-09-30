package com.comedyClub.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RatingDto implements Serializable{
	
	private static final long serialVersionUID = 3216547898512365417L;
	
	private Long id;
	private Integer rate;
	private Long storyId;
	private Long userId;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rating) {
		this.rate = rating;
	}

	public Long getStoryId() {
		return storyId;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.getRate())
//					.append(this.getStoryId())
//					.append(this.getUserId())
					.toString();
	}
	
	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		if  (!(obj instanceof RatingDto)) {
			return false;
		}
		
		RatingDto ratingDto =  (RatingDto) obj;
	
		return new EqualsBuilder()
					.append(this.getRate(), ratingDto.getRate())
//					.append(this.getStoryId(), ratingDto.getStoryId())
//					.append(this.getUserId(), ratingDto.getUserId())
					.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(5, 17)
					.append(this.getRate())
//					.append(this.getStoryId())
//					.append(this.getUserId())
					.toHashCode();
	}

}
