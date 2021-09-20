package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.MiPerfilControlador;
import control.UsuarioControlador;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class MiPerfil extends JDialog {

	private final JPanel cards = new JPanel();
	private Map<String, Object> componentes = new HashMap<String, Object>();
	
	private JPanel card1, card2, card3;
	private JLabel lblUserAlias;
	private JLabel lblUserID;
	private JLabel lblNombre;
	private JLabel lblMail;
	private JLabel lblDate;
	private JLabel lblPais;
	private JLabel lblDeveloper;
	private JLabel lblMostrarFecha;
	private JLabel lblMostrarMail;
	private JLabel lblMostrarNombre;
	private JLabel lblMostrarPais;
	private JLabel lblUserAliasMod;
	private JLabel lblNombreMod;
	private JLabel lblMailMod;
	private JLabel lblDateMod;
	private JLabel lblPaisMod;
	private JLabel lblUserID_1;
	private JTextField tFFecha;
	private JTextField tFMail;
	private JTextField tFNombre;
	private JTextField tFPais;
	

	/**
	 * Create the dialog.
	 */
	public MiPerfil() {
		setTitle("Mi perfil - " + UsuarioControlador.getUser().getAlias());
		setBounds(300, 250, 601, 406);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		cards.setBorder(null);
		getContentPane().add(cards, BorderLayout.CENTER);
		cards.setLayout(new CardLayout(0, 0));
		componentes.put("cards", cards);

		card1 = new JPanel();
		card1.setBackground(Color.WHITE);
		card1.setBorder(null);
		lblUserAlias = new JLabel(UsuarioControlador.getUser().getAlias());
		lblUserAlias.setForeground(Color.DARK_GRAY);
		lblUserAlias.setFont(new Font("Segoe UI", Font.BOLD, 28));
		
		lblUserID = new JLabel("User ID: " + UsuarioControlador.getUser().getIdUsuario());
		lblUserID.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		
		lblNombre = new JLabel("Nombre completo:");
		lblNombre.setForeground(Color.DARK_GRAY);
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblMail = new JLabel("Correo electr\u00F3nico:");
		lblMail.setForeground(Color.DARK_GRAY);
		lblMail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblDate = new JLabel("Fecha de nacimiento:");
		lblDate.setForeground(Color.DARK_GRAY);
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblPais = new JLabel("Pa\u00EDs:");
		lblPais.setForeground(Color.DARK_GRAY);
		lblPais.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblDeveloper = new JLabel();
		lblDeveloper.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblDeveloper.setForeground(new Color(204, 204, 255));
		if (UsuarioControlador.getUser().isDeveloper()) {
			lblDeveloper.setText("Perfil de desarrollador");
		}
		
		lblMostrarFecha = new JLabel(UsuarioControlador.getUser().getFechaNacimiento());
		componentes.put("lblFecha", lblMostrarFecha);
		
		lblMostrarMail = new JLabel(UsuarioControlador.getUser().getCorreo());
		componentes.put("lblMail", lblMostrarMail);
		
		lblMostrarNombre = new JLabel(UsuarioControlador.getUser().getNombreCompleto());
		componentes.put("lblNombre", lblMostrarNombre);
		
		lblMostrarPais = new JLabel(UsuarioControlador.getUser().getPais());
		componentes.put("lblPais", lblMostrarPais);
		
		GroupLayout gl_card1 = new GroupLayout(card1);
		gl_card1.setHorizontalGroup(
			gl_card1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_card1.createSequentialGroup()
					.addGap(28)
					.addComponent(lblUserAlias)
					.addContainerGap(323, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_card1.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_card1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMail)
						.addComponent(lblNombre)
						.addComponent(lblDeveloper)
						.addGroup(gl_card1.createSequentialGroup()
							.addGroup(gl_card1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate)
								.addComponent(lblPais))
							.addGap(18)
							.addGroup(gl_card1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMostrarPais)
								.addComponent(lblMostrarMail)
								.addComponent(lblMostrarFecha)
								.addComponent(lblMostrarNombre))))
					.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
					.addComponent(lblUserID)
					.addContainerGap())
		);
		gl_card1.setVerticalGroup(
			gl_card1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_card1.createSequentialGroup()
					.addGap(19)
					.addComponent(lblUserAlias)
					.addGap(57)
					.addGroup(gl_card1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(lblMostrarNombre))
					.addGap(18)
					.addGroup(gl_card1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMail)
						.addComponent(lblMostrarMail))
					.addGap(18)
					.addGroup(gl_card1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(lblMostrarFecha))
					.addGap(18)
					.addGroup(gl_card1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPais)
						.addComponent(lblMostrarPais))
					.addGap(39)
					.addComponent(lblDeveloper)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addComponent(lblUserID)
					.addContainerGap())
		);
		card1.setLayout(gl_card1);
		card2 = new JPanel();
		card2.setBorder(null);
		card2.setBackground(Color.WHITE);
		card3 = new JPanel();
		card3.setBackground(Color.WHITE);
		card3.setBorder(null);
		
		cards.add(card1, "datos");
		cards.add(card2, "modificar");
		
		lblUserAliasMod = new JLabel(UsuarioControlador.getUser().getAlias());
		lblUserAliasMod.setForeground(Color.DARK_GRAY);
		lblUserAliasMod.setFont(new Font("Segoe UI", Font.BOLD, 28));
		
		lblNombreMod = new JLabel("Nombre completo:");
		lblNombreMod.setForeground(Color.DARK_GRAY);
		lblNombreMod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblMailMod = new JLabel("Correo electr\u00F3nico:");
		lblMailMod.setForeground(Color.DARK_GRAY);
		lblMailMod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblDateMod = new JLabel("Fecha de nacimiento:");
		lblDateMod.setForeground(Color.DARK_GRAY);
		lblDateMod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblPaisMod = new JLabel("Pa\u00EDs:");
		lblPaisMod.setForeground(Color.DARK_GRAY);
		lblPaisMod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		lblUserID_1 = new JLabel("User ID: " + UsuarioControlador.getUser().getIdUsuario());
		lblUserID_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		
		tFFecha = new JTextField();
		tFFecha.setText(UsuarioControlador.getUser().getFechaNacimiento());
		componentes.put("fecha", tFFecha);
		tFFecha.setColumns(10);
		
		tFMail = new JTextField();
		tFMail.setText(UsuarioControlador.getUser().getCorreo());
		componentes.put("mail", tFMail);
		tFMail.setColumns(10);
		
		tFNombre = new JTextField();
		tFNombre.setText(UsuarioControlador.getUser().getNombreCompleto());
		componentes.put("nombre", tFNombre);
		tFNombre.setColumns(10);
		
		tFPais = new JTextField();
		tFPais.setText(UsuarioControlador.getUser().getPais());
		componentes.put("pais", tFPais);
		tFPais.setColumns(10);
		
		JButton btnSave = new JButton("Guardar cambios");
		btnSave.addActionListener(new MiPerfilControlador(componentes));
		btnSave.setActionCommand("save");
		
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.DARK_GRAY);
		
		GroupLayout gl_card2 = new GroupLayout(card2);
		gl_card2.setHorizontalGroup(
			gl_card2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_card2.createSequentialGroup()
					.addGap(28)
					.addComponent(lblUserAliasMod)
					.addContainerGap(323, Short.MAX_VALUE))
				.addGroup(gl_card2.createSequentialGroup()
					.addContainerGap(413, Short.MAX_VALUE)
					.addComponent(lblUserID_1)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_card2.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_card2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSave)
						.addGroup(gl_card2.createSequentialGroup()
							.addGroup(gl_card2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDateMod)
								.addComponent(lblMailMod)
								.addComponent(lblNombreMod)
								.addComponent(lblPaisMod))
							.addGap(28)
							.addGroup(gl_card2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tFNombre, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
								.addComponent(tFMail)
								.addComponent(tFFecha)
								.addComponent(tFPais))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_card2.setVerticalGroup(
			gl_card2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_card2.createSequentialGroup()
					.addGap(19)
					.addComponent(lblUserAliasMod)
					.addGap(57)
					.addGroup(gl_card2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreMod)
						.addComponent(tFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_card2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMailMod)
						.addComponent(tFMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_card2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateMod)
						.addComponent(tFFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_card2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaisMod)
						.addComponent(tFPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnSave)
					.addGap(34)
					.addComponent(lblUserID_1)
					.addContainerGap())
		);
		card2.setLayout(gl_card2);
		cards.add(card3, "settings");
		
		JButton btnDelete = new JButton("Borrar perfil de usuario");
		btnDelete.setActionCommand("borrar");
		btnDelete.addActionListener(new MiPerfilControlador());
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(255, 0, 102));
		GroupLayout gl_card3 = new GroupLayout(card3);
		gl_card3.setHorizontalGroup(
			gl_card3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_card3.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addContainerGap())
		);
		gl_card3.setVerticalGroup(
			gl_card3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_card3.createSequentialGroup()
					.addContainerGap(333, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addContainerGap())
		);
		card3.setLayout(gl_card3);
		
		{
			JPanel buttonPaneWest = new JPanel();
			buttonPaneWest.setBackground(Color.DARK_GRAY);
			getContentPane().add(buttonPaneWest, BorderLayout.WEST);
			
			JButton btnShowData = new JButton("Mostrar datos");
			btnShowData.setForeground(Color.DARK_GRAY);
			btnShowData.setBackground(Color.WHITE);
			btnShowData.setActionCommand("showData");
			btnShowData.addActionListener(new MiPerfilControlador(componentes));
			
			JButton btnModifyData = new JButton("Modificar datos");
			btnModifyData.setActionCommand("modData");
			btnModifyData.setForeground(Color.DARK_GRAY);
			btnModifyData.setBackground(Color.WHITE);
			btnModifyData.addActionListener(new MiPerfilControlador(componentes));
			
			JButton btnDevPanel = new JButton("Dev panel");
			btnDevPanel.setActionCommand("devPanel");;
			if (UsuarioControlador.getUser().isDeveloper()) {
				btnDevPanel.setVisible(true);
			} else {
				btnDevPanel.setVisible(false);
			}
			btnDevPanel.setForeground(Color.DARK_GRAY);
			btnDevPanel.setBackground(SystemColor.activeCaption);
			btnDevPanel.addActionListener(new MiPerfilControlador());
			
			JButton btnSettings = new JButton("Ajustes de perfil");
			btnSettings.setActionCommand("settings");
			btnSettings.addActionListener(new MiPerfilControlador(componentes));
			btnSettings.setForeground(Color.DARK_GRAY);
			btnSettings.setBackground(Color.WHITE);
			GroupLayout gl_buttonPaneWest = new GroupLayout(buttonPaneWest);
			gl_buttonPaneWest.setHorizontalGroup(
				gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPaneWest.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
							.addComponent(btnShowData, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addComponent(btnSettings, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addComponent(btnModifyData, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDevPanel, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
						.addContainerGap())
			);
			gl_buttonPaneWest.setVerticalGroup(
				gl_buttonPaneWest.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPaneWest.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnShowData)
						.addGap(18)
						.addComponent(btnModifyData)
						.addGap(18)
						.addComponent(btnSettings)
						.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
						.addComponent(btnDevPanel)
						.addContainerGap())
			);
			buttonPaneWest.setLayout(gl_buttonPaneWest);
		}
		

		
	}
}
