package br.app.carlosalberto.testeandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import br.app.carlosalberto.testeandroid.R;
import br.app.carlosalberto.testeandroid.model.GitHubApi;
import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import com.squareup.picasso.Picasso;
import br.app.carlosalberto.testeandroid.MyApplication;

public class GitHubApiListAdapter extends RealmBaseAdapter<GitHubApi> implements ListAdapter {

    private Context context = MyApplication.getContext();

    private static class ViewHolder {
        TextView name;
        TextView descricao;
        ImageView avatar;
        TextView forks;
        TextView stars;
    }

    public GitHubApiListAdapter(OrderedRealmCollection<GitHubApi> realmResults) {
        super(realmResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name =  (TextView)convertView.findViewById(R.id.tv_respositorio);
            viewHolder.descricao = (TextView) convertView.findViewById(R.id.tv_descricao);
            viewHolder.forks = (TextView) convertView.findViewById(R.id.tv_forks);
            viewHolder.stars = (TextView) convertView.findViewById(R.id.tv_estrelas);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.iv_avatar);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (adapterData != null) {
            final GitHubApi githubapi = adapterData.get(position);
            viewHolder.name.setText(githubapi.getName());
            viewHolder.descricao.setText(githubapi.getDescription());
            if(githubapi.getDescription().length() > 30) {
                viewHolder.descricao.setHeight(githubapi.getDescription().length()+15);
            }
            viewHolder.forks.setText(githubapi.getForks());
            viewHolder.stars.setText(githubapi.getStargazerscount());

            Picasso.with(context).load(githubapi.getAvatarurl()).into(viewHolder.avatar);
        }
        return convertView;
    }
}
