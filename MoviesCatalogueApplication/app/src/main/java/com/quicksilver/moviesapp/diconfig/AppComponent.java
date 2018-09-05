package com.quicksilver.moviesapp.diconfig;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.quicksilver.moviesapp.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionKey;
import dagger.android.AndroidInjector;

@Singleton
@Component
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
