package modelo.bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.clases.Aplicacion;

public class AplicacionesDAO {
	

	public static void insertarAplicacion(Aplicacion app) {
		try {
			EnlaceJDBC enlace=new EnlaceJDBC();
//			enlace.insertar("Insert into aplicacion values("+ app. +",'"+app.getNombreProducto()+"')")
			String holahola = "hola";
			if (enlace.insertar("Insert into aplicacion (nombre_aplicacion) values('" + holahola + "')")) {
//				System.out.println("El elemento "+ app.getNombreProducto()+ " se ha insertado correctamente");
				System.out.println("Insertado!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void selectPrueba() {
		ResultSet res = null;
		try {
			EnlaceJDBC enlace = new EnlaceJDBC();
			res = enlace.seleccionRegistros("select id_aplicacion, nombre_aplicacion from aplicacion");
			while (res.next()) {
				System.out.println("id app: " + res.getInt("id_aplicacion") + " nombre app: " + res.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//		public static void insertarAplicacionAI(Aplicacion app) {
//			try {
//				EnlaceJDBC enlace = new EnlaceJDBC();
//				if (enlace.insertar("Insert into aplicacion(nombre) values('" + app.getNombreProducto() + "')")) {
//					System.out.println("El elemento " + app.getNombreProducto() + " se ha insertado correctamente");
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}

	
//	importar a lista
//		public static List<Aplicacion> seleccionarAplicaciones() {
//			List<Aplicacion> listaAplicaciones = new ArrayList<Aplicacion>();
//			ResultSet res = null;
//			try {
//				EnlaceJDBC enlace = new EnlaceJDBC();
//				res = enlace.seleccionRegistros("select id_aplicacion, nombre_aplicacion from aplicacion");
//				while (res.next()) {
//					listaProductos.add(new Aplicacion(res.getInt("id_aplicacion"), res.getString(2)));
//				}
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			return listaAplicaciones;
//		}


}
