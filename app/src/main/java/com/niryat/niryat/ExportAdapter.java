package com.niryat.niryat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExportAdapter extends RecyclerView.Adapter<ExportAdapter.ExportViewHolder> {

    private Context mCtx;
    private List<Export> exportData;
    public ExportAdapter(Context mCtx, List<Export> exportData) {
        this.mCtx = mCtx;
        this.exportData = exportData;
}
    @Override
    public ExportAdapter.ExportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.export_data, null);
        return new ExportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExportViewHolder holder, int position) {
        Export export = exportData.get(position);

        holder.tv_product.setText(export.getProduct());
        holder.tv_category.setText(export.getCategory());
        holder.tv_year.setText(export.getYear());
        holder.tv_transport_cost.setText(String.valueOf(export.getTransportCost()));
        holder.tv_handling_cost.setText(String.valueOf(export.getHandlingCost()));
        holder.tv_insurance_cost.setText(String.valueOf(export.getInsurance()));
        holder.tv_delivery_duty.setText(String.valueOf(export.getDelivery()));

    }
    @Override
    public int getItemCount() {
        return exportData.size();
    }





    public class ExportViewHolder extends RecyclerView.ViewHolder {

        TextView tv_product, tv_category,tv_year,tv_transport_cost,tv_handling_cost,tv_insurance_cost,tv_delivery_duty;

        public ExportViewHolder(View itemView) {
            super(itemView);

            tv_product = itemView.findViewById(R.id.tv_product);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_year = itemView.findViewById(R.id.tv_year);
            tv_transport_cost = itemView.findViewById(R.id.tv_transport_cost);
            tv_handling_cost = itemView.findViewById(R.id.tv_handling_cost);
            tv_insurance_cost = itemView.findViewById(R.id.tv_insurance);
            tv_delivery_duty = itemView.findViewById(R.id.tv_delivery_duty);

        }
}}