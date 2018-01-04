package com.example.recycler.recyclerviewver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    private TextView name , description;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        extras=getIntent().getExtras();
        name =(TextView) findViewById(R.id.dnameid);
        description=(TextView) findViewById(R.id.ddescriptionid);
        if(extras!=null)
        {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
        }
    }
}
