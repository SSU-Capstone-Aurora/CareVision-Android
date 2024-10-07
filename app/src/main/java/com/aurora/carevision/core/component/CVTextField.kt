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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Green300
import com.aurora.carevision.app.ui.theme.Green400
import com.aurora.carevision.app.ui.theme.Green500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVBasicTextField(
    value: String,
    placeholder: String,
    onTextChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = onTextChanged,
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .background(Gray100)
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
            },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            },
            onSearch = {
                focusManager.clearFocus()
            }
        ),
        textStyle = CVTheme.typography.textBody2Medium.copy(color = Gray100),
        decorationBox = { innerTextField ->
            Box (
                modifier = Modifier.fillMaxWidth()


            ) {
                innerTextField()
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        textAlign = TextAlign.Start,
                        color = Gray300,
                        //modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }
    )
}

@Preview
@Composable
fun CVTextFieldPreview() {
    CVTheme {
        Column {
            CVBasicTextField(
                value = "",
                placeholder = "아이디를 입력해주세요",
                onTextChanged = {},
                onFocusChanged = {},
            )

            Spacer(modifier = Modifier.height(16.dp))

            CVBasicTextField(
                value = "Text Entered",
                placeholder = "Placeholder",
                onTextChanged = {},
                onFocusChanged = {},
            )
        }
    }
}