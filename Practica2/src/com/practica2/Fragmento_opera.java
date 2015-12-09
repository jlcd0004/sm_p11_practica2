package com.practica2;

/*import java.io.IOException;
import java.net.UnknownHostException;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragmento_opera extends Fragment {
	String num1;
	String num2;
	Boolean cuad;
	String usr,pas,dir,port;
	
	public View onCreateView(LayoutInflater i, ViewGroup c,
			Bundle savedInstanceState) {
		View v = i.inflate(R.layout.fragmento_opera, c, false);
		Bundle bundle = this.getArguments();	
		this.usr =bundle.getString("usr");
		this.pas =bundle.getString("pas");
		this.dir =bundle.getString("dir");
		this.port =bundle.getString("port");
		TextView a = (TextView) v.findViewById(R.id.un);
		TextView b = (TextView) v.findViewById(R.id.dos);
		TextView c1 = (TextView) v.findViewById(R.id.tres);
		TextView d = (TextView) v.findViewById(R.id.cuatro);
		a.setText(usr);
		b.setText(pas);
		c1.setText(dir);
		d.setText(port);
		
		
		this.cuad =bundle.getBoolean("cuad");
		this.num1 =bundle.getString("num1");
		this.num2 =bundle.getString("num2");
		
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
		
		return v;
	}

}*/
