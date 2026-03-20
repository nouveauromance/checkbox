package br.gov.sp.cps.checkbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CheckBox ckVerde, ckVermelho, ckAzul;
    private TextView textResultado;
    private Button btnResultado;
    private RadioGroup radioGroup;
    private RadioButton rdOpA, rdOpB, rdOpC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // vincular os elementos view no layout
        ckAzul = findViewById(R.id.ckAzul);
        ckVerde = findViewById(R.id.ckVerde);
        ckVermelho = findViewById(R.id.ckVermelho);
        textResultado = findViewById(R.id.textResultado);
        btnResultado = findViewById(R.id.btnResultado);
        radioGroup = findViewById(R.id.radioGroup);
        rdOpA = findViewById(R.id.rbOpA);
        rdOpB = findViewById(R.id.rbOpB);
        rdOpC = findViewById(R.id.rbOpC);

        // chamar o "ouvinte" para executar
        /*btnResultado.setOnClickListener(view -> {
            String texto = "";
            if(ckVermelho.isChecked()){
                texto = texto + "Vermelho";
            }
            if(ckVerde.isChecked()){
                texto = texto + "Verde";
            }
            if(ckAzul.isChecked()){
                texto = texto + "Azul";
            }
            textResultado.setText(texto);
        });*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioButton();
    }

    // método para tratar RadioGroup
    public void radioButton(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup radioGroup, int i) {
                if(i == R.id.rbOpA){
                    textResultado.setText("Selecionado Op A");
                }
                if(i == R.id.rbOpB){
                    textResultado.setText("Selecionado Op B");
                }
                if(i == R.id.rbOpC){
                    textResultado.setText("Selecionado Op C");
                }
            }
        });
    }
}