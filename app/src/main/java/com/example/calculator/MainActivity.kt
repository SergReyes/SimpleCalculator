package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    var operation: String = ""
    var firstVal: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resulttext: EditText = findViewById(R.id.resulttext)

        val button0: Button = findViewById(R.id.button0)
        button0.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + " 0")
        }
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "1")
        }
        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "2")
        }
        val button3: Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "3")
        }
        val button4: Button = findViewById(R.id.button4)
        button4.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "4")
        }
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "5")
        }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "6")
        }
        val button7: Button = findViewById(R.id.button7)
        button7.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "7")
        }
        val button8: Button = findViewById(R.id.button8)
        button8.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "8")
        }
        val button9: Button = findViewById(R.id.button9)
        button9.setOnClickListener{
            resulttext.setText(resulttext.text.toString() + "9")
        }
        val buttondot: Button = findViewById(R.id.buttondot)
        buttondot.setOnClickListener{
            resulttext.setText(resulttext.text.toString()+".")
        }
        val buttonclear: Button = findViewById(R.id.buttonclear)
        buttonclear.setOnClickListener{
            resulttext.setText("")
        }
        val equals: Button = findViewById(R.id.equals)
        equals.setOnClickListener{
            val secondVal = resulttext.text.toString().toFloat()
            val finalVal = when {
                operation == "add" -> (firstVal?.plus(secondVal)).toString()
                operation == "subtract" -> (firstVal?.minus(secondVal)).toString()
                operation == "multiply" -> (firstVal?.times(secondVal)).toString()
                operation == "divide" -> (firstVal?.div(secondVal)).toString()
                else -> "Invalid Input"

            }
            resulttext.setText(finalVal)

        }

        //Operator Buttons
        val buttonadd: Button = findViewById(R.id.buttonadd)
        buttonadd.setOnClickListener{
            if (resulttext.text == null)
                resulttext.setText("")
            else {
                firstVal = resulttext.text.toString().toFloat()
                operation = "add"
                resulttext.setText(null)
            }
        }
        val buttonsub: Button = findViewById(R.id.buttonsub)
        buttonsub.setOnClickListener{
            if (resulttext.text == null)
                resulttext.setText("")
            else {
                firstVal = resulttext.text.toString().toFloat()
                operation = "subtract"
                resulttext.setText(null)
            }
        }
        val buttonmulti: Button = findViewById(R.id.buttonmulti)
        buttonmulti.setOnClickListener{
            if (resulttext.text == null)
                resulttext.setText("")
            else {
                firstVal = resulttext.text.toString().toFloat()
                operation = "multiply"
                resulttext.setText(null)
            }
        }
        val buttondiv: Button = findViewById(R.id.buttondiv)
        buttondiv.setOnClickListener{
            if (resulttext.text == null)
                resulttext.setText("")
            else {
                firstVal = resulttext.text.toString().toFloat()
                operation = "divide"
                resulttext.setText(null)
            }
        }


    }


}
