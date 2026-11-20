
package com.newmarket.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketScreen()
        }
    }
}

@Composable
fun MarketScreen() {
    var search by remember { mutableStateOf("") }
    var selected by remember { mutableStateOf("All") }

    val categories = listOf(
        "All", "Technology", "Automobile",
        "Fashion", "Gadgets", "Science",
        "Business", "Gaming", "World"
    )

    val news = listOf(
        "New Technology Updates",
        "Latest Smartphone Launches",
        "New Electric Vehicles",
        "Science and Space Discoveries",
        "Latest Business Updates",
        "New Gaming Releases"
    )

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF4F6FA)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    "NEW MARKET",
                    fontSize = 27.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF173B75)
                )

                Text(
                    "India • World • Latest Updates",
                    color = Color.DarkGray,
                    fontSize = 13.sp
                )

                Spacer(Modifier.height(18.dp))

                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Search market updates...") },
                    singleLine = true
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    "Explore Categories",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "All",
                        modifier = Modifier
                            .background(
                                Color(0xFF173B75),
                                RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        color = Color.White
                    )
                    Text("Tech")
                    Text("Auto")
                    Text("Fashion")
                }

                Spacer(Modifier.height(20.dp))

                Text(
                    "Latest Market Updates",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(10.dp))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(news.filter {
                        it.contains(search, ignoreCase = true)
                    }) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White
                            )
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "LATEST UPDATE",
                                    color = Color(0xFF1976D2),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(6.dp))
                                Text(
                                    item,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(Modifier.height(6.dp))
                                Text(
                                    "Market news and updates coming soon.",
                                    color = Color.Gray,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
