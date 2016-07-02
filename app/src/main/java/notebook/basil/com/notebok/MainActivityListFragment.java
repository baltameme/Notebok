package notebook.basil.com.notebok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;


    @Override
    public void onActivityCreated(Bundle savedInstance) {

        super.onActivityCreated(savedInstance);

        notes = new ArrayList<Note>();
        notes.add(new Note("Facebook Note 2016", "FB Note Text", Note.Category.TECHNICHAL));

        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchDetailActivity(position);
    }

    private void launchDetailActivity(int position) {

        Note note = (Note)getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        intent.putExtra("note", note);

        startActivity(intent);
    }


}
