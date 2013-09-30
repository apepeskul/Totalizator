package com.comedyClub.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 3165487412362978214L;
	
	private Long id;
	private String name;
    private String password;

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
		
		if  (!(obj instanceof UserDto)) {
			return false;
		}
		
		UserDto userDto =  (UserDto) obj;
		
		return new EqualsBuilder()
					.append(this.getName(), userDto.getName())
					.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder(13, 37)
					.append(this.getName())
					.toHashCode();
	}

}
