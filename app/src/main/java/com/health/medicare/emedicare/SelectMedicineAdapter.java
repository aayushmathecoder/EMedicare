package com.health.medicare.emedicare;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by M1035979 on 2/24/2018.
 */

public class SelectMedicineAdapter extends ArrayAdapter<Category> implements View.OnClickListener {
    @Override
    public void onClick(View view) {

    }
    //the list values in the List of type Category
    private List<Category> categoryList;

    //activity context
    private Context context;

    //the layout resource file for the list items
    private int resource;

    private LayoutInflater layoutInflater;
    //constructor initializing the values
    public SelectMedicineAdapter(Context context, int resource, List<Category> categoryList) {
        super(context, resource, categoryList);
        this.context = context;
        this.resource = resource;
        this.categoryList = categoryList;
        layoutInflater = LayoutInflater.from(context);
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(convertView==null) {
            view = layoutInflater.inflate(R.layout.row_category_layout, null);
        }
            //we need to get the view of the xml for our list item
            //And for this we need a layoutinflater


            //getting the view
         //   View view = layoutInflater.inflate(resource, null, false);

            //getting the view elements of the list from the view
            ImageView imageView = view.findViewById(R.id.categoryImage);
            TextView textViewName = view.findViewById(R.id.categoryName);


            //getting the category of the specified position
            Category category = categoryList.get(position);

            //adding values to the list item
            imageView.setImageDrawable(context.getResources().getDrawable(category.getImage()));
            textViewName.setText(category.getName());


            //finally returning the view
            return view;

    }


}
