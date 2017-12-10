package com.ecbook.proyectoecbook.proyectoecbook.Explorar;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ecbook.proyectoecbook.R;
import com.ecbook.proyectoecbook.proyectoecbook.InfoBooks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class ExplorarFragment extends Fragment implements RecyclerViewOnClickListener{
    RecyclerView rv;
    //Toolbar toolbar;

    List<InfoBooks> libros;
    AdapterExplorar adapter;
    Context context;

    Button btnVENTA, btnINTERCAMBIO;

    /*Spinner spinner;
    int posicion=0;
    String[] tipoVentIntercam = new String[2];*/

    /*private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;*/

    public static String telefono = "telefono";
    public static String email = "email";

    public final static String FIREBASE_REFERENCES = "Libro_VENTA";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(FIREBASE_REFERENCES);

    public final static String FIREBASE_REFERENCES2 = "Libro_INTERCAMBIO";
    FirebaseDatabase database2 = FirebaseDatabase.getInstance();
    DatabaseReference myRef2 = database2.getReference(FIREBASE_REFERENCES2);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_explorar, container, false);
        btnVENTA = (Button) rootView.findViewById(R.id.btnVENTA);
        btnINTERCAMBIO = (Button) rootView.findViewById(R.id.btnINTERCAMBIO);


        refresh(rootView);

        libros = new ArrayList<>();

        final AdapterExplorar adapter = new AdapterExplorar(libros);

        adapter.setRecyclerViewOnClickListener(this);

        myRef.child(FIREBASE_REFERENCES);
        myRef2.child(FIREBASE_REFERENCES2);
        rv.setAdapter(adapter);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                libros.add(libro);
                refresh(rootView);
                rv.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                libros.add(libro);
                refresh(rootView);
                rv.setAdapter(adapter);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        myRef2.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                libros.add(libro);
                refresh(rootView);
                rv.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                libros.add(libro);
                refresh(rootView);
                rv.setAdapter(adapter);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnVENTA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("antes de limpiar ", String.valueOf(libros));
                clear2();

                refresh(rootView);
                libros = new ArrayList<>();

                final AdapterExplorar adapter = new AdapterExplorar(libros);

                myRef.child(FIREBASE_REFERENCES);
                rv.setAdapter(adapter);

                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                        libros.add(libro);
                        refresh(rootView);
                        rv.setAdapter(adapter);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                        libros.add(libro);
                        refresh(rootView);
                        rv.setAdapter(adapter);
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        adapter.setRecyclerViewOnClickListener(this);

        btnINTERCAMBIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh(rootView);

                libros = new ArrayList<>();

                final AdapterExplorar adapter = new AdapterExplorar(libros);

                //adapter.setRecyclerViewOnClickListener(this);

                myRef2.child(FIREBASE_REFERENCES2);
                rv.setAdapter(adapter);

                myRef2.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                        libros.add(libro);
                        refresh(rootView);
                        rv.setAdapter(adapter);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        InfoBooks libro = dataSnapshot.getValue(InfoBooks.class);
                        libros.add(libro);
                        refresh(rootView);
                        rv.setAdapter(adapter);
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        /*toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //setContentView(R.layout.fragment_explorar);
        //toolbarCard = (Toolbar) rootView.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbarCard);

        //linearLayoutDetails = (ViewGroup) rootView.findViewById(R.id.linearLayoutDetails);
        //imageViewExpand = (ImageView) rootView.findViewById(R.id.imageViewExpand);

        /*Toolbar toolbarCard = (Toolbar) rootView.findViewById(R.id.toolbarCard);
        toolbarCard.setTitle("Hola");
        toolbarCard.setSubtitle("Ejemplo");
        toolbarCard.inflateMenu(R.menu.card_menu);*/

        /*rv = (RecyclerView)rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(context));*/


        //PARA EL MENU TOOLBAR
        /*toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_option1:
                        Toast.makeText(getContext(),"funciona1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option2:
                        Toast.makeText(getContext(),"funciona2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option3:
                        Toast.makeText(getContext(),"funciona3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });*/


        return rootView;
    }


    @Override
    public void onClickListener(View view, int position) {
        Toast.makeText(getContext(),"funciona", Toast.LENGTH_SHORT).show();
        hacerIntent(position);
    }



    private void refresh(View rootView) {
        rv = (RecyclerView)rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(context));
    }

    /*public void setSupportActionBar(Toolbar supportActionBar) {
        Toolbar supportActionBar1 = supportActionBar;
    }*/

    public void hacerIntent (int position){
        String telfA = String.format(libros.get(position).getTelefono(), telefono);
        String resA = String.format(libros.get(position).getEmail(), email);

        Intent i = new Intent(getActivity(), Pop.class);
        i.putExtra(telefono, telfA);
        i.putExtra(email, resA);
        startActivity(i);
    }

    //PARA EL EXPANDIR
    /*public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }*/

    /*public void clear() {
            int size = this.libros.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    this.libros.remove(0);
                }

                this.notifyItemRangeRemoved(0, size);
            }
        }*/


    private  void clear2(){
        libros.clear();
        rv.setAdapter(new AdapterExplorar(getActivity(), new ArrayList<InfoBooks>()));
    }
}
