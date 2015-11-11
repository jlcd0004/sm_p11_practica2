package com.practica2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Fragmento2 extends Fragment {

	/**
	 * En 'fragmento2' hay un 'ImageButton'(objeto 'boton') para inicio de
	 * sesión y con el método 'onClick' se cambia esa vista por
	 * 'fragmento_sesion' cuando se pulse 'boton'.
	 * */
	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		View v = i.inflate(R.layout.fragmento2, c, false);

		ImageButton boton = (ImageButton) v.findViewById(R.id.button1);

		boton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {

				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction transaction = fragmentManager
						.beginTransaction();
				Fragmento_sesion frag_s = new Fragmento_sesion();

				transaction.replace(R.id.container, frag_s);
				transaction.commit();

			}

		});

		return v;

	}
}