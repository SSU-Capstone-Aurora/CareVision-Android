package com.aurora.carevision.core.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary300
import com.aurora.carevision.app.ui.theme.White
import kotlinx.coroutines.selects.select
import androidx.compose.foundation.interaction.InteractionSource as InteractionSource1

@SuppressLint("RememberReturnType")
@Composable
fun ReviewDropdownMenu(
    menuItems: List<String>,
    selectedText : String,
    onMenuItemClick: (String) -> Unit
) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    var buttonWidth by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Column {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .border(1.dp, Gray300, RoundedCornerShape(10.dp))
                .background(White)
                .padding(6.dp)
                .onGloballyPositioned { coordinates ->
                    buttonWidth = with(density) { coordinates.size.width.toDp() }
                },
            contentAlignment = Alignment.CenterEnd
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment =  Alignment.CenterVertically
            ){
                Text(
                    text = if(selectedText.isEmpty()) "과를 선택해주세요" else selectedText,
                    style = CVTheme.typography.textBody1Medium,
                    color = Gray500,
                    modifier = Modifier
                        .padding(start=12.dp)
                )
            }

            IconButton(onClick = { isDropDownMenuExpanded = !isDropDownMenuExpanded }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menubutton_24),
                    contentDescription = "menu icon",
                    modifier = Modifier
                        .size(36.dp)
                )
            }
        }

        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .width(buttonWidth +12.dp)
                .border(1.dp, Primary300, RoundedCornerShape(10.dp))
                .background(White)
        ) {
            menuItems.forEachIndexed {index, menuItem ->
                var isCursered by remember{ mutableStateOf(false)}
                val backgroundcolor = if(isCursered) Primary300 else White
                DropdownMenuItem(
                    onClick = {
                        onMenuItemClick(menuItem)
                        isDropDownMenuExpanded = false
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
                        .background(backgroundcolor)
                        .padding(8.dp) // 메뉴 아이템들 사이 패딩

                        .pointerInput(Unit){
                            awaitPointerEventScope {
                                while(true){
                                    val event = awaitPointerEvent()
                                    isCursered = event.changes.any {it.pressed}
                                }
                            }
                        }


                )

            }
        }
    }

}

@Composable
@Preview
fun ReviewDropdownMenuPreview() {
    CVTheme {
        var selectedItem by rememberSaveable { mutableStateOf("과를 선택해주세요") }  // 선택된 항목 저장
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize(),
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        ) {
            val menuItems = listOf("신고하기", "차단하기", "기타")
            ReviewDropdownMenu(menuItems = menuItems, selectedText = "", onMenuItemClick = { selected ->
                selectedItem= selected
                //println("Selected item: $selectedItem")
                })
        }
    }
}