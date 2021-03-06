package com.example.testtask.ui.employees



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.testtask.R
import com.example.testtask.data_source.Repository
import com.example.testtask.ui.MainActivity
import com.example.testtask.ui.specialities.SpecialititesFragmentDirections
import com.example.testtask.ui.specialities.SpecialititesViewModel

class EmployeesFragment : androidx.fragment.app.Fragment() {
    val viewModel: EmployeesViewModel by viewModels{EmployeesViewModelFactory((activity as MainActivity).repository)}
    val args: EmployeesFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.initSpecialityId(args.specialityId)
        return inflater.inflate(R.layout.employees_fragment, container, false)
    }

    fun onClickSpecialityItem(){
        val action = EmployeesFragmentDirections.actionEmployeesFragmentToEmployeeDetailFragment("1")
        findNavController().navigate(action)
    }
}

@Suppress("UNCHECKED_CAST")
class EmployeesViewModelFactory(val repository: Repository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EmployeesViewModel(repository) as T
    }
}