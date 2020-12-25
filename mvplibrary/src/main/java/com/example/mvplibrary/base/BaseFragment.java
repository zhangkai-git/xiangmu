package com.example.mvplibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.function.Predicate;

public abstract class BaseFragment<P> extends Fragment {
    public P Presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutID(), container, false);
        if (Presenter == null) {
            Presenter = getPresenter();
        }
        initView(inflate);
        initData();
        return inflate;

    }

    protected abstract void initData();

    protected abstract void initView(View inflate);

    protected abstract P getPresenter();

    protected abstract int getLayoutID();
}