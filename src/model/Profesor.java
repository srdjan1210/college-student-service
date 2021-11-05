package model;

import java.util.ArrayList;
import java.util.Date;

import model.Student.Status;

public class Profesor {
	private String prezime;
	private String ime;
	private Date datumRodjenja;
	private String adresa;
	private Integer kontaktTelefon;
	private String emailAdresa;
	private String adresaKancelarije;
	private Integer brojLicneKarte;
	private String zvanje;
	private Integer godineStaza;
	private ArrayList<Predmet> predmeti;
	
	public Profesor(String prezime, String ime, Date datumRodjenja, String adresa, Integer kontaktTelefon,
			String emailAdresa, String adresaKancelarije, Integer brojLicneKarte, String zvanje, Integer godineStaza,
			ArrayList<Predmet> predmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.predmeti = new ArrayList<Predmet>();
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

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public Integer getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(Integer brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public Integer getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(Integer godineStaza) {
		this.godineStaza = godineStaza;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
	
	
}
