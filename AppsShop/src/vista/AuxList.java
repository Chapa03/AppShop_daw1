package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import modelo.bbdd.CategoriaDAOPS;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AuxList extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JList lista;
	DefaultListModel modeloLista;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AuxList dialog = new AuxList();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AuxList() {
		setBounds(100, 100, 550, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		modeloLista = new DefaultListModel();
		modeloLista.addAll(CategoriaDAOPS.listaCategorias());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.WEST);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JButton btnNewButton = new JButton("Imprimir lista selecc.");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < lista.getSelectedValuesList().toArray().length; i++) {
							System.out.println(lista.getSelectedValuesList().toArray()[i]);
						}
					}
				});
				panel.add(btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("Borrar elemento");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modeloLista.remove(lista.getSelectedIndex());
					}
				});
				panel.add(btnNewButton_1);
			}
			{
				textField = new JTextField();
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JButton btnNewButton_2 = new JButton("Add element");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modeloLista.addElement(textField.getText());
					}
				});
				panel.add(btnNewButton_2);
			}
			{
				JButton btnNewButton_3 = new JButton("New button");
				panel.add(btnNewButton_3);
			}
			{
				JButton btnNewButton_4 = new JButton("New button");
				panel.add(btnNewButton_4);
			}
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		lista = new JList(modeloLista);

		JScrollPane scroll = new JScrollPane(lista);
		
		contentPanel.add(scroll);
		
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

}





/*
 * JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(e -> {
			modelo.addElement(textField.getText());
			textField.setText("");
		});
		panelBotones.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.remove(listaConModelo.getSelectedIndex());
			}
		});
		panelBotones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar todos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeAllElements();
			}
		});
		panelBotones.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Mostrar seleccionado");
		btnNewButton_3.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, listaConModelo.getSelectedValue());
		}
				);
		panelBotones.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cambiar tipo selecci\u00F3n");
		btnNewButton_4.addActionListener(e -> {
			listaConModelo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		});
		panelBotones.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Ver seleccionados");
		btnNewButton_5.addActionListener(e -> {
			JOptionPane.showInternalMessageDialog(null, listaConModelo.getSelectedValuesList());
			for (Object s : listaConModelo.getSelectedValuesList()) {
				
			}
		});
		panelBotones.add(btnNewButton_5);


		JButton btnNewButton_6 = new JButton("Borrar seleccionados");
		btnNewButton_6.addActionListener(e -> {
			int cont = 0;
			for (Integer y : listaConModelo.getSelectedIndices()) {
				modelo.remove(y - cont++);
			}
		});
*/