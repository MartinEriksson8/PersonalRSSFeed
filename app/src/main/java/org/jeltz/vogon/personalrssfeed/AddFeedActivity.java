package org.jeltz.vogon.personalrssfeed;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button saveButton = (Button) findViewById(R.id.addFeedButton);
        final EditText feedAdress = (EditText) findViewById(R.id.addFeedEditText);
        final EditText feedName = (EditText) findViewById(R.id.addFeedNameEditText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if RSS feed is too short, show error message, otherwise add to db
                if(feedAdress.getText().length() < 6){
                    Toast.makeText(getApplicationContext(), "RSS feed address is too short!", Toast.LENGTH_LONG).show();
                    return;
                }
                Database db = new Database(AddFeedActivity.this);

                RssFeed feed = new RssFeed(feedName.getText().toString(), feedAdress.getText().toString());
                db.addRssFeed(feed);
                Toast.makeText(getApplicationContext(), "RSS feed added successfully", Toast.LENGTH_LONG).show();
                feedAdress.setText("");
                feedName.setText("");
            }
        });
    }
}
