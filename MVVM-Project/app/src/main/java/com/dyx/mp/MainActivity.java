package com.dyx.mp;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.dyx.mp.databinding.ActivityMainBinding;
import com.dyx.mp.model.User;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("哒哒", "18");
        binding.setUser(user);
    }
}
