package projetPOO01;

import java.util.List;
import java.util.Scanner;

import projetPOO01.Enumerations.EPersonne;
import projetPOO01.Exceptions.ErreurSaisie;
import projetPOO01.GestionPersonnes.Client;
import projetPOO01.GestionPersonnes.Fournisseur;
import projetPOO01.GestionPersonnes.IClient;
import projetPOO01.GestionPersonnes.Patron;
import projetPOO01.GestionPersonnes.Personne;
import projetPOO01.GestionPersonnes.Salarie;
import projetPOO01.Methodes.Achat;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Programme {
	static List<Personne> listPersonne = new ArrayList<Personne>();
	static boolean Patron = false;
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
		System.out.println("Taper 2: Visualiser les profils existants");
		System.out.println("Taper 3: Gestion Client \n ");
		String[] listString = {"1","2","3"};		
		a = validateAnswer(listString);
		switch(a) {
		case "1": 
			afficheMenu1();
			break;
		case "2":
			afficheMenu2();
			break;
		case "3":
			afficheMenu3();
			break;
		default:
			afficheMenu();			
			break;
		}	
	}
	
	public static void afficheMenu2() {
		for (Personne p:listPersonne) {
			System.out.println(p);			
		}	
		System.out.println("-----------------------------------------------");
		System.out.println("Taper entrer pour retourner au menu ou Q pour quitter.");
		String[] listString = {"","Q"};		
		String a = validateAnswer(listString);
		if (a.equals("")) {
			afficheMenu();			
		}
	}
	
	public static void afficheMenu3() {
		List<String> listNClients  = new ArrayList<String>();
		List<IClient> listClient = new ArrayList<IClient>();
		String choixMenu3;
		for(Personne p:listPersonne) {
			if (p instanceof IClient) {
				IClient f = (IClient) p;
				if (f.clientOuPas()) {
					listNClients.add(f.afficheNClient());
					System.out.print(f.afficheNClient());
					System.out.println(f);
					listClient.add(f);
				}		
			}
		}
		System.out.println("Taper le numéro client pour gérer ses achats, ou r pour retour: ");
		listNClients.add("r");
		String[] arrayClient = listNClients.toArray(new String[0]);
		choixMenu3 = validateAnswer(arrayClient);
		if (!choixMenu3.equals("r")) {
			int index = listNClients.indexOf(choixMenu3);
			IClient client = listClient.get(index);
			System.out.println("----------------------------");
			System.out.println("Vous avez choisi le client: "+choixMenu3);
			
			afficheMenuAchat(client);
			
			afficheMenu();
		}
		else {
			afficheMenu();	
		}
		
	}
	public static void afficheMenuAchat(IClient Client) {
		System.out.println("Saisie d'un nouvel achat");
		System.out.println("----------------------------");
		System.out.println("Date (format XX/XX/XX):");
		
		boolean erreursaisie = true;
		while(erreursaisie) {
			try {
				String date = sc.nextLine();
				Achat.checkDate(date);	
				
				erreursaisie = false;
		 	}
			catch(Exception e) {
				System.err.println(e.getMessage());
				System.out.println("Date (format XX/XX/XX):");
			}
		 	}
		}
		
		
		
		
	
	public static void afficheMenu1() {
		String choixMenu1;
		System.out.println("Saisie d'un nouveau profil");
		System.out.println("-----------------------------------------------");
		System.out.println("Voulez vous saisir un profil salarié, client, fournisseur ou patron?");
		System.out.println("Taper s pour salarié, c pour client, f pour fournisseur, p pour patron ou r pour retourner au menu princpal: \n ");
		String[] listString = {"s","c","f","p","r"};
		choixMenu1 = validateAnswer(listString);

		Dictionary<EPersonne, String> dico = new Hashtable<EPersonne, String>();		
		switch(choixMenu1) {
		case "s": 
			System.out.println("Vous avez choisi le profil salarié.");
			System.out.println("-----------------------------------------------");
			initDicoPersonne(dico, choixMenu1);
			initToutesPersonne(dico);		

			Personne p = new Salarie(dico); // changer pour le dico ici
			listPersonne.add(p);
			System.out.println("Salarié ajouté. \n");
			afficheMenu1();
			break;

		case "c":
			System.out.println("Vous avez choisi le profil client.");
			System.out.println("-----------------------------------------------");
			initDicoPersonne(dico, choixMenu1);
			initToutesPersonne(dico);		
			Personne p1 = new Client(dico);
			listPersonne.add(p1);
			System.out.println("Client ajouté. \n ");
			afficheMenu1();
			break;
		case "f":
			System.out.println("Vous avez choisi le profil fournisseur.");
			System.out.println("----------------------------------------------- \n");
			initDicoPersonne(dico, choixMenu1);			
			initToutesPersonne(dico);
			Personne p2 = new Fournisseur(dico);
			System.out.println(dico);
			listPersonne.add(p2);
			System.out.println(p2);
			System.out.println("Fournisseur ajouté. \n");
			afficheMenu1();
			break;
		case "p":
			System.out.println("Vous avez choisi le profil patron.");
			System.out.println("----------------------------------------------- \n");
			if (Patron) {
				System.out.println("Attention vous avez déjà ajouté un patron, si vous continuez vous allez le supprimer.\"");
				System.out.println("Taper R pour retourner ou C pour continuer:");
				String[] listChoixPatron = {"R","C"};
				String b = validateAnswer(listChoixPatron);
				switch(b) {
				case "C":
					deletePatron();
					addPatron(dico);
					afficheMenu1();
					
				case "R":
					afficheMenu();
				}		
			}
			else {
				addPatron(dico);
				System.out.println("Patron ajouté, retour au menu principal. \n ");		
				afficheMenu1();
				break;
			}
		case "r":
			System.out.println("Retour au menu principal !");
			afficheMenu();
			break;	
		}				
	}
	
	
	public static void addPatron(Dictionary<EPersonne, String> dico) {
		initDicoPersonne(dico, "p");
		initToutesPersonne(dico);
		Personne p3 = new Patron(dico);
		Patron = true;
		listPersonne.add(p3);
		System.out.println("Patron ajouté. \n");
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
			dico.put(EPersonne.clientOuPas,"Etes vous client (oui/non): ");
			break;
		case "p":
			dico.put(EPersonne.salaire,"Saisie du salaire au format: XXXX,XX");
			dico.put(EPersonne.nSecu,"Saisie du numéro de sécurité social : ");
			dico.put(EPersonne.clientOuPas,"Etes vous client (oui/non): ");
			break;		
		case "c":
			dico.put(EPersonne.nClient,"Saisie du numéro Client (attention un numéro par client) : ");
			break;
		case "f":
			dico.put(EPersonne.nFour,"Saisie du numéro Fournisseur (attention un numéro par fournisseur) : ");
			dico.put(EPersonne.clientOuPas,"Etes vous client (oui/non): ");
			break;		
		}
	}

	public static void initToutesPersonne(Dictionary<EPersonne, String> dico) {
			
		String element;	
		boolean erreursaisie;
		boolean nClientOuiNon = false;
		for (Enumeration<EPersonne> k = dico.keys(); k.hasMoreElements();)  {
			EPersonne ep = k.nextElement();
			System.out.println(dico.get(ep));
			if(ep == EPersonne.codepostal) {
				erreursaisie = true;
				while(erreursaisie) {
           	 		try {
	            		 String codepostal = sc.nextLine();
	            		 Personne.checkCodePostal(codepostal);
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
	            		 Salarie.checknSecu(nSecu);
	            		 dico.put(ep,nSecu);
	            		 erreursaisie = false;
	           	 	}
           	 		catch(Exception e) {
           	 			System.err.println(e.getMessage());
           	 			System.out.println(dico.get(ep));
           	 		}
	           	 	}
				}
			else if(ep == EPersonne.clientOuPas) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String clientOuPas = sc.nextLine();
	            		 Personne.checkClientOuPas(clientOuPas);
	            		 dico.put(ep,clientOuPas);
	            		 if (clientOuPas.equals("oui")) {
	            			 nClientOuiNon = true;
	            		 }
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
	            		 Salarie.checkSalaire(salaire);
	            		 dico.put(ep,salaire);
	            		 erreursaisie = false;
	           	 	}
          	 		catch(Exception e) {
          	 			System.err.println(e.getMessage());
          	 			System.out.println(dico.get(ep));
          	 		}
	           	 	}
				}	
			
			else if(ep == EPersonne.nClient) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String nClient = sc.nextLine();
	            		 List<String> listClient = listNClient();
	            		 Client.testNClient(nClient,listClient);
	            		 dico.put(ep,nClient);
	            		 erreursaisie = false;
	           	 	}
         	 		catch(Exception e) {
         	 			System.err.println(e.getMessage());
         	 			System.out.println(dico.get(ep));
         	 		}
	           	 	}
				}
					
			else if(ep == EPersonne.nFour) {
	           	 erreursaisie = true;
	           	 while(erreursaisie) {
	           	 	try {
	            		 String nFour = sc.nextLine();
	            		 List<String> listFournisseur = listNFournisseur();
	            		 Fournisseur.testNFournisseur(nFour,listFournisseur);
	            		 dico.put(ep,nFour);
	            		 erreursaisie = false;
	           	 	}
        	 		catch(Exception e) {
        	 			System.err.println(e.getMessage());
        	 			System.out.println(dico.get(ep));
        	 		}
	           	 	}
				}

			else {
				element = sc.nextLine();
	   	 		dico.put(ep,element);	
			}
		}
		if (nClientOuiNon) {
			dico.put(EPersonne.nClient,"Saisie du numéro Client (attention un numéro par client) : ");
			erreursaisie = true;
			System.out.println(dico.get(EPersonne.nClient));
          	 while(erreursaisie) {
          	 	try {
           		 String nClient = sc.nextLine();
           		 List<String> listClient = listNClient();
           		 Client.testNClient(nClient,listClient);
           		 dico.put(EPersonne.nClient,nClient);
           		 erreursaisie = false;
          	 	}
    	 		catch(Exception e) {
    	 			System.err.println(e.getMessage());
    	 			System.out.println(dico.get(EPersonne.nClient));
    	 		}
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
			System.out.println("Attention votre réponse est non valable. Taper parmis les choix suivant: "); 
			for(String e:listRep) { // faire pour de 0 à l'avant dernier et gérer le dernier dans un cas apart
				if (e.equals("")) {
					System.out.print("Entrer ");
				}
				System.out.print(e+" ");
			}
			element = sc.nextLine();
		}
		return element;
	}

	public static void gereclient(IClient client) {
		client.achete(null);
		client.paie();
	}




	public static List<String> listNFournisseur() {
		List<String> listNFournisseur = new ArrayList<String>() ;
		for (Personne p:listPersonne) {
			if (p.getClass().getSimpleName().equals("Fournisseur")) {
				Fournisseur f = (Fournisseur) p;
				listNFournisseur.add(f.getnFournisseur());
			}
		}
		return listNFournisseur;
	}
	
	/**
	public static List<String> listNClient() {
		List<String> listNClient = new ArrayList<String>() ;
		for (Personne p:listPersonne) {
			if (p.getClass().getSimpleName().equals("Client")) {
				Client f = (Client) p;
				listNClient.add(f.getnClient());
			}
		}
		return listNClient;
	}**/
	public static List<String> listNClient(){
		List<String> listClients  = new ArrayList<String>();
		for(Personne p:listPersonne) {
			if (p instanceof IClient) {
				IClient f = (IClient) p;
				if (f.clientOuPas()) {
					listClients.add(f.afficheNClient());	
				}
			}
		}
		return listClients;
		}		
	
	public static void deletePatron() {
		for (Personne p:listPersonne) {
			if (p instanceof Patron) {
				listPersonne.remove(p);
				return;
			}
		}
	}

	
	
	
	
	


	



	
	
	
}
