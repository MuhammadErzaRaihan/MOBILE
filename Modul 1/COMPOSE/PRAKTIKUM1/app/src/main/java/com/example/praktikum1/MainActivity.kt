package com.example.praktikum1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.praktikum1.ui.theme.PRAKTIKUM1Theme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PRAKTIKUM1Theme {
                DiceRollerApp()
            }
        }
    }
}

@Preview()
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage()
}



@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {

    var result1 by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    var message by remember { mutableStateOf("") }

    val imageResource1 = when (result1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val imageResource2 = when (result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

     Column (
         modifier = modifier,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         androidx.compose.foundation.layout.Row {
             Image(
                 painter = painterResource(imageResource1),
                 contentDescription = result1.toString()
             )

             Spacer(modifier = Modifier.height(8.dp))

             Image(
                 painter = painterResource(imageResource2),
                 contentDescription = result2.toString()
             )
         }


         Spacer(modifier = Modifier.height(16.dp))

         val doubleMessage = stringResource(R.string.double_message)
         val badMessage = stringResource(R.string.bad_message)

         Button(onClick = {
             result1 = (1..6).random()
             result2 = (1..6).random()

             message = if (result1 == result2) {
                 doubleMessage
             } else {
                 badMessage
             }
         }) {
             Text(stringResource(R.string.roll))
         }

         Spacer(modifier = Modifier.height(16.dp))

         Text(text = message)


     }}


