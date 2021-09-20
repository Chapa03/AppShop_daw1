package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control.UsuarioControlador;

import javax.swing.JTable;

public class AuxTabla extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AuxTabla dialog = new AuxTabla();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AuxTabla() {
		String[] cabecera = {"Alias", "Nombre completo", "Fecha de nacimiento", "País", "Correo", "Desarrollador"};
		Object[][] datosTabla = {{UsuarioControlador.getUser().getAlias(), UsuarioControlador.getUser().getNombreCompleto(), UsuarioControlador.getUser().getFechaNacimiento(), UsuarioControlador.getUser().getPais(), UsuarioControlador.getUser().getCorreo(), UsuarioControlador.getUser().isDeveloper()}};
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			table = new JTable(datosTabla, cabecera);
			scroll = new JScrollPane(table);
			contentPanel.add(scroll, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
