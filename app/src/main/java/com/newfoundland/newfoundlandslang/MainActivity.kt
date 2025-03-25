package com.newfoundland.newfoundlandslang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.newfoundland.newfoundlandslang.ui.theme.NewfoundlandSlangTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewfoundlandSlangTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Slang",
                        selectedIcon = ImageVector.vectorResource(id = R.drawable.baseline_message_24),
                        unselectedIcon = ImageVector.vectorResource(id = R.drawable.outline_message_24)
                    ),
                    BottomNavigationItem(
                        title = "Quiz",
                        selectedIcon = ImageVector.vectorResource(id = R.drawable.baseline_quiz_24),
                        unselectedIcon = ImageVector.vectorResource(id = R.drawable.outline_quiz_24)
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = ImageVector.vectorResource(id = R.drawable.baseline_settings_24),
                        unselectedIcon = ImageVector.vectorResource(id = R.drawable.outline_settings_24)
                    ),
                )
                var selectedItemIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex==index,
                                        onClick = {
                                            selectedItemIndex = index
                                            //navController.navigate(item.title)
                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                        alwaysShowLabel = true,
                                        icon = {
                                            Icon(
                                                imageVector = if (index == selectedItemIndex) {
                                                    item.selectedIcon
                                                } else {
                                                    item.unselectedIcon
                                                },
                                                contentDescription = item.title
                                            )
                                        },

                                    )
                                }
                            }
                        }
                    ) {
                        paddingValues ->
                        // Add your screen content here
                        Box(modifier = Modifier.padding(paddingValues)) {

                        }
                    }
                }
            }
        }
    }
}
