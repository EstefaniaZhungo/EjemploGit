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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author estef
 */
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Servidor {
    private ServerSocket servidor;
    private Map<String, String> map;

    public Servidor() throws IOException {
        this.servidor = new ServerSocket(5000);
        this.map = new HashMap<>();
        cargarDiccionario();
    }

    public void cargarDiccionario() {
        map.put("nombre", "Gloria");
        map.put("curso", "B Nocturno");
        map.put("proyecto", "Sistema de Biblioteca");
    }

    public void iniciar() {
        System.out.println("Servidor iniciado en el puerto 5000, esperando clientes...");
        while (true) {
            try {
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado.");

                // Crear streams para recibir y enviar datos
                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

                // Leer la clave enviada por el cliente
                String clave = in.readLine();
                System.out.println("Clave recibida: " + clave);

                // Buscar el valor en el diccionario
                String valor = map.getOrDefault(clave, "Clave no encontrada");

                // Enviar el valor al cliente
                out.println(valor);

                // Cerrar la conexión con el cliente
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            servidor.iniciar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

