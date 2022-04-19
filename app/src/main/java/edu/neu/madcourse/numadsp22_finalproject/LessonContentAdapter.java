package edu.neu.madcourse.numadsp22_finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LessonContentAdapter extends BaseAdapter {
    Context context;
    String[] lessonPoints;
    LayoutInflater inflater;

    public LessonContentAdapter(Context ctx, String[]lessonPoints){
        this.context = ctx;
        this.lessonPoints = lessonPoints;
        inflater = LayoutInflater.from(ctx);

    }
    @Override
    public int getCount() {
        return lessonPoints.length;
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
        convertView = inflater.inflate(R.layout.lesson_list_txtview_item, null);

        TextView txtView = (TextView) convertView.findViewById(R.id.lessonPoints);
        txtView.setText(lessonPoints[position]);

        return convertView;
    }
}
