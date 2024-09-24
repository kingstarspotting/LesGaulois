package personnages;

public class Gaulois {
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	private String nom;
	private int force;
	private int effetPotion = 1;

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " +  texte + " »");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force / 3) * effetPotion);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 5);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour je suis Astérix");
		panoramix.preparerPotion();
		asterix.boirePotion(5);
		asterix.frapper(minus);
	}
}
