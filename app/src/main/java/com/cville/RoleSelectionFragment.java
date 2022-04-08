package com.cville;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoleSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoleSelectionFragment extends Fragment {

    private String role = "";

    public RoleSelectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoleSelectionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoleSelectionFragment newInstance(String param1, String param2) {
        RoleSelectionFragment fragment = new RoleSelectionFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_role_selection, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageButton helperButton = view.findViewById(R.id.helper_button);
        helperButton.setOnClickListener(v -> {
            role = "helper";
        });

        ImageButton seekerButton = view.findViewById(R.id.refugee_button);
        seekerButton.setOnClickListener(v -> {
            role = "seeker";
        });

        ImageButton infoButton = view.findViewById(R.id.next_fab_role);
        infoButton.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_roleSelectionFragment_to_registerP1RefFragment);
        });
    }
}