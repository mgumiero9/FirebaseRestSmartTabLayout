package com.mgumiero9.firebasecommunication.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mgumiero9.firebasecommunication.R;
import com.mgumiero9.firebasecommunication.util.ViewUtils;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class DemoFragment extends Fragment implements DemoView, HasSupportFragmentInjector, View.OnClickListener {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    Context context;

    @Inject
    DemoPresenter demoPresenter;

    LinearLayout layoutInit, layoutData;
    EditText name, age;
    TextView title;
    Button addButton;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());

        setupBindings(view);
        title.setText(String.valueOf(position));
        setupViewPagerLayoutBehavior(position, layoutData, layoutInit);
        addButton.setOnClickListener(this);
    }

    private void setupBindings(View view) {
        title = (TextView) view.findViewById(R.id.item_title);
        layoutInit = (LinearLayout) view.findViewById(R.id.demo_ll_init_page);
        layoutData = (LinearLayout) view.findViewById(R.id.demo_ll_data);
        addButton = (Button) view.findViewById(R.id.demo_b_add);
        name = (EditText) view.findViewById(R.id.demo_et_name);
        age = (EditText) view.findViewById(R.id.demo_et_age);
    }

    /**
     * called to setup ViewPager Layout Behavior
     *
     * @param position   {int}
     * @param layoutData {LinearLayout}
     * @param layoutInit {LinearLayout}
     */
    private void setupViewPagerLayoutBehavior(int position, LinearLayout layoutData, LinearLayout layoutInit) {
        if (position > 0) {
            layoutData.setVisibility(View.VISIBLE);
            layoutInit.setVisibility(View.GONE);
        } else {
            layoutData.setVisibility(View.GONE);
            layoutInit.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        storeCustomer();
    }

    private void storeCustomer() {
        demoPresenter.storeData(name.getText().toString(), Integer.parseInt(age.getText().toString()));
    }

    @Override
    public void showMessage(String message, DialogInterface.OnClickListener onClickListener) {
        ViewUtils.showDialog(context, message, onClickListener);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(context, "Message: " + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemsReceived(String name, int age) {
        Toast.makeText(context, "name, age: " + name + age, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCustomerStored() {

    }

    @Override
    public void stopRefreshing() {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    /**
     * Returns an {@link AndroidInjector} of {@link Fragment}s.
     */
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
