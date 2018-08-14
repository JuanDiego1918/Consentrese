package com.example.juand.consentrese;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.ArrayList;
import java.util.Random;

public class MedioActivity extends AppCompatActivity {

    ImageButton img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;
    Conexion con;
    ArrayList<UserVo> lista;
    SQLiteDatabase bd;
    ImageView imagenActual, imagenAnterior;
    Drawable parejas[] = new Drawable[12], defecto;
    int asignacion1, asignacion2, asignacion3, asignacion4, asignacion5, asignacion6;
    int onClick = 0;
    int cantidadparejas, puntajeGa, num, asignados, n;
    CountDownTimer timer;
    TextView jugador1, jugador2, puntaje1, puntaje2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio);
        defecto = getResources().getDrawable(R.drawable.pregunta);
        img1 = findViewById(R.id.btn1m);
        img2 = findViewById(R.id.btn2m);
        img3 = findViewById(R.id.btn3m);
        img4 = findViewById(R.id.btn4m);
        img5 = findViewById(R.id.btn5m);
        img6 = findViewById(R.id.btn6m);
        img7 = findViewById(R.id.btn7m);
        img8 = findViewById(R.id.btn8m);
        img9 = findViewById(R.id.btn9m);
        img10 = findViewById(R.id.btn10m);
        img11 = findViewById(R.id.btn11m);
        img12 = findViewById(R.id.btn12m);
        jugador1 = findViewById(R.id.jugador1);
        jugador2 = findViewById(R.id.jugador2);
        puntaje1 = findViewById(R.id.puntaje);
        puntaje2 = findViewById(R.id.puntaje2);

        jugador1.setText(" " + Usuarios.player1);
        jugador2.setText(" " + Usuarios.player2);

        generarnumero();
        asignarParejasAleatorias();
        if (Usuarios.numeroj == num) {
            if (Usuarios.numeroj == 1) {
                Usuarios.numeroj = 2;
            } else {
                Usuarios.numeroj = 1;
            }
        } else {
            Usuarios.numeroj = num;
        }

        if (Usuarios.numeroj == 1) {
            jugador1.setTextColor(Color.GREEN);
            puntaje1.setTextColor(Color.GREEN);
            jugador2.setTextColor(Color.GRAY);
            puntaje2.setTextColor(Color.GRAY);
        } else {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
                    if (cantidadparejas == 5) {
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
        puntaje1.setText("Puntaje: "+Usuarios.puntaje1);
        puntaje2.setText("Puntaje: "+Usuarios.puntaje2);
        while (asignados < 12) {
            n = new Random().nextInt(12);
            switch (n + 1) {
                case 1:
                    while (asignacion1 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img1);
                        asignados++;
                        asignacion1++;
                    }
                    break;
                case 2:
                    while (asignacion2 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img2);
                        asignados++;
                        asignacion2++;
                    }
                    break;
                case 3:
                    while (asignacion3 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img3);
                        asignados++;
                        asignacion3++;
                    }
                    break;
                case 4:
                    while (asignacion4 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img4);
                        asignados++;
                        asignacion4++;
                    }
                    break;
                case 5:
                    while (asignacion5 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img5);
                        asignados++;
                        asignacion5++;
                    }
                    break;
                case 6:
                    while (asignacion6 < 2) {
                        int posicion = new Random().nextInt(12);
                        while (parejas[posicion] != null) {
                            posicion = new Random().nextInt(12);
                        }
                        parejas[posicion] = getResources().getDrawable(R.drawable.img6);
                        asignados++;
                        asignacion6++;
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
                    imagenActual.setImageDrawable(defecto);
                    imagenAnterior.setImageDrawable(defecto);
                    puntajeGa = puntajeGa - 1;
                    if (Usuarios.numeroj == 1) {
                        puntaje1.setText("Puntaje :" + puntajeGa);
                    } else {
                        puntaje2.setText("Puntaje :" + puntajeGa);
                    }
                    imagenAnterior.setEnabled(true);
                    imagenActual.setEnabled(true);
                } else {
                    puntajeGa = puntajeGa + 100;
                    if (Usuarios.numeroj == 1) {
                        puntaje1.setText("Puntaje :" + puntajeGa);
                    } else {
                        puntaje2.setText("Puntaje :" + puntajeGa);
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
