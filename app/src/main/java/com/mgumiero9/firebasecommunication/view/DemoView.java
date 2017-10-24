package com.mgumiero9.firebasecommunication.view;

import android.content.DialogInterface;

interface DemoView {
    void showMessage(String message, DialogInterface.OnClickListener onClickListener);

    void showToast(String message);

    void onItemsReceived(String name, int age);

    void onCustomerStored(String name, int age);

    void onResetCustomerDB();

    void stopRefreshing();

    void startLoading();

    void stopLoading();
}
