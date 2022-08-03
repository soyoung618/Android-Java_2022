package com.cookandroid.and0803_01_cuslistcar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context mContext; //메인액티버티 컨텍스트 저장
    car[] mData; //ListViewItem 아이템 데이터를 저장한 배열리스트 저장
    public  CustomAdapter(Context mContext,car[] mData){
        this.mContext =mContext;
        this.mData =mData;
    }
    @Override
    public int getCount() { return mData.length;}
    @Override
    public Object getItem(int i) { return mData[i];}
    @Override
    public long getItemId(int i) { return i;}
    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view == null){
            view =View.inflate(mContext,R.layout.car_child_view,null);
        }
        car tempCar = mData[i];
        ImageView carIV =(ImageView) view.findViewById(R.id.imageView1);
        TextView carTV =(TextView) view.findViewById(R.id.textView1);
        carIV.setImageResource(tempCar.getImage_id());
        carTV.setText(tempCar.getName());

        return view;
    }


}
