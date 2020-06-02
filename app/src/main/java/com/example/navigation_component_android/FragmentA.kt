package com.example.navigation_component_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    // Variable para la Tercer forma
    private lateinit var navController: NavController;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Primera forma
        // btn_navigate_to_b.setOnClickListener{
        //    findNavController().navigate(R.id.action_fragmentA_to_fragmentB);
        //  }

        // Segunda forma
        // btn_navigate_to_b.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fragmentA_to_fragmentB))

        // Tercera forma (Recomendada)
           navController = Navigation.findNavController(view)
           btn_navigate_to_b.setOnClickListener{
           navController.navigate(R.id.action_fragmentA_to_fragmentB)
         }
    }

}
