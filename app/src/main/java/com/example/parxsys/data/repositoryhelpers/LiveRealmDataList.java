package com.example.parxsys.data.repositoryhelpers;

import androidx.lifecycle.LiveData;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmResults;

public class LiveRealmDataList<T extends RealmModel> extends LiveData<RealmResults<T>> {

    private RealmResults<T> results;

    private final RealmChangeListener<RealmResults<T>> listener =
            new RealmChangeListener<RealmResults<T>>() {
                @Override
                public void onChange(RealmResults<T> results) {
                    setValue(results);
                }
            };

    public LiveRealmDataList(RealmResults<T> realmResults) {
        results = realmResults;
    }

    @Override
    protected void onActive() {
        if (results != null)
            results.addChangeListener(listener);
    }

    @Override
    protected void onInactive() {
        if (results != null)
            results.removeChangeListener(listener);
    }
}
