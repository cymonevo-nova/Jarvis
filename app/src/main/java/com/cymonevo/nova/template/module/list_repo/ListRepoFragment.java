package com.cymonevo.aurora.template.module.list_repo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cymonevo.aurora.template.R;
import com.cymonevo.aurora.template.R2;
import com.cymonevo.aurora.template.config.API.HttpStatus;
import com.cymonevo.aurora.template.service.API.APICall;
import com.cymonevo.aurora.template.service.API.APIResponse;
import com.cymonevo.aurora.template.service.API.github.GithubAPI;
import com.cymonevo.aurora.template.service.API.github.entity.GithubRepository;
import com.cymonevo.aurora.template.service.API.github.request.ListRepoRequest;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListRepoFragment extends Fragment implements APICall {
    List<GithubRepository> dataset;

    @BindView(R2.id.rv_list_repo)
    RecyclerView rvListRepo;
    LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_repo, container, false);
        ButterKnife.bind(this, root);
        rvListRepo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvListRepo.setLayoutManager(layoutManager);
        GithubAPI.listRepos(this, new ListRepoRequest("cymon1997"));
        return root;
    }

    @Override
    public void onResponse(APIResponse response) {
        if (response.status == HttpStatus.STATUS_OK) {
            this.dataset = List.class.isInstance(response.payload)? List.class.cast(response.payload) : null;
            ListRepoAdapter adapter = new ListRepoAdapter(this.dataset);
            rvListRepo.setAdapter(adapter);
        } else {
            Toast.makeText(getContext(), response.message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(APIResponse response) {
        Toast.makeText(getContext(), response.message, Toast.LENGTH_SHORT).show();
    }
}
