package com.example.priyanka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String selectedProducts="",selectedPrice="";
    public List<items> itemsList = new ArrayList<items>();
    public List<String> priceList = new ArrayList<String>();
    public items itemObj = new items();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listViewProducts);
        itemsList.clear();

        priceList = Arrays.asList(getResources().getStringArray(R.array.price));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, getResources().getStringArray(R.array.prods));
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedProducts = listView.getItemAtPosition(position).toString();
                selectedPrice = priceList.get(position);
                String contains="no";

                if(itemsList.size()==0) {
                    itemsList.add(new items(selectedProducts, selectedPrice));
                } else {
                    int selPosition=0;
                    for (int i = 0; i < itemsList.size(); i++) {
                        if (itemsList.get(i).getName().equalsIgnoreCase(selectedProducts) &&
                                itemsList.get(i).getPrice().equalsIgnoreCase(selectedPrice)) {
                            contains = "yes";
                            selPosition = i;
                        }
                    }
                    if(contains.equalsIgnoreCase("no")) {
                        itemsList.add(new items(selectedProducts, selectedPrice));
                        itemObj.setItemsList(itemsList);
                    } else {
                        itemsList.remove(selPosition);
                    }
                }
            }
        });
    }
    public void Submit(View v){
        for(int i=0;i<itemsList.size();i++){
            System.out.println(itemsList.get(i).getName()+" "+itemsList.get(i).getPrice());
        }
        startActivity(new Intent(this, SecondActivity.class));
    }
}
