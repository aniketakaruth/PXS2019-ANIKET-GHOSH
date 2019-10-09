package com.example.parxsys.data.repositoryhelpers;

import androidx.lifecycle.LiveData;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;



public class LiveRealmData<T extends RealmObject> extends LiveData<RealmResults<T>> {

    private RealmResults<T> result;

    private final RealmChangeListener<RealmResults<T>> listener =
            new RealmChangeListener<RealmResults<T>>() {
                @Override
                public void onChange(RealmResults<T> newResult) {
                    result = newResult;
                }
            };

    public LiveRealmData(RealmResults<T> realmResults) {
        result = realmResults;
    }

    @Override
    protected void onActive() {
        if(result != null){
            result.addChangeListener(listener);
        }
    }

    @Override
    protected void onInactive() {
        if(result != null){

            result.removeChangeListener(listener);
        }
    }
}
