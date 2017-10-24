package com.mgumiero9.firebasecommunication.data.repository;

import com.mgumiero9.firebasecommunication.data.entity.Customer;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface DemoRepository {
    Observable<Customer> readData();

    Completable storeData(String name, int age);

    Observable<Customer> resetCustomerDB(String areYouSure);

}
