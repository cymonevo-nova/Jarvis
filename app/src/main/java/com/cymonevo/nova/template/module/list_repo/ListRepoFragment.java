package com.cymonevo.nova.template.module.list_repo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cymonevo.nova.template.R;
import com.cymonevo.nova.template.R2;
import com.cymonevo.nova.template.config.Http;
import com.cymonevo.nova.template.service.Provider;
import com.cymonevo.nova.template.service.api.APICall;
import com.cymonevo.nova.template.service.api.APIResponse;
import com.cymonevo.nova.template.service.api.github.GithubAPI;
import com.cymonevo.nova.template.service.api.github.entity.GithubRepository;
import com.cymonevo.nova.template.service.api.github.request.ListRepoRequest;

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
    private final int API_LIST_REPO_CODE = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_repo, container, false);
        ButterKnife.bind(this, root);
        rvListRepo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvListRepo.setLayoutManager(layoutManager);
        Provider.getGithubAPI().listRepos(this, API_LIST_REPO_CODE, new ListRepoRequest("cymon1997"));
        return root;
    }

    @Override
    public void onAPIResponse(int code, APIResponse response) {
        if (response.status == Http.STATUS_OK) {
            this.dataset = List.class.isInstance(response.payload)? List.class.cast(response.payload) : null;
            ListRepoAdapter adapter = new ListRepoAdapter(this.dataset);
            rvListRepo.setAdapter(adapter);
        } else {
            Toast.makeText(getContext(), response.message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAPIFailure(int code, String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
