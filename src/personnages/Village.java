package personnages;

import java.util.Iterator;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef (Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
	}
	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];	
	}
	
	public void afficherVillageois() {
		int i = 0;
		System.out.println("Dans le village du chef " + chef + " vivent les légendaires gaulois :");
		while (villageois[i] != null) {
			System.out.println("- " + villageois[i].getNom());
			i++;
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
		// On obtient cette exception car on demande un indice trop haut
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		//village.ajouterHabitant();
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		// On obtient "null" car il n'y a pas de gaulois 1.
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
