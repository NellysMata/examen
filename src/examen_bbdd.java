import java.sql.*;

import javax.swing.JOptionPane;

public class examen_bbdd {
    static final String URL = "jdbc:sqlite:C:\\sql-lite\\jugadores";

    public static void main(String[] args) {
      //Registro la clase
        Class.forName("org.sqlite.JDBC");
        // URL
		String url = "jdbc:sqlite:C:\\sql-lite\\jugadores";
		// conn
        try {
        	//Conectar con la url de la base de datos
        	Connection conn = DriverManager.getConnection(URL);
        	//Declaro las variables conn y pt
            conn = DriverManager.getConnection(URL);
            var pt = conn.createStatement();
            //Creo la variable opcion para preguntar al usuario
            int opcion = 0;
            do {
                System.out.println("\n Mi base de datos ");
                System.out.println("\n1. Añadir tablas");
                System.out.println("\n2. Listar tablas");
                System.out.println("\n3. Eliminar tablas");
                System.out.println("\n4. Salir");
      
                //un switch para ejecutar la accion que va a realizar el usuario
                switch (opcion) {
                case 1:
                	//Para introducir una tabla
                	JOptionPane.showInputDialog("\n 1. Introduce el nombre de la tabla a crear:");
                    String nombreTabla = System.console().readLine();
                    //Asigno un nombre a la tabla
                    String CrearTabla = "CREATE TABLE " + nombreTabla + " (id INT PRIMARY KEY, nombre VARCHAR(255))";
                    // Creo una tabla
                    JOptionPane.showInputDialog("Has creado una tabla" +nombreTabla);
                    break;
                case 2:
                	//Para imprimir las tablas creadas desde el nombre de los jugadores
                    System.out.println("\n2. Listado de tablas creadas:");
                    var resultSet = pt.executeQuery("select * from Nombre");
                    JOptionPane.showInputDialog("\nHas listado la tabla");
                    break;
                case 3:
                	//Para eliminar las tablas ya creadas
                    System.out.println("\n3. Diga la tabla que quiere eliminar:");
                    String nombreTablaEliminada = System.console().readLine();
                    String EliminarTabla = "DROP TABLE " + nombreTablaEliminada;
                    JOptionPane.showInputDialog("Has eliminado una tabla");
                    break;
                case 4:
                	//Para indicar que ha salido del programa
                	 JOptionPane.showInputDialog("4. Has salido");
                    break;
                default:
                	//En caso de que el usuario eliga una opcion que no está dentro del switch
                	 JOptionPane.showInputDialog("Esta opción no es valida");
                    break;
                }
                //Creo un bucle para cuando el cliente elija una opcion que no esta dentro de la opciones
            }while(opcion !=4);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JOptionPane.showMessageDialog(null, "No has introducido una opcion valida");
        }
    }
}
