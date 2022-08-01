package sungil.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val et_weight: EditText by lazy {
        findViewById(R.id.et_weight)
    }
    private val et_height: EditText by lazy {
        findViewById(R.id.et_height)
    }
    private val bt_result: Button by lazy {
        findViewById(R.id.bt_result)
    }
    private val tv_result: TextView by lazy {
        findViewById(R.id.tv_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_result.setOnClickListener {
            Toast.makeText(this, "클릭!!", Toast.LENGTH_SHORT).show()
            val isEmpty1: Boolean = et_height.text.isEmpty()
            val isEmpty2: Boolean = et_weight.text.isEmpty()
            if(isEmpty1.not() && isEmpty2.not()) {
                val int_height: Double = et_height.text.toString().toDouble() * 0.01
                val int_weight: Int = et_weight.text.toString().toInt()
                val myBmi:Float = (int_weight / (int_height * int_height)).toFloat()
                val txtBmi = "%.1f".format(myBmi)
                var msg:String = ""
                if(myBmi < 18.5) {
                    msg = "BMI는 $txtBmi 로\n 저체중입니다."
                } else if(myBmi >= 18.5 && myBmi < 23) {
                    msg = "BMI는 $txtBmi 로\n 정상입니다."
                } else if(myBmi >= 23 && myBmi < 25) {
                    msg = "BMI는 $txtBmi 로\n 비만 전 단계입니다."
                } else if(myBmi >= 25 && myBmi < 30) {
                    msg = "BMI는 $txtBmi 로\n 1단계 비만입니다."
                } else if(myBmi >= 30 && myBmi < 35) {
                    msg = "BMI는 $txtBmi 로\n 2단계 비만입니다."
                } else {
                    msg = "BMI는 $txtBmi 로\n 3단계 비만입니다."
                }
                tv_result.text = msg
            }
        }
    }
}