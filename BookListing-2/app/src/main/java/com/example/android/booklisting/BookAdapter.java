package com.example.android.booklisting;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class BookAdapter extends ArrayAdapter<Book> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();


    public BookAdapter(Activity context, ArrayList<Book> books) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        // Find the book at the given position in the list of books
        final Book currentBook = getItem(position);
        Log.i(LOG_TAG, "Item position: " + position);

        // Find the TextView with view ID book_title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.book_title);
        // Display the title of the in that TextView
        titleTextView.setText(currentBook.getTitle());

        // Find the TextView with view ID book_title
        TextView authorTextView = (TextView) listItemView.findViewById(R.id.book_author);
        // Display the author of the book in that TextView
        authorTextView.setText(currentBook.getAuthor());

        assert currentBook != null;


        Log.i(LOG_TAG, "ListView has been returned");
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}