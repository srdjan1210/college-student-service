package model;

public class Skok {
	private String id;
	private int skakacId;
	private String skakaonicaId;
	private double bodoviDuzina;
	private double bodoviStil;
	private double bodoviVetar;
	
	public Skok() {
		super();
	}

	public Skok(String id, int skakacId, String skakaonicaId, double bodoviDuzina, double bodoviStil,
			double bodoviVetar) {
		super();
		this.id = id;
		this.skakacId = skakacId;
		this.skakaonicaId = skakaonicaId;
		this.bodoviDuzina = bodoviDuzina;
		this.bodoviStil = bodoviStil;
		this.bodoviVetar = bodoviVetar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bodoviDuzina);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bodoviStil);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(bodoviVetar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + skakacId;
		result = prime * result + ((skakaonicaId == null) ? 0 : skakaonicaId.hashCode());
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
		Skok other = (Skok) obj;
		if (Double.doubleToLongBits(bodoviDuzina) != Double.doubleToLongBits(other.bodoviDuzina))
			return false;
		if (Double.doubleToLongBits(bodoviStil) != Double.doubleToLongBits(other.bodoviStil))
			return false;
		if (Double.doubleToLongBits(bodoviVetar) != Double.doubleToLongBits(other.bodoviVetar))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (skakacId != other.skakacId)
			return false;
		if (skakaonicaId == null) {
			if (other.skakaonicaId != null)
				return false;
		} else if (!skakaonicaId.equals(other.skakaonicaId))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSkakacId() {
		return skakacId;
	}

	public void setSkakacId(int skakacId) {
		this.skakacId = skakacId;
	}

	public String getSkakaonicaId() {
		return skakaonicaId;
	}

	public void setSkakaonicaId(String skakaonicaId) {
		this.skakaonicaId = skakaonicaId;
	}

	public double getBodoviDuzina() {
		return bodoviDuzina;
	}

	public void setBodoviDuzina(double bodoviDuzina) {
		this.bodoviDuzina = bodoviDuzina;
	}

	public double getBodoviStil() {
		return bodoviStil;
	}

	public void setBodoviStil(double bodoviStil) {
		this.bodoviStil = bodoviStil;
	}

	public double getBodoviVetar() {
		return bodoviVetar;
	}

	public void setBodoviVetar(double bodoviVetar) {
		this.bodoviVetar = bodoviVetar;
	}
	
	@Override
	public String toString() {
		return String.format("%-6s %-10d %-10s %-8.2f %-8.2f %-8.2f", id, skakacId, skakaonicaId, bodoviDuzina, bodoviStil, bodoviVetar);
	}
	
	public static String getFormattedHeader() {
		return String.format("%-6s %-10s %-10s %-8.2s %-8.2s %-8.2s", "IDSK", "IDSC", "IDSA", "BDUZINA", "BSTIL", "BVETAR");
	}
}
