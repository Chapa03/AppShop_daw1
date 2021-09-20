package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import control.DevPanelAplicacionesControlador;
import control.MiPerfilControlador;
import control.UsuarioControlador;
import modelo.bbdd.CategoriaDAOPS;
import modelo.clases.CategoriaJuegos;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Point;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import javax.swing.ListSelectionModel;

public class DevPanelAplicaciones extends JDialog {
	JList list;
	DefaultListModel modeloLista;
	
	private JPanel cards = new JPanel();
	private Map<String, Object> componentes = new HashMap<String, Object>();
	
	private JPanel card1, card2, card3;
	private JTextField txtModCategories;
	private JTextField textField;
	
	/**
	 * Create the dialog.
	 */
	public DevPanelAplicaciones() {
		setTitle("Mi perfil - " + UsuarioControlador.getUser().getAlias());
		setBounds(300, 250, 650, 415);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		cards.setBorder(null);
		getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(new CardLayout(0, 0));
		componentes.put("cards", cards);

		card1 = new JPanel();
		card1.setBackground(Color.WHITE);
		card1.setBorder(null);
		
//		COMBO BOX DE CATEGORIAS DE JUEGOS
		List<String> aux = new ArrayList<String>();
		for (CategoriaJuegos cat: CategoriaDAOPS.listaCategorias()) {
			aux.add(cat.getNombreCategoria());
		}
		modeloLista = new DefaultListModel();
		modeloLista.addAll(CategoriaDAOPS.listaCategorias());
		
		GroupLayout gl_card1 = new GroupLayout(card1);
		gl_card1.setHorizontalGroup(
			gl_card1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 454, Short.MAX_VALUE)
		);
		gl_card1.setVerticalGroup(
			gl_card1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 367, Short.MAX_VALUE)
		);
		card1.setLayout(gl_card1);
		card2 = new JPanel();
		card2.setBorder(null);
		card2.setBackground(Color.WHITE);
		card3 = new JPanel();
		card3.setBackground(Color.WHITE);
		card3.setBorder(null);
		
		cards.add(card1, "general");
		cards.add(card2, "categories");
		
		

		card2.setLayout(new BorderLayout(0, 0));
		
		JPanel panelList = new JPanel();
		card2.add(panelList, BorderLayout.CENTER);
		panelList.setLayout(new GridLayout(0, 1, 0, 0));
		
		list = new JList(modeloLista);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(0);
		
				JScrollPane scroll = new JScrollPane(list);
				panelList.add(scroll);
				
				card2.add(scroll);
				
				JPanel panelNorte = new JPanel();
				card2.add(panelNorte, BorderLayout.NORTH);
				
				txtModCategories = new JTextField();
				panelNorte.add(txtModCategories);
				txtModCategories.setText("Modificar categorías:");
				txtModCategories.setColumns(10);
				
				JPanel panelBotones = new JPanel();
				card2.add(panelBotones, BorderLayout.SOUTH);
				
				textField = new JTextField();
				panelBotones.add(textField);
				textField.setColumns(10);
				
				JButton btnAddCategory = new JButton("Añadir categoría");
				panelBotones.add(btnAddCategory);
				
				JButton btnDelCategory = new JButton("Eliminar categoría");
				panelBotones.add(btnDelCategory);
		cards.add(card3, "card3");
		GroupLayout gl_card3 = new GroupLayout(card3);
		gl_card3.setHorizontalGroup(
			gl_card3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 454, Short.MAX_VALUE)
		);
		gl_card3.setVerticalGroup(
			gl_card3.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 367, Short.MAX_VALUE)
		);
		card3.setLayout(gl_card3);
		
		{
			JPanel buttonPaneWest = new JPanel();
			buttonPaneWest.setBackground(Color.DARK_GRAY);
			getContentPane().add(buttonPaneWest, BorderLayout.WEST);
			
			JButton btnGeneral = new JButton("General");
			btnGeneral.setForeground(Color.DARK_GRAY);
			btnGeneral.setBackground(Color.WHITE);
			btnGeneral.setActionCommand("general");
			btnGeneral.addActionListener(new DevPanelAplicacionesControlador(componentes));
			
			JButton btnCategories = new JButton("Categor\u00EDas");
			btnCategories.setActionCommand("categories");
			btnCategories.setForeground(Color.DARK_GRAY);
			btnCategories.setBackground(Color.WHITE);
			btnCategories.addActionListener(new DevPanelAplicacionesControlador(componentes));
			
			JButton btnCard3 = new JButton("Card 3");
			btnCard3.setActionCommand("card3");
			btnCard3.addActionListener(new DevPanelAplicacionesControlador(componentes));
			btnCard3.setForeground(Color.DARK_GRAY);
			btnCard3.setBackground(Color.WHITE);
			GroupLayout gl_buttonPaneWest = new GroupLayout(buttonPaneWest);
			gl_buttonPaneWest.setHorizontalGroup(
				gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPaneWest.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
							.addComponent(btnGeneral, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
							.addComponent(btnCard3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCategories, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_buttonPaneWest.setVerticalGroup(
				gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPaneWest.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnGeneral)
						.addGap(18)
						.addComponent(btnCategories)
						.addGap(18)
						.addComponent(btnCard3)
						.addContainerGap(251, Short.MAX_VALUE))
			);
			buttonPaneWest.setLayout(gl_buttonPaneWest);
		}
	}
}
