package com.example.custombottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation=findViewById(R.id.bottom_navigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_sort_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_tasbeeh));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_baseline_notifications_24));



        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment=null;
                switch (item.getId()){
                    case 1:
                        fragment=new HomeFragment();

                        break;
                    case 2:
                        fragment=new SortFragment();
                        break;
                    case 3:
                        fragment=new TasbeehFragment();
                        break;
                    case 4:
                        fragment=new NotificationFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });
        // set notification count
        bottomNavigation.setCount(4,"11");

        // set home fragment initially selected/ firstly selected
        bottomNavigation.show(1, true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "you clicked "+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "you Reselected "+item.getId(), Toast.LENGTH_SHORT).show();

            }
        });



    }



    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layoutId,fragment).commit();

    }
}