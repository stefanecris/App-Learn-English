package com.stefane.learnenglish.Fragments;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.stefane.learnenglish.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalsFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonDog, buttonCat, buttonLion, buttonMonkey, buttonSheep, buttonCow;

    private MediaPlayer mediaPlayer;

    public AnimalsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        // Na Activity, posso acessar alguns métodos diretamente. Porém, aqui não!
        buttonDog = view.findViewById(R.id.buttonDog);
        buttonCat = view.findViewById(R.id.buttonCat);
        buttonLion = view.findViewById(R.id.buttonLion);
        buttonMonkey = view.findViewById(R.id.buttonMonkey);
        buttonSheep = view.findViewById(R.id.buttonSheep);
        buttonCow = view.findViewById(R.id.buttonCow);

        buttonDog.setOnClickListener(this);
        buttonCat.setOnClickListener(this);
        buttonLion.setOnClickListener(this);
        buttonMonkey.setOnClickListener(this);
        buttonSheep.setOnClickListener(this);
        buttonCow.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        // Log.i("Elemento clicado", "Item: " + v.getId());

        switch(v.getId()){
            case R.id.buttonDog:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                break;
            case R.id.buttonCat:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                break;
            case R.id.buttonLion:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                break;
            case R.id.buttonMonkey:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                break;
            case R.id.buttonSheep:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                break;
            case R.id.buttonCow:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                break;
        }

        executeSound(v);

    }

    public void executeSound(View view){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }

        // Add evente quando o som é finalizado
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.release(); // Libera recursos
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
