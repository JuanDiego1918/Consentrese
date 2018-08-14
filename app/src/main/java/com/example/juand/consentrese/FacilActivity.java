package com.example.juand.consentrese;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FacilActivity extends AppCompatActivity {

    ImageButton image1, image2, image3, image4, image5, image6, image7, image8;
    int asignacion1, asignacion2, asignacion3, asignacion4;
    Drawable pareja[] = new Drawable[8], imagen_ws;
    ImageView imagenAnterior, imagenActual;
    int miClick = 0;
    Chronometer crono;
    CountDownTimer time;
    TextView intentos, intentos2, puntaje, puntaje2, jugador1, jugador2;
    int tipoJuego, cantidadIntentos = 0, cantidadParejas = 0, puntajeGa;
    int num;
    Conexion miConexion;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        miConexion = new Conexion(getApplicationContext(), "Puntaje", null, 1);

        imagen_ws = getResources().getDrawable(R.drawable.pregunta);
        image1 = findViewById(R.id.btn1);
        image2 = findViewById(R.id.btn2);
        image3 = findViewById(R.id.btn3);
        image4 = findViewById(R.id.btn4);
        image5 = findViewById(R.id.btn5);
        image6 = findViewById(R.id.btn6);
        image7 = findViewById(R.id.btn7);
        image8 = findViewById(R.id.btn8);
        crono = findViewById(R.id.crono);
        jugador1 = findViewById(R.id.jugador1);
        jugador2 = findViewById(R.id.jugador2);
        //crono.start();
        intentos = findViewById(R.id.intentos);
        puntaje = findViewById(R.id.puntaje);
        intentos2 = findViewById(R.id.intentos2);
        puntaje2 = findViewById(R.id.puntaje2);

        jugador1.setText("Player 1 " + Usuarios.player1);
        jugador2.setText("Player 2 " + Usuarios.player2);

        generarnumero();
        asignarParejasAleatorias();
        if (Usuarios.numeroj == num) {
            if (Usuarios.numeroj == 1) {
                Usuarios.numeroj = Usuarios.numeroj + 1;
            } else {
                Usuarios.numeroj = Usuarios.numeroj - 1;
            }
        } else {
            Usuarios.numeroj = num;
        }
        if (Usuarios.numeroj == 1) {
            puntaje.setText("Puntaje " + Usuarios.puntaje1);
            puntaje2.setText("Puntaje " + Usuarios.puntaje2);
            jugador1.setTextColor(Color.GREEN);
            intentos.setTextColor(Color.GREEN);
            puntaje.setTextColor(Color.GREEN);
            jugador2.setTextColor(Color.GRAY);
            intentos2.setTextColor(Color.GRAY);
            puntaje2.setTextColor(Color.GRAY);
        } else {
            puntaje.setText("Puntaje " + Usuarios.puntaje1);
            puntaje2.setText("Puntaje " + Usuarios.puntaje2);
            jugador1.setTextColor(Color.GRAY);
            intentos.setTextColor(Color.GRAY);
            puntaje.setTextColor(Color.GRAY);
            jugador2.setTextColor(Color.GREEN);
            intentos2.setTextColor(Color.GREEN);
            puntaje2.setTextColor(Color.GREEN);
        }

        /*if (((SystemClock.elapsedRealtime() - crono.getBase())/1000)==5){
            Toast.makeText(getApplicationContext(),"Tiempo",Toast.LENGTH_SHORT).show();
        }*/
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image1.setImageDrawable(pareja[0]);
                    miClick = 1;
                    imagenAnterior = image1;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image1.setImageDrawable(pareja[0]);
                    miClick = 2;
                    imagenActual = image1;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image2.setImageDrawable(pareja[1]);
                    miClick = 1;
                    imagenAnterior = image2;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image2.setImageDrawable(pareja[1]);
                    miClick = 2;
                    imagenActual = image2;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image3.setImageDrawable(pareja[2]);
                    miClick = 1;
                    imagenAnterior = image3;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image3.setImageDrawable(pareja[2]);
                    miClick = 2;
                    imagenActual = image3;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image4.setImageDrawable(pareja[3]);
                    miClick = 1;
                    imagenAnterior = image4;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image4.setImageDrawable(pareja[3]);
                    miClick = 2;
                    imagenActual = image4;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image5.setImageDrawable(pareja[4]);
                    miClick = 1;
                    imagenAnterior = image5;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image5.setImageDrawable(pareja[4]);
                    miClick = 2;
                    imagenActual = image5;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image6.setImageDrawable(pareja[5]);
                    miClick = 1;
                    imagenAnterior = image6;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image6.setImageDrawable(pareja[5]);
                    miClick = 2;
                    imagenActual = image6;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image7.setImageDrawable(pareja[6]);
                    miClick = 1;
                    imagenAnterior = image7;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image7.setImageDrawable(pareja[6]);
                    miClick = 2;
                    imagenActual = image7;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (miClick == 0) {
                    image8.setImageDrawable(pareja[7]);
                    miClick = 1;
                    imagenAnterior = image8;
                    imagenAnterior.setEnabled(false);
                } else if (miClick == 1) {
                    image8.setImageDrawable(pareja[7]);
                    miClick = 2;
                    imagenActual = image8;
                    imagenActual.setEnabled(false);
                    tiempo();
                    if (cantidadParejas == 3) {
                        termina();
                    }
                }
            }
        });
    }

    private void generarnumero() {
        num = (int) (Math.floor(Math.random() * 2) + 1);
    }

    private void termina() {
        if (Usuarios.numeroj == 1) {
            Usuarios.puntaje1 = puntajeGa+100;
        } else {
            Usuarios.puntaje2 = puntajeGa+100;
        }

        if (Usuarios.puntaje1 == 0 || Usuarios.puntaje2 == 0) {
            recreate();
        } else {
            ventana();
        }
    }

    private void ventana() {
        registar(1);
        registar(2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Puntaje Final");
        String mensaje = null;
        mensaje = "Jugador 1 " + Usuarios.player1 + "\n";
        mensaje += "Puntaje " + Usuarios.puntaje1 + "\n\n";
        mensaje += "Jugador 2 " + Usuarios.player2 + "\n";
        mensaje += "Puntaje " + Usuarios.puntaje2 + "\n\n";
        if (Usuarios.puntaje2 > Usuarios.puntaje1) {
            mensaje += "GANO " + Usuarios.player2;
        } else {
            if (Usuarios.puntaje1 > Usuarios.puntaje2) {
                mensaje += "GANO " + Usuarios.player1;
            } else {
                mensaje += "EMPATE";
            }
        }
        builder.setMessage(mensaje);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Usuarios.puntaje2 = 0;
                Usuarios.puntaje1 = 0;
                Usuarios.numeroj = 0;
            }
        });
        builder.setNeutralButton("Publicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Usuarios.puntaje2 = 0;
                Usuarios.numeroj = 0;
                Usuarios.puntaje1 = 0;
                Toast.makeText(getApplicationContext(), "Se publicaria en las redes sociales pero no se ha desarrollado", Toast.LENGTH_SHORT).show();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }


    int asignados = 0, n = 0;

    // Metodo que realiza las parejas aleatoriamente
    private void asignarParejasAleatorias() {
        while (asignados < 8) {
            puntaje.setText("Puntaje: " + puntajeGa);
            n = new Random().nextInt(8);
            switch (n + 1) {
                case 1:
                    while (asignacion1 < 2) {
                        int posicion = new Random().nextInt(8);
                        while (pareja[posicion] != null) {
                            posicion = new Random().nextInt(8);
                        }
                        pareja[posicion] = getResources().getDrawable(R.drawable.img1);
                        asignados++;
                        asignacion1++;
                    }
                    break;
                case 2:
                    while (asignacion2 < 2) {
                        int posicion = new Random().nextInt(8);
                        while (pareja[posicion] != null) {
                            posicion = new Random().nextInt(8);
                        }
                        pareja[posicion] = getResources().getDrawable(R.drawable.img2);
                        asignados++;
                        asignacion2++;
                    }
                    break;
                case 3:
                    while (asignacion3 < 2) {
                        int posicion = new Random().nextInt(8);
                        while (pareja[posicion] != null) {
                            posicion = new Random().nextInt(8);
                        }
                        pareja[posicion] = getResources().getDrawable(R.drawable.img3);
                        asignados++;
                        asignacion3++;
                    }
                    break;
                case 4:
                    while (asignacion4 < 2) {
                        int posicion = new Random().nextInt(8);
                        while (pareja[posicion] != null) {
                            posicion = new Random().nextInt(8);
                        }
                        pareja[posicion] = getResources().getDrawable(R.drawable.img4);
                        asignados++;
                        asignacion4++;
                    }
                    break;
            }
        }
    }

    public void tiempo() {
        time = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if (!imagenAnterior.getDrawable().getConstantState().equals(imagenActual.getDrawable().getConstantState())) {
                    imagenAnterior.setImageDrawable(imagen_ws);
                    imagenActual.setImageDrawable(imagen_ws);
                    puntajeGa = puntajeGa - 1;
                    if (Usuarios.numeroj == 1) {
                        puntaje.setText("Puntaje: " + puntajeGa);
                    } else {
                        puntaje2.setText("Puntaje: " + puntajeGa);
                    }
                    imagenAnterior.setEnabled(true);
                    imagenActual.setEnabled(true);
                } else {
                    puntajeGa = 100 + puntajeGa;
                    if (Usuarios.numeroj == 1) {
                        puntaje.setText("Puntaje: " + puntajeGa);
                    } else {
                        puntaje2.setText("Puntaje: " + puntajeGa);
                    }
                    imagenActual.setVisibility(View.INVISIBLE);
                    imagenAnterior.setVisibility(View.INVISIBLE);
                    cantidadParejas++;

                }
                miClick = 0;
                time.cancel();
            }
        };
        time.start();
    }

    private void registar(int i) {
        sqLiteDatabase = miConexion.getWritableDatabase();

        ContentValues values = new ContentValues();

        if (i == 1) {
            values.put(Utilidades.NOMBRE_USUARIO, Usuarios.player1);
            values.put(Utilidades.PUNTAJE, Usuarios.puntaje1);
        } else {
            values.put(Utilidades.NOMBRE_USUARIO, Usuarios.player2);
            values.put(Utilidades.PUNTAJE, Usuarios.puntaje2);
        }

        sqLiteDatabase.insert("juegos", Utilidades.PUNTAJE, values);
    }


}
