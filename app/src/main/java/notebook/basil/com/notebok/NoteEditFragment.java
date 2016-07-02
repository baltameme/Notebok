package notebook.basil.com.notebok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {


    public NoteEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_note_edit, container, false);

        EditText title = (EditText)fragment.findViewById(R.id.editNoteTitle);
        EditText message = (EditText)fragment.findViewById(R.id.editNoteMessage);
        ImageButton noteCatButton = (ImageButton)fragment.findViewById(R.id.editNoteButton);

        Intent intent = getActivity().getIntent();
        Note note = (Note)intent.getSerializableExtra("note");

        title.setText(note.getTitle());
        message.setText(note.getMessage());
        noteCatButton.setImageResource(note.getAssociatedDrawable());

        return fragment;
    }

}
