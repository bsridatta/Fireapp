package com.example.sridatta.fireapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

//under construction

public class RecycleView extends AppCompatActivity {

// the catelog using recylerView

    private RecyclerView rv_catelog;
    private DatabaseReference mDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

    // getting the book

        mDatabase= FirebaseDatabase.getInstance().getReference().child("library").child("books");

        // making  the visual of the recycler view
        rv_catelog=(RecyclerView) findViewById(R.id.rv_recycleView);
        rv_catelog.setHasFixedSize(true);
        rv_catelog.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<RetreiveBooks,RecycleViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<RetreiveBooks, RecycleViewHolder>(
// the view :p
            RetreiveBooks.class,
                R.layout.activity_row_view,
                RecycleViewHolder.class,
                mDatabase

        ) {
            @Override
            protected void populateViewHolder(RecycleViewHolder viewHolder, RetreiveBooks model, int position) {


                //getting the key so as to identify the folder or book currently dealing with
                final String BookKey = getRef(position).getKey();
                viewHolder.setTitle(model.getTitle());
                viewHolder.setAuthor(model.getAuthor());
                viewHolder.setLocation(model.getLocation());
                viewHolder.setPublisher(model.getPublisher());
                viewHolder.setBookImage(getApplicationContext(),model.getBookImage());

                // setting onClick listener to the recycler view to the whole card
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent Map = new Intent(RecycleView.this,Map.class);
                        Map.putExtra("BookKey",BookKey);
                        startActivity(Map);

                        //Toast.makeText(RecycleView.this,"you clicked the view",Toast.LENGTH_LONG).show();
                    }
                });



            }
        };


        rv_catelog.setAdapter(firebaseRecyclerAdapter);

    }

    // adding entities into the card i guess
//recyclerViewHolder Is Custom Defined
    public static class RecycleViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView tvLocation;
        public RecycleViewHolder(View itemView) {
            super(itemView);

            mView=itemView;
            //onclick listener for the location to redirect to the map
             tvLocation =(TextView)mView.findViewById(R.id.tv_location);
            tvLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                 //   Intent toy = new Intent(RecycleView.this,addBook.class);
                    Log.v("RecycleView","some text");
                }
            });

        }

        public void setTitle(String title){

            TextView tvTitle =(TextView)mView.findViewById(R.id.tv_title);
            tvTitle.setText(title);


        }

        public void setPublisher(String publisher){

            TextView tvPublisher =(TextView)mView.findViewById(R.id.tv_publisher);
            tvPublisher.setText(publisher);

        }

        public void setLocation(String location){

         //   TextView tvLocation =(TextView)mView.findViewById(R.id.tv_location);
            tvLocation.setText(location);

        }

        public void setAuthor(String author){

           TextView tvAuthor =(TextView)mView.findViewById(R.id.tv_author);
            tvAuthor.setText(author);

        }



        public void setBookImage(Context ctx, String BookImage) {
            ImageView iv_imageBook = (ImageView)mView.findViewById(R.id.iv_imageBook);
            Picasso.with(ctx).load(BookImage).into(iv_imageBook);
        }




    }
//floating bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
//floating bar

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //floating bar
        if(item.getItemId()==R.id.action_add){
            startActivity(new Intent(RecycleView.this,addBook.class));
        }

        return super.onOptionsItemSelected(item);
    }



}
