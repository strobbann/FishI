package se.rosa.fishi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import se.rosa.fishi.fragment.FishListFragment;
import se.rosa.fishi.model.Fish;
import se.rosa.fishi.repository.FishRepository;
import se.rosa.fishi.repository.InMemoryFishRepository;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQ_CODE_ADD_FISH = 10;
    private FloatingActionButton fabButton;
    private FishRepository fishRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fishRepository = new InMemoryFishRepository();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.recyclerview_container);
        if (fragment == null) {
            fragment = FishListFragment.newInstance();
            fm.beginTransaction()
                    .replace(R.id.recyclerview_container, fragment)
                    .commit();
        }
        fabButton = (FloatingActionButton) findViewById(R.id.fab_add_fish_button);
        fabButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add_fish_button: {
                Intent intent = AddFishActivity.getIntent(this);
                startActivityForResult(intent,REQ_CODE_ADD_FISH);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_ADD_FISH){
            if (resultCode == RESULT_OK){

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
