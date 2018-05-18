package org.itstep.transferdatabetweenfragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Koren Vitalii on 19.05.2018.
 */
public class ActivityStartFromFragment extends Activity
{
    public static final String ARG_MESSAGE_FROM_FRAGMENT = "arg_message_from_fragment";
    public static final String ARG_MESSAGE_FROM_ACTIVITY_STARTED_FROM_FRAGMENT = "arg_message_from_activity_started_from_fragment";

    public static Intent newIntent(Context activity, String messageFromFragment)
    {
        Intent intent = new Intent(activity, ActivityStartFromFragment.class);
        intent.putExtra(ARG_MESSAGE_FROM_FRAGMENT, messageFromFragment);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_from_fragment);
        if(savedInstanceState != null && savedInstanceState.containsKey(ARG_MESSAGE_FROM_FRAGMENT))
        {
            String message = savedInstanceState.getString(ARG_MESSAGE_FROM_FRAGMENT);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        Button close = findViewById(R.id.button_close);
        close.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.putExtra(ARG_MESSAGE_FROM_ACTIVITY_STARTED_FROM_FRAGMENT, "Hi! I'm from Activity opened from Fragment");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }
}

