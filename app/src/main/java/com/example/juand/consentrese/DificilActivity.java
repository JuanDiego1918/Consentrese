package com.example.juand.consentrese;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DificilActivity extends AppCompatActivity {

    ImageButton img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16;
    ImageView imagenActual, imagenAnterior;
    TextView jugador1, jugador2, puntaje1, puntaje2, movimientos1, movimientos2;
    Drawable parejas[] = new Drawable[16], defecto;
    int asignados, asignado1, asignado2, asignado3, asignado4, asignado5, asignado6,asignado8,asignado7, n, num, onClick, puntajeGa;
    int cantidadparejas;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificil);

        defecto = getResources().getDrawable(R.drawable.pregunta);
        img1 = findViewById(R.id.btn1d);
        img2 = findViewById(R.id.btn2d);
        img3 = findViewById(R.id.btn3d);
        img4 = findViewById(R.id.btn4d);
        img5 = findViewById(R.id.btn5d);
        img6 = findViewById(R.id.btn6d);
        img7 = findViewById(R.id.btn7d);
        img8 = findViewById(R.id.btn8d);
        img9 = findViewById(R.id.btn9d);
        img10 = findViewById(R.id.btn10d);
        img11 = findViewById(R.id.btn11d);
        img12 = findViewById(R.id.btn12d);
        img13 = findViewById(R.id.btn13d);
        img14 = findViewById(R.id.btn14d);
        img15 = findViewById(R.id.btn15d);
        img16 = findViewById(R.id.btn16d);
        jugador1 = findViewById(R.id.jugador1);
        jugador2 = findViewById(R.id.jugador2);
        puntaje1 = findViewById(R.id.puntaje);
        puntaje2 = findViewById(R.id.puntaje2);

        jugador2.setText(""+Usuarios.player2);
        jugador1.setText(""+Usuarios.player1);
        generarnumero();
        asignarParejasAleatorias();

        if (Usuarios.numeroj==num){
            if (Usuarios.numeroj==1){
                Usuarios.numeroj=2;
            }else{
                Usuarios.numeroj=1;
            }
        }else {
            Usuarios.numeroj=num;
        }

        if (Usuarios.numeroj==1){
            jugador1.setTextColor(Color.GREEN);
            puntaje1.setTextColor(Color.GREEN);
            jugador2.setTextColor(Color.GRAY);
            puntaje2.setTextColor(Color.GRAY);
        }else{
            jugador2.setTextColor(Color.GREEN);
            puntaje2.setTextColor(Color.GREEN);
            jugador1.setTextColor(Color.GRAY);
            puntaje1.setTextColor(Color.GRAY);
        }

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img1.setImageDrawable(parejas[0]);
                    onClick = 1;
                    imagenAnterior = img1;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img1.setImageDrawable(parejas[0]);
                    onClick = 2;
                    imagenActual = img1;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img2.setImageDrawable(parejas[1]);
                    onClick = 1;
                    imagenAnterior = img2;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img2.setImageDrawable(parejas[1]);
                    onClick = 2;
                    imagenActual = img2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img3.setImageDrawable(parejas[2]);
                    imagenAnterior = img3;
                    imagenAnterior.setEnabled(false);
                    onClick = 1;
                } else if (onClick == 1) {
                    img3.setImageDrawable(parejas[2]);
                    imagenActual = img3;
                    onClick = 2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img4.setImageDrawable(parejas[3]);
                    onClick = 1;
                    imagenAnterior = img4;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img4.setImageDrawable(parejas[3]);
                    onClick = 2;
                    imagenActual = img4;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img5.setImageDrawable(parejas[4]);
                    onClick = 1;
                    imagenAnterior = img5;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img5.setImageDrawable(parejas[4]);
                    onClick = 2;
                    imagenActual = img5;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img6.setImageDrawable(parejas[5]);
                    onClick = 1;
                    imagenAnterior = img6;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img6.setImageDrawable(parejas[5]);
                    onClick = 2;
                    imagenActual = img6;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img7.setImageDrawable(parejas[6]);
                    onClick = 1;
                    imagenAnterior = img7;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img7.setImageDrawable(parejas[6]);
                    onClick = 2;
                    imagenActual = img7;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img8.setImageDrawable(parejas[7]);
                    onClick = 1;
                    imagenAnterior = img8;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img8.setImageDrawable(parejas[7]);
                    onClick = 2;
                    imagenActual = img8;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img9.setImageDrawable(parejas[8]);
                    onClick = 1;
                    imagenAnterior = img9;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img9.setImageDrawable(parejas[8]);
                    onClick = 2;
                    imagenActual = img9;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img10.setImageDrawable(parejas[9]);
                    onClick = 1;
                    imagenAnterior = img10;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img10.setImageDrawable(parejas[9]);
                    onClick = 2;
                    imagenActual = img10;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img11.setImageDrawable(parejas[10]);
                    onClick = 1;
                    imagenAnterior = img11;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img11.setImageDrawable(parejas[10]);
                    onClick = 2;
                    imagenActual = img11;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick == 0) {
                    img12.setImageDrawable(parejas[11]);
                    onClick = 1;
                    imagenAnterior = img12;
                    imagenAnterior.setEnabled(false);
                } else if (onClick == 1) {
                    img12.setImageDrawable(parejas[11]);
                    onClick = 2;
                    imagenActual = img12;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas == 7) {
                        termina();
                    }
                }
            }
        });

        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    img13.setImageDrawable(parejas[12]);
                    imagenAnterior=img13;
                    onClick=1;
                    imagenAnterior.setEnabled(false);
                }else if(onClick==1){
                    img13.setImageDrawable(parejas[12]);
                    imagenActual=img13;
                    onClick=2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas==7){
                        termina();
                    }
                }
            }
        });
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    img14.setImageDrawable(parejas[13]);
                    imagenAnterior=img14;
                    onClick=1;
                    imagenAnterior.setEnabled(false);
                }else if(onClick==1){
                    img14.setImageDrawable(parejas[13]);
                    imagenActual=img14;
                    onClick=2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas==7){
                        termina();
                    }
                }
            }
        });
        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    img15.setImageDrawable(parejas[14]);
                    imagenAnterior=img15;
                    onClick=1;
                    imagenAnterior.setEnabled(false);
                }else if(onClick==1){
                    img15.setImageDrawable(parejas[14]);
                    imagenActual=img15;
                    onClick=2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas==7){
                        termina();
                    }
                }
            }
        });
        img16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick==0){
                    img16.setImageDrawable(parejas[15]);
                    imagenAnterior=img16;
                    onClick=1;
                    imagenAnterior.setEnabled(false);
                }else if(onClick==1){
                    img16.setImageDrawable(parejas[15]);
                    imagenActual=img16;
                    onClick=2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadparejas==7){
                        termina();
                    }
                }
            }
        });

    }

    private void generarnumero() {
        num=(int) (Math.floor(Math.random()*2)+1);
    }

    private void termina() {
        if (Usuarios.numeroj==1){
            Usuarios.puntaje1=puntajeGa+100;
        }else{
            Usuarios.puntaje2=puntajeGa+100;
        }
        if (Usuarios.puntaje1==0 || Usuarios.puntaje2==0){
            recreate();
        }else {
            ventana();
        }

    }

    private void ventana() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Puntaje Final");
        String mensaje = "";
        mensaje += "Player 1 " + Usuarios.player1 + "\n";
        mensaje += "Puntaje  " + Usuarios.puntaje1 + "\n\n";
        mensaje += "Player 2 " + Usuarios.player2 + "\n";
        mensaje += "Puntaje " + Usuarios.puntaje2 + "\n\n";

        if (Usuarios.puntaje2 > Usuarios.puntaje1) {
            mensaje += "GANADOR " + Usuarios.player2;
        } else if (Usuarios.puntaje1 > Usuarios.puntaje2) {
            mensaje += "GANADOR " + Usuarios.player1;
        } else {
            mensaje += "EMPATE " + Usuarios.player2;
        }

        builder.setMessage(mensaje);

        builder.setNeutralButton("Publicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Usuarios.puntaje1=0;
                Usuarios.puntaje2=0;
                Usuarios.numeroj=0;
                Toast.makeText(getApplicationContext(), "Se publicaria en las redes sociales pero no se ha desarrollado", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Usuarios.puntaje1=0;
                Usuarios.puntaje2=0;
                Usuarios.numeroj=0;

                finish();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }

    private void asignarParejasAleatorias() {
        puntaje2.setText("Puntaje "+Usuarios.puntaje2);
        puntaje1.setText("Puntaje "+Usuarios.puntaje1);
        while (asignados < 16) {
            n = new Random().nextInt(16);
            switch (n + 1) {
                case 1:
                    while (asignado1 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img1);
                        asignados++;
                        asignado1++;
                    }
                    break;
                case 2:
                    while (asignado2 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img2);
                        asignados++;
                        asignado2++;
                    }
                    break;
                case 3:
                    while (asignado3 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img3);
                        asignados++;
                        asignado3++;
                    }
                    break;
                case 4:
                    while (asignado4 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img4);
                        asignados++;
                        asignado4++;
                    }
                    break;
                case 5:
                    while (asignado5 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img5);
                        asignados++;
                        asignado5++;
                    }
                    break;
                case 6:
                    while (asignado6 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img6);
                        asignados++;
                        asignado6++;
                    }
                    break;
                case 7:
                    while (asignado7 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img7);
                        asignados++;
                        asignado7++;
                    }
                    break;
                case 8:
                    while (asignado8 < 2) {
                        int posicion = new Random().nextInt(16);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(16);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img8);
                        asignados++;
                        asignado8++;
                    }
                    break;
            }
        }
    }

    public void tiempo() {
        timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (!imagenActual.getDrawable().getConstantState().equals(imagenAnterior.getDrawable().getConstantState())) {
                    imagenAnterior.setImageDrawable(defecto);
                    imagenActual.setImageDrawable(defecto);
                    puntajeGa = puntajeGa - 1;
                    if (Usuarios.numeroj==1){
                        puntaje1.setText("Puntaje "+puntajeGa);
                    }else{
                        puntaje2.setText("Puntaje "+puntajeGa);
                    }
                    imagenActual.setEnabled(true);
                    imagenAnterior.setEnabled(true);
                } else {
                    puntajeGa = puntajeGa + 100;
                    if (Usuarios.numeroj==1){
                        puntaje1.setText("Puntaje "+puntajeGa);
                    }else{
                        puntaje2.setText("Puntaje "+puntajeGa);
                    }
                    imagenActual.setVisibility(View.INVISIBLE);
                    imagenAnterior.setVisibility(View.INVISIBLE);
                    cantidadparejas++;
                }
                onClick = 0;
                timer.cancel();
            }

        };
        timer.start();
    }
}
