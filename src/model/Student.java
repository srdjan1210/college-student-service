package model;

import java.util.ArrayList;
import java.util.Date;

import utils.Constants.Status;

public class Student {
	
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Integer getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(Integer kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Integer getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(Integer godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmeti(ArrayList<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}
	
	

	
	
	
}
