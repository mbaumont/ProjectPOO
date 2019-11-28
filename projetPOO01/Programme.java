package projetPOO01;

import java.util.List;
import java.util.Scanner;

import projPOO01.enumerations.ESalarie;
import projetPOO01Enumerations.EPersonne;
import projetPOO01Exceptions.ErreurSaisie;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import projetPOO01GestionPersonnes.Client;
import projetPOO01GestionPersonnes.Fournisseur;
import projetPOO01GestionPersonnes.IClient;
import projetPOO01GestionPersonnes.Personne;
import projetPOO01GestionPersonnes.Salarie;

public class Programme {
	static List<Personne> listPersonne = new ArrayList<Personne>();
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {		
		afficheMenu();			
	}	
	public static void afficheMenu() {
		String a;
		System.out.println("Menu Principal");
		System.out.println("-----------------------------------------------");
		System.out.println("Bienvenue dans votre gestionnaire de personnel.\n");
		System.out.println("Taper 1: Saisie d'un nouveau profil");
		System.out.println("Taper 2: Visualiser les profils existants \n ");		
		String[] listString = {"1","2"};
		
		a = validateAnswer(listString);
		switch(a) {
		case "1": 
			afficheMenu1();
			break;
		case "2":
			afficheMenu2();
			break;
		default:
			afficheMenu();
		}	
	}
	
	public static void afficheMenu2() {
		for (Personne p:listPersonne) {
			System.out.println(p);			
		}	
	}

	public static void afficheMenu1() {
		String a;	
	
		System.out.println("Saisie d'un profil");
		System.out.println("-----------------------------------------------");
		System.out.println("Voulez vous saisir un profil salarié, client ou fournisseur?");
		System.out.println("Taper s pour salarié, c pour client, f pour fournisseur ou r pour retourner au menu princpal: \n ");
		String[] listString = {"s","c","f","r"};
		a = validateAnswer(listString);
		Dictionary<EPersonne, String> dico = new Hashtable<EPersonne, String>();


		
		switch(a) {
		case "s": 
			System.out.println("Vous avez choisi le profil salarié.");
			System.out.println("-----------------------------------------------");
			initDicoPersonne(dico, a);
			initToutesPersonne(dico);		

			Personne p = new Salarie(dico); // changer pour le dico ici
			listPersonne.add(p);
			System.out.println("Salarié aouté, retour au menu principal. \n");
			break;

		case "c":
			System.out.println("Vous avez choisi le profil client.");
			System.out.println("-----------------------------------------------");
			initDicoPersonne(dico, a);
			initToutesPersonne(dico);		
			Personne p1 = new Client(dico);
			listPersonne.add(p1);
			System.out.println("Client ajouté, retour au menu principal. \n ");
			
			break;
		case "f":
			System.out.println("Vous avez choisi le profil fournisseur.");
			System.out.println("----------------------------------------------- \n");
			initDicoPersonne(dico, a);
			initToutesPersonne(dico);
			Personne p2 = new Fournisseur(dico);
			listPersonne.add(p2);
			System.out.println("Fournisseur ajouté, retour au menu principal. \n");
		default:
			System.out.println("Retour au menu principal !");
		}		
		afficheMenu();
	}	
	

	public static void initDicoPersonne(Dictionary<EPersonne, String> dico, String typePersonne){
		dico.put(EPersonne.nom,"Saisie du nom : ");
		dico.put(EPersonne.prenom,"Saisie du prénom : ");
		dico.put(EPersonne.adresse,"Saisie de l'adresse : ");
		dico.put(EPersonne.ville,"Saisie de la ville : ");
		dico.put(EPersonne.codepostal,"Saisie du code postal : ");
		switch(typePersonne) {
		case "s":
			dico.put(EPersonne.salaire,"Saisie du salaire au format: XXXX,XX");
			dico.put(EPersonne.nSecu,"Saisie du numéro de sécurité social : ");
			break;
		case "c":
			dico.put(EPersonne.nClient,"Saisie du numéro Client (attention un numéro par client) : ");
			break;
		case "f":
			dico.put(EPersonne.nFour,"Saisie du numéro Fournisseur (attention un numéro par fournisseur) : ");
			break;			
		}
	}

