package blog;

public enum Sale{
	HELIUM("He","Gas"),
	MAGNESIUM("mG","Solid");
	private String chemical;
	private String nature;
	private Sale(String s1,String s2) {
		chemical = s1;
		nature = s2;
	}
	public String chemical() {return chemical;};
	public String nature() {return nature;};
	
}

