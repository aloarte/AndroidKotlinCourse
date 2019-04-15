package com.p4r4d0x.kotlintestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {

    //lateinit variables: will be initialized later, not nullable by definition
    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    //The first time that the variable is called, it will be executed the lazy code into the lambda{}
    private val displayOperation by lazy { findViewById<TextView>(R.id.tv_operation) }

    private var operand1: Double? = null //This variable can be null. Will need the !! mark to set a value to the variable
    private var operand2: Double = 0.0  //this variable is never null, so dont need the !! operator
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initViews();


    }

    private fun initViews() {

        //Set the value of lateinit variables
        result = findViewById(R.id.et_result)
        newNumber = findViewById(R.id.et_new_number)

        //Set value to 4 number buttons by explicit type declaration
        val button0: Button = findViewById(R.id.btn_0)
        val button1: Button = findViewById(R.id.btn_1)
        val button2: Button = findViewById(R.id.btn_2)
        val button3: Button = findViewById(R.id.btn_3)

        //Set value to the 5 button operation by non explicit type declaration
        val buttonEquals = findViewById<Button>(R.id.btn_equals)
        val buttonPlus = findViewById<Button>(R.id.btn_add)
        val buttonMinus = findViewById<Button>(R.id.btn_minus)
        val buttonDivide = findViewById<Button>(R.id.btn_divide)
        val buttonMultiply = findViewById<Button>(R.id.btn_multipli)

        //define a listener wich appends into the edit text the value of the numeric button
        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }

        //add the listener to the first 4 buttons
        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)

        //Set the rest the onclicklistener to the rest of the numeric button as a lambda function. Get each button view value without findviewbyid
        btn_4.setOnClickListener { newNumber.append(btn_4.text) }
        btn_5.setOnClickListener { newNumber.append(btn_5.text) }
        btn_6.setOnClickListener { newNumber.append(btn_6.text) }
        btn_7.setOnClickListener { newNumber.append(btn_7.text) }
        btn_8.setOnClickListener { newNumber.append(btn_8.text) }
        btn_9.setOnClickListener { newNumber.append(btn_9.text) }
        btn_dot.setOnClickListener { newNumber.append(btn_dot.text) }

        //Create a new listener for the operations
        val opListener = View.OnClickListener { view ->
            val op = (view as Button).text.toString()
            val value = newNumber.text.toString()
            if (value.isNotEmpty()) {
                performOperation(value, op)
            }
            pendingOperation = op
            displayOperation.text = pendingOperation

        }


        //set the listener to the previous operation views
        buttonEquals.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)


    }

    private fun performOperation(value: String, operation: String) {

        if (operand1 == null) {
            operand1 = value.toDouble()
        } else {
            operand2 = value.toDouble()

            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            //Check the operation and set te result into operand1
            when (pendingOperation) {
                "=" -> operand1 = operand2
                "/" -> if (operand2 == 0.0) {
                    operand1 = Double.NaN //Division by zero
                } else {
                    operand1 = operand1!! / operand2
                }
                "*" -> operand1 = operand1!! * operand2
                "-" -> operand1 = operand1!! - operand2
                "+" -> operand1 = operand1!! + operand2
            }
        }

        //Set the result
        result.setText(operand1.toString())

        //Erase the new number field
        newNumber.setText("")
    }
}
