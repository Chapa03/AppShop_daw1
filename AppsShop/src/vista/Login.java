package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UsuarioControlador;
import modelo.clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JDialog {
	static String pass = "";
	static String cifrado = "";
	private final JPanel contentPanel = new JPanel();
	private JTextField tFAlias;
	private JPasswordField pwPassword;
	private JLabel lblWarningLogin;
	private JLabel lblShowAlias;

	
	public void setAvisoCambioUsuario(String alias) {
		lblWarningLogin.setText("Se cerrará la sesión de: ");
		lblShowAlias.setText(alias);
	}
	
	/**
	 * Create the dialog.
	 */
	public Login() {
		setModal(true);
		setAlwaysOnTop(true);

		setTitle("Iniciar sesion");
		setBounds(100, 100, 300, 180);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel centro = new JPanel();
			centro.setBackground(Color.WHITE);
			centro.setBorder(null);
			contentPanel.add(centro, BorderLayout.CENTER);
			
			JLabel lblAlias = new JLabel("Alias:");
			lblAlias.setForeground(Color.DARK_GRAY);
			
			tFAlias = new JTextField();
			tFAlias.setColumns(10);
			JLabel lblPass = new JLabel("Password:");
			lblPass.setForeground(Color.DARK_GRAY);
			
			pwPassword = new JPasswordField();
			
			JLabel lblShowPasswordIcon = new JLabel("");
			lblShowPasswordIcon.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					pwPassword.setEchoChar((char)0);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					pwPassword.setEchoChar('*');
				}
			});
			lblShowPasswordIcon.setIcon(new ImageIcon(Login.class.getResource("/vista/graphics/invisible.png")));
			
			lblWarningLogin = new JLabel("");
			lblShowAlias = new JLabel("");
			GroupLayout gl_centro = new GroupLayout(centro);
			gl_centro.setHorizontalGroup(
				gl_centro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_centro.createSequentialGroup()
						.addGroup(gl_centro.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_centro.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblWarningLogin)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblShowAlias, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
							.addGroup(gl_centro.createSequentialGroup()
								.addGap(25)
								.addGroup(gl_centro.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblPass)
									.addComponent(lblAlias))
								.addGap(38)
								.addGroup(gl_centro.createParallelGroup(Alignment.LEADING, false)
									.addComponent(pwPassword)
									.addComponent(tFAlias, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblShowPasswordIcon)))
						.addContainerGap(25, Short.MAX_VALUE))
			);
			gl_centro.setVerticalGroup(
				gl_centro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_centro.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_centro.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_centro.createSequentialGroup()
								.addGroup(gl_centro.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblAlias)
									.addComponent(tFAlias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_centro.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPass)
									.addComponent(pwPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addComponent(lblShowPasswordIcon))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_centro.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblWarningLogin)
							.addComponent(lblShowAlias))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			centro.setLayout(gl_centro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.setForeground(Color.DARK_GRAY);
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario u = new Usuario();
						String pass = "";
						for (int i = 0; i < pwPassword.getPassword().length; i++) {
							pass += "" + pwPassword.getPassword()[i];
						}
						try {
							u = UsuarioControlador.login(tFAlias.getText(), pass);
							if (pass.equals(u.getPassword()) && tFAlias.getText().equals(u.getAlias())) {
								JOptionPane.showMessageDialog(okButton, "Bienvenido " + u.getAlias());
//								activo el campo loged para el usuario que acaba de iniciar sesión para poder trabajar
//								con el en la ventana principal
								u.setLoged(true);
//								Le pasamos el usuario que ha iniciado sesión al controlador de usuario
								UsuarioControlador.setUser(u);
								VentanaPrincipal.setMenuUserAlias(UsuarioControlador.getUser());
								dispose();
								
							} else {
								JOptionPane.showMessageDialog(okButton, "Por favor, introduce un usuario y password validos.");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(Color.DARK_GRAY);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
