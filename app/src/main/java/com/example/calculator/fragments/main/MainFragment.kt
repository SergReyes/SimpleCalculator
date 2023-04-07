package com.example.calculator.fragments.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.MainActivity
import com.example.calculator.R
import com.example.calculator.database.Results
import com.example.calculator.database.ResultsViewModel
import com.example.calculator.databinding.FragmentResultsBinding
import com.example.calculator.fragments.results.ResultsFragment

class  MainFragment : Fragment() {

    var operation: String = ""
    var firstVal: Float? = null
    private lateinit var resultsviewmodel: ResultsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //resultsviewmodel = ViewModelProvider(this).get(ResultsViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container,false)

        var resulttext: EditText = view.findViewById(R.id.resulttext)
        val buttonnav: Button = view.findViewById(R.id.buttontoresultspage)
        buttonnav.setOnClickListener(){
//            Intent intent = new Intent(this, ResultsFragment::class.java)
//            startActivity(intent)
            findNavController().navigate(R.id.action_mainFragment_to_resultsFragment)

        }
    val button0: Button = view.findViewById(R.id.button0)
    button0.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + " 0")
    }
    val button1: Button = view.findViewById(R.id.button1)
    button1.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "1")
    }
    val button2: Button = view.findViewById(R.id.button2)
    button2.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "2")
    }
    val button3: Button = view.findViewById(R.id.button3)
    button3.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "3")
    }
    val button4: Button = view.findViewById(R.id.button4)
    button4.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "4")
    }
    val button5: Button = view.findViewById(R.id.button5)
    button5.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "5")
    }
    val button6: Button = view.findViewById(R.id.button6)
    button6.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "6")
    }
    val button7: Button = view.findViewById(R.id.button7)
    button7.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "7")
    }
    val button8: Button = view.findViewById(R.id.button8)
    button8.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "8")
    }
    val button9: Button = view.findViewById(R.id.button9)
    button9.setOnClickListener{
        resulttext.setText(resulttext.text.toString() + "9")
    }
    val buttondot: Button = view.findViewById(R.id.buttondot)
    buttondot.setOnClickListener{
        resulttext.setText(resulttext.text.toString()+".")
    }
    val buttonclear: Button = view.findViewById(R.id.buttonclear)
    buttonclear.setOnClickListener{
        resulttext.setText("")
    }
    val buttonequals: Button = view.findViewById(R.id.buttonequals)
    buttonequals.setOnClickListener{
        val secondVal = resulttext.text.toString().toFloat()
        val finalVal = when {
            operation == "add" -> (firstVal?.plus(secondVal)).toString()
            operation == "subtract" -> (firstVal?.minus(secondVal)).toString()
            operation == "multiply" -> (firstVal?.times(secondVal)).toString()
            operation == "divide" -> (firstVal?.div(secondVal)).toString()
            else -> "Invalid Input"
        }
        //insertResulTtoDatabase(finalVal)
        resulttext.setText(finalVal)
    }
        val buttonadd: Button = view.findViewById(R.id.buttonadd)
    buttonadd.setOnClickListener{
        if (resulttext.text == null)
            resulttext.setText("")
        else {
            firstVal = resulttext.text.toString().toFloat()
            operation = "add"
            resulttext.setText(null)
        }
    }
    val buttonsub: Button = view.findViewById(R.id.buttonsub)
    buttonsub.setOnClickListener{
        if (resulttext.text == null)
            resulttext.setText("")
        else {
            firstVal = resulttext.text.toString().toFloat()
            operation = "subtract"
            resulttext.setText(null)
        }
    }
    val buttonmulti: Button = view.findViewById(R.id.buttonmulti)
    buttonmulti.setOnClickListener{
        if (resulttext.text == null)
            resulttext.setText("")
        else {
            firstVal = resulttext.text.toString().toFloat()
            operation = "multiply"
            resulttext.setText(null)
        }
    }
    val buttondiv: Button = view.findViewById(R.id.buttondiv)
    buttondiv.setOnClickListener {
        if (resulttext.text == null)
            resulttext.setText("")
        else {
            firstVal = resulttext.text.toString().toFloat()
            operation = "divide"
            resulttext.setText(null)
        }
    }
        return view
    }

    private fun insertResulTtoDatabase(results: String) {
        val result = Results(0,results)
        resultsviewmodel.database.insertResult(result)
    }
}