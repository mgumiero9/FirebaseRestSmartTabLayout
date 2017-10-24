package com.mgumiero9.firebasecommunication.view;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface DemoSubcomponent extends AndroidInjector<DemoFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DemoFragment> {
    }
}