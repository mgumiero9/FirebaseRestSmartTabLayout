package com.mgumiero9.firebasecommunication.view;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface DemoActivitySubcomponent extends AndroidInjector<DemoActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DemoActivity> {
    }
}