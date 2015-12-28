package com.practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class C_socket {

	Socket sc = new Socket();

	DataOutputStream salida;

	DataInputStream entrada;

	public void conect(String HOST, int PUERTO) throws UnknownHostException,
			IOException {
		boolean serv;
		sc = new Socket(HOST, PUERTO);

		salida = new DataOutputStream(sc.getOutputStream());
		entrada = new DataInputStream(sc.getInputStream());
		 serv = sc.isConnected();
		

	}
	
}
