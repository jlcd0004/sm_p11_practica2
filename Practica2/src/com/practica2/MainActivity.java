package com.practica2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	/**
	 * Este método es el que se ejecuta al iniciar la aplicación, en él se
	 * añaden de manera dinámica dos fragmentos, 'fragmento' y 'fragmento2' a
	 * sus respectivos contenedores,'container2' y 'container'.
	 * */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();

		Fragmento2 frag2 = new Fragmento2();
		Fragmento frag = new Fragmento();

		Fragment f = fragmentManager.findFragmentById(R.id.container);
		Fragment f2 = fragmentManager.findFragmentById(R.id.container2);

		if (f == null && f2 == null) {
			transaction.add(R.id.container2, frag);

			transaction.add(R.id.container, frag2);

			transaction.commit();
		}
	}

	
}
