import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDController {
	private Connection conexion;
	public BDController() {
		super();
		try {
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/nba", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el constructor vacio del BDController");
			e.printStackTrace();
		}
	}
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	public boolean existeCodigo(int cod){
		boolean existe=false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String cadena="select * from jugadores where codigo= "+ cod +";";
			ResultSet rs = miStatement.executeQuery(cadena);
			while (rs.next()) {
				existe=true;
			}
			miStatement.close();
			rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en ExisteCódigo");
		e.printStackTrace();
	}
	return existe;
	}
	public boolean existeEquipo(String nombre_equipo){
		boolean existe=false;
		try {
			Statement miStatement = this.conexion.createStatement();
			String cadena="select * from jugadores where nombre_equipo= '"+ nombre_equipo +"';";
			ResultSet rs = miStatement.executeQuery(cadena);
			while (rs.next()) {
				existe=true;
			}
			miStatement.close();
			rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en ExisteEquipo");
		e.printStackTrace();
	}
	return existe;
	}
	
	public void dardeAltaJugador(int codigo, String nombre, String procedencia, String altura, int peso, String posicion, String nombre_equipo) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "Insert jugadores (codigo, nombre, procedencia, altura, peso, posicion, nombre_equipo) values"
					+ " ('" + codigo + "', '" + nombre +"'," +"'" + procedencia + "'," + "'" + altura + "'," + "" + peso + "," + "'" + posicion + "'," + "'" + nombre_equipo
					+ "');";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en dardeAltaJugador");
			e.printStackTrace();
		}
	}
	
	public void dardeBajaJugador(int cod) {
		try {
			// Creo el objeto tipo statement para poder hacer la consulta
			Statement miStatement = this.conexion.createStatement();
			String cadena = "delete from jugadores where codigo=" + cod + ";";
			miStatement.executeUpdate(cadena);
			miStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en bajaOpositor");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Equipo> listadoEquipos() {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from equipos");
			while (rs.next()) {
				equipos.add(new Equipo(rs.getString("nombre"), rs.getString("ciudad"),rs.getString("conferencia"), rs.getString("division")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoEquipos");
			e.printStackTrace();
		}
		return equipos;
	}
	public ArrayList<Equipo> listadoEquiposPorDivision(String division) {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from equipos where division='" + division + "'");
			while (rs.next()) {
				equipos.add(new Equipo(rs.getString("nombre"), rs.getString("ciudad"),rs.getString("conferencia"), rs.getString("division")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoEquipos");
			e.printStackTrace();
		}
		return equipos;
	}
	public ArrayList<Equipo> listadoEquiposPorConferencia(String conferencia) {
		ArrayList<Equipo> equipos = new ArrayList<Equipo>();
		// Creo el objeto tipo statement para poder hacer la consulta
		try {
			Statement miStatement = this.conexion.createStatement();
			ResultSet rs = miStatement.executeQuery("Select * from equipos where conferencia='" + conferencia + "'");
			while (rs.next()) {
				equipos.add(new Equipo(rs.getString("nombre"), rs.getString("ciudad"),rs.getString("conferencia"), rs.getString("division")));
			}
			miStatement.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en listadoEquipos");
			e.printStackTrace();
		}
		return equipos;
	}
}
