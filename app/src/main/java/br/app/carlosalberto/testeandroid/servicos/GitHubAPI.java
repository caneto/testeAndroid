package br.app.carlosalberto.testeandroid.servicos;

import br.app.carlosalberto.testeandroid.model.pojo.RespostaApi.RespostaServidor;
import retrofit.http.GET;

public interface GitHubAPI {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    RespostaServidor buscaGitHub();


}
