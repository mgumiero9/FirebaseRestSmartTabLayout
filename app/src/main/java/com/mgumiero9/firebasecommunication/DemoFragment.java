package com.mgumiero9.firebasecommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

public class DemoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = FragmentPagerItem.getPosition(getArguments());
        TextView title = view.findViewById(R.id.item_title);
        LinearLayout llInit = view.findViewById(R.id.demo_ll_init_page);
        LinearLayout llData = view.findViewById(R.id.demo_ll_data);

        title.setText(String.valueOf(position));

        setupViewPagerLayoutVisibility(position, llData, llInit);
    }

    private void setupViewPagerLayoutVisibility(int position, LinearLayout llData, LinearLayout llInit) {
        if (position > 0) {
            llData.setVisibility(View.VISIBLE);
            llInit.setVisibility(View.GONE);
        } else {
            llData.setVisibility(View.GONE);
            llInit.setVisibility(View.VISIBLE);
        }
    }
}
