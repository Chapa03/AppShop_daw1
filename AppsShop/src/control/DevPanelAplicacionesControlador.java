package control;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class DevPanelAplicacionesControlador implements ActionListener{
	private Map<String, Object> componentes = new HashMap<String, Object>();
	
	public DevPanelAplicacionesControlador() {
	}

	public DevPanelAplicacionesControlador(Map<String, Object> componentes) {
		super();
		this.componentes = componentes;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		switch (s) {
		case "categories":
			CardLayout c1 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c1.show((JPanel)componentes.get("cards"), "categories");
			break;
		case "general":
			CardLayout c2 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c2.show((JPanel)componentes.get("cards"), "general");
			break;
		case "card3":
			CardLayout c3 = (CardLayout)(((JPanel)componentes.get("cards")).getLayout());
			c3.show((JPanel)componentes.get("cards"), "card3");
			break;
		default:
			break;
		}
		
	}

}
