package org.itstep.transferdatabetweenfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements Fragment1.onSomeEventListener
{

    private static final String LOG_TAG = "myLogs";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Fragment frag2 = new Fragment2();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragment2, frag2);
        ft.commit();
    }

    public void onClick(View v)
    {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 1 from Activity");

        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView) frag2.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 2 from Activity");
    }

    @Override
    public void someEvent(String s)
    {
        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragment2);
        ((TextView) frag2.getView().findViewById(R.id.textView)).setText("Text from Fragment 1:" + s);
    }

//    public void methodForUseFromFragment()
//    {
//        Log.d(LOG_TAG, "methodForUseFromFragment: ");
//    }
}