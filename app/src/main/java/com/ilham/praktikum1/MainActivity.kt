package com.ilham.praktikum1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWith: EditText
    private lateinit var edtHeigth: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWith = findViewById(R.id.edit_width)
        edtHeigth = findViewById(R.id.edit_height)
        edtLength = findViewById(R.id.edit_lenght)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.getId() == R.id.btn_calculate){
            var inputLength :String = edtLength.getText().toString().trim()
            var inputWith :String = edtWith.getText().toString().trim()
            var inputHeight :String = edtHeigth.getText().toString().trim()

            var isEmptyFields :Boolean= false
            var isInvalidDouble :Boolean= false

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong")
            }

            if (TextUtils.isEmpty(inputWith)){
                isEmptyFields = true;
                edtWith.setError("Field ini tidak boleh kosong")
            }

            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtHeigth.setError("Field ini tidak boleh kosong")
            }

            var length :Double = inputLength.toDouble()
            var width :Double = inputWith.toDouble()
            var heigth :Double = inputHeight.toDouble()

            if (length == null){
                isInvalidDouble = true
                edtLength.setError("Field ini harus berupa nomer yang valid")
            }

            if (width == null){
                isInvalidDouble = true
                edtWith.setError("Field ini harus berupa nomer yang valid")
            }

            if (heigth == null){
                isInvalidDouble = true
                edtHeigth.setError("Field ini harus berupa nomer yang valid")
            }

            if (!isEmptyFields && !isInvalidDouble){
                var volume: Double = length * width * heigth
                tvResult.text = volume.toString()
            }
        }
    }
    private fun toDouble(str : String): Double? {
        return try {
            str.toDouble()
        } catch (e :NumberFormatException){
            null
        }
    }
}

