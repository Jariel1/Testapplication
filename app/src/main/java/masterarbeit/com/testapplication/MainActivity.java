package masterarbeit.com.testapplication;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        CustomDialogFragment editNameDialog = new CustomDialogFragment();
        editNameDialog.show(fm, "fragment_edit_name");



    }}
