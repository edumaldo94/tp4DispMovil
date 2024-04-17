package com.softulp.simulacro.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.simulacro.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

       binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        hacerLLamada();
     //   final TextView textView = binding.textHome;
   //     homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void hacerLLamada(){
        binding.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroTelefono = binding.idNumeroTel.getText().toString();
                homeViewModel.llamar(numeroTelefono);
            }
        });
    }

}