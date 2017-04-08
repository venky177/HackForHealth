package vans.hackforhealth;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatDisplay extends AppCompatActivity {

    LinearLayout mainList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_display);
        mainList=(LinearLayout)findViewById(R.id.RLchatwindows);

    }


}
