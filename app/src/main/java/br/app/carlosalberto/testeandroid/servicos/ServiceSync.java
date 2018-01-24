package br.app.carlosalberto.testeandroid.servicos;

import java.util.List;
import android.content.Context;
import android.util.Log;

import br.app.carlosalberto.testeandroid.dao.GitHubApiDao;
import br.app.carlosalberto.testeandroid.model.GitHubApi;
import br.app.carlosalberto.testeandroid.model.pojo.RespostaApi.RespostaServidor;
import retrofit.RetrofitError;

public class ServiceSync {

    private static final String TAG = "ProjetoTest.ServiceSync";

    private Context mContext;

   //rivate GitHubRepository gitHubRepository;

    public Boolean retorno;

    public ServiceSync(Context context) {
        mContext = context;
     //   gitHubRepository = new gitHubRepository();

    }

    /**
     * Coleta as Informações da api do GifHub para carregar o banco interno
     * @return
     */
    public boolean githubdados()
    {



        ServiceFactory sv = new ServiceFactory();
        try {
            RespostaServidor respostaServidor = sv.create(mContext, GitHubAPI.class).buscaGitHub();
            //retorno = wsretorno.getResponse_data().get.get("found").toString();

            for (int item = 0; item <= 20; item++) {
                Log.d(TAG, "RETORNO");

                Log.d(TAG, "ID do Respositorio >" + respostaServidor.getItems().get(item).getId());
                Log.d(TAG, "Nome do Respositorio >" + respostaServidor.getItems().get(item).getName());
                Log.d(TAG, "Nome Completo do Respositorio >" + respostaServidor.getItems().get(item).getFullName());
                Log.d(TAG, "Nome do Responsavel >" + respostaServidor.getItems().get(item).getOwner().getLogin());
                Log.d(TAG, "Descricao do Repositorio >" + respostaServidor.getItems().get(item).getDescription());
                Log.d(TAG, "Forks : " + respostaServidor.getItems().get(item).getForks());
                Log.d(TAG, "Stars : " + respostaServidor.getItems().get(item).getStargazersCount());
                Log.d(TAG, "Link Img Avatar : " + respostaServidor.getItems().get(item).getOwner().getAvatarUrl());
                Log.d(TAG, "Link do Pull Request : " + respostaServidor.getItems().get(item).getPullsUrl());

                GitHubApi gitHubApi = new GitHubApi();
                gitHubApi.setId(respostaServidor.getItems().get(item).getId());
                gitHubApi.setName(respostaServidor.getItems().get(item).getName());
                gitHubApi.setDescription(respostaServidor.getItems().get(item).getDescription());
                gitHubApi.setForks(respostaServidor.getItems().get(item).getForks().toString());
                gitHubApi.setStargazerscount(respostaServidor.getItems().get(item).getStargazersCount().toString());
                gitHubApi.setAvatarurl(respostaServidor.getItems().get(item).getOwner().getAvatarUrl());
                // Gravar dados no banco local.
                gravaGitHubApiDB(gitHubApi);
            }

        } catch(RetrofitError e2){
            e2.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return true;
    }

    private void gravaGitHubApiDB (GitHubApi gitHubApi) {

        GitHubApiDao gitHubAPIDao = new GitHubApiDao();

        gitHubAPIDao.salvaGitHubApi(gitHubApi);
    }

}

