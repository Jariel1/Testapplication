package masterarbeit.com.testapplication;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ALB on 20.10.2015.
 */

public class CustomDialogFragment extends DialogFragment implements RangeSeekBar.OnRangeSeekBarChangeListener<Long> {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Util util = new Util();
    static TextView myAwesomeTextView, myAwesomeTextView1;

    public CustomDialogFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.customdialog,null);
        final TextView myAwesomeTextView = (TextView)view.findViewById(R.id.textview);
        final TextView myAwesomeTextView1 = (TextView)view.findViewById(R.id.textview1);

        Date minDate = new Date(39600000);
        Date maxDate = new Date(39600000 + 180000 * 65);

        RangeSeekBar<Long> rangeSeekBar = new RangeSeekBar<Long>(getActivity());
        rangeSeekBar.setRangeValues(minDate.getTime(), maxDate.getTime());

        rangeSeekBar.setSelectedMinValue((long) 39600000 + 180000 * 5);
        rangeSeekBar.setSelectedMaxValue((long) 39600000 + 180000 * 60);

        rangeSeekBar.setTextAboveThumbsColor(Color.TRANSPARENT);
        rangeSeekBar.setNotifyWhileDragging(true);

        myAwesomeTextView.setText(sdf.format((long) 39600000 + 180000 * 5) + " - " + sdf.format((long) 39600000 + 180000 * 60));
        myAwesomeTextView1.setText(sdf.format((long) 39600000 + 180000 * 5) + " - " + sdf.format( (long) 39600000 + 180000 * 60));

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Long>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> rangeSeekBar, Long minValue, Long maxValue) {
                Log.i("TAG", "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);
                myAwesomeTextView.setText(sdf.format(minValue) + " - " + sdf.format(maxValue));
                myAwesomeTextView1.setText(util.uhrzeitParsen(minValue) + " - " + util.uhrzeitParsen(maxValue));
            }
        });

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.seekbar_placeholder);
        layout.addView(rangeSeekBar);
        setCancelable(false);
        return view;


    }
    public void onRangeSeekBarValuesChanged(RangeSeekBar<?> rangeSeekBar, Long minValue, Long maxValue) {
        Log.i("TAG", "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);
        myAwesomeTextView.setText(sdf.format(minValue) + " - " + sdf.format(maxValue));
        myAwesomeTextView1.setText(util.uhrzeitParsen(minValue) + " - " + util.uhrzeitParsen(maxValue));



    }

}
