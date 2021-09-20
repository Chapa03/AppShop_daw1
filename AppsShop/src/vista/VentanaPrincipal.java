package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import control.UsuarioControlador;
import control.VentanaPrincipalControlador;
import modelo.bbdd.CategoriaDAOPS;
import modelo.clases.CategoriaJuegos;
import modelo.clases.Usuario;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Insets;

public class VentanaPrincipal extends JFrame {
	private JPanel contentPane;
	private JButton btnPerfil = new JButton("Mi Perfil");
	private static JMenu menuUser;
	
	/*
	 * Podemos introducir todos los elementos que podemos necesitar
	 * enviar al controlador de la vista en un HashMap. De esta forma, no necesitariamos
	 * un constructor para cada conjunto de elementos sobre los que queramos hacer 
	 * cambios desde el controlador. Ya que, en cada llamada al ActionListener o KeyListener 
	 * con el constrcutor del controlador, le pasamos todo el conjunto de elementos
	 */
	private Map<String, Object> componentes = new HashMap<String, Object>();
	private JTextField textField;
	
	public static void setMenuUserAlias(Usuario user) {
		menuUser.setText(user.getAlias());
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setFont(new Font("Segoe UI", Font.PLAIN, 14));
		setResizable(false);
		setForeground(Color.WHITE);
		setTitle("AppShop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(290, 240, 700, 450);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		menuUser = new JMenu("Invitado");
		menuUser.setForeground(Color.WHITE);
		menuUser.setBackground(Color.DARK_GRAY);
		menuUser.setMnemonic(KeyEvent.VK_U);
//		Anhadimos menuUser al HasMap
		componentes.put("menuUser", menuUser);
		menuBar.add(menuUser);
		
		JMenuItem menuSignup = new JMenuItem("Registrarse");
		menuSignup.setForeground(Color.WHITE);
		menuSignup.setBackground(Color.DARK_GRAY);
		menuSignup.setActionCommand("signup");
		menuSignup.addActionListener(new VentanaPrincipalControlador());
		menuSignup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
		menuUser.add(menuSignup);
		
		JMenuItem menuLogin = new JMenuItem("Iniciar sesi\u00F3n");
		menuLogin.setForeground(Color.WHITE);
		menuLogin.setBackground(Color.DARK_GRAY);
		menuLogin.setActionCommand("login");
		menuLogin.addActionListener(new VentanaPrincipalControlador(componentes));
		menuLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.ALT_MASK));
		menuUser.add(menuLogin);
		
		JMenuItem menuChangeUser = new JMenuItem("Cambiar usuario");
		menuChangeUser.setForeground(Color.WHITE);
		menuChangeUser.setBackground(Color.DARK_GRAY);
		menuChangeUser.setActionCommand("change");
		menuChangeUser.addActionListener(new VentanaPrincipalControlador(componentes));
		menuChangeUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		menuUser.add(menuChangeUser);
		
