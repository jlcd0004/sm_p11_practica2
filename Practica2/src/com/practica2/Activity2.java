package com.practica2;

import java.io.IOException;
import java.net.UnknownHostException;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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

		new Thread(new Runnable() {
			public void run() {
				try {
					int port2 = Integer.parseInt(port);
					final C_socket con = new C_socket();

					con.conect(dir, port2);
					con.salida.writeBytes("usr " + usr + "\r\n");
					con.salida.writeBytes("pas " + pas + "\r\n");

					ImageButton bot = (ImageButton) findViewById(R.id.imageButton1);

					bot.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							try {
								CheckBox cuadr = (CheckBox) findViewById(R.id.checkBox1);
								EditText num1 = (EditText) findViewById(R.id.editText1);
								EditText num2 = (EditText) findViewById(R.id.editText2);
								if (!cuadr.isChecked()) {

									con.salida.writeBytes("opera "
											+ num1.getText() + " "
											+ num2.getText() + "\r\n");

								} else {
									con.salida.writeBytes("opera2 "
											+ num1.getText() + " "
											+ num2.getText() + "\r\n");

								}

							} catch (IOException e) {

								e.printStackTrace();
							}
						}
					});

				} catch (UnknownHostException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();

	}

}
