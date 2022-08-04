package com.cookandroid.and0804_02_dbcuradpidol;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class IdolAdaper extends CursorAdapter {
    public  IdolAdaper(Context context, Cursor c, boolean autoRequery){
        super(context, c, autoRequery);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v= View.inflate(context,R.layout.list_item,null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName =view.findViewById(R.id.txtGNameResult);
        TextView txtTel =view.findViewById(R.id.txtGNumberResult);

        txtName.setText("그룹명 : "+ cursor.getString(1));
        txtTel.setText("인원수 : "+cursor.getString(2));

    }
}
