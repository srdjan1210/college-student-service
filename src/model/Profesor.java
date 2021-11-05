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
	
	
}
