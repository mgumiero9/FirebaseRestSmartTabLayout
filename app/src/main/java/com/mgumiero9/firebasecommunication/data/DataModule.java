package com.mgumiero9.firebasecommunication.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mgumiero9.firebasecommunication.BuildConfig;
import com.mgumiero9.firebasecommunication.data.remote.Api;
import com.mgumiero9.firebasecommunication.data.repository.DemoRepository;
import com.mgumiero9.firebasecommunication.data.repository.DemoRepositoryImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private static final int TIMEOUT = 30;

    /**
     * @param gson         Gson object
     * @param okHttpClient Http client
     * @return Api
     */
    @Provides
    @Singleton
    Api provideApi(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Api.class);
    }

    /**
     * @return Gson
     */
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    /**
     * @param httpLoggingInterceptor HttpLogging Interceptor
     * @return OkHttpClient
     */
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    /**
     * @return HttpLogginInterceptor
     */
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    DemoRepository provideDemoRepository(Api api) {
        return new DemoRepositoryImpl(api);
    }
}