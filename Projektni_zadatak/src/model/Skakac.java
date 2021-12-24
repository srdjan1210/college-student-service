package model;

public class Skakac {
	private int id;
	private String ime;
	private String prezime;
	private String drzavaId;
	private int titule;
	private double licniRekord;
	
	public Skakac(){
		super();
	}
	
	public Skakac(int id, String ime, String prezime, String drzavaId, int titule, double licniRekord) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.drzavaId = drzavaId;
		this.titule = titule;
		this.licniRekord = licniRekord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drzavaId == null) ? 0 : drzavaId.hashCode());
		result = prime * result + id;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(licniRekord);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		result = prime * result + titule;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skakac other = (Skakac) obj;
		if (drzavaId == null) {
			if (other.drzavaId != null)
				return false;
		} else if (!drzavaId.equals(other.drzavaId))
			return false;
		if (id != other.id)
			return false;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (Double.doubleToLongBits(licniRekord) != Double.doubleToLongBits(other.licniRekord))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (titule != other.titule)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDrzavaId() {
		return drzavaId;
	}

	public void setDrzavaId(String drzavaId) {
		this.drzavaId = drzavaId;
	}

	public int getTitule() {
		return titule;
	}

	public void setTitule(int titule) {
		this.titule = titule;
	}

	public double getLicniRekord() {
		return licniRekord;
	}

	public void setLicniRekord(double licniRekord) {
		this.licniRekord = licniRekord;
	}
	
	@Override
	public String toString() {
		return String.format("%-5d %-7s %-10s %-6s %-8d %-6.2f", id, ime, prezime, drzavaId, titule, licniRekord);
	}
	
	public static String getFormattedHeader() {
		return String.format("%-5s %-7s %-10s %-6s %-8s %-6s", "IDSC", "IMESC", "PRZSC", "IDD", "TITULE", "PBSC");
	}

	
}
