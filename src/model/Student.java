package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	enum Status{
		Budzet,
		Samofinansiranje
	}
	
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa;
	private Integer kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private Integer godinaUpisa;
	private Integer godinaStudija;
	private Status  status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniPredmeti;
	private ArrayList<Predmet> nepolozeniPredmeti;
	
	public Student(String prezime, String ime, Date datumRodjenja, String adresa, Integer kontaktTelefon,
			String emailAdresa, String brojIndeksa, Integer godinaUpisa, Integer godinaStudija, Status status,
			double prosecnaOcena) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.godinaStudija = godinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.polozeniPredmeti = new ArrayList<Ocena>();
		this.nepolozeniPredmeti = new ArrayList<Predmet>();
	}
	
	
	
}
