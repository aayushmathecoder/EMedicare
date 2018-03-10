package com.health.medicare.emedicare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class SuccessAdapter  extends BaseAdapter

{
    private List<CartDetails> cartDetailsList;

    //activity context
    private Context context;

    //the layout resource file for the list items
    private int resource;

    private LayoutInflater layoutInflater;

    //int totalItemsInTheCart;
    // List<Medicine> cartItems=new ArrayList<>();
    static class ViewHolder {
        private TextView medName;
        private TextView medQuantity;
        private TextView medPrice;
    }

    public SuccessAdapter(Context context, int resource, List cartDetailsList) {

        //super(context, resource, medicineList1);
        this.context = context;
        this.resource = resource;
        this.cartDetailsList = cartDetailsList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return cartDetailsList.size();
    }

    @Override
    public Object getItem(int i) {
        return cartDetailsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        View view;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_success_layout, viewGroup, false);
            view = convertView;
            SuccessAdapter.ViewHolder viewHolder = new SuccessAdapter.ViewHolder();
            viewHolder.medName = (TextView) view.findViewById(R.id.medicine_name_textview);
            viewHolder.medQuantity = (TextView) view.findViewById(R.id.quantity_textview);
            viewHolder.medPrice = (TextView) view.findViewById(R.id.medicine_price_textview);

            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        // fill data
        final SuccessAdapter.ViewHolder holder = (SuccessAdapter.ViewHolder) view.getTag();
        //setting values to the views
        holder.medName.setText(cartDetailsList.get(position).getMedicine().getMedicineName());
        holder.medQuantity.setText("Quantity:"+cartDetailsList.get(position).getItemQuantity()+" tablets");
        holder.medPrice.setText("Rs. "+cartDetailsList.get(position).getMedicine().getPriceOfTenTablet());

        return view;


    }
}