package net.copaba.poloth85.petagramfragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.copaba.poloth85.petagramfragment.R;
import net.copaba.poloth85.petagramfragment.adapter.PerfilAdaptador;
import net.copaba.poloth85.petagramfragment.pojo.Pet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilViewFragment extends Fragment {

    private ArrayList<Pet> pets;
    private RecyclerView rvPerfil;
    private TextView nombre;

    public PerfilViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View view = inflater.inflate(R.layout.fragment_perfil,container,false);
        rvPerfil = (RecyclerView) view.findViewById(R.id.rvPerfil);
        nombre = (TextView) view.findViewById(R.id.tvNombreCv);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);


        rvPerfil.setLayoutManager(glm);
        inicializaListaFotosPets();
        inicializaAdaptador(view);

        return view;
    }
    public PerfilAdaptador adaptador;
    public void inicializaAdaptador(View view){
        adaptador = new PerfilAdaptador(pets,getActivity());
        RecyclerView rvPerfil = (RecyclerView) view.findViewById(R.id.rvPerfil);
        rvPerfil.setAdapter(adaptador);
    }
    public void inicializaListaFotosPets(){
        pets = new ArrayList<Pet>();
        nombre.setText("Caris");
        pets.add(new Pet("Caris", R.drawable.dog_5,6));
        pets.add(new Pet("Caris",R.drawable.dog_5_1,10));
        pets.add(new Pet("Caris", R.drawable.dog_5_2,18));
        pets.add(new Pet("Caris", R.drawable.dog_5_3,25));

    }

}
