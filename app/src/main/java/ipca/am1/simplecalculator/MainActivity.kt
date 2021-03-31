package ipca.am1.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var dot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buNumberEvent(view: View) {

        if (isNewOp) {

            edt_ShowNumber.setText("")
        }
        isNewOp = false
        val buSelect = view as Button
        var buClickValue: String = edt_ShowNumber.text.toString()

        when (buSelect.id) {

            btn_0.id -> {
                buClickValue += "0"
            }
            btn_1.id -> {
                buClickValue += "1"
            }
            btn_2.id -> {
                buClickValue += "2"
            }
            btn_3.id -> {
                buClickValue += "3"
            }
            btn_4.id -> {
                buClickValue += "4"
            }
            btn_5.id -> {
                buClickValue += "5"
            }
            btn_6.id -> {
                buClickValue += "6"
            }
            btn_7.id -> {
                buClickValue += "7"
            }
            btn_8.id -> {
                buClickValue += "8"
            }
            btn_9.id -> {
                buClickValue += "9"
            }
            btn_Dot.id ->
            {
                if (dot == false)
                {
                    buClickValue += "."
                }
                dot = true
            }
            btn_PlusMinus.id ->
            {

                buClickValue = "-" + buClickValue

            }
        }
        edt_ShowNumber.setText(buClickValue)
    }

    var op = "X"
    var oldNumber = ""

    fun buOpEvent (view: View){
        val buSelect = view as Button
        when(buSelect.id){

            btn_Mult.id->{

                op = "X"
            }
            btn_Div.id->{
                op = "/"

            }

            btn_Minus.id->{
                op = "-"

            }
            btn_Sum.id->{
                op = "+"

            }
        }
        oldNumber = edt_ShowNumber.text.toString()
        isNewOp = true
        dot = false
    }

    fun buEqualEvent (view: View){
        val newNumber = edt_ShowNumber.text.toString()
        var finalNumber : Double? = null
        when(op){
            "X"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()

            }
            "/"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()

            }
            "-"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()

            }
            "+"->{
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()

            }

        }
        edt_ShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercentEvent ( view: View){
        val number = (edt_ShowNumber.text.toString().toDouble())/100
        edt_ShowNumber.setText(number.toString())
        isNewOp=true
    }

    fun buCleanEvent(view: View) {
        edt_ShowNumber.setText("")
        dot = false


    }


}