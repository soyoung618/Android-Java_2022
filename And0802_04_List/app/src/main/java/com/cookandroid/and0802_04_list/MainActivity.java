package com.cookandroid.and0802_04_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ArrayList<String> choice = new ArrayList<>(); //String 동적 객체 배열
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        btn=findViewById(R.id.btn);
        final String[] data = { "히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
                "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이" };
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, data); //라디오 버튼
       // list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);  //체크 박스
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),data[i]+" 선택", Toast.LENGTH_SHORT).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice.clear();
                SparseBooleanArray chkItme = list.getCheckedItemPositions();
                if (chkItme.size()!=0){
                    for(int i=0; i<data.length;i++){
                        if (chkItme.get(i))choice.add(data[i]);
                    }
                }
                String str ="";
                for(String s : choice)  str += s+" "; // 뛰어서 나오ㄱㅣ

                Toast.makeText(getApplicationContext(), "선텍 : "  + choice, Toast.LENGTH_SHORT).show();
            }
        });

    }
}












