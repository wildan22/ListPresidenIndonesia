package com.kelompok3.listpresidenindonesia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PresidenAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Presiden> presiden;

    public void setPresiden(ArrayList<Presiden> presiden) {
        this.presiden = presiden;
    }

    public PresidenAdapter(Context context) {
        this.context = context;
        presiden = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return presiden.size();
    }

    @Override
    public Object getItem(int i) {
        return presiden.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_data,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Presiden presiden = (Presiden)getItem(i);
        viewHolder.bind(presiden);
        return view;
    }

    private class ViewHolder{
        private TextView txtName;
        private TextView txtMasaJabatan;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_nama_presiden);
            txtMasaJabatan = view.findViewById(R.id.txt_periode);
            imgPhoto = view.findViewById(R.id.img_view);
        }
        void bind(Presiden presiden){
            txtName.setText(presiden.getNama());
            txtMasaJabatan.setText(presiden.getMasa_jabatan());
            imgPhoto.setImageResource(presiden.getPhoto());
        }

    }
}
