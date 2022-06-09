package ru.mirea.galkina.mireaproject.pr8;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.galkina.mireaproject.R;

public class KittensFragment extends Fragment {

    private List<Kittens> kittens = new ArrayList<>();
    private KittensViewModel kittensViewModel;
    private KittensAdapter kittensAdapter = new KittensAdapter(kittens);
    private RecyclerView recyclerView;
    private ActivityResultLauncher<Intent> launcher;
    public static final int ADD_CAT_RESULT_CODE=1;
    public static final String NAME_LABEL="name";
    public static final String BREED_LABEL="breed";
    public static final String COLOR_LABEL="color";
    public static final String AGE_LABEL="age";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kittens, container, false);

        if (getActivity() != null){
            kittensViewModel = new ViewModelProvider(getActivity()).
                    get(KittensViewModel.class);
            kittensViewModel.getKittensLiveData().observe(getActivity(), this::onChanged);
        }
        view.findViewById(R.id.btnAddKitten).setOnClickListener(this::onNewBrawlClicked);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView = (RecyclerView) view.findViewById(R.id.kittensRecyclerView);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kittensAdapter);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result) -> {
                    if (result.getResultCode() == ADD_CAT_RESULT_CODE
                            && result.getData() != null){
                        Kittens kitten = new Kittens();
                        kitten.name = result.getData().getStringExtra(NAME_LABEL);
                        kitten.breed = result.getData().getStringExtra(BREED_LABEL);
                        kitten.color = result.getData().getStringExtra(COLOR_LABEL);
                        kitten.age = result.getData().getStringExtra(AGE_LABEL);
                        kittensViewModel.addKitten(kitten);
                        kittensAdapter.notifyDataSetChanged();
                    }
                });
        return view;
    }

    public void onChanged(List<Kittens> kittenfromDB) {
        if (!kittens.isEmpty()){
            kittens.clear();
        }
        kittens.addAll(kittenfromDB);
        kittensAdapter.notifyDataSetChanged();
    }

    private void onNewBrawlClicked(View view){
        Intent intent = new Intent(getActivity(), KittensAdd.class);
        launcher.launch(intent);
    }
}