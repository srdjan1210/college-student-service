package model;

public class Skakaonica {
	private String id;
	private String naziv;
	private int duzina;
	private String tip;
	private String drzavaId;
	
	public Skakaonica(){
		super();
	}
	
	public Skakaonica(String id, String naziv, int duzina, String tip, String drzavaId) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.duzina = duzina;
		this.tip = tip;
		this.drzavaId = drzavaId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drzavaId == null) ? 0 : drzavaId.hashCode());
		result = prime * result + duzina;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		result = prime * result + ((tip == null) ? 0 : tip.hashCode());
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
		Skakaonica other = (Skakaonica) obj;
		if (drzavaId == null) {
			if (other.drzavaId != null)
				return false;
		} else if (!drzavaId.equals(other.drzavaId))
			return false;
		if (duzina != other.duzina)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (tip == null) {
			if (other.tip != null)
				return false;
		} else if (!tip.equals(other.tip))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getDrzavaId() {
		return drzavaId;
	}

	public void setDrzavaId(String drzavaId) {
		this.drzavaId = drzavaId;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-20s %-10d %-15s %-10s", id, naziv, duzina, tip, drzavaId);
	}
	
	public static String getFormattedHeader() {
		return String.format("%-8s %-20s %-10s %-15s %-10s", "IDSA", "NAZIVSA", "DUZINASA", "TIPSA", "IDD");
	}
	
	
	
	
}
