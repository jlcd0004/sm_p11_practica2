package com.practica2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento extends Fragment {

		/**
		 * En 'fragmento' se presenta la información de la práctica.
		 * */
	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		return i.inflate(R.layout.fragmento, c, false);

	}

}