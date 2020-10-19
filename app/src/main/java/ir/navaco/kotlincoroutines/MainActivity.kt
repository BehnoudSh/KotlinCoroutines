package ir.navaco.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    private val RESULT_1 = "Result #1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {


        }


    }

    private suspend fun getResult1FromApi(): String {

        logThread("getResult1FromApi")

        delay(1000)

        return RESULT_1

    }

    private fun logThread(methodName: String) {

        println("debug : ${methodName} : ${Thread.currentThread().name}")

    }

}