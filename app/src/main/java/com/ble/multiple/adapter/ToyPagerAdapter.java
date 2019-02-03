package com.ble.multiple.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.ble.multiple.entity.BatteryEntity;
import com.ble.multiple.fragment.BaseFragment;
import com.ble.multiple.fragment.ToyFragment;

import java.util.ArrayList;

import static com.ble.multiple.activity.MainActivity.*;

public class ToyPagerAdapter extends PersistentPagerAdapter<BaseFragment> {

    private final ArrayList<BatteryEntity> batteryEntityList;

    public ToyPagerAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        batteryEntityList = bundle.getParcelableArrayList(BLUETOOTH_DEVICES);
    }

    public int getCount() {
        return batteryEntityList.size();
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putString(BLUETOOTH_DEVICE_ID, batteryEntityList.get(position).getEntityId());
        bundle.putSerializable(BLUETOOTH_DEVICE_TYPE, batteryEntityList.get(position).getDeviceType());
        bundle.putString(BLUETOOTH_DEVICE_NAME, batteryEntityList.get(position).getName());
        ToyFragment fragment = new ToyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}