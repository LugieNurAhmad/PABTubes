package com.example.pabtubes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRekap extends RecyclerView.Adapter<AdapterRekap.RekapViewHolder> {

    private Context mCtx;
    private List<DataRekap> dataRekapList;

    public AdapterRekap(Context mCtx, List<DataRekap> dataRekapList){
        this.mCtx =mCtx;
        this.dataRekapList = dataRekapList;
    }
    @NonNull
    @Override
    public AdapterRekap.RekapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RekapViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.listlayout_profil, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRekap.RekapViewHolder holder, int position) {
        DataRekap dataRekap = dataRekapList.get(position);

        holder.namaRekap.setText(dataRekap.getPenyakit());
    }

    @Override
    public int getItemCount() {
        return dataRekapList.size();
    }

    class RekapViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        TextView namaRekap;
        public RekapViewHolder(View itemView){
            super(itemView);
            namaRekap = itemView.findViewById(R.id.textRekap);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            DataRekap dataRekap =dataRekapList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, RekapData.class);
            intent.putExtra("data_penyakit", dataRekap);
            mCtx.startActivity(intent);
        }
    }
}



//    private Activity context;
//    private List<DataRegis> profilList;
//
//    public AdapterRekap(@NonNull Activity context, List<DataRegis> profilList) {
//        super(context, R.layout.listlayout_profil, profilList);
//        this.context = context;
//        this.profilList =profilList;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//
//        View ListViewItem = inflater.inflate(R.layout.listlayout_profil, null, true);
//
//        TextView textViewNama = (TextView) ListViewItem.findViewById(R.id.tvIsiNama);
//        TextView textViewEmail = (TextView) ListViewItem.findViewById(R.id.tvIsiEmail);
//        TextView textViewGender = (TextView) ListViewItem.findViewById(R.id.tvIsiGender);
//
//        DataRegis profil = profilList.get(position);
//
//        textViewNama.setText(profil.getNama());
//        textViewEmail.setText(profil.getEmail());
//        textViewGender.setText(profil.getGender());
//
//        return ListViewItem;
//    }
