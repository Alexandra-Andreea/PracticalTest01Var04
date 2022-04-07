package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private Button navigateButton;
    private CheckBox nameCheckBox;
    private EditText nameEditText;
    private CheckBox groupCheckBox;
    private EditText groupEditText;
    private Button displayInfoButton;
    private TextView textInView;

    private NavigateToActivitiesClickListener navigateButtonListener = new NavigateToActivitiesClickListener();
    private DisplayInfoClickListener displayButtonListener = new DisplayInfoClickListener();

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        nameEditText = (EditText)findViewById(R.id.name_edit_text);
        groupEditText = (EditText)findViewById(R.id.group_edit_text);
        nameEditText.setText("");
        groupEditText.setText("");

        displayInfoButton = (Button) findViewById(R.id.display_button);
        displayInfoButton.setOnClickListener(displayButtonListener);

        navigateButton = (Button) findViewById(R.id.navigate_button);
        navigateButton.setOnClickListener(navigateButtonListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.NAME, nameEditText.getText().toString());
        savedInstanceState.putString(Constants.GROUP, groupEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.NAME)) {
            nameEditText.setText(savedInstanceState.getString(Constants.NAME));
        }
        else {
            nameEditText.setText("");
        }

        if (savedInstanceState.containsKey(Constants.GROUP)) {
            groupEditText.setText(savedInstanceState.getString(Constants.GROUP));
        }
        else {
            groupEditText.setText("0");
        }
    }

    private class NavigateToActivitiesClickListener implements View.OnClickListener {
        @Override
        public void onClick (View view) {

        }
    }

    private class DisplayInfoClickListener implements View.OnClickListener {
        @Override
        public void onClick (View view) {
            context = getApplicationContext();

            nameEditText = (EditText)findViewById(R.id.name_edit_text);
            groupEditText = (EditText)findViewById(R.id.group_edit_text);

            nameCheckBox = (CheckBox)findViewById(R.id.name_check_box);
            groupCheckBox = (CheckBox)findViewById(R.id.group_check_box);

            textInView = (TextView) findViewById(R.id.text_view_after_click);
            String myText = "";

            if (nameCheckBox.isChecked()) {
                if (nameEditText.getText().toString() != null)
                    myText = myText + nameEditText.getText().toString();
                else
                    Toast.makeText(context, "Eroare", Toast.LENGTH_LONG).show();
            }

            if (groupCheckBox.isChecked()) {
                if (groupCheckBox.getText().toString() != null)
                    myText = myText + groupEditText.getText().toString();
                else
                    Toast.makeText(context, "Eroare", Toast.LENGTH_LONG).show();
            }

            textInView.setText(myText.toString());
        }
    }
}