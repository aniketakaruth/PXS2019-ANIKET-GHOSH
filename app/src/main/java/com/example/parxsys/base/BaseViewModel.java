package com.example.parxsys.base;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {

    private LoadingElements loadingElements;

    public BaseViewModel(LoadingElements loadingElements) {
        this.loadingElements = loadingElements;
    }
}
