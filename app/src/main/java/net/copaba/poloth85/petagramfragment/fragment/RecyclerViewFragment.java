package net.copaba.poloth85.petagramfragment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import net.copaba.poloth85.petagramfragment.Activity2;
import net.copaba.poloth85.petagramfragment.R;
import net.copaba.poloth85.petagramfragment.adapter.PetAdaptador;
import net.copaba.poloth85.petagramfragment.pojo.Pet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Polo on 23/08/16.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList<Pet> pets;
    private RecyclerView rvPets;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        rvPets = (RecyclerView) view.findViewById(R.id.rvPetagram);


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvPets.setLayoutManager(llm);
        inicializaListaPets();
        inicializaAdaptador(view);



        return view;
    }
    public PetAdaptador adaptador;
    public void inicializaAdaptador(View view){
        adaptador = new PetAdaptador(pets,getActivity());
        RecyclerView rvPets = (RecyclerView) view.findViewById(R.id.rvPetagram);
        rvPets.setAdapter(adaptador);
    }
    public void inicializaListaPets(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Lola", R.drawable.dog_6,6));
        pets.add(new Pet("Caris",R.drawable.dog_5,5));
        pets.add(new Pet("Yordi", R.drawable.dog_4,4));
        pets.add(new Pet("Mimi", R.drawable.dog_3,3));
        pets.add(new Pet("Mike", R.drawable.dog_2,2));
        pets.add(new Pet("Teo", R.drawable.dog_1,1));
    }
    public void irActivity2(View view) {
    //Mandamos al segundo activity solo las utimas 5 mascotas que se marcarn como favoritas
        ArrayList<Pet> pet = new ArrayList<Pet>();
        if(adaptador.petsFav != null && adaptador.petsFav.size()>5){
            for(int i = adaptador.petsFav.size()-5; i < adaptador.petsFav.size(); i++){
                pet.add(adaptador.petsFav.get(i));
            }
        }else {
            pet = adaptador.petsFav;
        }

        Bundle extra = new Bundle();
        extra.putSerializable("pets",(Serializable) pet);
        Intent intent =  new Intent(view.getContext(),Activity2.class);
        intent.putExtra("extra",extra);
        startActivity(intent);
    }

}
