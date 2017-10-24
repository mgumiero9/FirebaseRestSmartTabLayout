package com.mgumiero9.firebasecommunication;

import com.mgumiero9.firebasecommunication.data.DataModule;
import com.mgumiero9.firebasecommunication.view.DemoActivityModule;
import com.mgumiero9.firebasecommunication.view.DemoModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;


@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        DemoActivityModule.class,
        DemoModule.class,
        DataModule.class
})
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder app(App app);

        AppComponent build();
    }

    void inject(App app);
}