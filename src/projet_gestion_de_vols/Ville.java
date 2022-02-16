package projet_gestion_de_vols;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Ville implements Serializable {
	private int villeId;
	private String name;
	private LinkedList<Aeroport> aeroports = new LinkedList<Aeroport>();
	private static int nbr_ville =0;
	public Ville(String name) {
		this.name = name;
		this.villeId = ++this.nbr_ville; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static int getNbr_ville() {
		return nbr_ville;
	}
	public int getVilleId() {
		return villeId;
	}
	public void addAeroport(Aeroport aeroport) {
		this.aeroports.add(aeroport);
	}
	@Override
	public String toString() {
		String s = name;
		return s;
	}public LinkedList<Aeroport> getAeroports() {
		return aeroports;
	}
	
}
