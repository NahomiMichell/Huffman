package com.company;

import Exceptions.EmptyList;
import Exceptions.NullName;
import Exceptions.OutRank;
import Principal.TextCompressor;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, NullName, ClassNotFoundException, OutRank, EmptyList {
        Scanner sc=new Scanner(System.in);
        TextCompressor CDT= new TextCompressor();
        Menu menuu = new Menu();
        int opcion = 0;
        while (opcion != 4){
            opcion = menuu.menu();
            switch (opcion) {
                case 1:
                    LocationFiles to = new LocationFiles();
                    String texto = to.leerTxt("Example.txt");
                    if (texto.length() == 0) {
                        System.out.println("Error. No hay datos que comprimir");
                        throw new NullName();
                    }
                    String[] cadenas = CDT.Comprimir(texto);
                    System.out.println("Direcciones: " + cadenas[0] + "\nCaracteres: " + cadenas[1]);
                    break;
                case 2:
                    System.out.println("El mensaje orginal es: " +CDT.Descomprimir());
                    break;
                case 3:
                    System.out.println("Gracias por usar este programa.");
                    System.out.println("Saliendo...");
                    break;

            }

        }
    }
}
