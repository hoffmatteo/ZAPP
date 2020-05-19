package com.example.ueb4.travelStream.view;

import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ueb4.R;
import com.example.ueb4.travelStream.controller.TravelStreamAdapter;
import com.example.ueb4.travelStream.model.DsTravelStream;
import com.example.ueb4.utils.Args;

import java.util.ArrayList;
import java.util.List;


public class TravelStreamFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public static TravelStreamFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(Args.TOOLBAR_TITLE, title);
        TravelStreamFragment fragment = new TravelStreamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_travel_stream, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        setupToolbar();
        setupUiComponents();
        setupRecyclerView();
    }

    /**
     * Set the passed title for the toolbar
     */
    private void setupToolbar() {
        String title = getArguments().getString(Args.TOOLBAR_TITLE);
        // We have a Toolbar in place so we don't need to care about the NPE warning
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    private void setupUiComponents() {
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.fragment_travel_stream_rv);
    }

    private void setupRecyclerView() {
        // Init the LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // Set the orientation for the LayoutManager
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // Set LayoutManager for the RecyclerView
        mRecyclerView.setLayoutManager(layoutManager);
        // Init Adapter for RecyclerView
        com.example.ueb4.travelStream.controller.TravelStreamAdapter adapter = new com.example.ueb4.travelStream.controller.TravelStreamAdapter(getActivity(), generateDummyData());
        // Set the adapter
        mRecyclerView.setAdapter(adapter);
    }

    private List<DsTravelStream> generateDummyData() {
        ArrayList<DsTravelStream> data = new ArrayList<>();
        DsTravelStream object1 = new DsTravelStream("Antelope Canyon", "USA, Arizona", R.drawable.travel_stream_1);
        DsTravelStream object2 = new DsTravelStream("New York", "USA, New York", R.drawable.travel_stream_2);
        DsTravelStream object3 = new DsTravelStream("Wyoming wilderness", getString(R.string.travel_stream_card_subtitle), R.drawable.travel_stream_3);

        data.add(object1);
        data.add(object2);
        data.add(object3);

        return data;
    }

}
