package br.app.carlosalberto.testeandroid.servicos;

import android.content.Context;
import android.util.Base64;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;

public class ServiceFactory {
    private RestAdapter mAdapter;
    private String API_BASE_URL = "https://api.github.com";


    /**
     * Cria o adaptador para o REstAdapter e inicializa com os parametros.
     * @param context
     * @return
     */
    private RestAdapter getAdapter(final Context context) {
        if (mAdapter == null) {
            RequestInterceptor interceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade requestFacade) {

                    requestFacade.addHeader("Accept", "application/json");

                   // requestFacade.addHeader("ID", AppPreferences.newInstance(context).getFaceBookIDUser());
                   //requestFacade.addHeader("Token", AppPreferences.newInstance(context).getTokenFacebook());
                }
            };

            mAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_BASE_URL)
                    .setRequestInterceptor(interceptor)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setLog(new AndroidLog("ProjetoTeste"))
                    .build();
        }

        return mAdapter;
    }

    public <T> T create(Context context, Class<T> service) {

        return getAdapter(context).create(service);
    }
}
