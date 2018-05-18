package org.itstep.transferdatabetweenfragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

public class Fragment2 extends Fragment
{
    public static final String ARG_MESSAGE_FROM_ACTIVITY = "arg_message_from_activity";

    private static final String LOG_TAG = "myLogs";
    private static final int REQUEST_ACTIVITY = 5;

    public static Fragment2 newInstance(String messageFromActivity)
    {
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE_FROM_ACTIVITY, messageFromActivity);
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        if(getArguments() != null && getArguments().containsKey(ARG_MESSAGE_FROM_ACTIVITY))
//        {
//            String messageFromActivity = getArguments().getString(ARG_MESSAGE_FROM_ACTIVITY);
//            Toast.makeText(getActivity(), "Hi! It`s message from activity: " + messageFromActivity, Toast.LENGTH_SHORT).show();
//        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment2, null);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                Log.d(LOG_TAG, "Button click in Fragment2");
//                Activity activity = getActivity();
//                Button activityButton = (Button) activity.findViewById(R.id.btnFind);
//                activityButton.setText("Access from Fragment2");
                Intent intent = ActivityStartFromFragment.newIntent(getActivity(), "message from Fragment 2 to new Activity");
                startActivityForResult(intent, REQUEST_ACTIVITY);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_ACTIVITY)
        {
            String message = "Empty result";
            if(data.hasExtra(ActivityStartFromFragment.ARG_MESSAGE_FROM_ACTIVITY_STARTED_FROM_FRAGMENT))
                message = data.getStringExtra(ActivityStartFromFragment.ARG_MESSAGE_FROM_ACTIVITY_STARTED_FROM_FRAGMENT);
            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getActivity(), "Wrong result", Toast.LENGTH_SHORT).show();
    }
}