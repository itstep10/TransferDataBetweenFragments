package org.itstep.transferdatabetweenfragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment
{
    final String LOG_TAG = "myLogs";

    public interface onSomeEventListener
    {
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            someEventListener = (onSomeEventListener) activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment1, null);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Log.d(LOG_TAG, "Button click in Fragment1");
//                Activity activity = getActivity();
//                Button activityButton = (Button) activity.findViewById(R.id.btnFind);
//                activityButton.setText("Access from Fragment1");
//
//                if(activity instanceof MainActivity)
//                {
//                    MainActivity mainActivity = ((MainActivity) activity);
//                    mainActivity.methodForUseFromFragment();
//                }

                someEventListener.someEvent("Test text to Fragment2");
            }
        });

        return v;
    }
}