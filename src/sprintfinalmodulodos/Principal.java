package sprintfinalmodulodos;

import java.time.LocalDate;
import java.util.Scanner;


public class Principal{
    
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        Scanner scanner = new Scanner(System.in);
        Contenedor contenedor = new Contenedor();
        int opcion;
        
        
        do {
            //Menu ingreso datos
            //con 3 comillas pudo hacer bloque de texto multiplineas
            System.out.println(""" 
                ----------- MENU -----------               
                1. Almacenar Cliente
                2. Almacenar Profesional
                3. Almacenar Administrativo
                4. Almacenar Capacitacion
                5. Eliminar Usuario
                6. Listar Usuarios
                7. Listar Usuarios por Tipo
                8. Listar Capacitaciones
                9. Salir
                -------------------------------
                Seleccione una opcion:
                """);

            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1 -> { //Almacenar Cliente
                    System.out.print("Ingrese RUT: ");
                    int rutCliente = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese nombre: ");
                    String nombres = scanner.nextLine();                    
                    System.out.println("Ingrese apellido: ");
                    String apellidos = scanner.nextLine();                    
                    System.out.print("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
                    String fechaNacimiento = scanner.nextLine();                    
                    System.out.print("Ingrese edad: ");                    
                    int edad = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();                    
                    System.out.print("Ingrese AFP: "); 
                    String afp = scanner.nextLine();                    
                    System.out.print("Ingrese sistema de salud (1: Fonasa, 2: Isapre): ");
                    int sistemaSalud = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese dirección: ");
                    String direccion = scanner.nextLine();                    
                    System.out.print("Ingrese comuna: ");
                    String comuna = scanner.nextLine();
                    //----------
                    Cliente cliente = new Cliente ();
                    contenedor.almacenarCliente(cliente);
                    //----------                    
                    System.out.println("Los datos ingresados son: RUT: " 
                        + rutCliente + "Nombre: " + nombres + " " + apellidos
                        + ", Fecha de Nacimiento: " + fechaNacimiento
                        + ", Edad: " + edad + ",  Telefono: " + telefono
                        + ", AFP: " + afp + ", Sistema de Salud: " + sistemaSalud   
                        + ", Dirección: " + direccion+ " " + comuna);
                    contenedor.guardarClientes();
                }
            //------------------------------------------------------------------        
                case 2 -> { //Almacenar Profesional
                    System.out.print("Ingrese nombre: ");
                    String nombres = scanner.nextLine();                    
                    System.out.print("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Ingrese RUT: ");
                    int rut = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese título: ");
                    String titulo = scanner.nextLine();                    
                    System.out.print("Ingrese fecha de ingreso (dd/mm/yyyy): ");
                    String fechaIngreso = scanner.nextLine();
                    //----------
                    Profesional profesional = new Profesional();
                    contenedor.almacenarProfesional(profesional);
                    //-----------
                    System.out.println("Los datos ingresados son: Nombre: "
                            + nombres + "RUT: " + rut 
                            + ", Fecha de Nacimiento: " + fechaNacimiento
                            + ", Titulo: " + titulo
                            + ", Fecha de Ingreso: " + fechaIngreso);
                    contenedor.guardarProfesionales();  
                    //-----------
                }   
                    
                case 3-> { //Almacenar Administrativo
                    System.out.print("Ingrese nombre: ");
                    String nombres = scanner.nextLine();                    
                    System.out.print("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
                    String fechaNacimiento = scanner.nextLine();                  
                    System.out.print("Ingrese RUT: ");
                    int rut = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese área: ");
                    String area = scanner.nextLine();
                    
                    System.out.print("Ingrese experiencia previa: ");
                    String experienciaPrevia = scanner.nextLine();
                    //-----------
                    Administrativo administrativo = new Administrativo();
                    contenedor.almacenarAdministrativo(administrativo);
                    //-----------
                    System.out.println("Los datos ingresados son: Nombre: " 
                            + nombres + ", RUT: " + rut 
                            + ", Fecha de Nacimiento: " + fechaNacimiento
                            + ", Area " + area
                            + ", Experiencia previa: " + experienciaPrevia);
                    contenedor.guardarAdministrativos();
                    //-----------
                }
                    
                case 4-> { //Almacenar Capacitación
                    System.out.print("Ingrese identificador de la capacitación: ");
                    int identificador = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese RUT del cliente: ");
                    int rutCliente = scanner.nextInt();
                    scanner.nextLine();                    
                    System.out.print("Ingrese día: ");
                    String dia = scanner.nextLine();                    
                    System.out.print("Ingrese hora (HH:MM): ");
                    String hora = scanner.nextLine();                    
                    System.out.print("Ingrese lugar: ");
                    String lugar = scanner.nextLine();                    
                    System.out.print("Ingrese duración: ");
                    String duracion = scanner.nextLine();                    
                    System.out.print("Ingrese cantidad de asistentes: ");
                    int cantidadAsistentes = scanner.nextInt();
                    scanner.nextLine();
                    //-----------
                    Capacitacion capacitacion = new Capacitacion();
                    contenedor.almacenarCapacitacion(capacitacion);
                    //-----------
                    System.out.println("Los datos ingresados son: Identificador"
                            + " de la capacitacion: " + identificador + ", RUT: "
                            + rutCliente + ", Día y hora: " + dia + " " + hora
                            + ", Lugar: " + lugar + ", Duracion: " + duracion
                            + ", Cantidad de asistentes: " + cantidadAsistentes);
                    contenedor.guardarCapacitaciones();
                    //-----------
                }
                    
                case 5-> { //Eliminar Usuario
                    System.out.print("Ingrese RUT del usuario a eliminar: ");
                    int rut = scanner.nextInt();
                    scanner.nextLine();
                    contenedor.eliminarUsuario(rut);
                    
                    //guardar los cambios después de eliminar
                    contenedor.guardarClientes();
                    contenedor.guardarProfesionales();
                    contenedor.guardarAdministrativos();
                }
                    
                case 6-> { //Listar Usuarios
                    contenedor.listarUsuarios();
                }
                    
                case 7-> { //Listar Usuarios por Tipo
                    System.out.print("Ingrese el tipo de usuario"
                            + " (cliente/profesional/administrativo): ");
                    String tipoUsuario = scanner.nextLine();
                    contenedor.listarUsuariosPorTipo(tipoUsuario);
                }
                    
                case 8-> { //Listar Capacitaciones
                    contenedor.listarCapacitaciones();
                }
                    
                case 9-> { //Salir
                    System.out.println("Saliendo...");
                }
                    
                default-> {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            }
        //fin switch case
            
        } while (opcion != 9);    
        
        scanner.close();
        
        //almacenamiento de datos ingresado en ciclo do while
        contenedor.cargarClientes();
        contenedor.cargarProfesionales();
        contenedor.cargarAdministrativos();
        contenedor.cargarUsuarios();
        contenedor.cargarCapacitaciones();
        contenedor.cargarEliminarUsuarios();
        contenedor.cargarListarUsuariosPorTipo();
        contenedor.cargarListarCapacitaciones();

        
    }
    
}
