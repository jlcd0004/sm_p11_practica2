package com.practica2;

/*import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;

public class Fragmento_user extends Fragment {

	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		View v = i.inflate(R.layout.fragmento_user, c, false);
				
	
		Button bot2 = (Button) v.findViewById(R.id.button1);
		final EditText num1 = (EditText) v.findViewById(R.id.numero1);
		final EditText num2 = (EditText) v.findViewById(R.id.numero2);
		final Checkable cuad = (Checkable) v.findViewById(R.id.checkBox1);
		bot2.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				String n1 = num1.getText().toString();
				String n2 = num2.getText().toString();
				Boolean cuadr = cuad.isChecked();
				Fragmento_opera fragment = new Fragmento_opera();
				Bundle bundle2 = new Bundle();
				bundle2.putString("num1", n1);
				bundle2.putString("num2", n2);
				bundle2.putBoolean("cuad",cuadr);
				fragment.setArguments(bundle2);
			}

		});

		return v;
	}

}*/
