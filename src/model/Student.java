package model;

import java.time.LocalDate;
import java.util.ArrayList;

import utils.Constants.Status;

public class Student {
	
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private String adresa;
	private String kontaktTelefon;
	private String emailAdresa;
	private String brojIndeksa;
	private int godinaUpisa;
	private int godinaStudija;
	private Status  status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniPredmeti;
	private ArrayList<Predmet> nepolozeniPredmeti;
	
	public Student(String prezime, String ime, LocalDate datumRodjenja, String adresa, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, int godinaUpisa, int godinaStudija, Status status,
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

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
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

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
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
