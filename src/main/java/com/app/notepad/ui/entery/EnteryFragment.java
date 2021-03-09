package com.app.notepad.ui.entery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.notepad.MainActivity;
import com.app.notepad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;

public class EnteryFragment extends Fragment {

    private final static String FILE_NAME = "file.txt";
    private final static String FILE_NAME1 = "file.doc";

    public EnteryFragment() {
        super(R.layout.fragment_entery);
        MainActivity main = new MainActivity();
    }

    private File getExternalPath() {
        return new File(getActivity().getExternalFilesDir(null), FILE_NAME);
    }

    private File getExternalPath1() {
        return new File(getActivity().getExternalFilesDir(null), FILE_NAME1);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        FloatingActionButton fab3 = (FloatingActionButton) view.findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View view) {
                if(i%2 == 0) {
                    fab2.show();
                    fab3.show();
                }
                else {
                    fab2.hide();
                    fab3.hide();
                }
                i++;
            }
        });
        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                try {
                    EditText title = (EditText) view.findViewById(R.id.title);
                    EditText textBox = (EditText) view.findViewById(R.id.text);

                    String text = textBox.getText().toString();

                    fos = new FileOutputStream(getExternalPath());
                    fos.write(text.getBytes());
                    Toast.makeText(getActivity(), "File Save", Toast.LENGTH_SHORT).show();
                }
                catch(IOException ex) {

                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                finally{
                    try{
                        if(fos!=null)
                            fos.close();
                    }
                    catch(IOException ex){

                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                fab2.hide();
                fab3.hide();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FileOutputStream fos = null;
                try {
                    EditText title = (EditText) view.findViewById(R.id.title);
                    EditText textBox = (EditText) view.findViewById(R.id.text);

                    String text = textBox.getText().toString();

                    fos = new FileOutputStream(getExternalPath1());
                    fos.write(text.getBytes());
                    Toast.makeText(getActivity(), "File Save", Toast.LENGTH_SHORT).show();
                }
                catch(IOException ex) {

                    Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                finally{
                    try{
                        if(fos!=null)
                            fos.close();
                    }
                    catch(IOException ex){

                        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                fab2.hide();
                fab3.hide();
            }
        });
    }
}

