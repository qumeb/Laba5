package com.example.lab5;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class QuestionFragment extends Fragment {

    Button question_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        question_btn = view.findViewById(R.id.question_btn);
        question_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String[] items = {"Яблоко", "Лампочка"};
                final boolean[] selectedItems = {false, false};

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMultiChoiceItems(items, selectedItems,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which, boolean isChecked) {
                                        selectedItems[which] = isChecked;
                                    }

                                })
                        .setPositiveButton("Готово",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        String selected="";

                                        if(selectedItems[1]==true && selectedItems[0]==false){
                                            Toast toast=Toast.makeText(getActivity(),"Правильно!",Toast.LENGTH_SHORT);
                                            toast.show();
                                        }
                                        else {
                                            Toast toast=Toast.makeText(getActivity(),"Нет!",Toast.LENGTH_SHORT);
                                            toast.show();
                                        }

                                    }
                                })

                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}