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
import tounzcompagny.agingplanning.Objects.State;
import tounzcompagny.agingplanning.Objects.Study;


public class AdapterStudy extends ArrayAdapter<Study> {

    ArrayList<Study> studyList = new ArrayList<>();
    Context mContext;


    private static class ViewHolder {
        TextView nStudy;
        TextView cutsomer;
        TextView nbSample;
        TextView dateStart;
        TextView nbDayStart;
        TextView nbDayEnd;
        TextView dateEnd;
        TextView chamber;
        TextView test;
        TextView state;
    }

    public AdapterStudy(Context context, ArrayList<Study> data) {
        super(context, R.layout.fragment_grid_study, data);
        this.studyList = data;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_grid_study, parent, false);

            viewHolder.nStudy = (TextView) convertView.findViewById(R.id.grid_nStudy_TextView);
            viewHolder.cutsomer = (TextView) convertView.findViewById(R.id.grid_customer_TextView);
            viewHolder.nbSample = (TextView) convertView.findViewById(R.id.grid_nbSample_TextView);
            viewHolder.dateStart = (TextView) convertView.findViewById(R.id.grid_dateStart_TextView);
            viewHolder.nbDayStart = (TextView) convertView.findViewById(R.id.grid_nbDayStart_TextView);
            viewHolder.nbDayEnd = (TextView) convertView.findViewById(R.id.grid_nbDayEnd_TextView);
            viewHolder.dateEnd = (TextView) convertView.findViewById(R.id.grid_dateEnd_TextView);
            viewHolder.chamber = (TextView) convertView.findViewById(R.id.grid_chamber_TextView);
            viewHolder.test = (TextView) convertView.findViewById(R.id.grid_test_TextView);
            viewHolder.state = (TextView) convertView.findViewById(R.id.grid_state_TextView);

            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.nStudy.setText(studyList.get(position).getnStudy());
        viewHolder.cutsomer.setText(studyList.get(position).getCustomer());
        viewHolder.nbSample.setText(String.valueOf(studyList.get(position).getNbSample()));
        viewHolder.dateStart.setText(String.valueOf(studyList.get(position).getDateStart()));
        viewHolder.nbDayStart.setText(String.valueOf(studyList.get(position).getNbDayStart()));
        viewHolder.nbDayEnd.setText(String.valueOf(studyList.get(position).getNbDayEnd()));
        viewHolder.dateEnd.setText(String.valueOf(studyList.get(position).getDateEnd()));
        viewHolder.chamber.setText(String.valueOf(studyList.get(position).getChamber()));
        viewHolder.test.setText(studyList.get(position).getTest());
        viewHolder.state.setBackground(ContextCompat.getDrawable(mContext, studyList.get(position).getState().getIcon()));

        if (studyList.get(position).getState() == State.EN_ATTENTE) {
            viewHolder.nStudy.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_waiting));
            viewHolder.cutsomer.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_waiting));
            viewHolder.dateEnd.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_waiting));
        } else if (studyList.get(position).getState() == State.EN_COURS || studyList.get(position).getState() == State.FIN) {
            viewHolder.nStudy.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_in_progress));
            viewHolder.cutsomer.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_in_progress));
            viewHolder.dateEnd.setTextColor(ContextCompat.getColor(mContext, R.color.color_text_state_in_progress));
        } else {
            viewHolder.nStudy.setTextColor(ContextCompat.getColor(mContext, android.R.color.tertiary_text_dark));
            viewHolder.cutsomer.setTextColor(ContextCompat.getColor(mContext, android.R.color.tertiary_text_dark));
            viewHolder.dateEnd.setTextColor(ContextCompat.getColor(mContext, android.R.color.tertiary_text_dark));
        }

        if (position % 2 == 0) { // rows even
            convertView.setBackground(ContextCompat.getDrawable(mContext, R.color.color_background_grid_even));
        } else { // rows odd
            convertView.setBackground(ContextCompat.getDrawable(mContext, R.color.color_background_grid_odd));
        }


        return convertView;

    }

}
