package com.comedyClub.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class StoryDto implements Serializable {
	
	private static final long serialVersionUID = 9124633587745247475L;
	
	private Long id;
	private String title;
	private Long userId;
	private String content;
	private boolean isPublic;
	

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	
	public String toString() {
		return new ToStringBuilder(this)
					.append(this.getTitle())
					.append(this.getContent())
					.append(this.getIsPublic())
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
		
		if  (!(obj instanceof StoryDto)) {
			return false;
		}
		
		StoryDto storyDto =  (StoryDto) obj;
		return new EqualsBuilder()
					.append(this.getTitle(), storyDto.getTitle())
					.append(this.getContent(), storyDto.getContent())
					.append(this.getIsPublic(), storyDto.getIsPublic())
//					.append(this.getUserId(), storyDto.getUserId())
					.isEquals();
		
	}

	public int hashCode() {
		
		return new HashCodeBuilder(7, 31)
					.append(this.getTitle())
					.append(this.getContent())
					.append(this.getIsPublic())
//					.append(this.getUserId())
					.toHashCode();
	}

}
