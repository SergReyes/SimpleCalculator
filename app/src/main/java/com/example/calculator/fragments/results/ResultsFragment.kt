package com.example.calculator.fragments.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.calculator.R
import com.example.calculator.database.ResultsDatabase
import com.example.calculator.database.ResultsViewModel
import com.example.calculator.database.ResultsViewModelFactory
import com.example.calculator.databinding.FragmentResultsBinding

class ResultsFragment : Fragment() {

//    private var _binding: MainFragment? = null
//    private var binding = _binding!!
//    private lateinit var resultsViewModel: ResultsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
    val binding: FragmentResultsBinding  = DataBindingUtil.inflate(
        inflater, R.layout.fragment_results, container, false)

    val view = inflater.inflate(R.layout.fragment_results, container,false)

    val buttonreturn: Button = view.findViewById(R.id.buttonreturn)
    buttonreturn.setOnClickListener() {
//        val intent = Intent(getActivity(), MainActivity::class.java)
//        getActivity()?.startActivity(intent)
        findNavController().navigate(R.id.action_resultsFragment_to_mainFragment2)
    }

    val application = requireNotNull(this.activity).application

    val dataSource = ResultsDatabase.getDatabase(application).resultsDao()

    val viewModelFactory = ResultsViewModelFactory(dataSource, application)

    val resultsViewModel =
        ViewModelProvider(
            this, viewModelFactory
        ).get(ResultsViewModel::class.java)
    binding.setLifecycleOwner(this)
    binding.resultsViewModel = resultsViewModel
    return binding.root
}
        // Inflate the layout for this fragment
//        _binding = MainFragment.inflate(inflater,container,false)
//
//        val adapter = ResultsAdapter()
//        val recyclerView = binding.recyclerViewResults
//        recyclerView.adapter = adapter
//        recyclerView.LayoutManager = LinearLayoutManager(requireContext())
//
//        resultsViewModel = ViewModelProvider(this).get(ResultsViewModel::class.java)
//        resultsViewModel.getAllResults.observe(this, Observer{ result ->
//            adapter.setData(results)
//        })
//        view.add_btn.setOnClickListener{
//            insertDataToDatabase()
//        }

//        return binding.root
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
//
//    private fun insertDataToDatabase() {
//        val results = resultsTitle.text.toString()
//        //Create Results Object
//        val result = Results(0,results)
//        //Add data to Database
//        resultsViewModel.addResult(result)
//        Toast.makeText(requireContext(),"Successfully Added!", Toast.LENGTH_LONG).show()

//    }
//}