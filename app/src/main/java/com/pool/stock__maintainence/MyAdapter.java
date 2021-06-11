package com.pool.stock__maintainence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter  extends FirebaseRecyclerAdapter<RModel,MyAdapter.myviewholder> {
    Context context;
    public MyAdapter(@NonNull FirebaseRecyclerOptions<RModel> options) {
        super(options);
    }
    //adapter class for recyclerview
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final RModel model) {
        holder.currdate.setText(model.getCurrdate());
        holder.address.setText(model.getRecord_address());
        holder.name.setText(model.getRecord_name());
        holder.phone.setText(model.getRecord_phone());
        holder.qty.setText(model.getRecord_qty());
        holder.rate.setText(model.getRecord_ratepl());
        holder.total.setText(model.getRecord_total());
        holder.gst.setText(model.getRecord_GST());
        holder.status.setText(model.getStatus());





    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item,parent,false);
        return new MyAdapter.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView currdate,name,phone,address,qty,rate,total,gst,status;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            currdate=(TextView) itemView.findViewById(R.id.currentdatetext);
            address=(TextView) itemView.findViewById(R.id.addresstext);
            name=(TextView) itemView.findViewById(R.id.nametext);
            phone=(TextView) itemView.findViewById(R.id.phonetext);
            qty=(TextView) itemView.findViewById(R.id.qtytext);
            rate=(TextView) itemView.findViewById(R.id.ratetext);
            total=(TextView) itemView.findViewById(R.id.totaltext);
            gst=(TextView) itemView.findViewById(R.id.gsttext);
            status=(TextView) itemView.findViewById(R.id.paymenttext);



        }
    }
}

