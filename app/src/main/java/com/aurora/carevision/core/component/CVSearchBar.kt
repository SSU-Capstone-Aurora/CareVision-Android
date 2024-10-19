package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVHeadIconSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "텍스트를 입력하세요",
    backgroundColor: Color = White,
    headIcon: Int = R.drawable.ic_search_gray_24,
    borderVisible: Boolean = false
) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .fillMaxWidth()
            .border(if (borderVisible) 1.dp else 0.dp, Gray300, RoundedCornerShape(10.dp))
            .padding(16.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                if (focusState.isFocused) {
                    focusRequester.requestFocus()
                }
            },
        singleLine = true,
        textStyle = CVTheme.typography.textBody1Medium.copy(color = Gray500),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                
                Icon(
                    painter = painterResource(id = headIcon),
                    contentDescription = "search icon",
                    tint = Gray500,
                )


                Box(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    innerTextField()

                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Gray500,
                            style = CVTheme.typography.textBody1Medium,
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun CVTailIconSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "텍스트를 입력하세요",
    backgroundColor: Color = White,
    tailIcon: Int = R.drawable.ic_search_gray_24,
    borderVisible: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onTextChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .fillMaxWidth()

            .border(1.dp, Gray300, RoundedCornerShape(10.dp))
            .padding(16.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->focusState.isFocused},

        singleLine = true,
        textStyle = CVTheme.typography.textBody1Medium.copy(color = Gray500),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    innerTextField()

                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Gray500,
                            style = CVTheme.typography.textBody1Medium,
                        )
                    }
                }

                Icon(
                    painter = painterResource(id = tailIcon),
                    contentDescription = "search icon",
                    tint = Gray500,
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCVSearchBar() {
    CVTheme {
        var searchBarText by rememberSaveable { mutableStateOf("") }
        Column(
            modifier = Modifier
                .background(White)
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CVHeadIconSearchBar(value = "", onValueChange = {}, modifier = Modifier)
            CVHeadIconSearchBar(
                value = "dd",
                onValueChange = {},
                modifier = Modifier,
                backgroundColor = Gray200
            )
            CVTailIconSearchBar(
                value = "",
                onValueChange = {},
                placeholder = "병원 이름을 입력하세요",
                onTextChanged = {},
                onFocusChanged = {},
            )
        }
    }
}
