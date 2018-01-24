package br.app.carlosalberto.testeandroid;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import br.app.carlosalberto.testeandroid.dao.GitHubApiDao;
import br.app.carlosalberto.testeandroid.model.GitHubApi;
import br.app.carlosalberto.testeandroid.adapter.GitHubApiListAdapter;
import br.app.carlosalberto.testeandroid.servicos.ServiceSync;

import br.app.carlosalberto.testeandroid.model.pojo.RespostaApi.RespostaServidor;
import io.realm.RealmResults;

public class ActivityPrincipal extends AppCompatActivity {

    private ServiceSync sv;
    private GitHubApiListAdapter githubApiAdaptador;
    private RealmResults<GitHubApi> rgithubapi;
    private ListView githubLista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_principal);

        RespostaServidor resposta = new RespostaServidor();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sv = new ServiceSync(getApplicationContext());
        sv.githubdados();

        GitHubApiDao gitHubApiDao = new GitHubApiDao();

        githubLista = (ListView) findViewById(R.id.lv_github);

        rgithubapi = gitHubApiDao.getAll();
        githubApiAdaptador = new GitHubApiListAdapter(rgithubapi);
        githubLista.setAdapter(githubApiAdaptador);
        githubApiAdaptador.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
