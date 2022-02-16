package projet_gestion_de_vols;

import java.io.Serializable;

public class Client implements Serializable {
	private int clientId;
	private String nom;
	private String prenom;
	private boolean status;
	private int reservation=0;
	private static int nbr_clients=0;
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.status = true;
		this.clientId = ++nbr_clients;
	}
	public Client(int id,String nom, String prenom,boolean status,int reservation) {
		this.nom = nom;
		this.clientId = id;
		this.prenom = prenom;
		this.status = status;
		this.reservation = reservation;
		
		if(id>nbr_clients) {
			nbr_clients=id;
		}
	}
	
	
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getClientId() {
		return clientId;
	}public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void delete() {
		this.status = false;
	}public static int getNbr_clients() {
		return nbr_clients;
	}
	public int getReservation() {
		return reservation;
	}
	public void setReservation(int reservation) {
		this.reservation = reservation;
	}
	public void modify(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		String s= this.clientId + "-" + this.nom + "-" + this.prenom+"-"+this.status+"-"+this.reservation;
		return s;
	}
}
