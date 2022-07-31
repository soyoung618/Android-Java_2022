package com.cookandroid.and0729_04_sdmem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {
    Button btnRead, btnMKDir,btnDelDir,btnFileList;
    EditText edtSD;
    String strSDpath; File mydir; //앱 디렉터리 이름
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        setTitle("소영잉 SD카드 테스트");
        btnRead=findViewById(R.id.btnRead);
        btnMKDir=findViewById(R.id.btnMKDir);
        btnDelDir=findViewById(R.id.btnDelDir);
        btnFileList=findViewById(R.id.btnFileList);
        edtSD=findViewById(R.id.edtSD);

        //핸드폰의 SD 카드 절대 경로
        strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath();
        mydir=new File(strSDpath+"/myDir"); //앱 이름의 폴더 경로 세팅
        btnMKDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mydir.exists())mydir.mkdir();
            }
        });

        btnDelDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydir.delete();
            }
        });
    btnRead.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try{
                FileInputStream inFs = new FileInputStream(strSDpath+"/myDir/test.txt");
                byte[] in = new byte[inFs.available()];
                inFs.read(in); //str.toString()
                edtSD.setText(new String(in));
                inFs.close();
            }catch (Exception e){

            }
        }
    });
    btnFileList.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            File[] sysFiles =(new File(strSDpath).listFiles());
            String strFname ="파일 밒 폴더 개수 : "+sysFiles.length;
            for(int i=0;i<sysFiles.length;i++){
                if (sysFiles[i].isDirectory())
                    strFname += "\n[폴더]"+ sysFiles[i].toString();
                if (sysFiles[i].isFile()){
                    strFname += "\n[파일]"+ sysFiles[i].toString();
                }
                edtSD.setText(strFname);
            }
        }
    });
    }
}
















