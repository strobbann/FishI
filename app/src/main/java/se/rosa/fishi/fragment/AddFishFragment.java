package se.rosa.fishi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import se.rosa.fishi.R;


public class AddFishFragment extends Fragment {
    private static final String FISH_ID = "fishId";

    public static Fragment createInstance(){
        Fragment fragment = new AddFishFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fish_add_item,container,false);
        Spinner spinnerFishType = (Spinner) view.findViewById(R.id.spinner_fish_type);
        EditText etFishLength = (EditText) view.findViewById(R.id.et_fish_length);
        EditText etFishWeight = (EditText) view.findViewById(R.id.et_fish_weight);
        ArrayAdapter<CharSequence> fishtTypeAdapter = ArrayAdapter.createFromResource(getContext(),R.array.fishTypes,android.R.layout.simple_spinner_item);
        spinnerFishType.setAdapter(fishtTypeAdapter);
        return view;
    }
}
