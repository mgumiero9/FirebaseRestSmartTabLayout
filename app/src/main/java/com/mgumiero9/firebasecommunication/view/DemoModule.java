package com.mgumiero9.firebasecommunication.view;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = DemoSubcomponent.class)
public abstract class DemoModule {
    @Binds
    @IntoMap
    @FragmentKey(DemoFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindInjectorFactory(DemoSubcomponent.Builder builder);

    @Binds
    abstract DemoView provideView(DemoFragment demoFragment);

    @Binds
    abstract DemoInteractor provideInteractor(DemoInteractorImpl demoInteractorImpl);
}