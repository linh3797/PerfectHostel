package com.t3h.perfecthostel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.t3h.perfecthostel.base.BaseActivity;
import com.t3h.perfecthostel.databinding.ActivityMainBinding;
import com.t3h.perfecthostel.fragment.ChatFragment;
import com.t3h.perfecthostel.fragment.HomeFragment;
import com.t3h.perfecthostel.fragment.ListFragment;
import com.t3h.perfecthostel.fragment.MineFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {

    private ActionBar actionBar;

    private HomeFragment homeFragment = new HomeFragment();

    private ChatFragment chatFragment = new ChatFragment();

    private ListFragment listFragment = new ListFragment();

    private MineFragment mineFragment = new MineFragment();

    public HomeFragment getHomeFragment() {
        return homeFragment;
    }

    public ChatFragment getChatFragment() {
        return chatFragment;
    }

    public ListFragment getListFragment() {
        return listFragment;
    }

    public MineFragment getMineFragment() {
        return mineFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.home));
        loadFragment(homeFragment);
        binding.navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                loadFragment(homeFragment);
                actionBar.setTitle(getResources().getString(R.string.home));
                return true;
            case R.id.list:
                loadFragment(listFragment);
                actionBar.setTitle(getResources().getString(R.string.list));
                return true;
            case R.id.takePhoto:
                takeScreenshot();
                return true;
            case R.id.chat:
                loadFragment(chatFragment);
                actionBar.setTitle(getResources().getString(R.string.chat));
                return true;
            case R.id.mine:
                loadFragment(mineFragment);
                actionBar.setTitle(getResources().getString(R.string.mine));
                return true;
        }
        return false;
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);
            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            openScreenshot(imageFile);
        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

    private void openScreenshot(File imageFile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(imageFile);
        intent.setDataAndType(uri, "image/*");
        startActivity(intent);
    }
}
