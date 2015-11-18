package com.practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class C_socket {

	Socket sc;

	DataOutputStream salida;

	DataInputStream entrada;

	public void conect(String HOST, int PUERTO) {

		try {

			sc = new Socket(HOST, PUERTO);

			salida = new DataOutputStream(sc.getOutputStream());
			entrada = new DataInputStream(sc.getInputStream());

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());

		}
	}
}
