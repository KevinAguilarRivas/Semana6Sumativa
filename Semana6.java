/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana6;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class Semana6 {
    static int valorEntradaVip = 30000;
    static int valorEntradaPlatea = 15000;
    static int valorEntradaGeneral = 10000;
    static int totalAsientosVip = 20;
    static int totalAsientosPlatea = 20;
    static int totalAsientosGeneral = 20;

    static int asientoReservadoVip;
    static int asientoReservadoPlatea;
    static int asientoReservadoGeneral;
 
 public static class Datos{
     String nombre;
     int edad;
     boolean esEstudiante;
     boolean esTerceraEdad;
     
    public Datos(String nombre, int edad) {    //Breakpoint
        this.nombre = nombre;
        this.edad = edad;
        this.esEstudiante = edad > 0 && edad <= 18;
        this.esTerceraEdad = edad > 60 && edad < 120;
    }
    public void mostrarDatosEntrada() {
    System.out.println("Nombre: " +nombre);
    System.out.println("Edad: "+edad);
    System.out.println("Estudiante?: " + (esEstudiante ? "Sí" : "No"));
    System.out.println("Tercera edad?: " + (esTerceraEdad ? "Sí" : "No"));
 }
 }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Breakpoint
        int opcionMenu;
        int opcionMenuCompraFinal;
        int ubicacion;
        int asientoSeleccionado = 0;
        int valorPagar = 0;
        int edad;
       
        
        System.out.println("Bienvenido al Teatro Moro!");  //Breakpoint
        System.out.println("Estudiantes tienen un descuento de 10%");  
        System.out.println("Tercera edad tienen un descuento de 15%"); 
        System.out.println("");  
        
        do{
        do {
         menuPrincipal();  //Breakpoint
         opcionMenu = scanner.nextInt();
         if (opcionMenu < 1 || opcionMenu > 2){
         caracterInvalido();
         }
         if (opcionMenu == 2) {
        System.out.println("Gracias por visitar el Teatro Moro. ¡Hasta pronto!");
        return;
         }
         }while (opcionMenu < 1 || opcionMenu > 2);
        
        valorPagar = 0;
            
        do{
         System.out.print("Ingrese su edad: ");
         edad = scanner.nextInt();   //Breakpoint
         scanner.nextLine();

         if (edad < 0 || edad > 120){
         caracterInvalido();    
         }
         }while(edad < 0 || edad > 120);
         System.out.print("Ingrese su nombre: ");
         String nombre = scanner.nextLine();
         Datos datos = new Datos(nombre, edad);   //Breakpoint
         

        
         do {           //Seleccion de ubicacion    
         mostrarUbicaciones();
         ubicacion=scanner.nextInt();
         if (ubicacion < 0 || ubicacion > 3){
         caracterInvalido();
         }
         }while (ubicacion < 0 || ubicacion > 3);
         
         
         switch (ubicacion){
             case 1:
                 do{
                 mostrarAsientosVip();
                 asientoSeleccionado=scanner.nextInt();    //Breakpoint
                 if (asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosVip || asientoSeleccionado == asientoReservadoVip){
                     System.out.println("Asiento ya reservado o: ");
                     caracterInvalido();
                 }
                 valorPagar = valorEntradaVip;
                 }while(asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosVip|| asientoSeleccionado == asientoReservadoVip);
                 break;
                 
             case 2:
                 do{
                 mostrarAsientosPlatea();
                 asientoSeleccionado=scanner.nextInt();    //Breakpoint
                 if (asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosPlatea|| asientoSeleccionado == asientoReservadoPlatea){
                     System.out.println("Asiento ya reservado o: ");
                     caracterInvalido();    
                 }
                 valorPagar = valorEntradaPlatea;
                 }while(asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosPlatea|| asientoSeleccionado == asientoReservadoPlatea);
                 break;
                 
             case 3:
                 do{
                 mostrarAsientosGeneral();
                 asientoSeleccionado=scanner.nextInt();      //Breakpoint
                 if (asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosGeneral|| asientoSeleccionado == asientoReservadoGeneral){
                     System.out.println("Asiento ya reservado o: ");
                     caracterInvalido();    
                 }
                 valorPagar = valorEntradaGeneral;
                 }while(asientoSeleccionado < 0 || asientoSeleccionado > totalAsientosGeneral|| asientoSeleccionado == asientoReservadoGeneral);
                 break;
             default:
                 break;
         }
        valorPagar = descuentoEdad(edad, valorPagar);    //Breakpoint
         System.out.println("");

         switch (ubicacion) {  //Impresion de boleta
              
              case 1:
                 System.out.println("=================================");
                 System.out.println("Boleta:");
                 datos.mostrarDatosEntrada();     //Breakpoint
                 detalleCompraVip("VIP", valorEntradaVip, asientoSeleccionado, valorPagar);
                 asientoReservadoVip = 0;
                 asientoReservadoVip += asientoSeleccionado;
                 System.out.println("=================================");
                 break;
                    
              case 2:
                 System.out.println("=================================");
                 System.out.println("Boleta:"); 
                 datos.mostrarDatosEntrada();    //Breakpoint
                 detalleCompraPlatea("Platea", valorEntradaPlatea, asientoSeleccionado, valorPagar);
                 asientoReservadoPlatea = 0;
                 asientoReservadoPlatea += asientoSeleccionado;
                 System.out.println("=================================");
                 break;
                    
              case 3:
                 System.out.println("=================================");
                 System.out.println("Boleta:");     
                 datos.mostrarDatosEntrada();     //Breakpoint
                 detalleCompraGeneral("General", valorEntradaGeneral, asientoSeleccionado, valorPagar);   
                 asientoReservadoGeneral = 0;
                 asientoReservadoGeneral += asientoSeleccionado;
                 System.out.println("=================================");
                 break;
              default:
                  break;
                  
         }
         System.out.println("");
         do{
         menuCompra();
         opcionMenuCompraFinal = scanner.nextInt();      //Breakpoint
         if (opcionMenuCompraFinal < 0 || opcionMenuCompraFinal > 3){
         caracterInvalido();
         }
         }while (opcionMenuCompraFinal < 0 || opcionMenuCompraFinal > 3);    
         
         if(opcionMenuCompraFinal == 2 ){
             valorPagar = editarEntrada(scanner, ubicacion, asientoSeleccionado, edad, datos);
         }else if (opcionMenuCompraFinal == 3 ){
             System.out.println("Gracias por visitar el Teatro Moro. ¡Hasta pronto!");
             opcionMenu = 2;
         }
        
        }while(opcionMenu == 1);
         scanner.close();   //Breakpoint

    }
    
 public static void menuPrincipal(){
    System.out.println("Menu: ");
    System.out.println("1. Comprar entrada. ");
    System.out.println("2. Salir. ");
    System.out.println("Seleccione en base al numero de la opcion: ");
}
 public static void menuCompra(){
    System.out.println("Menu: ");
    System.out.println("1. Realizar nueva compra. ");
    System.out.println("2. Ver/Editar entrada. ");
    System.out.println("3. Salir. ");
    System.out.println("Seleccione en base al numero de la opcion: ");    
 }
 
 public static void mostrarUbicaciones(){
    System.out.println("Seleccione ubicacion: ");
    System.out.println("1.VIP: $" +valorEntradaVip);
    System.out.println("2.Platea: $" +valorEntradaPlatea);
    System.out.println("3.General: $"+valorEntradaGeneral);
 }
 public static void mostrarAsientosVip(){
          System.out.println("Asientos Vip disponibles:");
          for (int i = 1; i <= totalAsientosVip; i++) {
          System.out.print(i + " ");
          if (i % 10 == 0) {
          System.out.println();
          }
          }
          
}
public static void mostrarAsientosPlatea(){
          System.out.println("Asientos Platea disponibles:");
          for (int i = 1; i <= totalAsientosPlatea; i++) {
          System.out.print(i + " ");
          if (i % 10 == 0) {
          System.out.println();
          }
          }
}
public static void mostrarAsientosGeneral(){
          System.out.println("Asientos General disponibles:");
          for (int i = 1; i <= totalAsientosGeneral; i++) {
          System.out.print(i + " ");
          if (i % 10 == 0) {
          System.out.println();
          }
          }
}
 public static void caracterInvalido(){
    System.out.println("La opcion ingresada no es correcta. Volver a intentar.");
 }
 public static int descuentoEdad(int edad, int valorPagar){
         if (edad > 0 && edad <= 18){
         valorPagar -= (valorPagar*10)/100;
         String tipoTarifa = "Estudiante";
         System.out.println("Tipo tarifa: " + tipoTarifa +"( 10% de descuento.)");
         
         }else if (edad < 120 && edad > 60){
         valorPagar -= (valorPagar*15)/100;
         String tipoTarifa = "Tercera edad";
         System.out.println("Tipo tarifa: " + tipoTarifa+"( 15% de descuento.)");
         
         }else {
         String tipoTarifa = "Publico general";
         System.out.println("Tipo tarifa: " + tipoTarifa);
         }
         return valorPagar;
     
 }
 public static void detalleCompraVip(String ubicacion, int valorEntradaVip, int asientoSeleccionado, int valorPagar){
     System.out.println("Ubicacion: VIP.");
     System.out.println("Valor entrada: $" +valorEntradaVip);
     System.out.println("Ubicacion del asiento: " +asientoSeleccionado);
     System.out.println("Precio final a pagar: $" +valorPagar);
     
 }
 public static void detalleCompraPlatea(String ubicacion, int valorEntradaPlatea, int asientoSeleccionado, int valorPagar){
     System.out.println("Valor entrada: $" +valorEntradaPlatea);
     System.out.println("Ubicacion del asiento: " +asientoSeleccionado);
     System.out.println("Ubicacion: Platea.");
     System.out.println("Precio final a pagar: $" +valorPagar);
 }
 public static void detalleCompraGeneral(String ubicacion, int valorEntradaGeneral, int asientoSeleccionado,int valorPagar){
     System.out.println("Valor entrada: $" +valorEntradaGeneral);
     System.out.println("Ubicacion del asiento: " +asientoSeleccionado);
     System.out.println("Ubicacion: General.");
     System.out.println("Precio final a pagar: $" +valorPagar);  
 }
    
    
 public static int editarEntrada(Scanner scanner, int ubicacionActual, int asientoActual, int edad, Datos datos){
     int nuevaUbicacion = ubicacionActual;
     int nuevoAsiento = asientoActual;
     int nuevoValor = 0;
     System.out.println("Que desea editar?");
     System.out.println("1. Ubicacion.");
     System.out.println("2. Asiento.");
     int opcionEditar = scanner.nextInt();  //Breakpoint
     switch (opcionEditar){
         case 1: 
             mostrarUbicaciones();
             nuevaUbicacion = scanner.nextInt();
             break;
         case 2:
             break;
         default:
             caracterInvalido();
             return 0;
     }
     switch (nuevaUbicacion){
         case 1: 
             mostrarAsientosVip();
             nuevoAsiento = scanner.nextInt();
             nuevoValor = valorEntradaVip;
             asientoReservadoVip = nuevoAsiento;
             break;
         case 2:
             mostrarAsientosPlatea();
             nuevoAsiento = scanner.nextInt();
             nuevoValor = valorEntradaPlatea;
             asientoReservadoPlatea = nuevoAsiento;
             break;     
         case 3:
             mostrarAsientosGeneral();
             nuevoAsiento = scanner.nextInt();
             nuevoValor = valorEntradaGeneral;
             asientoReservadoGeneral = nuevoAsiento;
             break;    
     }
     System.out.println("");
     nuevoValor = descuentoEdad(edad, nuevoValor);   //Breakpoint

     switch (nuevaUbicacion){ //Impresion de boleta despues de editar
         case 1:
             System.out.println("=================================");
             System.out.println("Boleta:");
             datos.mostrarDatosEntrada();
             detalleCompraVip("VIP", valorEntradaVip, nuevoAsiento, nuevoValor);
             System.out.println("=================================");
             break;
         case 2:
             System.out.println("=================================");
             System.out.println("Boleta:"); 
             datos.mostrarDatosEntrada();
             detalleCompraPlatea("Platea", valorEntradaPlatea, nuevoAsiento, nuevoValor);
             System.out.println("=================================");
             break;     
         case 3:
             System.out.println("=================================");
             System.out.println("Boleta:");     
             datos.mostrarDatosEntrada();
             detalleCompraGeneral("General", valorEntradaGeneral, nuevoAsiento, nuevoValor);
             System.out.println("=================================");
             break;    
     }
     return nuevoValor;
     
 }
 }
 

 


