package com.example.demo.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class PersonTurnId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int personId;

    private int turnId;
    
    public PersonTurnId() {
    }
    
    public PersonTurnId(int personId, int turnId) {
        this.personId = personId;
        this.turnId = turnId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(turnId, personId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonTurnId other = (PersonTurnId) obj;
		return turnId == other.turnId && personId == other.personId;
	}
    
}