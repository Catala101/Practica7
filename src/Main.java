import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cod=0;
		int opc=0;
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner(System.in);
		BDController controladorBD = new BDController();
		ArrayList <Jugador> jugadores = new ArrayList<Jugador>();
		ArrayList <Equipo> equipos = new ArrayList<Equipo>();
		System.out.println("^-^HOOOOOOOOOOOOOOOOOOOOOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAA^-^")
		do {
		Main.mostrarMenu();
		opc=sn.nextInt();
		
			switch(opc) {
				case 1:
					System.out.println("Introduzca el código del jugador:");
					cod=sn.nextInt();
					if (controladorBD.existeCodigo(cod)) {
						System.out.println("El código introducido ya existe.");
					}else {
							System.out.println("Introduzca el nombre del jugador:");
							String nombre=sc.nextLine();
							System.out.println("Introduzca la procedencia del jugador:");
							String procedencia=sc.nextLine();
							System.out.println("Introduzca la altura del jugador:");
							String altura=sc.nextLine();
							System.out.println("Introduzca el peso del jugador:");
							int peso=sn.nextInt();
							System.out.println("Introduzca la posición del jugador");
							String posicion=sc.nextLine();
							System.out.println("Introduzca el nombre del equipo:");
							String nombre_equipo=sc.nextLine();
							equipos = controladorBD.listadoEquipos();
							System.out.println("---------------------------");
							for (int i = 0; i < equipos.size(); i++) {
								System.out.println("Nombre: " + equipos.get(i).getNombre());
								System.out.println("Ciudad: " + equipos.get(i).getCiudad());
								System.out.println("Conferencia: " + equipos.get(i).getConferencia());
								System.out.println("División: " + equipos.get(i).getDivision());
								System.out.println("-----------------------");
							}
							if(controladorBD.existeEquipo(nombre_equipo)) {
								controladorBD.dardeAltaJugador(cod, nombre, procedencia, altura, peso, posicion, nombre_equipo);
								System.out.println("Jugador añadido!");
							}else {
								System.out.println("No se encuentra el equipo especificado.");
							}
					}
				break;
				case 2:
					System.out.println("Introduzca el código del jugador:");
					cod=sn.nextInt();
					if (controladorBD.existeCodigo(cod)) {
						controladorBD.dardeBajaJugador(cod);
						System.out.println("Jugador borrado!");
					}else {
						System.out.println("El código del jugador no existe.");
					}
				break;
				case 3:
					System.out.println("Introduzca la división:");
					String division=sc.nextLine();
					equipos = controladorBD.listadoEquiposPorDivision(division);
					System.out.println("---------------------------");
					for (int i = 0; i < equipos.size(); i++) {
						System.out.println("Nombre: " + equipos.get(i).getNombre());
						System.out.println("Ciudad: " + equipos.get(i).getCiudad());
						System.out.println("Conferencia: " + equipos.get(i).getConferencia());
						System.out.println("División: " + equipos.get(i).getDivision());
						System.out.println("-----------------------");
					}
				break;
				case 4:
					System.out.println("Introduzca la conferencia:");
					String conferencia=sc.nextLine();
					equipos = controladorBD.listadoEquiposPorConferencia(conferencia);
					System.out.println("---------------------------");
					for (int i = 0; i < equipos.size(); i++) {
						System.out.println("Nombre: " + equipos.get(i).getNombre());
						System.out.println("Ciudad: " + equipos.get(i).getCiudad());
						System.out.println("Conferencia: " + equipos.get(i).getConferencia());
						System.out.println("División: " + equipos.get(i).getDivision());
						System.out.println("-----------------------");
					}
				break;
				default:
					System.out.println("Número incorrecto.");
			}
		}while(opc==5);
	}
	
	
	public static void mostrarMenu() {
		System.out.println("1. Alta Jugador.\r\n" + 
				"2. Baja Jugador.\r\n" + 
				"3. Listado de equipos por división.\r\n" + 
				"4. Listado de equipos por conferencia.\r\n" + 
				"5. Salir.");
	}
}
