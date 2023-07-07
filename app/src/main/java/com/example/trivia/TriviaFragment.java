package com.example.trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentTriviaBinding;

public class TriviaFragment extends Fragment {
  private FragmentTriviaBinding binding;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TriviaFragment() {
        // Required empty public constructor
    }
    public static TriviaFragment newInstance(String param1, String param2) {
        TriviaFragment fragment = new TriviaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTriviaBinding.inflate(getLayoutInflater(), container, false);
        binding.textTitulo.setText("Hola " + mParam1);
       // return inflater.inflate(R.layout.fragment_trivia, container, false);
        binding.btnEnviar.setOnClickListener (view -> {


            boolean correcta = false;
            Bundle bundle = new Bundle();
            if (binding.radioGroupPokemon.getCheckedRadioButtonId() == binding.radioButton1.getId()) {
                correcta = true;
                bundle.putString("nombre", mParam1);
                bundle.putBoolean("respuesta", correcta);
                Navigation.findNavController(getView()).navigate(R.id.action_triviaFragment_to_respuestaFragment, bundle);

            }



        });

        return binding.getRoot();
    }}





