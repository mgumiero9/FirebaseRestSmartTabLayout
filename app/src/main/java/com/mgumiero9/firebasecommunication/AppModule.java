package com.mgumiero9.firebasecommunication;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Provides
    Context provideContext(App app) {
        return app.getApplicationContext();
    }
}
