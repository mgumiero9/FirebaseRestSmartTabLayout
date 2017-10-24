package com.mgumiero9.firebasecommunication.view;

import com.mgumiero9.firebasecommunication.data.entity.Customer;
import com.mgumiero9.firebasecommunication.data.repository.DemoRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;

class DemoInteractorImpl implements DemoInteractor {

    private DemoRepository demoRepository;

    @Inject
    DemoInteractorImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public Observable<Customer> readData() {
        return demoRepository.readData();
    }

    @Override
    public Completable storeData(String name, int age) {
        return demoRepository.storeData(name, age);
    }

    @Override
    public Completable resetCustomerDB(String areYouSure) {
        return demoRepository.resetCustomerDB(areYouSure);
    }
}
