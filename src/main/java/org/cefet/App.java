package org.cefet;

import org.cefet.system.InterfaceInicial;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main( String[] args )

    {
        InterfaceInicial interfaceInicial = new InterfaceInicial();
        interfaceInicial.exibe();
    }
}
