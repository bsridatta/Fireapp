package com.example.sridatta.fireapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class addBook extends AppCompatActivity {


// input entities
    private EditText title;
    private EditText publisher;
    private EditText author;
    private EditText locationCode;
// confirm button
    private Button addBook;

// button to direct to other tasks
    public Button btnSearch;
    public Button btnMap;
    private Firebase mRootRef;
// dummy
    public Button change;
@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
//firebase linkage
    // inside  library>>Books>>BookAddingNow

        mRootRef=new Firebase("https://mylogin-42311.firebaseio.com/Library/books");



        btnSearch=(Button)findViewById(R.id.button2);
        btnMap=(Button)findViewById(R.id.btn_map);
        addBook=(Button)findViewById(R.id.btn_addBook);
// fields to be filled
        locationCode=(EditText)findViewById(R.id.et_addCode);
        title=(EditText)findViewById(R.id.et_addTitle);
        publisher=(EditText)findViewById(R.id.et_addPublisher);
        author=(EditText)findViewById(R.id.et_addAuthor);

// the process of adding

        addBook.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String sTitle=title.getText().toString();
                String sPublisher=publisher.getText().toString();
                String sAuthor=author.getText().toString();
                String sCode=locationCode.getText().toString();

                // stacking inside  library>>Books>>BookAddingNow

                Firebase childRef =mRootRef.push();
                childRef.child("title").setValue(sTitle);
                childRef.child("author").setValue(sAuthor);
                childRef.child("publisher").setValue(sPublisher);
                childRef.child("code").setValue(sCode);



            }
        });

// taking to the new recycler view not yet ready
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(com.example.sridatta.fireapp.addBook.this, RecycleView.class);
                startActivity(toy);
            }
        });
    }



//dummy function to check the validity of color changing idea
    public void changeColor(){

        change.setBackgroundColor(Color.GREEN);
    }

//floating bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
//floating bar buttons

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    // as of now the only button is +
        if(item.getItemId()==R.id.action_add){
            startActivity(new Intent(addBook.this,addBook.class));
        }

        return super.onOptionsItemSelected(item);
    }


    /*
    public void onSearch(){
       startActivity(new Intent(addBook.this,SearchBook.class));
    }
*/
}


