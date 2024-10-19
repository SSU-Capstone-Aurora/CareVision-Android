package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Red700
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVDropdownMenu(menuItems: List<String>, onMenuItemClick: (String) -> Unit) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier.wrapContentSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu_button),
            contentDescription = "menu icon",
            modifier =
            Modifier
                .wrapContentSize()
                .clickable { isDropDownMenuExpanded = true },
            tint = Gray500
        )

        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },
            modifier = Modifier
                .background(White)
                .wrapContentSize()
        ) {
            menuItems.forEach { menuItem ->
                DropdownMenuItem(
                    onClick = {
                        onMenuItemClick(menuItem)
                        isDropDownMenuExpanded = false
                    },
                    text = {
                        Text(
                            text = menuItem,
                            color = Red700,
                            style = CVTheme.typography.textBody2Importance,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        )
                    },
                    modifier = Modifier
                        .background(White)
                        .fillMaxWidth()
                )
            }
        }
    }

}

@Composable
@Preview
fun ReviewDropdownMenuPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White).fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
        ) {
            val menuItems = listOf("신고하기", "차단하기", "기타")
            CVDropdownMenu(menuItems) { selectedItem ->
                println("Selected item: $selectedItem")
            }
        }
    }
}