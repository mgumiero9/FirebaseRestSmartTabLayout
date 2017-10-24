package com.mgumiero9.firebasecommunication.view;

import android.content.Context;
import android.content.DialogInterface;

import com.mgumiero9.firebasecommunication.data.entity.Customer;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DemoPresenter {

    private final Context context;
    private final DemoView demoView;
    private final DemoInteractor demoInteractor;
    private int page;
    private boolean complete;

    @Inject
    DemoPresenter(Context context, DemoView demoView, DemoInteractor demoInteractor) {
        this.context = context;
        this.demoView = demoView;
        this.demoInteractor = demoInteractor;
    }

    void readData() {

        demoInteractor.readData()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        demoView.startLoading();
                    }
                })
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        demoView.stopRefreshing();
                    }
                })
                .subscribe(new Consumer<Customer>() {
                    @Override
                    public void accept(Customer customer) throws Exception {
                        demoView.stopLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        demoView.showMessage("Erro: " + throwable.getLocalizedMessage(), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                demoView.stopLoading();
                                dialog.dismiss();
                            }
                        });
                        throwable.printStackTrace();
                    }
                });
    }

    void storeData(final String name, final int age) {
        if (name.isEmpty()) {
            demoView.showToast("Type your name to proceed.");
            return;
        }
        if (age == 0) {
            demoView.showToast("Type your age to proceed.");
            return;
        }

        demoInteractor.storeData(name, age)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        demoView.onCustomerStored(name, age);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        demoView.showToast("Erro: " + throwable.getLocalizedMessage());
                    }
                });
    }

    void resetCustomerDB() {

        demoInteractor.resetCustomerDB("true")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        demoView.onResetCustomerDB();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        demoView.showToast("Erro: " + throwable.getLocalizedMessage());
                    }
                });
    }
}






