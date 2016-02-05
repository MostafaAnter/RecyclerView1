package com.mostafa_anter.recyclerview1;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private List<Movies> movieList = new ArrayList<>();
    @Bind(R.id.recycler_view) RecyclerView recyclerView;
    private MoviesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //for add divider to recycler view
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();

        //after add class add this snippet
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Movies movie = movieList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    private void prepareMovieData() {
        Movies movie = new Movies("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new Movies("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new Movies("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(movie);

        movie = new Movies("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new Movies("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new Movies("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new Movies("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new Movies("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new Movies("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new Movies("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new Movies("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new Movies("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new Movies("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new Movies("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new Movies("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new Movies("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    /*Adding RecyclerView Item Click Listener
      RecyclerView doesn’t have OnItemClickListener method too to identify item click.
      You need to write your own class extending RecyclerView.OnItemTouchListener.
      Open MainActivity.java and add the below RecyclerTouchListener class along with ClickListener interface.*/
    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MainActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MainActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

}

