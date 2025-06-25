import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Book implements Serializable {
    private String title, author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }
    public void borrow() { isBorrowed = true; }

    public String toString() {
        return title + " by " + author + (isBorrowed ? " [Borrowed]" : "");
    }
}
