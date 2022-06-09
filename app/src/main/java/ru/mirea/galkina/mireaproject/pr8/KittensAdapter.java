package ru.mirea.galkina.mireaproject.pr8;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.galkina.mireaproject.R;

public class KittensAdapter extends RecyclerView.Adapter<KittensAdapter.KittensViewHolder>{
    private List<Kittens> kittens;

    public KittensAdapter(List<Kittens> kittens){
        this.kittens = kittens;
    }

    @NonNull
    @Override
    public KittensAdapter.KittensViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.kittens_list, parent, false);

        return new KittensAdapter.KittensViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull KittensAdapter.KittensViewHolder holder, int position) {
        Kittens kitten = kittens.get(position);
        holder.name.setText(kitten.name);
        holder.breed.setText(kitten.breed);
        holder.color.setText(kitten.color);
        holder.age.setText(kitten.age);
    }

    @Override
    public int getItemCount() {
        return kittens.size();
    }

    public static class KittensViewHolder extends RecyclerView.ViewHolder{
        public final TextView name;
        public final TextView breed;
        public final TextView color;
        public final TextView age;

        public KittensViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            breed = (TextView) itemView.findViewById(R.id.breed);
            color = (TextView) itemView.findViewById(R.id.color);
            age = (TextView) itemView.findViewById(R.id.age);
        }
    }
}
