package notebook.basil.com.notebok;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {

    private ImageButton noteCatButton;
    private Note.Category savedButtonCategory;
    private AlertDialog categoryDialogObj, confirmDialogObj;
    private EditText title, message;

    private static final String MODIFY_CATEGORY = "Modify Category";

    private boolean newNote = false;

    public NoteEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            newNote = bundle.getBoolean(NoteDetailActivity.NEW_NOTE_EXTRA, false);
        }

        // Restore last saved category Instance
        if(savedInstanceState != null) {
            savedButtonCategory = (Note.Category) savedInstanceState.get(MODIFY_CATEGORY);
        }

        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_note_edit, container, false);

        title = (EditText)fragment.findViewById(R.id.editNoteTitle);
        message = (EditText)fragment.findViewById(R.id.editNoteMessage);
        noteCatButton = (ImageButton)fragment.findViewById(R.id.editNoteButton);
        Button saveButton = (Button)fragment.findViewById(R.id.saveNote);

        Intent intent = getActivity().getIntent();
        Note note = (Note)intent.getSerializableExtra("note");

        title.setText(note.getTitle());
        message.setText(note.getMessage());

        // Set Saved Category Image
        if(savedButtonCategory != null) {
            noteCatButton.setImageResource(Note.categoryToDrawable(savedButtonCategory));

        } else if(!newNote) {
            savedButtonCategory = note.getCategory();
            noteCatButton.setImageResource(note.getAssociatedDrawable());
        }

        buildCategoryDialog();
        buildConfirmDialog();


        noteCatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                categoryDialogObj.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                confirmDialogObj.show();
            }
        });


        return fragment;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MODIFY_CATEGORY, savedButtonCategory);
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



                }
            }
        });

        categoryDialogObj = categoryBuilder.create();
    }

    private void buildConfirmDialog() {
        AlertDialog.Builder confirmBuilder = new AlertDialog.Builder(getActivity());
        confirmBuilder.setTitle("Are you Sure ?");
        confirmBuilder.setMessage("Are you Sure to set a new Icon?");

        // Set OK Button
        confirmBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.d("Save Note", "Note Title: " + title.getText() +
                                    "Note Text: " + message.getText() +
                                    "Note Category: " + savedButtonCategory);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Set Cancel Button
        confirmBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        confirmDialogObj = confirmBuilder.create();

    }

}
