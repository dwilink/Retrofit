package com.dev.kodok.kontak.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dev.kodok.kontak.R;
import com.dev.kodok.kontak.model.pojo.Kontak;

import java.util.List;

/**
 * Created by root on 24/08/17.
 */

public class AdapterKontak extends BaseAdapter {
    private List<Kontak> kontaks;
    private Context context;

    public AdapterKontak (Context context, List<Kontak> kontaks){
        this.context = context;
        this.kontaks = kontaks;
    }

    @Override
    public int getCount() {
        return kontaks.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_kontak, parent, false);
        TextView tvFirstName = (TextView) view.findViewById(R.id.tvFirstName);
        TextView tvLastName = (TextView) view.findViewById(R.id.tvLastName);
        TextView tvGender = (TextView) view.findViewById(R.id.tvGender);
        TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        ImageView ivKontak = (ImageView) view.findViewById(R.id.ivAvatar);

        Kontak kontak = kontaks.get(position);
        tvFirstName.setText(kontak.getFirstName());
        tvLastName.setText(kontak.getLastName());
        tvGender.setText(kontak.getGender());
        tvEmail.setText(kontak.getEmail());

        Glide.with(context)
                .load(kontak.getAvatar())
                .into(ivKontak);


        System.out.println("first nama "+kontak.getFirstName());

        return view;
    }
}
