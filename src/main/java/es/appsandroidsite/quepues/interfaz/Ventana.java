package es.appsandroidsite.quepues.interfaz;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import es.appsandroidsite.quepues.modelo.Url;
import es.appsandroidsite.quepues.soap.HacerPeticiones;
import es.appsandroidsite.quepues.soap.Peticion;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textUrl;
	private DefaultListModel<String> modelo;
	private JList<String> list;
	private JTextField textSubcategoria;
	private JButton botonAgregar;
	private JButton botonEnviar;
	private JButton botonEliminar;
	private JButton botonBorrar;

	
	private JComboBox comboTest;
	private JComboBox comboCategoria;

	private ArrayList<Url> lista;
	private Url url;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		lista= new ArrayList<Url>();
		setTitle("CoDejaVu: JList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelJList = new JLabel("                                             Quepues  ");
		labelJList.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelJList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		labelJList.setBounds(37, 11, 516, 26);
		contentPane.add(labelJList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 163, 516, 144);
		contentPane.add(scrollPane);
		
		list = new JList<String>(); // definimos el tipo de elementos del array
		modelo = new DefaultListModel <String>();
		list.setModel(modelo);
		
		
		scrollPane.setViewportView(list);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// se pone removeElementAt porque le pasamos un índice
				int ind=list.getSelectedIndex();
				modelo.removeElementAt(ind);
				lista.remove(ind);
				mostrarLista(lista);
				
			}
		});
		botonEliminar.setBounds(37, 318, 112, 23);
		contentPane.add(botonEliminar);
		
		botonBorrar = new JButton("Borrar Lista");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				lista.clear();
				mostrarLista(lista);
				
				
			}
		});
		botonBorrar.setBounds(159, 318, 112, 23);
		contentPane.add(botonBorrar);
		
		textUrl = new JTextField();
		textUrl.setBounds(114, 70, 439, 20);
		contentPane.add(textUrl);
		textUrl.setColumns(10);
		
		
		
		
		textSubcategoria = new JTextField();
		textSubcategoria.setColumns(10);
		textSubcategoria.setBounds(114, 101, 439, 20);
		contentPane.add(textSubcategoria);
		
		botonEnviar = new JButton("Enviar");
		botonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				System.out.println("Enviados datos");
				HacerPeticiones h;
				for(int i=0;i<lista.size();i++){
					h=new HacerPeticiones(lista.get(i));
					System.out.println(lista.get(i).toString());
					h.run();
				}
				if(HacerPeticiones.getNoenviadas().size()==0){
					  JOptionPane.showMessageDialog( null, "¡Se ha enviado correctamente!" );
					  lista.clear();
					  modelo.clear();
				}else{
					String texto="¡ATENCIÓN!\nNo se han podido guardar las siguientes referencias:";
					for(int i=0;i<HacerPeticiones.getNoenviadas().size();i++){
						texto=texto.concat("\n- "+HacerPeticiones.getNoenviadas().get(i).getUrl());
					}
					texto.concat("\n\nVuelva a intentarlo más tarde");
					HacerPeticiones.resetNoenviadas();
					
					  JOptionPane.showMessageDialog( null, texto );
				}
			
				
				
			};
				
				
				
				
			
		});
		botonEnviar.setBounds(448, 318, 106, 35);
		contentPane.add(botonEnviar);
		
		JLabel lblUrl = new JLabel("Url:");
		lblUrl.setBounds(38, 73, 46, 14);
		contentPane.add(lblUrl);
		
		JLabel lblSubcategoria = new JLabel("Subcategoria:");
		lblSubcategoria.setBounds(37, 104, 93, 14);
		contentPane.add(lblSubcategoria);
		
		JLabel lblTest = new JLabel("Test:");
		lblTest.setBounds(334, 138, 46, 14);
		contentPane.add(lblTest);
		
		comboTest = new JComboBox();
		comboTest.addItem("A10-Aula 10");
		comboTest.addItem("CL-Escuela de Negocio");
		comboTest.setBounds(114, 132, 199, 20);
		contentPane.add(comboTest);
		
		comboCategoria = new JComboBox();
		comboCategoria.addItem("G-Gestión");
		comboCategoria.addItem("M-Marketing");
		comboCategoria.addItem("D-Diseño");
		comboCategoria.addItem("H-Hostelería y Turismo");
		comboCategoria.addItem("In-Informática");
		comboCategoria.addItem("T-Tecnología");
		comboCategoria.addItem("S-Sociosanitaria");
		comboCategoria.addItem("IP-Imagen Personal");
		comboCategoria.setBounds(385, 132, 168, 20);
		contentPane.add(comboCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(37, 138, 93, 14);
		contentPane.add(lblCategoria);
		
		 botonAgregar = new JButton("Agregar");
		botonAgregar.addActionListener(new ActionListener() {
			boolean agregar;
			public void actionPerformed(ActionEvent arg0) {
				agregar=true;
				//para que no me agregue elementos vacios ni repetidos
				
				String codCat,codTest;
				StringTokenizer c,t;
				
				
				if(textUrl.getText().length()!=0 && textSubcategoria.getText().length()!=0){
					url= new Url();
					url.setUrl(textUrl.getText());
					url.setSubCategoria(textSubcategoria.getText());
					c= new StringTokenizer((String)comboCategoria.getSelectedItem(),"-",true);
					codCat=c.nextToken();
					
					url.setCategoria(codCat); 
					
					t= new StringTokenizer((String)comboTest.getSelectedItem(),"-",true);
					codTest=t.nextToken();
					url.setTest(codTest); 
					
					
							if(!modelo.contains((String)url.toString())){
					
									modelo.addElement(url.toString());
									lista.add(url);
									mostrarLista(lista);
							}
				}
				
			}
		});
		botonAgregar.setBounds(281, 318, 99, 23);
		contentPane.add(botonAgregar);
	}
	
	public static void mostrarLista(List lista){
		
		if(lista.size()!=0){
			for(int i=0;i<lista.size();i++){
				System.out.println(lista.get(i).toString());
			}
		}else{
			System.out.println("No hay elementos");
		}
		
		
	}
	
	/*
	public static boolean enviarUrls(List lista){
		boolean insertado=false;
		
		try{
		
		 // public Url(String categoria, String test, String subCategoria, String url) {
		for(int i = 0;i<lista.size();i++){
		Peticion p= new Peticion();
		if(p.insertaUrl((Url)lista.get(i))!=null){
			insertado=true;
			
		}else{
			insertado=false;
		}
		System.out.println(insertado);
		}
		insertado=true;
		}catch(Exception e){
			System.out.println("Error al insertar los registros");
			insertado=false;
		}
		
		return insertado;
		
		
	}
	*/
}
	
