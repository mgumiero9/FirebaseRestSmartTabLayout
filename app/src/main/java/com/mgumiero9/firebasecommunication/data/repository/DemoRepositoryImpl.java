package com.mgumiero9.firebasecommunication.data.repository;

import com.mgumiero9.firebasecommunication.data.entity.Customer;
import com.mgumiero9.firebasecommunication.data.remote.Api;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class DemoRepositoryImpl implements DemoRepository {

    private Api api;

    @Inject
    public DemoRepositoryImpl(Api api) {
        this.api = api;
    }

    @Override
    public Observable<Customer> readData() {
        return api.readData();
    }

    @Override
    public Completable storeData(String name, int age) {
        return api.storeData(name, age);
    }

    @Override
    public Completable resetCustomerDB(String areYouSure) {
        return api.resetCustomerDB(areYouSure);
    }
}
