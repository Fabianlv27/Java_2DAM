package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jugador database table.
 * 
 */
@Entity
@NamedQuery(name="Jugador.findAll", query="SELECT j FROM Jugador j")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday_GMT;

	@Column(name="full_name")
	private String fullName;
    @Id
    @Column(length = 10)
	private String id;

	private String league;

	private String season;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="id_club")
	private Club club;

	public Jugador() {
	}

	public Date getBirthday_GMT() {
		return this.birthday_GMT;
	}

	public void setBirthday_GMT(Date birthday_GMT) {
		this.birthday_GMT = birthday_GMT;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLeague() {
		return this.league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

}