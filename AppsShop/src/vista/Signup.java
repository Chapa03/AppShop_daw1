package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UsuarioControlador;
import modelo.clases.Usuario;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Signup extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tFAlias;
	private JTextField tFNombre;
	private JTextField tfFechaNacimiento;
	private JTextField tFPais;
	private JTextField tFEmail;
	private JPasswordField pwPass;
	private JPasswordField pwPass1;
	private boolean coincidePassword;
	private String pass;
	private String pass1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Signup dialog = new Signup();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Signup() {
		setResizable(false);
		setTitle("Registro");
		setBounds(100, 100, 400, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblAlias = new JLabel("Alias:");
		
		JLabel checkAlias = new JLabel("");
		
		JLabel checkEmail = new JLabel("");
		
		JLabel checkPass1 = new JLabel("");
		
		JLabel checkPass2 = new JLabel("");
		
		JLabel checkNombre = new JLabel("");
		
		JLabel checkFecha = new JLabel("");
		
		JLabel checkPais = new JLabel("");
		
		tFAlias = new JTextField();
		tFAlias.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(tFAlias.getText().length() >= 5 && tFAlias.getText().length() <= 15) {
					if (UsuarioControlador.comprobacionActivaAlias(tFAlias.getText())) {
						checkAlias.setIcon(new ImageIcon(Signup.class.getResource("/vista/graphics/check.png")));
					}
				} else {
					checkAlias.setIcon(new ImageIcon(Signup.class.getResource("/vista/graphics/error.png")));
				}
			}
		});
		tFAlias.setColumns(10);
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		JLabel lblPassword2 = new JLabel("Confirmar contrase\u00F1a:");
		
		JLabel lblNombre = new JLabel("Nombre y apellidos:");
		
		tFNombre = new JTextField();
		tFNombre.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
		
		tfFechaNacimiento = new JTextField();
		tfFechaNacimiento.setToolTipText("Introduce la fecha con el siguiente formato: \"DD-MM-AAAA\"");
		tfFechaNacimiento.setColumns(10);
		
		JLabel lblPais = new JLabel("Pa\u00EDs:");
		
		tFPais = new JTextField();
		tFPais.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Email:");
		
		tFEmail = new JTextField();
		tFEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tFEmail.setColumns(10);
		
		pwPass = new JPasswordField();
		pwPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass = "";
				for (int i = 0; i < pwPass.getPassword().length; i++) {
					pass += "" + pwPass.getPassword()[i];
				}
			}
		});
		
		pwPass1 = new JPasswordField();
		pwPass1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pass1 = "";
				for (int i = 0; i < pwPass.getPassword().length; i++) {
					pass1 += "" + pwPass.getPassword()[i];
				}
				if (pass1.equals(pass)) {
					checkPass2.setIcon(new ImageIcon(Signup.class.getResource("/vista/graphics/check.png")));
				} else {
					checkPass2.setIcon(new ImageIcon(Signup.class.getResource("/vista/graphics/error.png")));
				}
			}
		});
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAlias)
								.addComponent(lblPassword)
								.addComponent(lblPassword2)
								.addComponent(lblNombre)
								.addComponent(lblFechaNacimiento)
								.addComponent(lblPais))
							.addGap(49)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(pwPass, Alignment.LEADING)
								.addComponent(tFPais, Alignment.LEADING, 150, 150, Short.MAX_VALUE)
								.addComponent(tfFechaNacimiento, Alignment.LEADING, 150, 150, Short.MAX_VALUE)
								.addComponent(tFNombre, Alignment.LEADING, 150, 150, Short.MAX_VALUE)
								.addComponent(tFEmail, Alignment.LEADING, 150, 150, Short.MAX_VALUE)
								.addComponent(tFAlias, Alignment.LEADING)
								.addComponent(pwPass1, Alignment.LEADING)))
						.addComponent(lblCorreo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkAlias, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPass1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPass2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNombre, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkFecha, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPais, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlias)
						.addComponent(tFAlias, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkAlias))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCorreo)
						.addComponent(tFEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkEmail))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(pwPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPass1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword2)
						.addComponent(pwPass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPass2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(tFNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaNacimiento)
						.addComponent(tfFechaNacimiento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkFecha))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPais)
						.addComponent(tFPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(checkPais))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JCheckBox chckbxDev = new JCheckBox("Soy desarrollador");
			chckbxDev.setForeground(Color.LIGHT_GRAY);
			chckbxDev.setBackground(Color.DARK_GRAY);
			chckbxDev.setToolTipText("Marca esta casilla si eres desarrollador");
			buttonPane.add(chckbxDev);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.DARK_GRAY);
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pass = "";
						for (int i = 0; i < pwPass.getPassword().length; i++) {
							pass += "" + pwPass.getPassword()[i];
						}
						Usuario user = new Usuario (0, tFNombre.getText(), tFAlias.getText(), pass, tfFechaNacimiento.getText(), tFPais.getText(), tFEmail.getText(), chckbxDev.isSelected());
						
						if (UsuarioControlador.register(user)) {
							JOptionPane.showMessageDialog(okButton, "Se ha creado el usuario "+ user.getAlias() + (user.isDeveloper() ? " (dev) " : " ") + "con los siguientes datos: \n" + user.toString());
							dispose();
						} else {
							JOptionPane.showMessageDialog(okButton, "El usuario no ha podido ser registrado, vuelva a intentarlo de nuevo");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
