package com.health.medicare.emedicare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M1035979 on 2/24/2018.
 */

public class MedicineListAdapter extends RecyclerView.Adapter<MedicineListAdapter.MyViewHolder> {

    private List<Medicine> medicineList;

    //activity context
    private Context context;

    //the layout resource file for the list items
    private int resource;

    LayoutInflater layoutInflater;

    // int totalItemsInTheCart;
    List<Medicine> cartItems = new ArrayList<>();
    private int totalItemsInCart;
    private float totalCartPrice;
    private final EventBus mEventBus = EventBus.getDefault();
    String totalPriceAndTotalItems;
    List<CartDetails> cartDetailsList = new ArrayList<>();


    MedicineListAdapter(Context context, int resource, List<Medicine> medicineList) {

        this.context = context;
        this.resource = resource;
        this.medicineList = medicineList;
//        mEventBus.register(this);

    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView medicineName;
        private TextView medicineExpiryDate;
        private TextView itemQuantity;
        private TextView pricePerQuantity;
        private TextView totalPriceOfItem;
        private ImageButton minusButton;
        private ImageButton plusButton;
        private ImageButton addToCartBtn;

        MyViewHolder(View view) {
            super(view);
            medicineName = (TextView) view.findViewById(R.id.doctor_name_textview);
            medicineExpiryDate = (TextView) view.findViewById(R.id.medicine_expiry_textview);
            pricePerQuantity = (TextView) view.findViewById(R.id.medicine_price_textview);
            itemQuantity = (TextView) view.findViewById(R.id.medicine_quantity_tv);
            totalPriceOfItem = (TextView) view.findViewById(R.id.medicine_final_price_textview);
            minusButton = (ImageButton) view.findViewById(R.id.decreaseQtyBtn);
            plusButton = (ImageButton) view.findViewById(R.id.increaseQtyBtn);
            addToCartBtn = (ImageButton) view.findViewById(R.id.add_to_cart_button);
        }
    }


    @Override
    public MedicineListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_medicine_list, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MedicineListAdapter.MyViewHolder holder, final int position) {
        holder.addToCartBtn.setTag(position);
        holder.plusButton.setTag(position);
        holder.minusButton.setTag(position);
        //setting values to the views
        holder.medicineName.setText(medicineList.get(position).getMedicineName());
        holder.medicineExpiryDate.setText("Expiry Date: " + medicineList.get(position).getExpiryDate());
        holder.pricePerQuantity.setText("Rs."+medicineList.get(position).getPriceOfTenTablet());
        holder.totalPriceOfItem.setText("Rs."+medicineList.get(position).getPriceOfTenTablet());

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int position1 = (Integer) view.getTag();
                int itemQuantityCount = Integer.parseInt(holder.itemQuantity.getText().toString());
                if (itemQuantityCount < 20) {
                    itemQuantityCount++;
                    //medicineList.get(position1).set
                    holder.itemQuantity.setText("" + itemQuantityCount);
                    float totalPrice = itemQuantityCount * Float.parseFloat(holder.pricePerQuantity.getText().toString().substring(3));
                    holder.totalPriceOfItem.setText("Rs."+totalPrice);
                } else {
                    Toast.makeText(context, "Quantity cannot be more than 20 per order", Toast.LENGTH_SHORT).show();
                }


            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //int position1 = (Integer) view.getTag();
                int itemQuantityCount = Integer.parseInt(holder.itemQuantity.getText().toString());
                if (itemQuantityCount > 1) {
                    itemQuantityCount--;
                    holder.itemQuantity.setText("" + itemQuantityCount);
                    float totalPrice = itemQuantityCount * Float.parseFloat(holder.pricePerQuantity.getText().toString().substring(3));
                    holder.totalPriceOfItem.setText("Rs."+totalPrice);
                } else {
                    Toast.makeText(context, "Quantity cannot be less than 1", Toast.LENGTH_SHORT).show();
                }


            }
        });
        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cartItems.add(medicineList.get(position));
                totalCartPrice = totalCartPrice + Float.parseFloat(holder.totalPriceOfItem.getText().toString().substring(3));
                totalItemsInCart = totalItemsInCart + 1;
                Toast.makeText(context, "" + medicineList.get(position).getMedicineName() + " added to the Cart", Toast.LENGTH_SHORT).show();
                //cartDetailsList = new ArrayList<>();
                CartDetails cartDetails = new CartDetails(totalCartPrice, totalItemsInCart,holder.itemQuantity.getText().toString(), medicineList.get(position));
                cartDetailsList.add(cartDetails);
                mEventBus.post(cartDetailsList);
                holder.addToCartBtn.setEnabled(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }
}



