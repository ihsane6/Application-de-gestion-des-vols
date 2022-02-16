package projet_gestion_de_vols;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.Font;

public class application {

	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTable tabClients;
	private JButton btnAjouterClient;
	private JButton btnSupprimerClient;
	private JButton btnModifierClient;
	private JButton btnEnregistrer; 
	JButton btnEnregistrerAero;
	JButton btnAjouterAero;
	JButton btnSupprimerAero;
	JButton btnModifierAero;
	LinkedList<Client> clients;
	LinkedList<Ville> villes;
	LinkedList<Aeroport> aeroports;
	LinkedList<Avion> avions;
	LinkedList<Vol> vols;
	DefaultTableModel modelClients;
	DefaultTableModel modelAeroports;
	DefaultTableModel modelAvion;
	DefaultTableModel modelAvionVol;
	DefaultTableModel modelVols;
	DefaultTableModel modelVolRes;
	DefaultTableModel modelClientRes;
	DefaultTableModel modelClientReservant;
	private JPanel panelAeroports;
	JTabbedPane tabbedPane;
	JComboBox CBVilles;
	JTextPane txtpPlaces;
	JTextPane txtpAeroDepart;
	JTextPane txtpAeroArrivee;
	private JTextField txtAero;
	private JTable tabAeroports;
	private JPanel panelAvions;
	private JTextField txtAvion;
	private JScrollPane scrollPane_2;
	private JTable tabAvions;
	private JLabel lblModle;
	private JLabel lblCapacit;
	private JTextField txtCapacite;
	private JButton btnAjouterAvion;
	private JButton btnSupprimerAvion;
	private JButton btnModifierAvion;
	private JButton btnEnregistrerAvion;
	private JPanel panelVols;
	private JTextField txtDateDepart;
	private JTextField txtDateArrivee;
	private JLabel lblNewLabel;
	private JLabel lblDateArrive;
	private JLabel lblLaDateDoit;
	private JComboBox CBVilleDepart;
	private JComboBox CBAeroportDepart;
	private JLabel lblVilleDepart;
	private JLabel lblAeroportDpart;
	private JLabel lblVilleArrive;
	private JLabel lblAeroportArrive;
	private JComboBox CBVilleArrivee;
	private JComboBox CBAeroportArrivee;
	private JScrollPane scrollPane_3;
	private JTable tabAvions1;
	private JLabel lblAvion;
	private JTextField txtAvion1;
	private JTextField txtCapacite1;
	private JScrollPane scrollPane_4;
	private JTable tabVols;
	private JButton btnAjouterVol;
	private JButton btnSupprimerVol;
	private JButton btnModifierVol;
	private JButton btnEnregistrerVol;
	private JLabel lblPrix;
	private JTextField txtPrix;
	private JLabel lblCapacit_1;
	private JPanel panelReservation;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;
	private JTable tabClientRes;
	private JTable tabVolRes;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JButton btnReserver;
	private JButton btnEnregistrer_1;
	private JTable tabClientReservant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public application() throws IOException {
		initialize();
		clients = new LinkedList();
		villes = new LinkedList();
		aeroports = new LinkedList();
		avions = new LinkedList();
		vols = new LinkedList();
		modelClients = (DefaultTableModel) tabClients.getModel();
		modelAeroports = (DefaultTableModel) tabAeroports.getModel();
		modelAvion = (DefaultTableModel) tabAvions.getModel();
		modelAvionVol = (DefaultTableModel) tabAvions1.getModel();
		modelVols = (DefaultTableModel) tabVols.getModel();
		modelVolRes = (DefaultTableModel) tabVolRes.getModel();
		modelClientRes = (DefaultTableModel) tabClientRes.getModel();
		modelClientReservant = (DefaultTableModel) tabClientReservant.getModel();
		btnModifierClient.setVisible(false);
		btnSupprimerClient.setVisible(false);
		remplirLesTable();
		btnModifierAero.setVisible(false);
		btnSupprimerAero.setVisible(false);
		btnModifierAvion.setVisible(false);
		btnSupprimerAvion.setVisible(false);
		btnModifierVol.setVisible(false);
		btnSupprimerVol.setVisible(false);
		tabbedPane.setVisible(false);
		

		
	}
	private void save() {
		File fichierclients = new File("clients.txt");
		File fichiervilles = new File("Villes.txt");
		File fichieraeroports = new File("Aeroports.txt");
		File fichieravions = new File("Avions.txt");
		File fichiervols = new File("Vols.txt");
		FileWriter fwc = null;
		FileWriter fwv = null;
		FileWriter fwa = null;
		FileWriter fwav = null;
		FileWriter fwVols = null;
		try {
			fwc = new FileWriter(fichierclients);
			fwv = new FileWriter(fichiervilles);
			fwa = new FileWriter(fichieraeroports);
			fwav = new FileWriter(fichieravions);
			fwVols = new FileWriter(fichiervols);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pwv = new PrintWriter(fwv);
		PrintWriter pwc = new PrintWriter(fwc);
		PrintWriter pwa = new PrintWriter(fwa);
		PrintWriter pwav = new PrintWriter(fwav);
		PrintWriter pwVols = new PrintWriter(fwVols);
		for(Client client : clients) {
			pwc.println(client);
		}
		for(Ville ville: villes) {
			pwv.println(ville);
		}
		for(Aeroport aero : aeroports) {
			pwa.println(aero.toString1());
		}
		for(Avion avion: avions) {
			pwav.println(avion);
		}
		for(Vol vol: vols) {
			pwVols.println(vol);
		}
		pwc.close();
		pwv.close();
		pwa.close();
		pwav.close();
		pwVols.close();
	}
	private void remplirLesTable() throws IOException {
		Path pathc = Paths.get("clients.txt");
		Path pathv = Paths.get("Villes.txt");
		Path patha = Paths.get("Aeroports.txt");
		Path pathav = Paths.get("Avions.txt");
		Path pathVols = Paths.get("Vols.txt");
		if(Files.exists(pathc)) {
			File fichier = new File("clients.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String s = br.readLine();
			while (s != null) {
			      file.add(s);
			      s = br.readLine();
			   }
			for(int i =0;i<file.size();i++) {
				String[] clientS = file.get(i).split("-");
				Client client = new Client(Integer.parseInt(clientS[0]),clientS[1],clientS[2],Boolean.parseBoolean(clientS[3]),Integer.parseInt(clientS[4]));
				clients.add(client);
				if(clientS[3].equals("true")) {
					modelClients.addRow(new String[] {Integer.toString(client.getClientId()),client.getNom(),client.getPrenom()});
					modelClientRes.addRow(new String[] {Integer.toString(client.getClientId()),client.getNom(),client.getPrenom()});
					
				}
				
			}
		}
		if(Files.exists(pathv)) {
			File fichier = new File("Villes.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String villeName = br.readLine();
			
			while (villeName != null) {
			      file.add(villeName);
			      villeName = br.readLine();
			      
			   }
			
			for(int i =0;i<file.size();i++) {
				
				Ville ville = new Ville(file.get(i));
				villes.add(ville);
				CBVilles.addItem(ville);
				CBVilleDepart.addItem(ville);
				CBVilleArrivee.addItem(ville);
					
			}
			
		}
		if(Files.exists(patha)) {
			File fichier = new File("Aeroports.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String s = br.readLine();
			while (s != null) {
			      file.add(s);
			      s = br.readLine();
			   }
			
			for(int i =0;i<file.size();i++) {
				String[] aeroS = file.get(i).split("-");
				int index = 0;
				for(int j = 0;j<villes.size();j++) {
					if(villes.get(j).toString().equals(aeroS[2])) {
						index = j;
					}
				}
				Aeroport aero = new Aeroport(Integer.parseInt(aeroS[0]),aeroS[1],villes.get(index),Boolean.parseBoolean(aeroS[3]));
				aeroports.add(aero);
				
				if(aeroS[3].equals("true")) {
					modelAeroports.addRow(new String[] {Integer.toString(aero.get_AeroportId()),aero.get_nom(),aero.getVille().getName()});
				}
				
				
			}
			if( CBVilleDepart.getSelectedItem()!=null){
				Ville ville = (Ville) CBVilleDepart.getSelectedItem();
				for(Aeroport aeros : ville.getAeroports()) {
					CBAeroportDepart.addItem(aeros);
					
				}
			}
			
			if( CBVilleArrivee.getSelectedItem()!=null){
				CBAeroportArrivee.removeAllItems();
				Ville villearrivee = (Ville) CBVilleArrivee.getSelectedItem();
				for(Aeroport aero : villearrivee.getAeroports()) {
					CBAeroportArrivee.addItem(aero);
					
				}
			}
			
			
		}
		if(Files.exists(pathav)) {
			File fichier = new File("Avions.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String s = br.readLine();
			while (s != null) {
			      file.add(s);
			      s = br.readLine();
			   }
		
			for(int i =0;i<file.size();i++) {
				String[] avionS = file.get(i).split("-");
				Avion avion = new Avion(Integer.parseInt(avionS[0]),avionS[1],Integer.parseInt(avionS[2]),Boolean.parseBoolean(avionS[3]));
				avions.add(avion);
				if(avionS[3].equals("true")) {
					modelAvion.addRow(new String[] {Integer.toString(avion.getAvionId()),avion.getModele(),avionS[2]});
					modelAvionVol.addRow(new String[] {Integer.toString(avion.getAvionId()),avion.getModele(),avionS[2]});
					
				}
				
			}
			
		}
		if(Files.exists(pathVols)) {
			File fichier = new File("Vols.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String s = br.readLine();
			while (s != null) {
			      file.add(s);
			      s = br.readLine();
			   }
		
			for(int i =0;i<file.size();i++) {
				String[] volS = file.get(i).split("-");
				int indexDepart=0;
				int indexArrivee=0;
				int indexAvion =0;
				for(int j =0;j<aeroports.size();j++) {
					if(aeroports.get(j).get_AeroportId()==Integer.parseInt(volS[1])) {
						indexDepart=j;
					}
				}
				for(int j =0;j<aeroports.size();j++) {
					if(aeroports.get(j).get_AeroportId()==Integer.parseInt(volS[3])) {
						indexArrivee=j;
					}
				}
				for(int j =0;j<avions.size();j++) {
					if(avions.get(j).getAvionId()==Integer.parseInt(volS[5])) {
						indexAvion=j;
					}
				}
				Vol vol = new Vol(Integer.parseInt(volS[0]),aeroports.get(indexDepart),aeroports.get(indexArrivee),volS[2],volS[4],avions.get(indexAvion),Integer.parseInt(volS[6]));
				vols.add(vol);
				
				modelVols.addRow(new String[] {Integer.toString(vol.getVolId()),vol.getVilleDepart().getName(),volS[2],vol.getVilleArrivee().getName(),volS[4],volS[6]});
				modelVolRes.addRow(new String[] {Integer.toString(vol.getVolId()),vol.getVilleDepart().getName(),volS[2],vol.getVilleArrivee().getName(),volS[4],volS[6]});
				for(Client client: clients) {
					if(client.getReservation()==vol.getVolId()) {
						vol.reserver(client);
					}
				}
				
				
			}
			
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		frame.setBounds(100, 100, 686, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelWelcome = new JPanel();
		panelWelcome.setBounds(0, 0, 670, 484);
		frame.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pc\\OneDrive\\Bureau\\Projet gestion\\projet_gestion_de_vols\\news_photo_avion.PNG"));
		lblNewLabel_3.setBounds(10, 22, 287, 451);
		panelWelcome.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gestion des vols");
		lblNewLabel_4.setFont(new Font("Castellar", Font.PLAIN, 33));
		lblNewLabel_4.setBounds(307, 51, 353, 117);
		panelWelcome.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Commencer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelWelcome.setVisible(false);
				tabbedPane.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(501, 398, 141, 55);
		panelWelcome.add(btnNewButton);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setBounds(10, 11, 650, 462);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panelClients = new JPanel();
		panelClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNom.setText(null);
				txtPrenom.setText(null);
				tabClients.getSelectionModel().clearSelection();
				btnAjouterClient.setVisible(true);
				btnModifierClient.setVisible(false);
				btnSupprimerClient.setVisible(false);
				btnEnregistrer.setVisible(true);
			}
		});
		tabbedPane.addTab("clients", null, panelClients, null);
		panelClients.setLayout(null);
		
		JLabel lblNom = new JLabel("nom :");
		lblNom.setBounds(38, 73, 50, 14);
		panelClients.add(lblNom);
		lblNom.setVerticalAlignment(SwingConstants.BOTTOM);
		
		txtNom = new JTextField();
		txtNom.setBounds(177, 70, 86, 20);
		panelClients.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("prenom :");
		lblPrenom.setBounds(40, 116, 64, 14);
		panelClients.add(lblPrenom);
		lblPrenom.setVerticalAlignment(SwingConstants.BOTTOM);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(177, 113, 86, 20);
		panelClients.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		btnAjouterClient = new JButton("ajouter");
		btnAjouterClient.setBounds(38, 243, 113, 23);
		panelClients.add(btnAjouterClient);
		
		btnModifierClient = new JButton("modifier");
		btnModifierClient.setBounds(177, 302, 117, 23);
		panelClients.add(btnModifierClient);
		
		btnSupprimerClient = new JButton("supprimer");
		btnSupprimerClient.setBounds(38, 302, 113, 23);
		panelClients.add(btnSupprimerClient);
		
		btnEnregistrer = new JButton("enregistrer");
		btnEnregistrer.setBounds(522, 400, 113, 23);
		panelClients.add(btnEnregistrer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 36, 328, 313);
		panelClients.add(scrollPane);
		
		tabClients = new JTable();
		tabClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabClients.getSelectedRow();
				txtNom.setText((String) modelClients.getValueAt(index, 1));
				txtPrenom.setText((String) modelClients.getValueAt(index, 2));
				btnAjouterClient.setVisible(false);
				btnModifierClient.setVisible(true);
				btnSupprimerClient.setVisible(true);
				btnEnregistrer.setVisible(false);
				
				
				
			}
		});
		tabClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "prenom", "nom"
			}
		));
		scrollPane.setViewportView(tabClients);
		
