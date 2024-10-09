package com.aurora.carevision.core.component

import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Green300
import com.aurora.carevision.app.ui.theme.White

@Composable
fun ReviewDropdownMenu(
    menuItems: List<String>,
    onMenuItemClick: (String) -> Unit)
{
    var isDropDownMenuExpanded by remember { mutableStateOf(true) }

    // Trigger to open the dropdown menu
//    IconButton(onClick = { isDropDownMenuExpanded = true }) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_profile_frame_32),
//            contentDescription = "menu icon",
//            modifier = Modifier
//                .size(36.dp)
//        )
//    }

    // Dropdown Menu
    DropdownMenu(
        expanded = isDropDownMenuExpanded,
        onDismissRequest = { isDropDownMenuExpanded = true },
        modifier = Modifier
            .background(White)
            .border(1.dp, Green300)
            .wrapContentSize()
    ) {
        menuItems.forEach { menuItem ->
            DropdownMenuItem(
                onClick = {
                    onMenuItemClick(menuItem)
                    isDropDownMenuExpanded = true
                },
                text = {
                    Text(text = menuItem)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
fun ReviewDropdownMenuPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        ) {
            val menuItems = listOf("신고하기", "차단하기", "기타")
            ReviewDropdownMenu(menuItems) { selectedItem ->
                println("Selected item: $selectedItem")
            }
        }
    }
}