package eder.padilla.personal.works.realmexample;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nombre,
            posicion,
            dorsal,
            email;
    private Button   siguiente;
    Realm realm;
    int numdor = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        objetInit();
    }
    public void objetInit(){
        nombre=(EditText)findViewById(R.id.nombre);
        posicion=(EditText)findViewById(R.id.posicion);
        dorsal=(EditText)findViewById(R.id.dorsal);
        email=(EditText)findViewById(R.id.email);
        siguiente=(Button)findViewById(R.id.siguiente);
        siguiente.setOnClickListener(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        realm = Realm.getInstance(realmConfig);
    }
    public void createUser(Modelo modelo) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(modelo);
        realm.commitTransaction();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.siguiente:
                numdor = Integer.parseInt(dorsal.getText().toString());
                createUser(new Modelo(nombre.getText().toString(), posicion.getText().toString(),
                        numdor,email.getText().toString() ));
                Intent myIntent = new Intent(MainActivity.this, Resultados.class);
                MainActivity.this.startActivity(myIntent);
                break;
        }

    }
}

