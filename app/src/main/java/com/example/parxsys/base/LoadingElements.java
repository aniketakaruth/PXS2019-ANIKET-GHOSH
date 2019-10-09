package com.example.parxsys.base;

public interface LoadingElements {

    void showLoading(String message);

    void hideLoading();

    void showToast(String message);

    void endScreen();

    void hideKeyboard();

    void showSnackBar(String message);

    void showAlert(String message);

}
