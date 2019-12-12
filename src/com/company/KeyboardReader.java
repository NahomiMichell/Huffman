package com.company;

import java.util.Scanner;

public class KeyboardReader {
    private Scanner scanner;
    private static KeyboardReader instance;

    public KeyboardReader(){
        scanner = new Scanner(System.in);
    }
    public static KeyboardReader getInstance(){
        if (instance == null){
            instance = new KeyboardReader();
        }
        return instance;
    }
    String leerPalabra() {
        return scanner.next();
    }
    String leeerLinea(){
        return scanner.next();
    }
    public int leerEntero(String mensaje, String reintento){
        System.out.println(mensaje);
        do {
            if (scanner.hasNextInt()){
                return scanner.nextInt();
            }
            scanner.next();
            System.out.println(reintento);
        }while (true);
    }
    public double leerFlotante (String mensaje, String reintento){
        System.out.println(mensaje);
        do {
            if(scanner.hasNextDouble()){
                return scanner.nextDouble();
            }
            scanner.next();
            System.out.println(reintento);
        }while (true);
    }
}
