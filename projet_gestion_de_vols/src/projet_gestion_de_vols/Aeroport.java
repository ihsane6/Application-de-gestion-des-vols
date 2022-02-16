package projet_gestion_de_vols;

import java.io.Serializable;

public class Aeroport implements Serializable{
	private int AeroportId;
	private String nom ;
    private Ville ville ;
    private boolean status;
    private static int nbr_Aeroport =0;

    // Constructeur
    public Aeroport(String nom ,Ville ville){
        this.nom =  nom ;
        this.AeroportId = ++nbr_Aeroport;
        this.ville = ville ;
        this.status = true;
        ville.addAeroport(this);
    }
    public Aeroport(int id,String nom ,Ville ville, boolean status){
        this.nom =  nom ;
        this.AeroportId = id;
        this.ville = ville ;
        this.status = status;
        if(status=true) {
        	 ville.addAeroport(this);
        }
       
        if(id>nbr_Aeroport) {
			nbr_Aeroport=id;
		}
    }

    //getters des attributs
    public String get_nom (){
        return nom ;
    }
    public int get_AeroportId (){
        return AeroportId ;
    }
    public Ville getVille(){
        return ville ;
    }public static void setNbr_Aeroport(int nbr_Aeroport) {
		Aeroport.nbr_Aeroport = nbr_Aeroport;
	}
    public void modify(String nom ,Ville ville){
        this.nom =  nom ;
        this.ville = ville ;
        
    }
    public void delete() {
    	this.status = false;
    }

	public boolean isStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public void setStatus(boolean b) {
		status = b;
		
	}@Override
	public String toString() {
		String s = this.nom;
		return s;
	}
	public String toString1() {
		String s = this.AeroportId + "-" + this.nom + "-" + this.ville.getName()+"-"+this.status;
		return s;
	}

}
