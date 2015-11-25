package com.practica2;

import java.io.IOException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends Activity {
	String usr;
	String pas;
	String dir;
	String port;

	/**
	 * Este método se ejecuta al iniciar 'activity_2',se obtienen los datos de
	 * 'fragmento_sesion' con el método 'getString' de la clase 'Bundle' y se
	 * presentan al usuario los datos obtenidos de los campos de escritura de
	 * 'fragmento_sesion' con el método 'setText'. Posteriormente se gestionara
	 * una conexión a un servicio remoto con estos datos.
	 * 
	 * */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);

		final TextView usuario = (TextView) findViewById(R.id.textView1);
		final TextView key = (TextView) findViewById(R.id.textView3);
		final TextView IP = (TextView) findViewById(R.id.textView4);
		final TextView puerto = (TextView) findViewById(R.id.textView5);

		Bundle bundle = getIntent().getExtras();

		this.usr = bundle.getString("usr");
		this.pas = bundle.getString("pas");
		this.dir = bundle.getString("dir");
		this.port = bundle.getString("port");

		new Thread(new Runnable() {
			public void run() {

				int port2 = Integer.parseInt(port);
				C_socket con = new C_socket();

				try {
					con.conect(dir, port2);
					con.entrada.readLine();
					String en = con.entrada.readLine();
					usuario.setText(en);

				} catch (UnknownHostException e) {

					e.printStackTrace();
					
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();

		IP.setText(dir);
		puerto.setText(port);

	}

}
