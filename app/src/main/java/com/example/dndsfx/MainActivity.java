package com.example.dndsfx;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    SoundBlock sbMusic;
    SoundBlock sbAmbient;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbMusic = new SoundBlock(this,this, R.id.spinnerMusica, R.array.musicas, R.id.musicaSeleccionada);

        sbAmbient = new SoundBlock(this,this, R.id.spinnerAmbiente, R.array.ambientes, R.id.ambienteSeleccionado);

        SoundManager sm = new SoundManager();
    }

    public void playMusic(View view)
    {
        sbMusic.changeSound();
    }

    public void playAmbient(View view)
    {
        sbAmbient.changeSound();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
