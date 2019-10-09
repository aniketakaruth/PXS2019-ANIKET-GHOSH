package com.example.parxsys.utils;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmUtility {


    public static <T extends RealmObject> LiveData<List<T>> asLiveData(RealmResults<T> results) {
        return new com.example.parxsys.data.repositoryhelpers.LiveRealmDataList(results);
    }


}
