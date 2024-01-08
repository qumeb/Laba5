package com.example.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuFragment extends Fragment {

    EditText FIO,Email;
    Button form_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FIO=view.findViewById(R.id.editText_FIO);
        Email=view.findViewById(R.id.editTextEmail);
        form_btn =(Button) view.findViewById(R.id.btn_form);
        form_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FIO.setText("");
                Email.setText("");
                Toast myToast= Toast.makeText(view.getContext(),"УСПЕХ!",Toast.LENGTH_SHORT);
                myToast.show();
            }
        });
    }
}