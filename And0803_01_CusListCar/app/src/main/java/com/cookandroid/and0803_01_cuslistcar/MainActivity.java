package com.cookandroid.and0803_01_cuslistcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    CustomAdapter customAdapter;
    car[] carArray ={new car(R.drawable.car1,"SM3"),new car(R.drawable.car2,"SM4"),new car(R.drawable.car3,"SM3"),
            new car(R.drawable.car4,"SM4"),new car(R.drawable.car5,"SM6"),new car(R.drawable.car6,"SM3"),};

    public void customToast(car clickItem){
        View layout =getLayoutInflater().inflate(R.layout.car_toast_layout,null);
        ImageView image =layout.findViewById(R.id.imageView1);
        TextView text = layout.findViewById(R.id.textView1);
        image.setImageResource(clickItem.getImage_id());
        text.setText(clickItem.getName());
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=findViewById(R.id.listView1);
        customAdapter = new CustomAdapter(this,carArray);
        listView1.setAdapter(customAdapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int arg2, long arg3) {
                car clickItem =(car) listView1.getItemAtPosition(arg2);
                setTitle(clickItem.getName());
                customToast(clickItem);
            }
        });
    }
}