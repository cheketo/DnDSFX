package com.example.dndsfx;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView musicaSeleccionada;

    TextView ambienteSeleccionado;

    String textoMusica = "";

    String textoAmbiente = "";

//    String path = Environment.getExternalStorageDirectory().toString() + "/Pictures";
//    Log.d("Files", "Path: " + path);
//        File directory = new File(path);
//        File[] files = directory.listFiles();
//    Log.d("Files", "Size: "+ files.length);
//    for (int i = 0; i < files.length; i++)
//        {
//            Log.d("Files", "FileName:" + files[i].getName());
//        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerMusica = findViewById(R.id.spinnerMusica);
        ArrayAdapter<CharSequence> adapterMusica = ArrayAdapter.createFromResource(this, R.array.musicas,android.R.layout.simple_spinner_item);
        adapterMusica.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMusica.setAdapter(adapterMusica);
        spinnerMusica.setOnItemSelectedListener(this);

        Spinner spinnerAmbiente = findViewById(R.id.spinnerAmbiente);
        ArrayAdapter<CharSequence> adapterAmbiente = ArrayAdapter.createFromResource(this, R.array.ambientes,android.R.layout.simple_spinner_item);
        adapterAmbiente.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAmbiente.setAdapter(adapterAmbiente);
        spinnerAmbiente.setOnItemSelectedListener(this);

        musicaSeleccionada = (TextView) findViewById(R.id.musicaSeleccionada);

        ambienteSeleccionado = (TextView) findViewById(R.id.ambienteSeleccionado);

        // Load Music



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
//        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void cambiarMusica( View view )
    {
        Spinner spinnerMusica = findViewById(R.id.spinnerMusica);
        String text = spinnerMusica.getSelectedItem().toString();

        musicaSeleccionada.setTextSize( 20 );
        musicaSeleccionada.setText( text );

        SeekBar musica1 = findViewById(R.id.volumenMusica1);
        SeekBar musica2 = findViewById(R.id.volumenMusica2);

        musica1.setProgress( musica2.getProgress() );

        Toast.makeText( spinnerMusica.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    public void cambiarAmbiente( View view )
    {

        Spinner spinnerAmbiente = findViewById(R.id.spinnerAmbiente);
        String text = spinnerAmbiente.getSelectedItem().toString();

        ambienteSeleccionado.setTextSize( 20 );
        ambienteSeleccionado.setText( text );

        SeekBar ambiente1 = findViewById(R.id.volumenAmbiente1);
        SeekBar ambiente2 = findViewById(R.id.volumenAmbiente2);

        ambiente1.setProgress( ambiente2.getProgress() );

        Toast.makeText( spinnerAmbiente.getContext(), text, Toast.LENGTH_SHORT).show();


    }
}
