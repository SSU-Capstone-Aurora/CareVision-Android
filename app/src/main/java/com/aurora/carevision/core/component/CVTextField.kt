package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVBasicTextField(
    value: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Int? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = onTextChanged,
        isError = isError,
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
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
        textStyle = CVTheme.typography.textBody2Medium.copy(color = Black),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary600,
            unfocusedBorderColor = Gray500,
            focusedLabelColor = Primary600,
            focusedLeadingIconColor = Primary600,
            focusedTrailingIconColor = Primary600,
            unfocusedLabelColor = Gray500,
            unfocusedLeadingIconColor = Gray500,
            unfocusedTrailingIconColor = Gray500,
            errorLabelColor = Red600,
            errorBorderColor = Red600,
            cursorColor = Primary600,
        ),
        label = {
            Text(
                text = label,
                style = CVTheme.typography.captionRegular,
                color = Gray500
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = CVTheme.typography.captionRegular,
                color = Gray500
            )
        },
        trailingIcon = {
            if (trailingIcon != null) {
                Icon(painter = painterResource(id = trailingIcon), contentDescription = "")
            }
        }
    )
}

@Preview
@Composable
fun CVTextFieldPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            CVBasicTextField(
                value = "",
                placeholder = "아이디를 입력하세요",
                label = "아이디",
                onTextChanged = {},
                onFocusChanged = {},
                trailingIcon = R.drawable.ic_login_error_24
            )

            Spacer(modifier = Modifier.height(16.dp))

            CVBasicTextField(
                value = "Text Entered",
                placeholder = "아이디를 입력하세요",
                label = "아이디",
                onTextChanged = {},
                onFocusChanged = {},
                isError = true
            )
        }
    }
}


