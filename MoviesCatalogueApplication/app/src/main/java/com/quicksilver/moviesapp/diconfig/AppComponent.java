package com.quicksilver.moviesapp.diconfig;

import android.app.Application;

import com.quicksilver.moviesapp.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        HttpModule.class,
        AsyncModule.class
})
public interface AppComponent extends AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
