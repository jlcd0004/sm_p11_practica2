package com.practica2;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends Activity {
	String usr;
	String pas;
	String dir;
	String port;
	String o;
	String o2;
	String suma;
	String resta;
	String multi;

	final C_socket con = new C_socket();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_2);

		Bundle bundle = getIntent().getExtras();

		Button cerrar = (Button) findViewById(R.id.cerrar);
		this.usr = bundle.getString("usr");
		this.pas = bundle.getString("pas");
		this.dir = bundle.getString("dir");
		this.port = bundle.getString("port");
		final int port2 = Integer.parseInt(port);

		new Thread(new Runnable() {
			public void run() {
				try {
					con.conect(dir, port2);
					con.entrada.readUTF();
					con.salida.writeBytes("usr " + usr + "\r\n");
					con.salida.writeBytes("pas " + pas + "\r\n");
					String a = con.entrada.readUTF();
					String b = con.entrada.readUTF();

				} catch (UnknownHostException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}).start();
		ImageButton bot = (ImageButton) findViewById(R.id.imageButton1);

		bot.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new Thread(new Runnable() {
					public void run() {
						try {
							CheckBox cuadr = (CheckBox) findViewById(R.id.checkBox1);
							EditText num1 = (EditText) findViewById(R.id.editText1);
							EditText num2 = (EditText) findViewById(R.id.editText2);
							final TextView sum = (TextView) findViewById(R.id.textView5);
							final TextView mul = (TextView) findViewById(R.id.textView6);
							final TextView res = (TextView) findViewById(R.id.textView7);
							if (!cuadr.isChecked()) {

								con.salida.writeBytes("opera " + num1.getText()
										+ " " + num2.getText() + "\r\n");

								o = con.entrada.readUTF();

								Scanner scan = new Scanner(o);
								scan.next();
								suma = scan.next();
								scan.next();
								multi = scan.next();
								scan.next();
								resta = scan.next();

							} else {
								con.salida.writeBytes("opera2 "
										+ num1.getText() + " " + num2.getText()
										+ "\r\n");

								o2 = con.entrada.readUTF();
								Scanner scan2 = new Scanner(o2);
								scan2.next();
								suma = scan2.next();
								scan2.next();
								multi = scan2.next();
								scan2.next();
								resta = scan2.next();
							}
							sum.post(new Runnable() {
								public void run() {
									sum.setText(suma);
								}
							});
							mul.post(new Runnable() {
								public void run() {
									mul.setText(multi);
								}
							});
							res.post(new Runnable() {
								public void run() {
									res.setText(resta);
								}
							});
						} catch (IOException e) {

							e.printStackTrace();
						}
					}
				}).start();

			}
		});

		cerrar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent i = new Intent(view.getContext(), MainActivity.class);
				try {

					con.sc.close();
					
				} catch (IOException e) {

					e.printStackTrace();
				}
				startActivity(i);

			}

		});

	}

}
