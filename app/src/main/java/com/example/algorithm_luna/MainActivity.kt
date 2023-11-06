package com.example.algorithm_luna

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algorithm_luna.ui.theme.Algorithm_LunaTheme

class MainActivity : ComponentActivity(), View.OnClickListener {
    lateinit var btnInput : Button
    lateinit var txtInput : EditText
    lateinit var txtOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            Algorithm_LunaTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
        setContentView(R.layout.activity_main)
        btnInput = findViewById(R.id.button1)
        txtInput = findViewById(R.id.input_text)
        txtOutput = findViewById(R.id.answer)

        btnInput.setOnClickListener(this)
        }

    override fun onClick(input: View?) {
        when (input?.id){
            R.id.button1 -> {
                var cardNum = txtInput.text.toString()
                if (cardNum.isNullOrEmpty()){
                    txtOutput.text = "Input is empty!"

                } else {
                var res = cardNum.filter { it.isDigit() }.
                reversed().
                map { it.toString().toInt()}.
                toMutableList().
                mapIndexed() { index, c -> if ((index + 1) % 2 == 0) c * 2 else c }.
                map{it -> if(it > 9) (it/10) + (it%10) else it}.
                sum() % 10 == 0
                txtOutput.text = "$res"
            }
            }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Algorithm_LunaTheme {
        Greeting("Android")
    }
}