	public static void initToutesPersonne(Dictionary<EPersonne, String> dico) {
			
		String element;	
		boolean erreursaisie;
		for (Enumeration<EPersonne> k = dico.keys(); k.hasMoreElements();)  {
			EPersonne ep = k.nextElement();
			System.out.println(dico.get(ep));
			if(ep == EPersonne.codepostal) {
				erreursaisie = true;
				while(erreursaisie) {
           	 		try {
	            		 String codepostal = sc.nextLine();
	            		 checkCodePostal(codepostal);
	            		 dico.put(ep,codepostal);
	            		 erreursaisie = false;
           	 		}
           	 		catch(Exception e) {
           	 			System.err.println(e.getMessage());
           	 			System.out.println(dico.get(ep));
           	 		}
           	 	}
			}
			else if(ep == EPersonne.nSecu) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String nSecu = sc.nextLine();
	            		 checknSecu(nSecu);
	            		 dico.put(ep,nSecu);
	            		 erreursaisie = false;
	           	 	}
           	 		catch(Exception e) {
           	 			System.err.println(e.getMessage());
           	 			System.out.println(dico.get(ep));
           	 		}
	           	 	}
				}
			else if(ep == EPersonne.salaire) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String salaire = sc.nextLine();
	            		 checkSalaire(salaire);
	            		 dico.put(ep,salaire);
	            		 erreursaisie = false;
	           	 	}
          	 		catch(Exception e) {
          	 			System.err.println(e.getMessage());
          	 			System.out.println(dico.get(ep));
          	 		}
	           	 	}
				}	
			/**
			else if(ep == EPersonne.nClient) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String nClient = sc.nextLine();
	            		 testNClient(nClient);
	            		 dico.put(ep,nClient);
	            		 erreursaisie = false;
	           	 	}
         	 		catch(Exception e) {
         	 			System.err.println(e.getMessage());
         	 			System.out.println(dico.get(ep));
         	 		}
	           	 	}
				}
			**/		
			/**if (ep == EPersonne.nFour) {
				while(testNFournisseur(ep)) {
					System.out.println("Le numéro fournisseur est déjà prit, choisissez un autre numéro");
					element = sc.nextLine();
				}
			}
			
			else if (k.equals("le numéro client")) {
				while(testNClient(k)) {
					System.out.println("Le numéro client est déjà prit, choisissez un autre numéro");
					element = sc.nextLine();
				}
			}
			**/
			else {
				element = sc.nextLine();
	   	 		dico.put(ep,element);	//ajouter ici les test pour les verification salaire etc
			}
		}
		
	}
	
		
	public static boolean testReponse(String[] listRep, String element){
		for (String r:listRep) {
			if (element.equals(r)) {
				return false;
			}		
		}
		return true;	
	}

	public static String validateAnswer(String[] listRep){
		String element;
		element = sc.nextLine();
		while (testReponse(listRep,element)) {
			System.out.println("Attention votre réponse est non valable, tapez"); 
			for(String e:listRep) { // faire pour de 0 à l'avant dernier et gérer le dernier dans un cas apart
				System.out.print(e+", ");
			}
			element = sc.nextLine();
		}
		return element;
	}
	public static void gereclient(IClient client) {
		client.achete();
		client.paie();
	}


	public static boolean testNFournisseur(String nFournisseur) {
		List<String> listNFournisseur;
		listNFournisseur = listNFour();
		for (String f:listNFournisseur) {
			if (f.equals(nFournisseur)) {
				return true;
				}
			}
		return false;
		}

	public static boolean testNClient(String nClient) {
		List<String> listNClient;
		listNClient = listNClient();
		for (String c:listNClient) {
			if (c.equals(nClient)) {
				return true;
				}
			}
		return false;
		}
	

	public static List<String> listNFour() {
		List<String> listNFournisseur = new ArrayList<String>() ;
		for (Personne p:listPersonne) {
			if (p.getClass().getSimpleName().equals("Fournisseur")) {
				Fournisseur f = (Fournisseur) p;
				listNFournisseur.add(f.getnFournisseur());
			}
		}
		return listNFournisseur;
	}
	
	public static List<String> listNClient() {
		List<String> listNClient = new ArrayList<String>() ;
		for (Personne p:listPersonne) {
			if (p.getClass().getSimpleName().equals("Client")) {
				Client f = (Client) p;
				listNClient.add(f.getnClient());
			}
		}
		return listNClient;
	}
	
	
	
	
	
	
	
	
	// Les mettre dans une autre classe pour plus de lisibilité
	public static void checknSecu(String nSecu) throws ErreurSaisie {
		
		if (!nSecu.matches("\\d{13}")) {
			throw new ErreurSaisie("Il faut insérer 13 chiffres");		
		}
	}
	
	public static void checkCodePostal(String codepostal) throws ErreurSaisie {
		if(codepostal.length() !=5) {
			throw new ErreurSaisie("Attention le code postal doit être composé de 5 chiffres");
		}
		try {
			Integer.parseInt(codepostal);
		}
		catch(Exception e) {
			throw new ErreurSaisie("Attention il faut insérer des chiffres");
		}
	}
	
	public static void checkSalaire(String salaire) throws ErreurSaisie {
		if (salaire.matches("\\d{0,5},\\d{2}")) { 
			throw new ErreurSaisie("Attention il faut insérer au format XXXX,XX");
		}
	}
	
	
	
}
