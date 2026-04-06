package com.example.numberslist2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.numberslist2.ui.theme.NumbersList2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumbersList2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NumberList(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NumberList(modifier: Modifier){
    val englishNumList = listOf<String>("One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten")
    val arabicNumList = listOf<String>("واحد","إثنان","ثلاثة","أربعة","خمسة","Six","سبعة","ثمانية","تسعة","عشرة")
    LazyColumn() {
        items(10){ i ->
            NumberCard(i,englishNumList[i], arabicNumList[i])

        }
    }
}

@Composable
fun NumberCard(numberImage: Int, englishNum: String, arabicNum: String) {
    OutlinedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row {
            Image(
                painter = painterResource(numberImage),
                contentDescription = "image of the number",
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp),
            )
            Column() {
                Text(text = englishNum)
                Text(text = arabicNum)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NumberCardPreview() {
    NumbersList2Theme {

    }
}