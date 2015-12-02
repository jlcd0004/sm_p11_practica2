package com.practica2;

import java.io.IOException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

		Bundle bundle = getIntent().getExtras();

		this.usr = bundle.getString("usr");
		this.pas = bundle.getString("pas");
		this.dir = bundle.getString("dir");
		this.port = bundle.getString("port");
		
		FragmentManager fragmentManager2 = getFragmentManager();
		FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
		
		Fragmento_user f_user = new Fragmento_user();
		Fragmento_opera f_opera = new Fragmento_opera();
		Fragment frag_u = fragmentManager2.findFragmentById(R.id.contain2);
		Fragment frag_o = fragmentManager2.findFragmentById(R.id.contain);
		if (frag_u == null && frag_o == null) {
		transaction2.add(R.id.contain2, f_user);
		transaction2.add(R.id.contain, f_opera);
		transaction2.commit();
		}

		new Thread(new Runnable() {
			public void run() {
				try {
					int port2 = Integer.parseInt(port);
					C_socket con = new C_socket();

					con.conect(dir, port2);
					con.entrada.readLine();
					String en = con.entrada.readLine();
					

				} catch (UnknownHostException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();

		
	}

}
