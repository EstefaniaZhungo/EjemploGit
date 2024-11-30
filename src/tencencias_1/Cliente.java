/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tencencias_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author estef
 */
import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Conectar al servidor en localhost y puerto 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conectado al servidor.");

            // Crear streams para enviar y recibir datos
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Enviar una clave al servidor
            String clave = "nombre";  // Puedes cambiar esto por otra clave
            out.println(clave);
            System.out.println("Clave enviada: " + clave);

            // Recibir la respuesta del servidor
            String respuesta = in.readLine();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cerrar la conexión
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Cliente(String localhost, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

