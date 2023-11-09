package com.example.testapp1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp1.ui.theme.TestApp1Theme

class MainActivity : ComponentActivity() {
    // The first state the activity goes through
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate")
        println("test")
        setContent {
            TestApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart")
        setContent {
            TestApp1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.padding(16.dp).background(color = Color.Green),
                ) {
                    Box(modifier = Modifier.padding(16.dp).background(color = Color.Red), contentAlignment = Alignment.Center) {
                        GreetingButton("Maxwell")
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("MainActivity", "onSaveInstanceState")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        textAlign = TextAlign.Center
    )
}

/*
  Prints out a greeting when a button is pressed
 */
@Composable
fun GreetingButton(name: String, modifier: Modifier = Modifier) {
    Button(onClick = {

    }) {
        Greeting(name, modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestApp1Theme {
        Greeting("Android")
    }
}