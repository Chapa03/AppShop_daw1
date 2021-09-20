package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AuxTabbedPane extends JDialog {
	
	private JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel tab1, tab2, tab3, tab4, tab5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AuxTabbedPane dialog = new AuxTabbedPane();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AuxTabbedPane() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		tab1 = new JPanel();
		tab2 = new JPanel();
		tab3 = new JPanel();
		tab4 = new JPanel();
		tab5 = new JPanel();
		
		JButton boton1 = new JButton("Boton 1");
		JTextField txt1 = new JTextField();
		txt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txt1.getText().equals("0") || txt1.getText().equals("")) {
					System.out.println("NOOOOOOOOOOOOOOOOOOO");
				} else {
					System.out.println("YEEEAAAAAAAAAAAAAAAHH");
				}
			}
		});
		
		txt1.setPreferredSize(new Dimension(60, 20));
		JButton boton2 = new JButton("Boton 2");
		JTextField txt2 = new JTextField();
		JButton boton3 = new JButton("Boton 3");
		JTextField txt3 = new JTextField();
		JButton boton4 = new JButton("Boton 4");
		JTextField txt4 = new JTextField();
		JButton boton5 = new JButton("Boton 5");
		JTextField txt5 = new JTextField();
		
		tab1.add(boton1);
		tab1.add(txt1);
		tab2.add(boton2);
		tab2.add(txt2);
		tab3.add(boton3);
		tab3.add(txt3);
		tab4.add(boton4);
		tab4.add(txt4);
		tab5.add(boton5);
		tab5.add(txt5);
		
		tabbedPane.add("1aTab", tab1);
		tabbedPane.add("2aTab", tab2);
		tabbedPane.add("3aTab", tab3);
		tabbedPane.add("4aTab", tab4);
		tabbedPane.add("5aTab", tab5);
		
		getContentPane().add(tabbedPane);
	}

}



