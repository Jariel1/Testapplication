package masterarbeit.com.testapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.text.SimpleDateFormat;
import java.util.Date;

;

public class MainActivity extends Activity {


    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    Util util = new Util();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView myAwesomeTextView = (TextView)findViewById(R.id.textview);
        final TextView myAwesomeTextView1 = (TextView)findViewById(R.id.textview1);

       Date minDate = new Date(39600000);
       Date maxDate = new Date(39600000 + 180000 * 65);

        RangeSeekBar<Long> rangeSeekBar = new RangeSeekBar<Long>(this);
        rangeSeekBar.setRangeValues(minDate.getTime(), maxDate.getTime());

        rangeSeekBar.setSelectedMinValue((long) 39600000 + 180000 * 5);
        rangeSeekBar.setSelectedMaxValue((long) 39600000 + 180000 * 60);

        rangeSeekBar.setTextAboveThumbsColor(Color.TRANSPARENT);
        rangeSeekBar.setNotifyWhileDragging(true);

        myAwesomeTextView.setText(sdf.format((long) 39600000 + 180000 * 5) + " - " + sdf.format( (long) 39600000 + 180000 * 60));
        myAwesomeTextView1.setText(sdf.format((long) 39600000 + 180000 * 5) + " - " + sdf.format( (long) 39600000 + 180000 * 60));

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Long>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> rangeSeekBar, Long minValue, Long maxValue) {
                Log.i("TAG", "User selected new range values: MIN=" + minValue + ", MAX=" + maxValue);
                myAwesomeTextView.setText(sdf.format(minValue) + " - " + sdf.format(maxValue));
                myAwesomeTextView1.setText(util.uhrzeitParsen(minValue) + " - " + util.uhrzeitParsen(maxValue));
            }
        });

            // Add to layout
            LinearLayout layout = (LinearLayout) findViewById(R.id.seekbar_placeholder);
            layout.addView(rangeSeekBar);
        }
    }
