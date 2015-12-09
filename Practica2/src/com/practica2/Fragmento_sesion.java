package com.practica2;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fragmento_sesion extends Fragment {

	/**
	 * En 'fragmento_sesion' se presentan al usuario cuatro campos de escritura
	 * para que introduzca su nombre de usuario,contraseña,dirección IP de la
	 * máquina donde se ejecuta el servidor y puerto donde este escucha. Cada
	 * uno de estos campos se asocia con un objeto de la clase 'EditText'. Al
	 * pulsar 'button2', se obtiene el contenido de los campos de escritura y se
	 * pasa a String para guardarlo. Posteriormente se crea un objeto de la
	 * clase 'Intent' para cambiar la vista a 'activity_2' y pasarle los datos
	 * obtenidos.
	 * */
	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		View v = i.inflate(R.layout.fragmento_sesion, c, false);
		Button bot = (Button) v.findViewById(R.id.button2);
		final EditText user = (EditText) v.findViewById(R.id.numero1);
		final EditText pass = (EditText) v.findViewById(R.id.numero2);
		final EditText ip = (EditText) v.findViewById(R.id.editText3);
		final EditText port = (EditText) v.findViewById(R.id.editText4);
		bot.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("NewApi")
			public void onClick(View view) {
				String us = user.getText().toString();
				String key = pass.getText().toString();
				String dir = ip.getText().toString();
				String puerto = port.getText().toString();
				//if(!us.isEmpty() && !key.isEmpty() && !dir.isEmpty() && !puerto.isEmpty()){
				Intent i = new Intent(view.getContext(), Activity2.class);
				i.putExtra("usr", us);
				i.putExtra("pas", key);
				i.putExtra("dir", dir);
				i.putExtra("port", puerto);
				startActivity(i);
				//}
				}
			
			

		});
		return v;
	}
}