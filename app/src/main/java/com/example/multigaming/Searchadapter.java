package com.example.multigaming;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Searchadapter extends RecyclerView.Adapter<Searchadapter.Searchviewholder> implements Filterable
{
    ArrayList<ElementModel> dataholder;
    ArrayList<ElementModel> searchdataholder;
    private RecycleViewClickListener listener;

    public Searchadapter(ArrayList<ElementModel> dataholder , RecycleViewClickListener listener) {
        this.dataholder = dataholder;
        this.listener = listener;
        searchdataholder = new ArrayList<>(dataholder);
    }

    @NonNull
    @Override
    public Searchviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new Searchviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Searchviewholder holder, int position)
    {
        holder.img.setImageResource(dataholder.get(position).getImageview1());
        String  s = String.valueOf(position);


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    @Override
    public Filter getFilter() {
        Log.d("Kire","abs");
        return exampleFilter;
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<ElementModel> filteredList = new ArrayList<>();
            Log.d("Kire","abs");

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(searchdataholder);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ElementModel item : searchdataholder) {
                    if (item.getgame().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataholder.clear();
            dataholder.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

    class Searchviewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;

        public Searchviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onclick(view,getAdapterPosition());
        }
    }
    public interface RecycleViewClickListener{
        void onclick(View v , int position);
    }
}
