package com.example.priyanka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView) findViewById(R.id.listViewSelectedProducts);
        CustomAdapter adapterProduct = new CustomAdapter(SecondActivity.this, items.getItemsList().size());
        listView.setAdapter(adapterProduct);
    }

    public void Result(View view){
        startActivity(new Intent(this, ResultActivity.class));
    }
}
