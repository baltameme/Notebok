package notebook.basil.com.notebok;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {

    private ImageButton noteCatButton;
    private Note.Category savedBUttonCategory;
    private AlertDialog categoryDialogObj;

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
        noteCatButton = (ImageButton)fragment.findViewById(R.id.editNoteButton);

        Intent intent = getActivity().getIntent();
        Note note = (Note)intent.getSerializableExtra("note");

        title.setText(note.getTitle());
        message.setText(note.getMessage());
        noteCatButton.setImageResource(note.getAssociatedDrawable());

        buildCategoryDialog();

        noteCatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                categoryDialogObj.show();
            }
        });

        return fragment;
    }


    private void buildCategoryDialog() {

        final String[] categories = new String[]{"Personal", "Technichal", "Qoute", "Finance"};
        AlertDialog.Builder categoryBuilder = new AlertDialog.Builder(getActivity());
        categoryBuilder.setTitle("Choose Note Type");

        categoryBuilder.setSingleChoiceItems(categories, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                // Dismiss dialog window
                categoryDialogObj.cancel();
                switch (item) {

                    case 0:
                        savedBUttonCategory = Note.Category.PERSONAL;
                        noteCatButton.setImageResource(R.drawable.a);
                        break;

                    case 1:
                        savedBUttonCategory = Note.Category.TECHNICHAL;
                        noteCatButton.setImageResource(R.drawable.b);
                        break;

                    case 2:
                        savedBUttonCategory = Note.Category.QOUTE;
                        noteCatButton.setImageResource(R.drawable.c);
                        break;

                    case 3:
                        savedBUttonCategory = Note.Category.FINANCE;
                        noteCatButton.setImageResource(R.drawable.d);
                        break;

                }
            }
        });

        categoryDialogObj = categoryBuilder.create();
    }

}
