package com.example.priyanka;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements OnClickListener {
    private Activity activity;
    public ViewHolder holder;
    private static LayoutInflater inflater = null;
    private int count = 0;
    public List<items> itemList = new ArrayList<items>();
    public List<String> qtyList = new ArrayList<String>();
    public CustomAdapter(Activity a, Integer d) {
        try {
            activity = a;
            count = d;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemList.clear();
            itemList = items.itemsList;
        } catch (Exception e) {
            
            Log.e("LazyImg:onCreate", e + "");
        }
    }
    public int getCount() {
        return count;
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public static class ViewHolder {
        public TextView name,price;
        public NumberPicker spnQty;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = null;
        try {
            vi = convertView;
            if (convertView == null) {
                vi = inflater.inflate(R.layout.product_list_view, null);
                holder = new ViewHolder();
                holder.name = (TextView) vi.findViewById(R.id.txtName);
                holder.price = (TextView) vi.findViewById(R.id.txtPrice);
                holder.spnQty = (NumberPicker) vi.findViewById(R.id.spnQty);
                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }
            final items currentProduct = itemList.get(position);
            holder.name.setText(currentProduct.getName());
            holder.price.setText(currentProduct.getPrice());
            qtyList.clear();
            for(int i=1;i<=100;i++){
                qtyList.add(i+"");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.simple_list_item, android.R.id.text1, qtyList);
//            holder.spnQty.setAdapter(adapter);
            holder.spnQty.setMinValue(1);
            holder.spnQty.setMaxValue(100);
            holder.spnQty.setWrapSelectorWheel(true);

            //Set a value change listener for NumberPicker
            holder.spnQty.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    //Display the newly selected number from picker
                    System.out.println("price: " + newVal);
                    currentProduct.setQty(newVal + "");
                }
            });

//            holder.spnQty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    int qty = Integer.parseInt(holder.spnQty.getItemAtPosition(position).toString());
//                    int price = Integer.parseInt(currentProduct.getPrice());
//                    int totalPrice = qty * price;
//                    currentProduct.setQty(qty + "");
//                    currentProduct.setPrice(totalPrice + "");
//                    System.out.println("price: " + totalPrice);
//                    holder.price.setText(totalPrice+"");
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parent) {
//
//                }
//            });
        } catch (Exception e) {
            Log.e("CustomAdapter:getView",e+"");
        }
        return vi;
    }
    @Override
    public void onClick(View v) { }
}