package model;

import java.util.ArrayList;

import utils.EnumTypes.Semestar;

public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private Profesor profesor;
	private int espb;
	private ArrayList<Student> studentiPolozili;
	private ArrayList<Student> studentiNisuPolozili;
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, Profesor profesor, int espb) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.profesor = profesor;
		this.espb = espb;
		studentiPolozili = new ArrayList<Student>();
		studentiNisuPolozili = new ArrayList<Student>();
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public ArrayList<Student> getStudentiPolozili() {
		return studentiPolozili;
	}

	public void setStudentiPolozili(ArrayList<Student> studentiPolozili) {
		this.studentiPolozili = studentiPolozili;
	}

	public ArrayList<Student> getStudentiNisuPolozili() {
		return studentiNisuPolozili;
	}

	public void setStudentiNisuPolozili(ArrayList<Student> studentiNisuPolozili) {
		this.studentiNisuPolozili = studentiNisuPolozili;
	}
	
}
