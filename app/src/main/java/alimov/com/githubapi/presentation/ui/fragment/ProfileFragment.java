package alimov.com.githubapi.presentation.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import alimov.com.githubapi.R;
import alimov.com.githubapi.adapter.AdapterRepositories;
import alimov.com.githubapi.entity.Repository;
import alimov.com.githubapi.entity.User;
import alimov.com.githubapi.presentation.contract.ProfileContract;
import alimov.com.githubapi.presentation.ui.activity.ProfileActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Andrey on 21.12.2016.
 */

public class ProfileFragment extends Fragment implements ProfileContract.View {

    @BindView(R.id.image_view_avatar)
    ImageView mImageViewAvatar;

    @BindView(R.id.text_view_name)
    TextView mTextViewName;

    @BindView(R.id.text_view_email)
    TextView mTextViewEmail;

    @BindView(R.id.text_view_company)
    TextView mTextViewCompany;

    @BindView(R.id.text_view_followers)
    TextView mTextViewFollowers;

    @BindView(R.id.text_view_following)
    TextView mTextViewFollowing;

    @BindView(R.id.text_view_gists)
    TextView mTextViewGists;

    @BindView(R.id.text_view_repos)
    TextView mTextViewRepos;

    @BindView(R.id.text_view_empty_list)
    TextView mTextViewEmptyList;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.recycler_view_repositories)
    RecyclerView mRecyclerViewRepos;

    private ProfileContract.Presenter mPresenter;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, root);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerViewRepos.setLayoutManager(manager);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull ProfileContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        if (intent != null && intent.getExtras() != null) {
            String name = intent.getExtras().getString(ProfileActivity.KEY_NAME);
            String login = intent.getExtras().getString(ProfileActivity.KEY_LOGIN);
            mPresenter.loadUser(name);
            mPresenter.loadUserRepositories(login);
        }
    }


    @Override
    public void showToast() {
        Toast.makeText(getActivity(), getResources().getString(R.string.profile_toast_save), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openShare(String url) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getResources().getString(R.string.profile_url) + url);
        startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.profile_share_title)));
    }

    @Override
    public void openInBrowser(String login) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.profile_url) + login));
        startActivity(browserIntent);
    }

    @Override
    public void fillUserContent(User user) {
        getActivity().setTitle(user.getmLogin());

        mTextViewName.setText(getResources().getString(R.string.profile_name) + " " + user.getmName());
        if (user.getmEmail() == null) {
            mTextViewEmail.setVisibility(View.GONE);
        } else {
            mTextViewEmail.setVisibility(View.VISIBLE);
            mTextViewEmail.setText(getResources().getString(R.string.profile_email) + " " + user.getmEmail());
        }
        if (user.getmCompany() == null) {
            mTextViewCompany.setVisibility(View.GONE);
        } else {
            mTextViewCompany.setVisibility(View.VISIBLE);
            mTextViewCompany.setText(getResources().getString(R.string.profile_company) + " " + user.getmCompany());
        }
        mTextViewFollowers.setText(getResources().getString(R.string.profile_followers) + " " + user.getmFollowers());
        mTextViewFollowing.setText(getResources().getString(R.string.profile_following) + " " + user.getmFollowing());
        mTextViewGists.setText(getResources().getString(R.string.profile_gists) + " " + user.getmGists());
        mTextViewRepos.setText(getResources().getString(R.string.profile_repos) + " " + user.getmRepos());

        Picasso.with(getContext())
                .load(user.getmAvatarUrl())
                .centerCrop()
                .fit()
                .into(mImageViewAvatar);
    }

    @Override
    public void fillUserRepositories(List<Repository> repositories) {
        mProgressBar.setVisibility(View.INVISIBLE);
        if (repositories.size() == 0) {
            mTextViewEmptyList.setVisibility(View.VISIBLE);
            mRecyclerViewRepos.setVisibility(View.INVISIBLE);
        } else {
            mTextViewEmptyList.setVisibility(View.INVISIBLE);
            mRecyclerViewRepos.setVisibility(View.VISIBLE);
            mRecyclerViewRepos.setAdapter(new AdapterRepositories(repositories));
        }
    }


}
