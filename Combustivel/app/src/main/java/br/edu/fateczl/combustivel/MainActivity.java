package br.edu.fateczl.combustivel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 *@author:<Gustavo de Paula>
*/
public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private EditText etGasolina, etEtanol;
    private Button btnVerificar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etGasolina = findViewById(R.id.etValorGasolina);
        etEtanol = findViewById(R.id.etValorEtanol);
        tvResultado = findViewById(R.id.tvResultado);
        btnVerificar = findViewById(R.id.btnVer);

        btnVerificar.setOnClickListener(op -> ver());
    }
    private void ver(){
        double gasolina = Double.parseDouble(etGasolina.getText().toString());
        double etanol = Double.parseDouble(etEtanol.getText().toString());

        if (etanol <= (0.7 * gasolina)){
            tvResultado.setText("Etanol é mais vantajoso");
        } else {
            tvResultado.setText("Gasolina é mais vantajosa");
        }
        etGasolina.setText("");
        etEtanol.setText("");
    }


}