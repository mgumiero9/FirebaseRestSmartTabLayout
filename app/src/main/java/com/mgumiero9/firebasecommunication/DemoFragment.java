package com.mgumiero9.firebasecommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

public class DemoFragment extends Fragment implements View.OnClickListener {

    LinearLayout layoutInit, layoutData;
    TextView title;
    Button addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
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
        title = view.findViewById(R.id.item_title);
        layoutInit = view.findViewById(R.id.demo_ll_init_page);
        layoutData = view.findViewById(R.id.demo_ll_data);
        addButton = view.findViewById(R.id.demo_b_add);
    }

    private void setupViewPagerLayoutBehavior(int position, LinearLayout llData, LinearLayout llInit) {
        if (position > 0) {
            llData.setVisibility(View.VISIBLE);
            llInit.setVisibility(View.GONE);
        } else {
            llData.setVisibility(View.GONE);
            llInit.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}
