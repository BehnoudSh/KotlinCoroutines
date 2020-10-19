package ir.navaco.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    private val RESULT_1 = "Result #1"
    private val RESULT_2 = "Result #2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            //IO, Main, Default
            CoroutineScope(Dispatchers.IO)
                //launch ye doone coroutine e jadid misaze
                .launch {

                    fakeApiRequest()

                }
        }

    }

    private suspend fun fakeApiRequest() {
        val result1 = getResult1FromApi()
        println("debug:${result1}");
        setTextOnMainThread(result1)

        val result2 = getResult2FromApi()
        setTextOnMainThread(result2)
    }


    private suspend fun setTextOnMainThread(input: String) {
//context e coroutine e sakhte shode ro avaz kardim ke data ro az worker thread biarim to main thread namayesh bedim
        withContext(Main) {

            val newText = text.text.toString() + "\n${input}"
            text.text = newText

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

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return RESULT_2
    }
}