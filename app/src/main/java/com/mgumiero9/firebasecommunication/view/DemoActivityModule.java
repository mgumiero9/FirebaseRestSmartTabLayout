package com.mgumiero9.firebasecommunication.view;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = DemoActivitySubcomponent.class)
public abstract class DemoActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(DemoActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindInjectorFactory(DemoActivitySubcomponent.Builder builder);
}