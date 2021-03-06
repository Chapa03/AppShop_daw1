package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.DevPanelUsuariosControlador;
import control.UsuarioControlador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DevPanelUsuario extends JDialog {

	private Map<String, Object> componentes = new HashMap<String, Object>();
	private final JPanel contentPanel = new JPanel();
	private JTextField tFSearch;
	private JTable table;
	private JPanel panelTabla;
	private JScrollPane scroll;
	private String[] cabecera = { "Alias", "Nombre completo", "Fecha de nacimiento", "Pa?s", "Correo",
			"Desarrollador" };
	private String selectedObject, seleccionTabla;

	/**
	 * Create the dialog.
	 */
	public DevPanelUsuario() {
		setTitle("DEV PANEL - Administraci\u00F3n de usuarios");
		setBounds(100, 100, 860, 390);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.WEST);

		tFSearch = new JTextField();
		tFSearch.setToolTipText("Escribe el alias de un usuario para una b\u00FAsqueda r\u00E1pida");
		componentes.put("txtBuscar", tFSearch);
		tFSearch.addKeyListener(new DevPanelUsuariosControlador(componentes));
//		tFSearch.addActionListener();
		tFSearch.setColumns(10);

		JLabel lblAlias = new JLabel("Alias del usuario:");
		lblAlias.setForeground(Color.LIGHT_GRAY);

		JButton btnAllUsers = new JButton("Mostrar lista de usuarios");
		btnAllUsers.setBackground(Color.WHITE);
		btnAllUsers.setActionCommand("showAll");
		btnAllUsers.addActionListener(new DevPanelUsuariosControlador(componentes));

		JButton btnDeleteSelected = new JButton("Borrar seleccionados");
		btnDeleteSelected.setForeground(Color.WHITE);
		btnDeleteSelected.setBackground(new Color(255, 0, 102));

		JButton btnSwitchDevUser = new JButton("Establecer como desarrollador");
		btnAllUsers.setForeground(Color.DARK_GRAY);
		btnSwitchDevUser.setForeground(Color.DARK_GRAY);
		btnSwitchDevUser.setBackground(Color.WHITE);

		JButton btnShowDevs = new JButton("Mostrar desarrolladores");
		btnShowDevs.setForeground(Color.DARK_GRAY);
		btnShowDevs.setBackground(Color.WHITE);
		btnShowDevs.setActionCommand("devs");
		btnShowDevs.addActionListener(new DevPanelUsuariosControlador(componentes));

		JButton btnShowNoDevs = new JButton("Mostrar NO desarrolladores");
		btnShowNoDevs.addActionListener(new DevPanelUsuariosControlador(componentes));
		btnShowNoDevs.setForeground(Color.DARK_GRAY);
		btnShowNoDevs.setBackground(Color.WHITE);
		btnShowNoDevs.setActionCommand("nodevs");

		JLabel lblSeparator1 = new JLabel("");
		lblSeparator1.setIcon(new ImageIcon(DevPanelUsuario.class.getResource("/vista/graphics/separator1.png")));

		JLabel lblSeparator2 = new JLabel("");
		lblSeparator2.setIcon(new ImageIcon(DevPanelUsuario.class.getResource("/vista/graphics/separator1.png")));

		JLabel lblSeparator3 = new JLabel("");
		lblSeparator3.setIcon(new ImageIcon(DevPanelUsuario.class.getResource("/vista/graphics/separator1.png")));

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(tFSearch, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addComponent(lblAlias)
						.addComponent(btnAllUsers, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnShowDevs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnShowNoDevs, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(btnSwitchDevUser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSeparator1, Alignment.TRAILING)
						.addComponent(lblSeparator2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDeleteSelected, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(lblSeparator3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 96,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap().addComponent(lblAlias)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(tFSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblSeparator1)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAllUsers).addGap(18)
						.addComponent(btnShowDevs).addGap(18).addComponent(btnShowNoDevs)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSeparator2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSwitchDevUser)
						.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addComponent(lblSeparator3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDeleteSelected)
						.addContainerGap()));
		contentPanel.setLayout(gl_contentPanel);

		panelTabla = new JPanel();
		panelTabla.setBackground(Color.WHITE);
		panelTabla.setBorder(null);
		getContentPane().add(panelTabla, BorderLayout.CENTER);

		inicioComponentes();
	}

	private void inicioComponentes() {
		Object[][] datosTabla = { { UsuarioControlador.getUser().getAlias(),
				UsuarioControlador.getUser().getNombreCompleto(), UsuarioControlador.getUser().getFechaNacimiento(),
				UsuarioControlador.getUser().getPais(), UsuarioControlador.getUser().getCorreo(),
				(UsuarioControlador.getUser().isDeveloper() ? "S?" : "No") } };
		componentes.put("cabecera", cabecera);

		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(cabecera);
		modelo.addRow(datosTabla[0]);

		table = new JTable(modelo);
		table.setBackground(new Color(255, 255, 255));
		table.setForeground(Color.DARK_GRAY);
        
        
		componentes.put("tabla", table);
		scroll = new JScrollPane(table);
		componentes.put("scroll", scroll);

		JButton btnAllUsers = new JButton("Todos los usuarios");
		btnAllUsers.setActionCommand("all");
		btnAllUsers.addActionListener(new DevPanelUsuariosControlador());

		JLabel lblExport = new JLabel("Exportar a txt:");

		JButton btnFromTxt = new JButton("From TXT");
		btnFromTxt.setActionCommand("originalToTxt");
		btnFromTxt.addActionListener(new DevPanelUsuariosControlador());

		GroupLayout gl_panelTabla = new GroupLayout(panelTabla);
		gl_panelTabla.setHorizontalGroup(gl_panelTabla.createParallelGroup(Alignment.LEADING).addGroup(gl_panelTabla
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelTabla.createParallelGroup(Alignment.LEADING)
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
						.addGroup(gl_panelTabla.createSequentialGroup()
								.addComponent(lblExport, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAllUsers)
								.addPreferredGap(ComponentPlacement.RELATED, 337, Short.MAX_VALUE)
								.addComponent(btnFromTxt)))
				.addContainerGap()));
		gl_panelTabla.setVerticalGroup(gl_panelTabla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTabla.createSequentialGroup().addContainerGap()
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panelTabla.createParallelGroup(Alignment.BASELINE).addComponent(lblExport)
								.addComponent(btnAllUsers).addComponent(btnFromTxt))
						.addContainerGap(22, Short.MAX_VALUE)));
		panelTabla.setLayout(gl_panelTabla);
	}
}
