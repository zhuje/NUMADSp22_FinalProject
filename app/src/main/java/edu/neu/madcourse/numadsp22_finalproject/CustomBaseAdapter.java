package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String[] listLesson;
    int[] lockList;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String[]lessonList, int[]lockList){
        this.context = ctx;
        this.listLesson = lessonList;
        this.lockList = lockList;
        inflater = LayoutInflater.from(ctx);

    }
    @Override
    public int getCount() {
        return listLesson.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item, null);
        TextView txtView = (TextView) convertView.findViewById(R.id.LessonName);
        txtView.setText(listLesson[position]);
        ImageView locksImg = (ImageView) convertView.findViewById(R.id.lock);
        locksImg.setImageResource(lockList[position]);
        return convertView;
    }
}
