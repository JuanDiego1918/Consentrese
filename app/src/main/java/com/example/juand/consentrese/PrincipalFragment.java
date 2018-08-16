package com.example.juand.consentrese;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PrincipalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    View view;
    Activity activity;
    Puente miPuente;
    TextView nombre,nombre2;
    Button ajustes,iniciar,puntajes;
    Bundle miBundle;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrincipalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PrincipalFragment newInstance(String param1, String param2) {
        PrincipalFragment fragment = new PrincipalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_principal, container, false);

        nombre=view.findViewById(R.id.txtNombre);
        nombre2=view.findViewById(R.id.txtNombre2);
        ajustes=view.findViewById(R.id.btnAjusted);
        puntajes=view.findViewById(R.id.btnPuentaje);
        iniciar=view.findViewById(R.id.btnInciar);

        miBundle=getArguments();

        nombre.setText("Player 1 "+Usuarios.player1);
        nombre2.setText("Player 2 "+Usuarios.player2);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // miPuente.pantalla(1,""+miBundle.get("nombre"));
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                //builder.setIcon(R.drawable.logo);
                final CharSequence[] items = new CharSequence[3];

                items[0] = "Facil";
                items[1] = "Medio";
                items[2] = "Dificil";

                builder.setTitle("Seleccione Nivel")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent miIntent=null;
                                if (items[which]=="Facil") {
                                    miIntent=new Intent(getContext(),FacilActivity.class);
                                }else {
                                    if (items[which]=="Medio"){
                                        miIntent=new Intent(getContext(),MedioActivity.class);
                                    }else{
                                        miIntent=new Intent(getContext(),DificilActivity.class);
                                    }
                                }
                                startActivity(miIntent);
                            }
                        });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

        puntajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miPuente.pantalla(1);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.activity = (Activity) context;
            miPuente = (Puente) this.activity;
        }
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
