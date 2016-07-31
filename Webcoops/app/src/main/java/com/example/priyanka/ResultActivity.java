package com.example.priyanka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    ListView listView;
    public List<String> resultList = new ArrayList<String>();
    int userBalance=5000,totalAmount=0,balanceAmt=0;
    TextView txtTotalPrice,txtBalAmt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listView = (ListView) findViewById(R.id.listViewResult);
        txtTotalPrice = (TextView) findViewById(R.id.txtTotalPrice);
        txtBalAmt = (TextView) findViewById(R.id.txtBalAmount);

        resultList.clear();
        for(int i=0;i<items.getItemsList().size();i++){
            String name = items.getItemsList().get(i).getName();
            String price = items.getItemsList().get(i).getPrice();
            String qty = items.getItemsList().get(i).getQty();
            int totalPrice = Integer.parseInt(price) * Integer.parseInt(qty);
            resultList.add(name + " - Rs. " + totalPrice + " (Qty - " + qty + ")");
            totalAmount = totalAmount + totalPrice;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_list_item, android.R.id.text1, resultList);
        listView.setAdapter(adapter);

        balanceAmt = userBalance - totalAmount;
        txtTotalPrice.setText("Total Amount Charged: "+totalAmount);
        txtBalAmt.setText("Available Balance Amount: "+balanceAmt);
    }
}
