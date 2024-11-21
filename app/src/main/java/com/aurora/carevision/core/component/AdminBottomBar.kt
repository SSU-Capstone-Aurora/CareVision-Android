package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
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
    onCenterButtonClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .height(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .selectableGroup()
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )

            AdminBottomCenterButton(
                icon = R.drawable.ic_admin_registration_button,
                isSelected = true,
                onClick = { onCenterButtonClick() },
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

@Composable
fun AdminBottomNavItem(
    icon: Int,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
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
fun AdminBottomCenterButton(
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(64.dp)
            .background(Primary600, shape = CircleShape)
            .clickable { onClick() }
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Center Button Icon",
            tint = White,
            modifier = Modifier.size(36.dp)
        )
    }
}

@Composable
@Preview
fun AdminBottomBarPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .background(White)
        ) {
            AdminBottomBar(
                onCenterButtonClick = {},
                content = {
                    AdminBottomNavItem(
                        icon = R.drawable.ic_home_line,
                        label = "홈",
                        isSelected = true,
                        onClick = { }
                    )

                    AdminBottomNavItem(
                        icon = R.drawable.ic_bell_bottom_navi_line,
                        label = "요청",
                        isSelected = false,
                        onClick = {}
                    )
                }
            )
        }
    }
}