package com.mirea.kt.android.a2_12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    private ArrayList<Phones> phones;

    public PhoneAdapter(ArrayList<Phones> phones) {
        this.phones = phones;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelView;
        private final TextView sNumerView;
        private final TextView priceView;

        ViewHolder(View view){
            super(view);
            modelView = view.findViewById(R.id.tvPhoneModel);
            sNumerView = view.findViewById(R.id.tvPnoneSNumber);
            priceView = view.findViewById(R.id.tvPnonePricer);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneAdapter.ViewHolder holder, int position) {
    Phones phone = phones.get(position);
    holder.modelView.setText(String.format("%s %s", phone.getModel(), phone.getSerialNumber()));
    holder.priceView.setText(String.format("%d рублей", phone.getPrice()));
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }
}
