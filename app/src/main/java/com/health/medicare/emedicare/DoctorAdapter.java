package com.health.medicare.emedicare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;



public class DoctorAdapter extends BaseAdapter

{
    private List<Doctor> doctorList;

    //activity context
    private Context context;

    //the layout resource file for the list items
    private int resource;

    private LayoutInflater layoutInflater;

    //int totalItemsInTheCart;
    // List<Medicine> cartItems=new ArrayList<>();
    private static class ViewHolder {
        private TextView doctorName;
        private TextView doctorSpecialization;
        private TextView yearsOfExperience;
        private TextView feesOfDoctor;

        private Button callDoctor;
    }

    DoctorAdapter(Context context, int resource, List doctorList) {

        //super(context, resource, medicineList1);
        this.context = context;
        this.resource = resource;
        this.doctorList = doctorList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return doctorList.size();
    }

    @Override
    public Object getItem(int i) {
        return doctorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        View view;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.doctor_row_layout, viewGroup, false);
            view = convertView;
            DoctorAdapter.ViewHolder viewHolder = new DoctorAdapter.ViewHolder();
            viewHolder.doctorName = (TextView) view.findViewById(R.id.doctor_name_textview);
            viewHolder.doctorSpecialization = (TextView) view.findViewById(R.id.doctor_qualification_textview);
            viewHolder.feesOfDoctor = (TextView) view.findViewById(R.id.medicine_price_textview);
            viewHolder.yearsOfExperience = (TextView) view.findViewById(R.id.yearsOfExperience);

            viewHolder.callDoctor = view.findViewById(R.id.call_doctor);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        // fill data
        final DoctorAdapter.ViewHolder holder = (DoctorAdapter.ViewHolder) view.getTag();
        //setting values to the views
        holder.doctorName.setText(doctorList.get(position).getDoctorName());
        holder.doctorSpecialization.setText(doctorList.get(position).getDoctorSpecialization());
        holder.feesOfDoctor.setText("Rs. "+doctorList.get(position).getFeesOfDoctor());
        holder.yearsOfExperience.setText(doctorList.get(position).getYearsOfExperience());

        holder.callDoctor.setTag(position);


        holder.callDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position1 = (Integer) view.getTag();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                // Send phone number to intent as data
                intent.setData(Uri.parse("tel:" + doctorList.get(position).getDoctorPhoneNumber()));
                // Start the dialer app activity with number
                context.startActivity(intent);
            }
        });

        return view;
    }
}



