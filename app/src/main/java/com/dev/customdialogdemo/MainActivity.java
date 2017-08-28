package com.dev.customdialogdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        AlertDialog.Builder mDialog = new AlertDialog.Builder(this);
        View mDialogLayout  = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
        mDialog.setView(mDialogLayout);
        ListView lvItems  = mDialogLayout.findViewById(R.id.lv_security_questions);
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.security_questions));
        lvItems.setAdapter(mStringArrayAdapter);
        mDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("You clicked ok");
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showToast("You clicked cancel");
            }
        });
        mDialog.show();

    }

    private void showToast( String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
