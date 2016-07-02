package notebook.basil.com.notebok;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteViewFragment extends Fragment {


    public NoteViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_note_view, container, false);

        TextView title = (TextView)layout.findViewById(R.id.viewNoteTitle);
        TextView message = (TextView)layout.findViewById(R.id.viewNoteMessage);
        ImageView icon = (ImageView)layout.findViewById(R.id.viewNoteIcon);

        Intent intent = getActivity().getIntent();
        Note note = (Note) intent.getExtras().getSerializable("note");

        title.setText(note.getTitle());
        message.setText(note.getMessage());
        icon.setImageResource(note.getAssociatedDrawable());

        return layout;
    }

}
