package com.example.sridatta.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


//this is a activity to search for a book
public class QueryMachine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_machine);
    }


//floating bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
//floating bar button

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// only button in the floating bar is +
        if(item.getItemId()==R.id.action_add){
            startActivity(new Intent(QueryMachine.this,addBook.class));
        }

        return super.onOptionsItemSelected(item);
    }


}
