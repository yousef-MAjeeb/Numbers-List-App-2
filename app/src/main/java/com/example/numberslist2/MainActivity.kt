package com.example.numberslist2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.numberslist2.ui.theme.NumbersList2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumbersList2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {Text("Number List App")},
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    },
                    content = { paddingValues ->
                        NumberList(
                            modifier = Modifier.padding(paddingValues).padding(8.dp)
                        )

                    }

                )
            }
        }
    }
}

@Composable
fun NumberList(modifier: Modifier){
    val englishNumList = listOf<String>("One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten")
    val arabicNumList = listOf<String>("واحد","إثنان","ثلاثة","أربعة","خمسة","ستة","سبعة","ثمانية","تسعة","عشرة")
    val imageResourcesList = listOf(
        R.drawable.number_one, R.drawable.number_two,
        R.drawable.number_three, R.drawable.number_four,
        R.drawable.number_five, R.drawable.number_six,
        R.drawable.number_seven, R.drawable.number_eight,
        R.drawable.number_nine, R.drawable.number_ten,
    )
    LazyColumn(
        modifier = modifier,
    ) {
        items(10){ i ->
            NumberCard(
                imageResourcesList[i],
                englishNumList[i],
                arabicNumList[i]
            )
        }
    }
}

@Composable
fun NumberCard(numberImage: Int, englishNum: String, arabicNum: String) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(numberImage),
                contentDescription = "image of the number",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(8.dp),
            )
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = englishNum,
                    fontSize = 30.sp
                )
                Text(
                    text = arabicNum,
                    fontSize = 30.sp
                )
            }
        }

    }
}