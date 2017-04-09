package com.knrmalhotra.energycity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RaffelHotelActivity extends AppCompatActivity {

    private Button btn;
    int quantity = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raffel_hotel);

        btn = (Button) findViewById(R.id.request);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RaffelHotelActivity.this, RequestActivity.class));
            }
        });



    }

    public void increment(View v){
        if (quantity == 100){
            Toast.makeText(this, "You cannot order more than 100KWh", Toast.LENGTH_SHORT).show();
            return;

        }
        quantity =  quantity + 10;
        display(String.valueOf(quantity));
    }

    public void decrement(View v){
        if (quantity == 1){
            Toast.makeText(this, "You cannot less then 1KWh", Toast.LENGTH_SHORT).show();
            return;

        }
        quantity = quantity - 10;
        display(String.valueOf(quantity));
    }

    private void display(String number) {
        TextView tv = (TextView) findViewById(R.id.quantity_text_view);
        tv.setText(number+ "%");
    }
}
