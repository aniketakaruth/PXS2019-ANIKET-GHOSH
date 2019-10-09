package com.example.parxsys.dependency.modules;

import android.content.Context;
import com.example.parxsys.data.constants.BuildConfiguration;
import com.example.parxsys.data.constants.Constants;
import com.example.parxsys.data.remote.EmployeeApiService;
import com.example.parxsys.dependency.scopes.ApplicationContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    Gson provideGson() {

        return new GsonBuilder()
                .registerTypeAdapterFactory(new LenientTypeAdapterFactory())
                .create();
    }


    @Provides
    File provideFile(@ApplicationContext Context context) {
        return new File(context.getCacheDir(), "babyvac-okhttp-cache");
    }


    @Provides
    Cache provideCache(File file) {
        return new Cache(file, 10 * 1000 * 1000); //cache for 10mb
    }

    @Provides
    OkHttpClient okHttpClient(Cache cache) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfiguration.LOG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return new OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }


    @Provides
    @Singleton
    EmployeeApiService provideEmployeeApiService(OkHttpClient okHttpClient, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(EmployeeApiService.class);
    }






    public class LenientTypeAdapterFactory implements TypeAdapterFactory {

        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);

            return new TypeAdapter<T>() {

                public void write(JsonWriter out, T value) throws IOException {
                    delegate.write(out, value);
                }

                public T read(JsonReader in) throws IOException {
                    try {
                        return delegate.read(in);
                    } catch (JsonSyntaxException e) {
                        in.skipValue();
                        return null;
                    }
                }
            };
        }
    }
}
