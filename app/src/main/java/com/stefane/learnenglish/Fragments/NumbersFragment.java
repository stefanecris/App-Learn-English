package com.stefane.learnenglish.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.stefane.learnenglish.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;

    private MediaPlayer mediaPlayer;

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numbers, container, false);

        buttonOne = view.findViewById(R.id.buttonOne);
        buttonTwo = view.findViewById(R.id.buttonTwo);
        buttonThree = view.findViewById(R.id.buttonThree);
        buttonFour = view.findViewById(R.id.buttonFour);
        buttonFive = view.findViewById(R.id.buttonFive);
        buttonSix = view.findViewById(R.id.buttonSix);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        int idSound = 0;

        switch(v.getId()){
            case R.id.buttonOne:
                idSound = R.raw.one;
                break;
            case R.id.buttonTwo:
                idSound = R.raw.two;
                break;

            case R.id.buttonThree:
                idSound = R.raw.three;
                break;
            case R.id.buttonFour:
                idSound = R.raw.four;
                break;
            case R.id.buttonFive:
                idSound = R.raw.five;
                break;
            case R.id.buttonSix:
                idSound = R.raw.six;
                break;
        }

        executeSound(v, idSound);

    }

    public void executeSound(View view, int idSound){
        mediaPlayer = MediaPlayer.create(getActivity(), idSound);
        if(mediaPlayer != null){
            mediaPlayer.start();
            resourcesFree();
        }
    }

    public void resourcesFree(){
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
