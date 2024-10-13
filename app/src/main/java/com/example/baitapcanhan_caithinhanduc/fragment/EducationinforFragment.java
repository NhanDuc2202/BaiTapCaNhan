package com.example.baitapcanhan_caithinhanduc.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.baitapcanhan_caithinhanduc.R;
import com.google.android.material.tabs.TabLayout;


public class EducationinforFragment extends Fragment {
    private TabLayout tabLayout;
    private FrameLayout frameLayout;

    public EducationinforFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_educationinfor, container, false);

        // Liên kết các view từ XML
        tabLayout = view.findViewById(R.id.tabLayout);
        frameLayout = view.findViewById(R.id.framLayout);

        // Đặt fragment mặc định khi mở màn hình
        loadFragment(new Nganh());

        // Lắng nghe sự kiện chọn tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        loadFragment(new Nganh());
                        break;
                    case 1:
                        loadFragment(new GPA());
                        break;
                    case 2:
                        loadFragment(new TinhTrangHocTap());
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }

    // Phương thức để load fragment vào FrameLayout
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framLayout, fragment);
        fragmentTransaction.commit();
    }
}