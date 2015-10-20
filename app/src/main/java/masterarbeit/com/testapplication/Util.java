package masterarbeit.com.testapplication;

import android.util.Log;

import java.text.SimpleDateFormat;

/**
 * Created by ALB on 19.10.2015.
 */
public class Util {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    String neueUhrzeit = null;

    public String uhrzeitParsen (long Uhrzeit){

        Log.i("Uhrzeit", Long.toString(Uhrzeit));

        for(int i=0; i<65; i++) {
       if (Uhrzeit >= (39600000 + 180000 * i) && Uhrzeit < (39600000 + 180000 * (i+1))){
           neueUhrzeit = sdf.format(39600000 + 180000 * i);
           break;
        }
        if (Uhrzeit == 39600000 + 180000 * 65){
            neueUhrzeit = sdf.format(39600000 + 180000 * 64);
        }

    }
        return neueUhrzeit;
    }

}
