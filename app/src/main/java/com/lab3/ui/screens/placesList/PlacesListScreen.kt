package com.lab3.ui.screens.placesList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lab3.data.ItemsData
import androidx.compose.ui.draw.clip


/**
 * PlaceListScreen - the first (initial) screen in app with the list of items
 * - [onDetailsScreen]: (Int) -> Unit - function for redirection to details screen with parameter ID
 */
@Composable
fun PlacesListScreen(
    onDetailsScreen: (Int) -> Unit,
) {
    // state with the list of items to show on screen
    // ItemsData.itemsList - shared source of data
    val itemsListState = remember { mutableStateOf(ItemsData.itemsList) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(itemsListState.value) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(top = 20.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFDAB3FF))
                        .clickable {
                            onDetailsScreen(item.id)
                        }

                ) {
                    Text(
                        text = "${item.id}. ${item.title}",
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)


                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlacesListScreenPreview() {
    PlacesListScreen({})
}