		panelAeroports = new JPanel();
		panelAeroports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAero.setText(null);
				CBVilles.setSelectedItem(null);
				tabAeroports.getSelectionModel().clearSelection();
				btnAjouterAero.setVisible(true);
				btnModifierAero.setVisible(false);
				btnSupprimerAero.setVisible(false);
				btnEnregistrerAero.setVisible(true);
				
				
			}
		});
		tabbedPane.addTab("aeroports", null, panelAeroports, null);
		panelAeroports.setLayout(null);
		
		JLabel lblNom_1 = new JLabel("nom :");
		lblNom_1.setBounds(31, 68, 52, 14);
		lblNom_1.setVerticalAlignment(SwingConstants.BOTTOM);
		panelAeroports.add(lblNom_1);
		
		txtAero = new JTextField();
		txtAero.setBounds(131, 65, 86, 20);
		txtAero.setColumns(10);
		panelAeroports.add(txtAero);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(307, 53, 328, 313);
		panelAeroports.add(scrollPane_1);
		
		tabAeroports = new JTable();
		tabAeroports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabAeroports.getSelectedRow();
				txtAero.setText((String) modelAeroports.getValueAt(index, 1));
				CBVilles.setSelectedItem(aeroports.get(index).getVille());
				btnAjouterAero.setVisible(false);
				btnModifierAero.setVisible(true);
				btnSupprimerAero.setVisible(true);
				btnEnregistrerAero.setVisible(false);
				
				
				
				
				
				
			}
		});
		tabAeroports.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nom", "ville"
			}
		));
		scrollPane_1.setViewportView(tabAeroports);
		
		JLabel lblNom_1_1 = new JLabel("ville :");
		lblNom_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNom_1_1.setBounds(31, 120, 52, 14);
		panelAeroports.add(lblNom_1_1);
		
		btnAjouterAero = new JButton("Ajouter");
		btnAjouterAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom = txtAero.getText();
				Ville ville = (Ville) CBVilles.getSelectedItem();
				if(!(nom==null|| nom.equals(""))) {
					int c=0;
					int index =0;
					for(Aeroport aero: aeroports ) {
						if(aero.get_nom().equalsIgnoreCase(nom)&&aero.getVille().getName().equalsIgnoreCase(ville.getName())) {
							c=1;
							index = aeroports.indexOf(aero);
						}
					}
					if(c==0) {
						Aeroport aero = new Aeroport(nom,ville);
						aeroports.add(aero);
						modelAeroports.addRow(new String[] {Integer.toString(aero.get_AeroportId()),nom,ville.getName()});
						txtAero.setText(null);
						CBVilles.setSelectedItem(null);
						Ville villearrivee = (Ville) CBVilleArrivee.getSelectedItem();
						for(Aeroport aeros : villearrivee.getAeroports()) {
							CBAeroportArrivee.addItem(aeros);
							
						}
						Ville villedepart = (Ville) CBVilleDepart.getSelectedItem();
						for(Aeroport aeros : villedepart.getAeroports()) {
							CBAeroportDepart.addItem(aeros);
							
						}
					}
					else if(!(aeroports.get(index).isStatus())) {
						Aeroport aero= aeroports.get(index);
						aero.setStatus(true);
						modelAeroports.addRow(new String[] {Integer.toString(aero.get_AeroportId()),nom,aero.getVille().getName()});
						txtAero.setText(null);
						CBVilles.setSelectedItem(null);
					}
					
				}
			}
		});
		btnAjouterAero.setBounds(31, 235, 89, 23);
		panelAeroports.add(btnAjouterAero);
		
		JButton btnAjouterVille = new JButton("Ajouter Ville");
		btnAjouterVille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom = JOptionPane.showInputDialog( this,"Ajouter une ville");
				Ville ville = new Ville(nom);
				villes.add(ville);
				CBVilles.addItem(ville);
				CBVilleDepart.addItem(ville);
				CBVilleArrivee.addItem(ville);
				
			}
			
		});
		btnAjouterVille.setBounds(31, 185, 137, 23);
		panelAeroports.add(btnAjouterVille);
		
		btnSupprimerAero = new JButton("Supprimer");
		btnSupprimerAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabAeroports.getSelectedRow();
				if(indice!=-1) {
					 aeroports.get(indice).setStatus(false);
					 aeroports.get(indice).getVille().getAeroports().remove(aeroports.get(indice));
					 CBAeroportArrivee.removeItem(aeroports.get(indice));
					 CBAeroportDepart.removeItem(aeroports.get(indice));
					 modelAeroports.removeRow(indice);
					 txtAero.setText(null);
					 CBVilles.setSelectedItem(null);
					 btnAjouterAero.setVisible(true);
					 btnModifierAero.setVisible(false);
					 btnSupprimerAero.setVisible(false);
					 btnEnregistrerAero.setVisible(true);
				}
				
			}
		});
		
		btnSupprimerAero.setBounds(31, 288, 89, 23);
		panelAeroports.add(btnSupprimerAero);
		
		btnModifierAero = new JButton("Modifier");
		btnModifierAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabAeroports.getSelectedRow();
				String nom = txtAero.getText();
				Ville ville = (Ville) CBVilles.getSelectedItem();
				
				if(!(nom==null|| nom.equals("")||CBVilles.getSelectedItem()==null)) {
					int c=0;
					for(Aeroport aero: aeroports) {
						if(aero.get_nom().equalsIgnoreCase(nom)&&aero.getVille().getName().equalsIgnoreCase(ville.getName())) {
							c=1;
						}
					}
					if(c==0) {
						aeroports.get(indice).modify(nom, ville);
						modelAeroports.setValueAt(nom, indice, 1);
						modelAeroports.setValueAt(ville.toString(), indice, 2);
						txtAero.setText(null);
						CBVilles.setSelectedItem(null);
						btnAjouterAero.setVisible(true);
						btnModifierAero.setVisible(false);
						btnSupprimerAero.setVisible(false);
						btnEnregistrerAero.setVisible(true);
						tabAeroports.getSelectionModel().clearSelection();
						Ville villearrivee = (Ville) CBVilleArrivee.getSelectedItem();
						for(Aeroport aeros : villearrivee.getAeroports()) {
							CBAeroportArrivee.addItem(aeros);
							
						}
						Ville villedepart = (Ville) CBVilleDepart.getSelectedItem();
						for(Aeroport aeros : villedepart.getAeroports()) {
							CBAeroportDepart.addItem(aeros);
							
						}
					}
					
				}
			}
		});
		btnModifierAero.setBounds(148, 288, 89, 23);
		panelAeroports.add(btnModifierAero);
		
		btnEnregistrerAero = new JButton("Enregistrer");
		btnEnregistrerAero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnEnregistrerAero.setBounds(523, 400, 112, 23);
		panelAeroports.add(btnEnregistrerAero);
		
		CBVilles = new JComboBox();
		CBVilles.setBounds(116, 116, 137, 22);
		
		panelAeroports.add(CBVilles);
		
		panelAvions = new JPanel();
		panelAvions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAvion.setText(null);
				txtCapacite.setText(null);
				tabAvions.getSelectionModel().clearSelection();
				btnAjouterAvion.setVisible(true);
				btnModifierAvion.setVisible(false);
				btnSupprimerAvion.setVisible(false);
				btnEnregistrerAvion.setVisible(true);

			}
		});
		tabbedPane.addTab("Avions", null, panelAvions, null);
		panelAvions.setLayout(null);
		
		txtAvion = new JTextField();
		txtAvion.setColumns(10);
		txtAvion.setBounds(151, 59, 86, 20);
		panelAvions.add(txtAvion);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(307, 42, 328, 313);
		panelAvions.add(scrollPane_2);
		
		tabAvions = new JTable();
		tabAvions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabAvions.getSelectedRow();
				txtAvion.setText((String) modelAvion.getValueAt(index, 1));
				txtCapacite.setText((String) modelAvion.getValueAt(index, 2));
				btnAjouterAvion.setVisible(false);
				btnModifierAvion.setVisible(true);
				btnSupprimerAvion.setVisible(true);
				btnEnregistrerAvion.setVisible(false);
			}
		});
		tabAvions.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "modele", "capacite"
			}
		));
		scrollPane_2.setViewportView(tabAvions);
		
		lblModle = new JLabel("Mod\u00E8le :");
		lblModle.setVerticalAlignment(SwingConstants.BOTTOM);
		lblModle.setBounds(31, 62, 59, 14);
		panelAvions.add(lblModle);
		
		lblCapacit = new JLabel("Capacit\u00E9 :");
		lblCapacit.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCapacit.setBounds(31, 115, 65, 14);
		panelAvions.add(lblCapacit);
		
		txtCapacite = new JTextField();
		txtCapacite.setColumns(10);
		txtCapacite.setBounds(151, 112, 86, 20);
		panelAvions.add(txtCapacite);
		
		btnAjouterAvion = new JButton("Ajouter");
		btnAjouterAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String modele = txtAvion.getText();
				int capacite = Integer.parseInt(txtCapacite.getText());
				if(!(modele==null|| modele.equals("")|| txtCapacite.getText().equals(""))) {
					
					
					
						Avion avion = new Avion(modele,capacite);
						avions.add(avion);
						modelAvion.addRow(new String[] {Integer.toString(avion.getAvionId()),modele,txtCapacite.getText()});
						modelAvionVol.addRow(new String[] {Integer.toString(avion.getAvionId()),modele,txtCapacite.getText()});
						txtAvion.setText(null);
						txtCapacite.setText(null);
					
					
					
				}
			}
		});
		btnAjouterAvion.setBounds(31, 205, 89, 23);
		panelAvions.add(btnAjouterAvion);
		
		btnSupprimerAvion = new JButton("Supprimer");
		btnSupprimerAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabAvions.getSelectedRow();
				if(indice!=-1) {
					 avions.get(indice).setStatus(false);;
					 modelAvion.removeRow(indice);
					 modelAvionVol.removeRow(indice);
					 txtAvion.setText(null);
					 txtCapacite.setText(null);
					 btnAjouterAvion.setVisible(true);
					 btnModifierAvion.setVisible(false);
					 btnSupprimerAvion.setVisible(false);
					 btnEnregistrerAvion.setVisible(true);
				}
			}
		});
		btnSupprimerAvion.setBounds(31, 261, 89, 23);
		panelAvions.add(btnSupprimerAvion);
		
		btnModifierAvion = new JButton("Modifier");
		btnModifierAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabAvions.getSelectedRow();
				String model = txtAvion.getText();
				int capacite = Integer.parseInt(txtCapacite.getText());
				
				if(!( model.equals("")|| txtCapacite.getText().equals(""))) {
					
						avions.get(indice).modify(model, capacite);
						modelAvion.setValueAt(model, indice, 1);
						modelAvion.setValueAt(txtCapacite.getText(), indice, 2);
						modelAvionVol.setValueAt(model, indice, 1);
						modelAvionVol.setValueAt(txtCapacite.getText(), indice, 2);
						txtAvion.setText(null);
						txtCapacite.setText(null);
						btnAjouterAvion.setVisible(true);
						btnModifierAvion.setVisible(false);
						btnSupprimerAvion.setVisible(false);
						btnEnregistrerAvion.setVisible(true);
						tabAvions.getSelectionModel().clearSelection();
					
					
				}
				
				
			}
		});
		btnModifierAvion.setBounds(165, 261, 89, 23);
		panelAvions.add(btnModifierAvion);
		
		btnEnregistrerAvion = new JButton("Enregistrer");
		btnEnregistrerAvion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnEnregistrerAvion.setBounds(528, 400, 107, 23);
		panelAvions.add(btnEnregistrerAvion);
		
		panelVols = new JPanel();
		panelVols.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtDateDepart.setText(null);
				txtDateArrivee.setText(null);
				txtAvion1.setText(null);
				txtPrix.setText(null);
				txtCapacite1.setText(null);
				btnAjouterVol.setVisible(true);
				btnModifierVol.setVisible(false);
				btnSupprimerVol.setVisible(false);
				btnEnregistrerVol.setVisible(true);
				tabVols.getSelectionModel().clearSelection();
				tabAvions1.getSelectionModel().clearSelection();
				
			
			}
		});
		tabbedPane.addTab("Vols", null, panelVols, null);
		panelVols.setLayout(null);
		
		txtDateDepart = new JTextField();
		txtDateDepart.setBounds(150, 47, 123, 20);
		panelVols.add(txtDateDepart);
		txtDateDepart.setColumns(10);
		
		txtDateArrivee = new JTextField();
		txtDateArrivee.setColumns(10);
		txtDateArrivee.setBounds(150, 78, 123, 20);
		panelVols.add(txtDateArrivee);
		
		lblNewLabel = new JLabel("Date Depart :");
		lblNewLabel.setBounds(26, 50, 95, 14);
		panelVols.add(lblNewLabel);
		
		lblDateArrive = new JLabel("Date Arriv\u00E9e :");
		lblDateArrive.setBounds(26, 81, 95, 14);
		panelVols.add(lblDateArrive);
		
		lblLaDateDoit = new JLabel("La date doit etre selon le format (dd/mm/yy hh:mm)");
		lblLaDateDoit.setBounds(26, 11, 286, 14);
		panelVols.add(lblLaDateDoit);
		
		CBVilleDepart = new JComboBox();
		CBVilleDepart.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				CBAeroportDepart.removeAllItems();
				Ville ville = (Ville) CBVilleDepart.getSelectedItem();
				for(Aeroport aero : ville.getAeroports()) {
					CBAeroportDepart.addItem(aero);
					
				}
				
			}
		});
		
		CBVilleDepart.setBounds(26, 136, 109, 22);
		panelVols.add(CBVilleDepart);
		
		CBAeroportDepart = new JComboBox();
		CBAeroportDepart.setBounds(164, 136, 109, 22);
		panelVols.add(CBAeroportDepart);
		
		lblVilleDepart = new JLabel("Ville Depart :");
		lblVilleDepart.setBounds(26, 111, 95, 14);
		panelVols.add(lblVilleDepart);
		
		lblAeroportDpart = new JLabel("Aeroport D\u00E9part :");
		lblAeroportDpart.setBounds(164, 109, 95, 14);
		panelVols.add(lblAeroportDpart);
		
		lblVilleArrive = new JLabel("Ville Arriv\u00E9e :");
		lblVilleArrive.setBounds(26, 181, 95, 14);
		panelVols.add(lblVilleArrive);
		
		lblAeroportArrive = new JLabel("Aeroport Arriv\u00E9e :");
		lblAeroportArrive.setBounds(164, 181, 95, 14);
		panelVols.add(lblAeroportArrive);
		
		CBVilleArrivee = new JComboBox();
		CBVilleArrivee.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				CBAeroportArrivee.removeAllItems();
				Ville ville = (Ville) CBVilleArrivee.getSelectedItem();
				for(Aeroport aero : ville.getAeroports()) {
					CBAeroportArrivee.addItem(aero);
					
				}
			}
		});
		CBVilleArrivee.setBounds(26, 206, 109, 22);
		panelVols.add(CBVilleArrivee);
		
		CBAeroportArrivee = new JComboBox();
		CBAeroportArrivee.setBounds(164, 206, 109, 22);
		panelVols.add(CBAeroportArrivee);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(26, 294, 247, 129);
		panelVols.add(scrollPane_3);
		
		tabAvions1 = new JTable();
		tabAvions1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabAvions1.getSelectedRow();
				txtAvion1.setText((String) modelAvionVol.getValueAt(index, 1));
				txtCapacite1.setText((String) modelAvionVol.getValueAt(index, 2));
				
			}
		});
		tabAvions1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "modele", "capacite"
			}
		));
		scrollPane_3.setViewportView(tabAvions1);
		
		lblAvion = new JLabel("Avion :");
		lblAvion.setBounds(26, 239, 95, 14);
		panelVols.add(lblAvion);
		
		txtAvion1 = new JTextField();
		txtAvion1.setColumns(10);
		txtAvion1.setBounds(24, 261, 123, 22);
		panelVols.add(txtAvion1);
		
		txtCapacite1 = new JTextField();
		txtCapacite1.setColumns(10);
		txtCapacite1.setBounds(150, 261, 123, 22);
		panelVols.add(txtCapacite1);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(312, 11, 323, 242);
		panelVols.add(scrollPane_4);
		
		tabVols = new JTable();
		tabVols.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabVols.getSelectedRow();
				txtDateDepart.setText((String) modelVols.getValueAt(index, 2));
				txtDateArrivee.setText((String) modelVols.getValueAt(index, 4));
				CBVilleDepart.setSelectedItem(vols.get(index).getVilleDepart());
				CBVilleArrivee.setSelectedItem(vols.get(index).getVilleArrivee());
				CBAeroportDepart.setSelectedItem(vols.get(index).getAeroDepart());
				CBAeroportArrivee.setSelectedItem(vols.get(index).getAeroArrivee());
				txtAvion1.setText(vols.get(index).getAvion().getModele());
				txtPrix.setText(Integer.toString(vols.get(index).getPrix()));
				txtCapacite1.setText(Integer.toString(vols.get(index).getAvion().getCapacite()));
				for(int i = 0;i<avions.size();i++) {
					Avion a = avions.get(i);
					if(a.getAvionId()==vols.get(index).getAvion().getAvionId()) {
						tabAvions1.setRowSelectionInterval(i, i);
					}
				}
				btnAjouterVol.setVisible(false);
				btnModifierVol.setVisible(true);
				btnSupprimerVol.setVisible(true);
				btnEnregistrerVol.setVisible(false);
				
			}
		});
		tabVols.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "ville depart", "date depart", "ville arrivee", "date arrivee", "prix"
			}
		));
		scrollPane_4.setViewportView(tabVols);
		
		btnAjouterVol = new JButton("Ajouter");
		btnAjouterVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dateD = txtDateDepart.getText();
				String dateA = txtDateArrivee.getText(); 
				Ville villeD = (Ville) CBVilleDepart.getSelectedItem();
				Ville villeA = (Ville) CBVilleArrivee.getSelectedItem();
				Aeroport aeroD = (Aeroport) CBAeroportDepart.getSelectedItem();
				Aeroport aeroA = (Aeroport) CBAeroportArrivee.getSelectedItem();
				int index = tabAvions1.getSelectedRow();
				Avion avion = avions.get(index);
				String avionName = txtAvion1.getText(); 
				int prix = Integer.parseInt(txtPrix.getText()); 
				if(!( avionName.equals("")||txtCapacite1.equals("")|| dateD.equals("")|| dateA.equals("")||CBVilleArrivee.getSelectedItem()==null||CBVilleDepart.getSelectedItem()==null||CBAeroportArrivee.getSelectedItem()==null||CBAeroportDepart.getSelectedItem()==null)) {
					
						Vol vol = new Vol(aeroD,aeroA,dateD,dateA,avion,prix);
						vols.add(vol);
						modelVols.addRow(new String[] {Integer.toString(vol.getVolId()),villeD.getName(),dateD,villeA.getName(),dateA,Integer.toString(prix)});
						modelVolRes.addRow(new String[] {Integer.toString(vol.getVolId()),villeD.getName(),dateD,villeA.getName(),dateA,Integer.toString(prix)});
						txtDateDepart.setText(null);
						txtDateArrivee.setText(null);
						txtCapacite1.setText(null);
						txtAvion1.setText(null);
						txtPrix.setText(null);
						tabAvions1.getSelectionModel().clearSelection();
						
					}
					
					
				
				
				
			}
		});
		btnAjouterVol.setBounds(497, 291, 123, 23);
		panelVols.add(btnAjouterVol);
		
		btnSupprimerVol = new JButton("Supprimer");
		btnSupprimerVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabVols.getSelectedRow();
				if(indice!=-1) {
					 vols.remove(indice);
					 modelVols.removeRow(indice);
					 modelVolRes.removeRow(indice);
					 txtDateDepart.setText(null);
					 txtDateDepart.setText(null);
					 txtAvion1.setText(null);
					 txtPrix.setText(null);
					 txtCapacite1.setText(null);
					 btnAjouterVol.setVisible(true);
					 btnModifierVol.setVisible(false);
					 btnSupprimerVol.setVisible(false);
					 btnEnregistrerVol.setVisible(true);
					 tabVols.getSelectionModel().clearSelection();
					 tabAvions1.getSelectionModel().clearSelection();
					 
				}
				
			}
		});
		btnSupprimerVol.setBounds(497, 321, 123, 23);
		panelVols.add(btnSupprimerVol);
		
		btnModifierVol = new JButton("Modifier");
		btnModifierVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = tabVols.getSelectedRow();
				String dateD = txtDateDepart.getText();
				String dateA = txtDateArrivee.getText(); 
				Ville villeD = (Ville) CBVilleDepart.getSelectedItem();
				Ville villeA = (Ville) CBVilleArrivee.getSelectedItem();
				Aeroport aeroD = (Aeroport) CBAeroportDepart.getSelectedItem();
				Aeroport aeroA = (Aeroport) CBAeroportDepart.getSelectedItem();
				int indexAvion = tabAvions1.getSelectedRow();
				Avion avion = avions.get(indexAvion);
				String avionName = txtAvion1.getText(); 
				int prix = Integer.parseInt(txtPrix.getText()); 
				if(!( avionName.equals("")||txtCapacite1.equals("")|| dateD.equals("")|| dateA.equals("")||CBVilleArrivee.getSelectedItem()==null||CBVilleDepart.getSelectedItem()==null||CBAeroportArrivee.getSelectedItem()==null||CBAeroportDepart.getSelectedItem()==null)) {
					
						vols.get(index).modify(aeroD,aeroA,dateD,dateA,avion,prix);
						modelVols.setValueAt(dateD, index, 2);
						modelVols.setValueAt(dateA, index, 4);
						modelVols.setValueAt(prix, index, 5);
						modelVols.setValueAt(villeD.toString(), index, 1);
						modelVols.setValueAt(villeA.toString(), index, 3);
						modelVolRes.setValueAt(dateD, index, 2);
						modelVolRes.setValueAt(dateA, index, 4);
						modelVolRes.setValueAt(prix, index, 5);
						modelVolRes.setValueAt(villeD.toString(), index, 1);
						modelVolRes.setValueAt(villeA.toString(), index, 3);
						txtDateDepart.setText(null);
						txtDateArrivee.setText(null);
						txtCapacite1.setText(null);
						txtAvion1.setText(null);
						txtPrix.setText(null);
						btnAjouterVol.setVisible(true);
						btnModifierVol.setVisible(false);
						btnSupprimerVol.setVisible(false);
						btnEnregistrerVol.setVisible(true);
						tabVols.getSelectionModel().clearSelection();
						tabAvions1.getSelectionModel().clearSelection();
						
					}
				
				
				
				
				
				
				
			}
		});
		btnModifierVol.setBounds(497, 355, 123, 23);
		panelVols.add(btnModifierVol);
		
		btnEnregistrerVol = new JButton("Enregistrer");
		btnEnregistrerVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnEnregistrerVol.setBounds(497, 389, 123, 23);
		panelVols.add(btnEnregistrerVol);
		
		lblPrix = new JLabel("Prix :");
		lblPrix.setBounds(312, 359, 95, 14);
		panelVols.add(lblPrix);
		
		txtPrix = new JTextField();
		txtPrix.setColumns(10);
		txtPrix.setBounds(312, 390, 123, 20);
		panelVols.add(txtPrix);
		
		lblCapacit_1 = new JLabel("Capacit\u00E9 :");
		lblCapacit_1.setBounds(151, 239, 95, 14);
		panelVols.add(lblCapacit_1);
		
		panelReservation = new JPanel();
		panelReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index  = tabVolRes.getSelectedRow();
				txtpAeroDepart.setText(null);
				txtpAeroArrivee.setText(null);
				txtpPlaces.setText(null);
				tabVolRes.getSelectionModel().clearSelection();
				tabClientRes.getSelectionModel().clearSelection();
				tabClientReservant.getSelectionModel().clearSelection();
				modelClientReservant.setRowCount(0);
				
				
				
				
				
				
			}
		});
		tabbedPane.addTab("Reservation", null, panelReservation, null);
		panelReservation.setLayout(null);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(228, 42, 407, 281);
		panelReservation.add(scrollPane_5);
		
		tabVolRes = new JTable();
		tabVolRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabVolRes.getSelectedRow();
				txtpPlaces.setText(Integer.toString(vols.get(index).getSiegeDispo()));
				txtpAeroDepart.setText(vols.get(index).getAeroDepart().get_nom());
				txtpAeroArrivee.setText(vols.get(index).getAeroArrivee().get_nom());
				for(Client client : vols.get(index).getPassagers()) {
					modelClientReservant.addRow(new String[] {Integer.toString(client.getClientId()),client.getNom(),client.getPrenom()});
				}

				
				
				
				
				
				
			}
		});
		tabVolRes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "ville depart", "date depart", "ville arrivee", "date arrivee", "prix"
			}
		));
		scrollPane_5.setViewportView(tabVolRes);
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 41, 192, 121);
		panelReservation.add(scrollPane_6);
		
		tabClientRes = new JTable();
		tabClientRes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nom", "prenom"
			}
		));
		scrollPane_6.setViewportView(tabClientRes);
		
		lblNewLabel_1 = new JLabel("Clients :");
		lblNewLabel_1.setBounds(10, 16, 77, 14);
		panelReservation.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Vols :");
		lblNewLabel_2.setBounds(228, 16, 77, 14);
		panelReservation.add(lblNewLabel_2);
		
		txtpPlaces = new JTextPane();
		txtpPlaces.setBounds(148, 347, 133, 20);
		panelReservation.add(txtpPlaces);
		
		JLabel lblNewLabel_1_1 = new JLabel("Places restantes :");
		lblNewLabel_1_1.setBounds(10, 353, 115, 14);
		panelReservation.add(lblNewLabel_1_1);
		
		txtpAeroDepart = new JTextPane();
		txtpAeroDepart.setBounds(148, 378, 133, 20);
		panelReservation.add(txtpAeroDepart);
		
		txtpAeroArrivee = new JTextPane();
		txtpAeroArrivee.setBounds(148, 409, 133, 20);
		panelReservation.add(txtpAeroArrivee);
		
		lblNewLabel_1_2 = new JLabel("Aeroport depart :");
		lblNewLabel_1_2.setBounds(10, 384, 115, 14);
		panelReservation.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("Aeroport Arriv\u00E9e:");
		lblNewLabel_1_3.setBounds(10, 415, 115, 14);
		panelReservation.add(lblNewLabel_1_3);
		
		btnReserver = new JButton("Reserver");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indexVol = tabVolRes.getSelectedRow();
				int indexClient = tabClientRes.getSelectedRow();
				vols.get(indexVol).reserver(clients.get(indexClient));
				modelClientReservant.addRow(new String[] {Integer.toString(clients.get(indexClient).getClientId()),clients.get(indexClient).getNom(),clients.get(indexClient).getPrenom()});
				txtpPlaces.setText(Integer.toString(vols.get(indexVol).getSiegeDispo()));
				
				
				
				
			}
		});
		btnReserver.setBounds(529, 344, 89, 23);
		panelReservation.add(btnReserver);
		
		btnEnregistrer_1 = new JButton("Enregistrer");
		btnEnregistrer_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save();
			}
		});
		btnEnregistrer_1.setBounds(529, 384, 89, 23);
		panelReservation.add(btnEnregistrer_1);
		
		JScrollPane scrollPane_6_1 = new JScrollPane();
		scrollPane_6_1.setBounds(10, 198, 192, 123);
		panelReservation.add(scrollPane_6_1);
		
		tabClientReservant = new JTable();
		tabClientReservant.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "nom", "prenom"
			}
		));
		scrollPane_6_1.setViewportView(tabClientReservant);
		
		JLabel lblNewLabel_1_4 = new JLabel("Clients ayant reserv\u00E9 :");
		lblNewLabel_1_4.setBounds(10, 173, 133, 14);
		panelReservation.add(lblNewLabel_1_4);
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				save();
				
			}
		});
		btnSupprimerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabClients.getSelectedRow();
				if(indice!=-1) {
					 clients.get(indice).setStatus(false);;
					 modelClients.removeRow(indice);
					 modelClientRes.removeRow(indice);
					 txtPrenom.setText(null);
					 txtNom.setText(null);
					 btnAjouterClient.setVisible(true);
					 btnModifierClient.setVisible(false);
					 btnSupprimerClient.setVisible(false);
					 btnEnregistrer.setVisible(true);
				}
			}
		});
		btnModifierClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabClients.getSelectedRow();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				
				if(!(nom==null|| nom.equals("")||prenom==null|| prenom.equals(""))) {
					int c=0;
					for(Client client: clients) {
						if(client.getNom().equalsIgnoreCase(nom)&&client.getPrenom().equalsIgnoreCase(prenom)) {
							c=1;
						}
					}
					if(c==0) {
						clients.get(indice).modify(nom, prenom);
						modelClients.setValueAt(nom, indice, 1);
						modelClients.setValueAt(prenom, indice, 2);
						modelClientRes.setValueAt(nom, indice, 1);
						modelClientRes.setValueAt(prenom, indice, 2);
						txtNom.setText(null);
						txtPrenom.setText(null);
						btnAjouterClient.setVisible(true);
						btnModifierClient.setVisible(false);
						btnSupprimerClient.setVisible(false);
						btnEnregistrer.setVisible(true);
						tabClients.getSelectionModel().clearSelection();
					}
					
				}
			}
		});
		btnAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				if(!(nom==null|| nom.equals("")||prenom==null|| prenom.equals(""))) {
					int c=0;
					int index =0;
					for(Client client: clients) {
						if(client.getNom().equalsIgnoreCase(nom)&&client.getPrenom().equalsIgnoreCase(prenom)) {
							c=1;
							index = clients.indexOf(client);
						}
					}
					if(c==0) {
						Client client = new Client(nom,prenom);
						clients.add(client);
						modelClients.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
						modelClientRes.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
						txtNom.setText(null);
						txtPrenom.setText(null);
					}
					else if(!(clients.get(index).isStatus())) {
						Client client = clients.get(index);
						client.setStatus(true);
						modelClients.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
						modelClientRes.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
					}
					
				}
				
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
