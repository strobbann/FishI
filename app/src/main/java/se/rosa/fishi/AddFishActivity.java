package se.rosa.fishi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import se.rosa.fishi.fragment.AddFishFragment;
import se.rosa.fishi.repository.FishRepository;

public class AddFishActivity extends AppCompatActivity {

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, AddFishActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fish);
        Bundle bundle = getIntent().getExtras();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.add_fish_cotainer);
        if (fragment == null) {
            fragment = AddFishFragment.createInstance();
            fm.beginTransaction()
                    .add(R.id.add_fish_cotainer, fragment)
                    .commit();
        }
    }
}
