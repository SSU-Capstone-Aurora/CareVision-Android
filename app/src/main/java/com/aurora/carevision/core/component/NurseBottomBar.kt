package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun NurseBottomBar(
    content: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .height(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .selectableGroup()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            content = content,
        )
    }
}

@Composable
fun BottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 30.dp)
            .clickable { onClick() }
            .fillMaxHeight()
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "$label Icon",
            tint = if (isSelected) Primary600 else Gray500
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = label,
            textAlign = TextAlign.Center,
            style = CVTheme.typography.captionImportance,
            color = if (isSelected) Primary600 else Gray500
        )
    }
}

@Composable
@Preview
fun NurseBottomBarPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
        ) {
            NurseBottomBar(
                content = {
                    BottomNavItem(
                        icon = R.drawable.ic_home_line,
                        label = "Home",
                        isSelected = true,
                        onClick = {}
                    )
                    BottomNavItem(
                        icon = R.drawable.ic_home_line,
                        label = "Search",
                        isSelected = false,
                        onClick = {}
                    )
                    BottomNavItem(
                        icon = R.drawable.ic_home_line,
                        label = "Favorite",
                        isSelected = false,
                        onClick = {}
                    )
                    BottomNavItem(
                        icon = R.drawable.ic_home_line,
                        label = "내 정보",
                        isSelected = false,
                        onClick = {}
                    )
                }
            )
        }
    }
}
