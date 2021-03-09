package com.app.notepad.ui.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.notepad.MainActivity;
import com.app.notepad.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewFragment extends Fragment {
    public ViewFragment() {
        super(R.layout.fragment_views);
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
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.nav_entery);
            }
        });
    }
}


