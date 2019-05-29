package com.cymonevo.nova.template.module.list_repo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cymonevo.nova.template.R;
import com.cymonevo.nova.template.service.api.github.entity.GithubRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListRepoAdapter extends RecyclerView.Adapter<ListRepoAdapter.ListRepoViewHolder> {
    public static class ListRepoViewHolder extends RecyclerView.ViewHolder {
        View layout;
        @BindView(R.id.tv_repo_name)
        TextView tvRepoName;
        @BindView(R.id.tv_repo_desc)
        TextView tvRepoDesc;
        @BindView(R.id.tv_repo_url)
        TextView tvRepoUrl;

        public ListRepoViewHolder(View layout) {
            super(layout);
            this.layout = layout;
            ButterKnife.bind(this, this.layout);
        }

        public void setData(GithubRepository repo) {
            String name = (repo.isPrivate)? repo.name + " (private)" : repo.name;
            tvRepoName.setText(name);
            tvRepoDesc.setText(repo.description);
            tvRepoUrl.setText(repo.url);
        }
    }

    private List<GithubRepository> dataset;

    public ListRepoAdapter(List<GithubRepository> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ListRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ListRepoViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ListRepoViewHolder holder, int position) {
        holder.setData(this.dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return this.dataset.size();
    }
}