		JMenuItem menuLogout = new JMenuItem("Cerrar sesi\u00F3n");
		menuLogout.setForeground(Color.WHITE);
		menuLogout.setBackground(Color.DARK_GRAY);
		menuLogout.setActionCommand("logout");
		menuLogout.addActionListener(new VentanaPrincipalControlador(componentes));
		menuLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));
		menuUser.add(menuLogout);
		
		JMenuItem menuExit = new JMenuItem("Salir");
		menuExit.setForeground(Color.WHITE);
		menuExit.setBackground(Color.DARK_GRAY);
		menuExit.setActionCommand("exit");
		menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.ALT_MASK));
		menuExit.addActionListener(new VentanaPrincipalControlador());
		menuUser.add(menuExit);
		
		JMenu menuMisApps = new JMenu("Mis aplicaciones");
		menuMisApps.setForeground(Color.WHITE);
		menuMisApps.setBackground(Color.DARK_GRAY);
		menuMisApps.setMnemonic(KeyEvent.VK_M);
		menuBar.add(menuMisApps);
		
		JMenuItem menuLibrary = new JMenuItem("Biblioteca");
		menuLibrary.setActionCommand("biblioteca");
		menuLibrary.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		menuMisApps.add(menuLibrary);
		
		JMenuItem menuWishList = new JMenuItem("Lista de deseos");
		menuWishList.setActionCommand("wishlist");
		menuWishList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));
		menuMisApps.add(menuWishList);
		
		JMenu menuSettings = new JMenu("Ajustes");
		menuSettings.setForeground(Color.WHITE);
		menuSettings.setBackground(Color.DARK_GRAY);
		menuSettings.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menuSettings);
		
		JMenu menuTheme = new JMenu("Tema");
		menuSettings.add(menuTheme);
		
		JMenuItem itemThemeBlack = new JMenuItem("Negro");
		itemThemeBlack.setActionCommand("black");
		menuTheme.add(itemThemeBlack);
		
		JMenuItem itemThemeDark = new JMenuItem("Oscuro");
		itemThemeDark.setActionCommand("dark");
		menuTheme.add(itemThemeDark);
		
		JMenuItem itemThemeWhite = new JMenuItem("Blanco");
		itemThemeWhite.setActionCommand("white");
		menuTheme.add(itemThemeWhite);
		
		JMenu menuMore = new JMenu("M�s");
		menuMore.setForeground(Color.WHITE);
		menuMore.setBackground(Color.DARK_GRAY);
		menuMore.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menuMore);
		
		JMenuItem menuAbout = new JMenuItem("Acerca de...");
		menuAbout.setActionCommand("about");
		menuAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
		menuAbout.addActionListener(new VentanaPrincipalControlador());
		menuMore.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel lateralPanel = new JPanel();
		lateralPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(lateralPanel, BorderLayout.WEST);
		
		JButton btnPerfil = new JButton("Mi Perfil");
		btnPerfil.setBackground(Color.WHITE);
		btnPerfil.setForeground(Color.DARK_GRAY);
		btnPerfil.setActionCommand("perfil");
		btnPerfil.addActionListener(new VentanaPrincipalControlador(componentes));
		
		JButton btnGames = new JButton("Juegos");
		btnGames.setForeground(Color.DARK_GRAY);
		btnGames.setBackground(Color.WHITE);
		btnGames.setActionCommand("juegos");
		
		JButton btnApps = new JButton("Apps");
		btnApps.setForeground(Color.DARK_GRAY);
		btnApps.setBackground(Color.WHITE);
		btnApps.setActionCommand("apps");
		
		JButton btnDevPanel = new JButton("Dev panel");
		btnDevPanel.setActionCommand("devpanel");
		btnDevPanel.addActionListener(new VentanaPrincipalControlador());
		componentes.put("devbutton", btnDevPanel);
		btnDevPanel.setForeground(Color.DARK_GRAY);
		btnDevPanel.setBackground(SystemColor.activeCaption);
		btnDevPanel.setActionCommand("devpanel");
		btnDevPanel.setVisible(false);
		
		JLabel lblSeparator = new JLabel("");
		lblSeparator.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/vista/graphics/separator1.png")));
		
		JLabel lblSeparator1 = new JLabel("");
		lblSeparator1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/vista/graphics/separator1.png")));
		
		GroupLayout gl_lateralPanel = new GroupLayout(lateralPanel);
		gl_lateralPanel.setHorizontalGroup(
			gl_lateralPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lateralPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lateralPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPerfil, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(lblSeparator, Alignment.TRAILING)
						.addComponent(btnGames, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(btnApps, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(lblSeparator1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDevPanel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_lateralPanel.setVerticalGroup(
			gl_lateralPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lateralPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPerfil, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSeparator)
					.addGap(18)
					.addComponent(btnGames, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnApps, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSeparator1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addComponent(btnDevPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		lateralPanel.setLayout(gl_lateralPanel);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton btnSearch = new JButton("Buscar");
		btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.DARK_GRAY);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		List<String> aux = new ArrayList<String>();
		for (CategoriaJuegos cat: CategoriaDAOPS.listaCategorias()) {
			aux.add(cat.getNombreCategoria());
		}
		JComboBox cBCategorias = new JComboBox(aux.toArray());
		cBCategorias.setForeground(Color.WHITE);
		cBCategorias.setBackground(Color.DARK_GRAY);
		
		JLabel lblCategory = new JLabel("Categor\u00EDas:");
		lblCategory.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JButton btnGod = new JButton("GOD mode");
		btnGod.setBorder(null);
		btnGod.setMargin(new Insets(2, 4, 2, 4));
		btnGod.setIconTextGap(3);
		btnGod.setBackground(Color.WHITE);
		btnGod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario god;
					god = UsuarioControlador.login("chapa", "chapa");
					god.setLoged(true);
					UsuarioControlador.setUser(god);
					VentanaPrincipal.setMenuUserAlias(UsuarioControlador.getUser());
					btnDevPanel.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(lblCategory)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cBCategorias, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(89))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnGod)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategory)
						.addComponent(cBCategorias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 325, Short.MAX_VALUE)
					.addComponent(btnGod)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
