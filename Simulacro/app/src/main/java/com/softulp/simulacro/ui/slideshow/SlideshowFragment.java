package com.softulp.simulacro.ui.slideshow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.simulacro.Login;
import com.softulp.simulacro.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

      // final TextView textView = binding.textSlideshow;
     //   slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
      binding.btnSalir.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mostrarDialogoSalir();
          }
      });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void mostrarDialogoSalir() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Salir de la aplicación")
                .setMessage("¿Estás seguro de que quieres salir?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar la aplicación
                        Intent intent = new Intent(getActivity(), Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        getActivity().finish();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }
}