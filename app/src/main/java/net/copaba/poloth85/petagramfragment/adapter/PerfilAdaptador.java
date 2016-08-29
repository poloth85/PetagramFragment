package net.copaba.poloth85.petagramfragment.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.copaba.poloth85.petagramfragment.R;
import net.copaba.poloth85.petagramfragment.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by Polo on 24/08/16.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Pet> pet;
    Activity activity;

    public PerfilAdaptador(ArrayList<Pet> pet, Activity activity) {
        this.pet = pet;
        this.activity = activity;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new PerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PerfilViewHolder perfilViewHolder, int position) {
        final Pet pet1 = pet.get(position);
        perfilViewHolder.imgFoto.setImageResource(pet1.getFoto());
        perfilViewHolder.tvRaite.setText(String.valueOf(pet1.getRate()));




    }

    @Override
    public int getItemCount() {
        return pet.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRaite;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFotoCv);
            tvRaite = (TextView) itemView.findViewById(R.id.tvRaiteCv);
        }
    }
}
