package com.yohanesweisang.ajr_mobile_0055.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.yohanesweisang.ajr_mobile_0055.R;
import com.yohanesweisang.ajr_mobile_0055.models.Brosur;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BrosurAdapter extends RecyclerView.Adapter<BrosurAdapter.ViewHolder>
        implements Filterable {

    private List<Brosur> brosurList, filteredBrosurList;
    private Context context;

    public BrosurAdapter(List<Brosur> brosurList, Context context) {
        this.brosurList = brosurList;
        filteredBrosurList = new ArrayList<>(brosurList);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_brosur, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Brosur brosur = filteredBrosurList.get(position);

        holder.tvNamaMobil.setText(brosur.getNama_mobil());
        holder.tvTipeMobil.setText(brosur.getTipe_mobil());
        holder.tvJenisTransmisi.setText(brosur.getJenis_transmisi());
        holder.tvJenisBahanBakar.setText(brosur.getJenis_bahan_bakar());
        holder.tvWarna.setText(brosur.getWarna());

        if(TextUtils.isEmpty(brosur.getVolume_bagasi()))
        {
            holder.tvVolumeBagasi.setText("-");
        }else
            {
            holder.tvVolumeBagasi.setText(brosur.getVolume_bagasi());
        }

        if(TextUtils.isEmpty(brosur.getFasilitas()))
        {
            holder.tvFasilitas.setText("-");
        }else
        {
            holder.tvFasilitas.setText(brosur.getFasilitas());
        }

        DecimalFormat rupiahFormat = (DecimalFormat) DecimalFormat
                .getCurrencyInstance(new Locale("in", "ID"));
        holder.tvHargaSewa.setText(rupiahFormat.format(brosur.getHarga_sewa()));

//        holder.cvBrosur.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, AddEditActivity.class);
//                i.putExtra("id", brosur.getId());
//
//                if (context instanceof MainActivity)
//                    ((MainActivity) context).startActivityForResult(i,
//                            MainActivity.LAUNCH_ADD_ACTIVITY);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return filteredBrosurList.size();
    }


    public void setBrosurList(List<Brosur> brosurList) {
        this.brosurList = brosurList;
        filteredBrosurList = new ArrayList<>(brosurList);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charSequenceString = charSequence.toString();
                List<Brosur> filtered = new ArrayList<>();

                if (charSequenceString.isEmpty()) {
                    filtered.addAll(brosurList);
                } else {
                    for (Brosur brosur : brosurList) {
                        if (brosur.getNama_mobil().toLowerCase()
                                .contains(charSequenceString.toLowerCase()))
                            filtered.add(brosur);
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredBrosurList.clear();
                filteredBrosurList.addAll((List<Brosur>) filterResults.values);
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaMobil, tvHargaSewa, tvTipeMobil, tvJenisTransmisi, tvJenisBahanBakar, tvWarna, tvVolumeBagasi, tvFasilitas;
        CardView cvBrosur;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHargaSewa = itemView.findViewById(R.id.tv_hargaSewa);
            tvTipeMobil = itemView.findViewById(R.id.tv_tipeMobil);
            tvJenisTransmisi = itemView.findViewById(R.id.tv_jenisTransmisi);
            tvJenisBahanBakar = itemView.findViewById(R.id.tv_jenisBahanBakar);
            tvWarna = itemView.findViewById(R.id.tv_warna);
            tvVolumeBagasi = itemView.findViewById(R.id.tv_volumeBagasi);
            tvFasilitas = itemView.findViewById(R.id.tv_fasilitas);
            tvNamaMobil = itemView.findViewById(R.id.tv_namaMobil);
            cvBrosur = itemView.findViewById(R.id.cv_brosur);
        }
    }
}