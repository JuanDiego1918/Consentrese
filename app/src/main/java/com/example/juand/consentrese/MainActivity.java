package com.example.juand.consentrese;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AllFragments, Puente {

    Fragment miFragment;
    Dialog primera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primera = new Dialog(getApplicationContext());
        ventanaEmergente1();

    }

    private void ventanaEmergente1() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.ventaja_emergente, (ViewGroup) findViewById(R.id.venta));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);
        builder.setCancelable(false);

        final EditText text = (EditText) layout.findViewById(R.id.player1);

        builder.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Usuarios.player1 = text.getText().toString();
                ventanaEmergente2();
            }
        });

        builder.show();
    }

    private void ventanaEmergente2() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.ventaja_emergente, (ViewGroup) findViewById(R.id.venta));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);
        builder.setCancelable(false);

        final EditText text = (EditText) layout.findViewById(R.id.player1);
        text.setHint("Escriba su nombre jugador 2");
        builder.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Usuarios.player2 = text.getText().toString();
                miFragment = new PrincipalFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, miFragment).commit();
            }
        });

        builder.show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void Usuario(String nombre) {
        miFragment = new PrincipalFragment();
        Bundle miBundle = new Bundle();
        miBundle.putString("nombre", nombre);
        miFragment.setArguments(miBundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, miFragment).commit();
    }

    @Override
    public void pantalla(int numeroPantalla) {
        switch (numeroPantalla) {
            case 1:
                miFragment = new ListaPuntajes();
                break;
            case 6:
                miFragment = new PrincipalFragment();
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, miFragment).commit();
    }
}
