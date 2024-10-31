package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun AdminBottomBar(
    navigateToHome: () -> Unit = {},
    navigateToPatientRegister: () -> Unit = {},
    navigateToNotification: () -> Unit = {},
) {
    val selectedItem = remember { mutableStateOf("home") }  // 현재 선택된 아이템 상태

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BottomNavItem(
            icon = R.drawable.ic_home_line,
            label = "홈",
            isSelected = selectedItem.value == "home",
            onClick = {
                selectedItem.value = "home"
                navigateToHome()
            },
            modifier = Modifier.padding(start = 50.dp)
        )

        BottomNavItem(
            icon = R.drawable.ic_bell_bottom_navi_line,
            label = "요청",
            isSelected = selectedItem.value == "notification",
            onClick = {
                selectedItem.value = "notification"
                navigateToNotification()
            },
            modifier = Modifier.padding(end = 50.dp)
        )
    }
}

@Composable
fun BottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable { onClick() }
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
fun AdminBottomBarPreview() {
    CVTheme {
        AdminBottomBar()
    }
}
