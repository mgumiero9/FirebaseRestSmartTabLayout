package com.mgumiero9.firebasecommunication.view;

import com.mgumiero9.firebasecommunication.data.entity.Customer;

import io.reactivex.Completable;
import io.reactivex.Observable;

interface DemoInteractor {
    Observable<Customer> readData();

    Completable storeData(String name, int age);

    Observable<Customer> resetCustomerDB(String areYouSure);
}
