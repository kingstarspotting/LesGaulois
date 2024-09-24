package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isForcePositive();
	}
	public String getNom() {
		return nom;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	public void recevoirCoup(int forceCoup) {
		assert isForcePositive();
		int ancienneForce = force;
		force -= forceCoup;
		assert isForceDiminue(ancienneForce);
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	private boolean isForcePositive() {
		return force > 0;
	}
	
	private boolean isForceDiminue(int ancienneForce) {
		return force < ancienneForce;
	}
	
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour je suis Minus");
		minus.recevoirCoup(1);
		minus.recevoirCoup(2);
	}
}
