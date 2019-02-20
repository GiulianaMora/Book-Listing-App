package com.example.android.booklisting;

import android.os.Parcel;
import android.os.Parcelable;


public class Book implements Parcelable {

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
    /**
     * Title of the book
     */
    private String title;
    /**
     * Author of the book
     */
    private String author;

    /**
     * Author of the book
     */
    private String mUrl;



    /**
     * @param bookTitle     - (String) name of the book i.e.: "The Alchemist"
     * @param authorName    - (String) name of author i.e.: "Paulo Coelho"
     */
    public Book(String bookTitle, String authorName) {
        this.title = bookTitle;
        this.author = authorName;

    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrlBook() { return mUrl; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.mUrl);
    }


}
