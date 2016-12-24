package com.example.sridatta.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//the main activity helps you to choose the role of reader or librarian


public class MainActivity extends AppCompatActivity {

    // two buttons on the main activity
    private Button addButton;
    private Button findButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    addButton=(Button)findViewById(R.id.btn_addBook);

        findButton=(Button)findViewById(R.id.btn_findBook);




// directs to addBook when add button is clicked

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(com.example.sridatta.fireapp.MainActivity.this, addBook.class);


                startActivity(toy);
            }
        });



// directs to  query machine when find button is clicked
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(com.example.sridatta.fireapp.MainActivity.this, QueryMachine.class);


                startActivity(toy);
            }
        });

    }

    // buttons on the floating bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //producing the button
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //function which directs to the button pressed at the top
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //the ony button on the top floating panel is +
        if(item.getItemId()==R.id.action_add){
            startActivity(new Intent(MainActivity.this,newBook.class));
        }

        return super.onOptionsItemSelected(item);
    }


}
