package eder.padilla.personal.works.realmexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

public class Resultados extends AppCompatActivity {

    TextView tv_resultados;
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        tv_resultados =(TextView)findViewById(R.id.resultados);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).build();
        realm = Realm.getInstance(realmConfig);
        getUsers();
    }
    public void getUsers() {

        RealmResults<Modelo> results = realm.where(Modelo.class).findAll();
        results.sort("nombre");
        results.sort("nombre", Sort.ASCENDING);
        for (Modelo modelo : results) {
            tv_resultados.append("Nombre :"+ modelo.getNombre() +"\n"+
                                  "Posicion: "+ modelo.getPosicion()+"\n"+
                                  "Numero Dorsal: "+ modelo.getNumeroDorsal() +"\n"+
                                  "emai: "+modelo.getCorreo() +"\n" );
        }
    }

}
