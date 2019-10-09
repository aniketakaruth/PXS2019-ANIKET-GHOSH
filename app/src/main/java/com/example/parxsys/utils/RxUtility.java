package com.example.parxsys.utils;

import io.reactivex.disposables.Disposable;

public class RxUtility {

    public static void dispose(Disposable subscription) {
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

}
