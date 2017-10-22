package com.mgumiero9.firebasecommunication.data.remote;

import com.mgumiero9.firebasecommunication.data.entity.Customer;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("readData/")
    Observable<Customer> readData();

    @GET("storeData/")
    Observable<Customer> storeData(@Query("name") String name, @Query("age") int age);

    @GET("resetCustomerDB/")
    Observable<Customer> resetCustomerDB(@Query("areYouSure") String areYouSure);
}
