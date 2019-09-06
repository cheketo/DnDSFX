package com.example.dndsfx;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class SoundBlock
{
    MediaPlayer mediaPlayer;
    private TextView _selectedSound;
    private Activity _activity;
    private Spinner _soundSpinner;

    public SoundBlock(Context context, Activity activity, int spinnerViewId, int textArrayResId, int selectedSoundId)
    {
        _activity = activity;

        _soundSpinner = activity.findViewById(spinnerViewId);
        ArrayAdapter<CharSequence> musicAdapter = ArrayAdapter.createFromResource(context, textArrayResId, android.R.layout.simple_spinner_item);

        musicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        _soundSpinner.setAdapter(musicAdapter);
        _soundSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) context);

        _selectedSound = (TextView) activity.findViewById(selectedSoundId);
    }

    public void changeSound()
    {
        String text = _soundSpinner.getSelectedItem().toString();

        _selectedSound.setTextSize( 20 );
        _selectedSound.setText( text );
/*
        SeekBar ambiente1 = findViewById(R.id.volumenAmbiente1);
        SeekBar ambiente2 = findViewById(R.id.volumenAmbiente2);

        ambiente1.setProgress( ambiente2.getProgress() );*/

        if(mediaPlayer != null)
        {
            mediaPlayer.stop();
        }

        mediaPlayer = MediaPlayer.create(_soundSpinner.getContext(), SoundManager.sounds.get(text));
        mediaPlayer.start();
        //Toast.makeText( _soundSpinner.getContext(), text + " " + SoundManager.sounds.get(text), Toast.LENGTH_SHORT).show();


    }
}
