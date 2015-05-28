/*
 Collaborators:
    Andrew Barta
    David Lee
    For helping with version control
 */

package com.example.johnathon.favoritescripture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button shareButton = (Button)findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShareActivity.class);

                // get all the text from the user
                EditText bookEditText    = (EditText)findViewById(R.id.bookEditText);
                EditText chapterEditText = (EditText)findViewById(R.id.chapterEditText);
                EditText verseEditText   = (EditText)findViewById(R.id.verseEditText);

                // include all the data that the ShareActivity will need
                intent.putExtra("book", bookEditText.getText().toString());
                intent.putExtra("chapter", chapterEditText.getText().toString());
                intent.putExtra("verse", verseEditText.getText().toString());

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
