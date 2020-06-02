package com.example.navigation_component_android

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.fragment_a.*

class FragmentA : Fragment() {

    // Variable para la Tercer forma
    private lateinit var navController: NavController;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController()) || super.onOptionsItemSelected(item)

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
