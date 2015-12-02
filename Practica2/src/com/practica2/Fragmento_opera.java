package com.practica2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragmento_opera extends Fragment {
	String num1;
	String num2;
	Boolean cuad;
	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		View v = i.inflate(R.layout.fragmento_opera, c, false);
		
		Bundle bundle = this.getArguments();
		this.cuad =bundle.getBoolean("cuad");
		this.num1 =bundle.getString("num1");
		this.num2 =bundle.getString("num2");
		
		
		
		return v;
	}

}
