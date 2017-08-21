package tounzcompagny.agingplanning.UI;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tounzcompagny.agingplanning.R;


public class AdapterTitle extends ArrayAdapter {

    Context mContext;
    ArrayList<String> titleList = new ArrayList<>();

    public AdapterTitle(Context context, int textViewResourceId, ArrayList<String> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        titleList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.fragment_grid_title, null);
        TextView textView = (TextView) v.findViewById(R.id.grid_title_TextView);
        textView.setText(titleList.get(position));
        textView.setBackground(ContextCompat.getDrawable(mContext, R.color.color_background_grid_odd));
        return v;

    }

}
