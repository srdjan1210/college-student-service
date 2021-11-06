package model;

import java.util.Date;

import utils.Constants.BrOcena;

public class Ocena {
	private Student polozioIspit;
	private Predmet predmet;
	private BrOcena ocena;
	private Date datumPolaganjaIspita;
	
	public Ocena(Student polozioIspit, Predmet predmet, BrOcena ocena, Date datumPolaganjaIspita) {
		super();
		this.polozioIspit = polozioIspit;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}

	public Student getPolozioIspit() {
		return polozioIspit;
	}

	public void setPolozioIspit(Student polozioIspit) {
		this.polozioIspit = polozioIspit;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public BrOcena getOcena() {
		return ocena;
	}

	public void setOcena(BrOcena ocena) {
		this.ocena = ocena;
	}

	public Date getDatumPolaganjaIspita() {
		return datumPolaganjaIspita;
	}

	public void setDatumPolaganjaIspita(Date datumPolaganjaIspita) {
		this.datumPolaganjaIspita = datumPolaganjaIspita;
	}
	
	
	
	
}
