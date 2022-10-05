package com.example.demo.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PersonTurn {
	
	@EmbeddedId
    private PersonTurnId key = new PersonTurnId();
	
	@MapsId("personId")
    @ManyToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    public Person person;

	@MapsId("turnId")
    @ManyToOne
    @JoinColumn(name = "turnId", referencedColumnName = "id")
    public Turn turn;
	
	public PersonTurn() {
		super();
	}

	public PersonTurn(Person person, Turn turn) {
		super();
		this.person = person;
		this.turn = turn;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}
    
}
