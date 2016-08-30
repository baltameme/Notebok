package notebook.basil.com.notebok;

import java.io.Serializable;

/**
 * Created by apple on 6/23/16.
 */
public class Note implements Serializable {

    private String title, message;
    private long dateCreatedMilli, noteId;
    private Category category;

    public enum Category {PERSONAL, TECHNICHAL, QOUTE, FINANCE};


    public Note(String title, String message, Category category) {
        this.title = title;
        this.message = message;
        this.category = category;
        this.noteId = 0;
        this.dateCreatedMilli = 0;
    }

    public Note(String title, String message, long dateCreatedMilli, long noteId, Category category) {
        this.title = title;
        this.message = message;
        this.dateCreatedMilli = dateCreatedMilli;
        this.noteId = noteId;
        this.category = category;
    }

    // Implement Getters


    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public long getDate() {
        return dateCreatedMilli;
    }

    public long getId() {
        return noteId;
    }

    public int getAssociatedDrawable() {
        return R.drawable.a;
    }

    public static int categoryToDrawable(Category noteCategory) {
        switch (noteCategory) {

            case PERSONAL:
                return R.drawable.a;

            case TECHNICHAL:
                return R.drawable.b;

            case QOUTE:
                return R.drawable.c;

            case FINANCE:
                return R.drawable.d;

            default:
                return R.drawable.a;
        }
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", dateCreatedMilli=" + dateCreatedMilli +
                ", noteId=" + noteId +
                ", Category Name =" + category.name();
    }


}
