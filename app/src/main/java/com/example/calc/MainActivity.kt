package com.example.calc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val result =findViewById<TextView>(R.id.result)
        val operation = findViewById<TextView>(R.id.operation)
        val b_cos  = findViewById<TextView>(R.id.cos)
        val b_pi = findViewById<TextView>(R.id.pi)
        val b_e  = findViewById<TextView>(R.id.e)
        val b_equally = findViewById<TextView>(R.id.equally)

        val b_xy = findViewById<TextView>(R.id.xy)
        val b_ln = findViewById<TextView>(R.id.b_ln)
        val b_leftb = findViewById<TextView>(R.id.b_leftb)
        val b_rigtb = findViewById<TextView>(R.id.b_rightb)
        val b_log = findViewById<TextView>(R.id.b_log2)
        val b_sqrt = findViewById<TextView>(R.id.b_sqrt)
        val b_AC = findViewById<TextView>(R.id.AC)
        val b_back = findViewById<TextView>(R.id.back)
        val b_percent = findViewById<TextView>(R.id.percent)
        val b_point = findViewById<TextView>(R.id.point)
        val b_sin = findViewById<TextView>(R.id.sin)

        b_xy.setOnClickListener { operation.append("^") }
        b_leftb.setOnClickListener { operation.append("(") }
        b_rigtb.setOnClickListener { operation.append(")") }
        b_log.setOnClickListener { operation.append("log(") }
        b_percent.setOnClickListener { operation.append("%") }
        b_point.setOnClickListener { operation.append(".") }


        val b_division = findViewById<TextView>(R.id.division)
        val b_multiplication = findViewById<TextView>(R.id.multiplication)
        val b_minus = findViewById<TextView>(R.id.minus)
        val b_plus = findViewById<TextView>(R.id.plus)


        //Объявление переменных Числа
        val b_zero3 = findViewById<TextView>(R.id.zero3)
        val b_zero  = findViewById<TextView>(R.id.zero)
        val b_one = findViewById<TextView>(R.id.one)
        val b_two = findViewById<TextView>(R.id.two)
        val b_three = findViewById<TextView>(R.id.three)
        val b_four = findViewById<TextView>(R.id.four)
        val b_five = findViewById<TextView>(R.id.five)
        val b_six = findViewById<TextView>(R.id.six)
        val b_seven = findViewById<TextView>(R.id.seven)
        val b_eight = findViewById<TextView>(R.id.eight)
        val b_nine = findViewById<TextView>(R.id.nine)

        b_cos.setOnClickListener { operation.append("cos(") }
        b_pi.setOnClickListener { operation.append("pi") }
        b_e.setOnClickListener { operation.append("e") }
        b_sin.setOnClickListener { operation.append("sin(") }
        b_sqrt.setOnClickListener { operation.append("sqrt(") }
        b_ln.setOnClickListener { operation.append("ln(") }
        b_division.setOnClickListener { operation.append("/") }
        b_multiplication.setOnClickListener { operation.append("*") }
        b_minus.setOnClickListener { operation.append("-") }
        b_plus.setOnClickListener { operation.append("+") }

        b_zero.setOnClickListener { operation.append("0") }
        b_zero3.setOnClickListener { operation.append("000") }
        b_one.setOnClickListener { operation.append("1") }
        b_two.setOnClickListener { operation.append("2") }
        b_three.setOnClickListener { operation.append("3") }
        b_four.setOnClickListener { operation.append("4") }
        b_five.setOnClickListener { operation.append("5") }
        b_six.setOnClickListener { operation.append("6") }
        b_seven.setOnClickListener { operation.append("7") }
        b_eight.setOnClickListener { operation.append("8") }
        b_nine.setOnClickListener { operation.append("9") }


        b_back.setOnClickListener {
            val s = operation.text.toString()
            if (s != "") {
                operation.text = s.substring(0, s.length - 1)
            }
        }

        b_AC.setOnClickListener {
            operation.text = ""
            result.text = ""
        }

        result.setOnClickListener {
            val restext = result.text.toString()
            if (restext != "Error" && restext != ""){
                operation.text = restext
                result.text = ""
            }
        }

        b_equally.setOnClickListener{
            val optext = operation.text.toString() //Выражение в формате строки
            if (optext != "") {
                try {
                    val expr =  ExpressionBuilder(operation.text.toString()).build() //строим выражение
                    val res = expr.evaluate() //Находим ответ (число, может быть нецелое)
                    val longres = res.toLong() //longres - число в формате long (целочисленное)
                    if (longres.toDouble() == res) { //Если число целое,
                        result.text = longres.toString() //То: Отбрасываем ноль после запятой
                    } else {
                        result.text = res.toString() //Иначе: Сохраняем числа после запятой
                    }
                } catch (e: Exception) { //Если выражение записано некорректно
                    result.text = "Error" //В поле ответа пишем 'Error'
                }
            }
        }







    }
}