package com.example.priyankaks.bmiks;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView display,w,h;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.tvDisplay);
        h = (TextView) findViewById(R.id.textView1);
        w =  (TextView) findViewById(R.id.textView2);

            }


    public void calculation(View view) {
        // make sure we handle the click of the calculator button

        if (view.getId() == R.id.bsubmit) {

            // get the references to the widgets
            EditText weight = (EditText)findViewById(R.id.weight);
            EditText height = (EditText)findViewById(R.id.height);
            TextView result = (TextView)findViewById(R.id.result);

            // get the users values from the widget references

            float kg = Float.parseFloat(weight.getText().toString());
            float cm = Float.parseFloat(height.getText().toString());

            // calculate the bmi value

            float bmiValue = calculateBMI(kg, cm);

            // interpret the meaning of the bmi value
            String bmiInterpretation = interpretBMI(bmiValue);

            // now set the value in the result text

            result.setText(bmiValue + "-" + bmiInterpretation);
        }
    }

    // the formula to calculate the BMI index

    // check for http://en.wikipedia.org/wiki/Body_mass_index
    private float calculateBMI (float kg, float cm) {

        return (float) (kg / (cm * cm));
    }


    // interpret what BMI means
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 18.5) {
            return "YOU ARE UNDER WEIGHT";
        } else if (bmiValue > 18.5 && bmiValue < 24.9) {

            return "YOU WEIGHT IS NORMAL";
        } else if (bmiValue > 25 && bmiValue <29.9) {

            return "YOU ARE OVER WEIGHT";
        } else if (bmiValue > 30) {

            return "YOU ARE OBESE";
        } else {
            return "PLEASE ENTER THE DETAILS ";

    }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
