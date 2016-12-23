package alimov.com.githubapi.presentation.ui.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import alimov.com.githubapi.R;
import alimov.com.githubapi.presentation.contract.SearchContract;
import alimov.com.githubapi.presentation.ui.activity.ProfileActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Andrey on 21.12.2016.
 */

public class SearchFragment extends Fragment implements SearchContract.View {

    @BindView(R.id.edit_text_user_name)
    EditText mEditText;

    @OnClick(R.id.button_find)
    void find() {
        mPresenter.onSearch(mEditText.getText().toString());
    }

    private ProgressDialog mDialog;

    private SearchContract.Presenter mPresenter;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    public SearchFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, root);

        mEditText.setText("AlimovAndrey");

        mDialog = new ProgressDialog(getContext());
        mDialog.setMessage(getResources().getString(R.string.search_message_dialog));

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void startProfile(String name, String login) {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        intent.putExtra(ProfileActivity.KEY_NAME, name);
        intent.putExtra(ProfileActivity.KEY_LOGIN, login);
        getActivity().startActivity(intent);
    }

    @Override
    public void showError(String url) {
        mEditText.setError(getResources().getString(R.string.search_error_empty_name));
        mEditText.requestFocus();
    }

    @Override
    public void showDialog() {
        if (!mDialog.isShowing()) {
            mDialog.show();
        }
    }

    @Override
    public void hideDialog() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }


}
