package notebook.basil.com.notebok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apple on 6/30/16.
 */
public class NoteAdapter extends ArrayAdapter<Note>{

    public static class ViewHolder {

        TextView noteTitle;
        TextView noteText;
        ImageView noteImage;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Note note = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            viewHolder.noteTitle = (TextView)convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.noteText = (TextView)convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteImage = (ImageView)convertView.findViewById(R.id.listItemNoteImg);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }


        viewHolder.noteTitle.setText(note.getTitle());
        viewHolder.noteText.setText(note.getMessage());
        viewHolder.noteImage.setImageResource(R.drawable.a);


        return convertView;
    }
}
