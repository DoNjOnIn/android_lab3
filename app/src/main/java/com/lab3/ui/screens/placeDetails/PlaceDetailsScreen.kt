package com.lab3.ui.screens.placeDetails

import android.content.Context
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lab3.R
import com.lab3.data.ItemsData
import com.lab3.ui.navigation.NavigationGraph
import com.lab3.ui.navigation.SCREEN_PLACE_DETAILS

/**
 * PlaceDetailsScreen - the second screen in app with the details of selected item
 * - [id]: Int - the id parameter to find and show corresponding item on screen
 */

@Composable
fun PlaceDetailsScreen(
    id: Int,
    onBack: () -> Unit,
) {
    // State with the item
    val itemState = remember {
        mutableStateOf(
            // Finding the item by id in shared data source ItemsData.itemsList
            ItemsData.itemsList.first { it.id == id }
        )
    }
    @SuppressLint("DiscouragedApi")
    val context = LocalContext.current
    fun getImageResourceById(context: Context, id: Int): Int {
        val resourceName = "foto$id"
        return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
    }
    val imageResource = getImageResourceById(context, id)


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    onBack()
                },
                colors = ButtonDefaults.buttonColors(Color(0xFFD32F2F))
            ) {
                Text(text = "Back", color = Color(0xFFFFFFFF))
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            item {
                Text(
                    text = itemState.value.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            item {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = "Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Text(
                    text = itemState.value.description,
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .padding(top = 15.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceDetailsScreenPreview() {
    PlaceDetailsScreen(
        id = 3,
        onBack = {}
    )
}