package personnages;

public class Romain {
	private static final int NOMBRE_EQUIPEMENT_MAX = 2;
	
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[NOMBRE_EQUIPEMENT_MAX];
	private int nbEquipement = 0;
	
	
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
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
			case 2: {
				System.out.println("Le soldat " + nom + " est déjà bien protégé !");
				break;
			}
			case 1: {
				if (equipements[0] == equipement) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
				}
				else {
					equiper(equipement);
				}
				break;
			}
			case 0:{
				equiper(equipement);
				break;
			}
			
		}
	}
	private void equiper(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
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
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		
	}
}
