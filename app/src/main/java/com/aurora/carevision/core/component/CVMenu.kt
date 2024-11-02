package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray600
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun ReviewDropdownMenu(
    menuItems: List<String>,
    modifier: Modifier = Modifier,
    placeholder: String = "병원을 선택해주세요.",
    onMenuItemClick: (String) -> Unit = {}
) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .border(1.dp, Gray300, RoundedCornerShape(10.dp))
                .background(White)
                .padding(6.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (selectedItem.isEmpty()) placeholder else selectedItem,
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                    modifier = Modifier
                        .padding(start = 12.dp)
                )
            }

            IconButton(onClick = { isDropDownMenuExpanded = !isDropDownMenuExpanded }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menubutton_24),
                    contentDescription = "menu icon",
                    tint = Gray600,
                    modifier = Modifier
                        .size(36.dp)
                        .padding(end = 12.dp)
                )
            }
        }

        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(235.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .border(1.dp, Primary600, RoundedCornerShape(10.dp))
                .background(White)
        ) {
            menuItems.forEach { menuItem ->
                val isSelected = menuItem == selectedItem
                DropdownMenuItem(
                    onClick = {
                        selectedItem = menuItem
                        onMenuItemClick(menuItem)
                    },
                    text = {
                        Text(
                            text = menuItem,
                            style = CVTheme.typography.textBody1Medium,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(if (isSelected) Primary200 else White)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun ReviewDropdownMenuPreview() {
    CVTheme {
        var selectedItem by rememberSaveable { mutableStateOf("병원을 선택해주세요") }
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val menuItems = listOf(
                "내과",
                "외과",
                "소아과",
                "피부과",
                "안과",
                "이비인후과",
                "비뇨기과",
                "정형외과",
                "신경외과",
                "치과",
                "한의원",
                "약국"
            )
            ReviewDropdownMenu(
                menuItems = menuItems,
                onMenuItemClick = { selected ->
                    selectedItem = selected
                }
            )
        }
    }
}