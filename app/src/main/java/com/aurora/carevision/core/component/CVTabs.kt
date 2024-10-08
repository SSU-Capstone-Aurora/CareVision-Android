package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVTabs(
    tabItemTitle: List<String>,
    modifier: Modifier = Modifier,
    onClickTabItem: (Int) -> Unit, // Int : index
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier
            .background(White)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        TabRow(
            selectedTabIndex = selectedIndex,
            containerColor = Transparent,
            contentColor = Primary700,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex])
                        .padding(horizontal = 12.dp)
                        .height(4.dp),
                    color = Primary700,
                )
            },
            modifier = Modifier
                .background(White)
                .weight(2f),
        ) {
            tabItemTitle.forEachIndexed { index, _ ->
                Tab(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                        onClickTabItem(index)
                    },
                    modifier = Modifier.padding(horizontal = 16.dp),
                ) {
                    Box(
                        modifier =
                        Modifier
                    ) {
                        Text(
                            text = tabItemTitle[index],
                            style = CVTheme.typography.textBody1Importance,
                            modifier = Modifier.padding(vertical = 14.dp),
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview
fun CVTabsPreview() {
    CVTheme {
        CVTabs(
            tabItemTitle = listOf("간호사", "환자", "카메라"),
            onClickTabItem = {},
        )
    }
}