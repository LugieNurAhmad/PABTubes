package com.example.pabtubes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterProfil extends ArrayAdapter<DataRegis> {
    private Activity context;
    private List<DataRegis> profilList;

    public AdapterProfil(@NonNull Activity context, List<DataRegis> profilList) {
        super(context, R.layout.listlayout_profil, profilList);
        this.context = context;
        this.profilList =profilList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewItem = inflater.inflate(R.layout.listlayout_profil, null, true);

        TextView textViewNama = (TextView) ListViewItem.findViewById(R.id.tvIsiNama);
        TextView textViewEmail = (TextView) ListViewItem.findViewById(R.id.tvIsiEmail);
        TextView textViewGender = (TextView) ListViewItem.findViewById(R.id.tvIsiGender);

        DataRegis profil = profilList.get(position);

        textViewNama.setText(profil.getNama());
        textViewEmail.setText(profil.getEmail());
        textViewGender.setText(profil.getGender());

        return ListViewItem;
    }
}
