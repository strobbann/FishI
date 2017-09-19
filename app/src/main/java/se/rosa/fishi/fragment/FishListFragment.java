package se.rosa.fishi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import se.rosa.fishi.R;
import se.rosa.fishi.adapter.FishAdapter;
import se.rosa.fishi.repository.FishRepository;
import se.rosa.fishi.repository.InMemoryFishRepository;


public class FishListFragment extends Fragment {

    private static final String REPOSITORY = "repo";

    private FishRepository fishRepository;


    public static Fragment newInstance(){
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("repo", (Parcelable) fishRepository);
//        fragment.setArguments(bundle);
        return new FishListFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        fishRepository = new InMemoryFishRepository();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new FishAdapter(fishRepository.getFishes()));
        return view;
    }
}
