package alimov.com.githubapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import alimov.com.githubapi.R;
import alimov.com.githubapi.entity.Repository;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrey on 23.12.2016.
 */

public class AdapterRepositories extends RecyclerView.Adapter<AdapterRepositories.RepositoryViewHolder> {

    private List<Repository> mRepositories = new ArrayList<>();

    public AdapterRepositories(List<Repository> repositories) {
        mRepositories.addAll(repositories);
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repository, parent, false);
        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        Repository repository = mRepositories.get(position);

        holder.mTextViewName.setText(repository.getmName());
        holder.mTextViewLanguage.setText(repository.getmLanguage());
        holder.mTextViewForks.setText(repository.getmCountForks());
        holder.mTextViewStars.setText(repository.getmCountStars());
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_name)
        TextView mTextViewName;

        @BindView(R.id.text_view_language)
        TextView mTextViewLanguage;

        @BindView(R.id.text_view_forks)
        TextView mTextViewForks;

        @BindView(R.id.text_view_stars)
        TextView mTextViewStars;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
