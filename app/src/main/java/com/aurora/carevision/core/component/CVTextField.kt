package com.aurora.carevision.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary200
import com.aurora.carevision.app.ui.theme.Primary300
import com.aurora.carevision.app.ui.theme.Primary500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White
import java.util.DuplicateFormatFlagsException

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
            .fillMaxWidth()
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
            focusedBorderColor = if (isError) Red600 else Primary500,
            unfocusedBorderColor = if (isError) Red600 else Gray500,
            focusedLabelColor = if (isError) Red600 else Primary600,
            focusedLeadingIconColor = if (isError) Red600 else Primary600,
            focusedTrailingIconColor = if (isError) Red600 else Primary600,
            unfocusedLabelColor = if (isError) Red600 else Gray500,
            unfocusedLeadingIconColor = if (isError) Red600 else Gray500,
            unfocusedTrailingIconColor = if (isError) Red600 else Gray500,
            errorLabelColor = Red600,
            errorBorderColor = Red600,
            cursorColor = Primary600,
        ),
        label = {
            Text(
                text = label,
                style = CVTheme.typography.captionRegular,
                color = if (isError) Red600 else Gray500
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVPasswordTextField(
    value: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Int? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
){
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var password by rememberSaveable { mutableStateOf("") }
    var isVisiblePassword by rememberSaveable { mutableStateOf((false)) }

    OutlinedTextField(
        value = value,
        onValueChange = onTextChanged,
        singleLine = true,
        trailingIcon = {
            val icon = if (value.isEmpty()) {
                painterResource(id = R.drawable.ic_passwordvisible_black_icon_24)
            }
            else {
                if (isVisiblePassword) {
                    painterResource(id = R.drawable.ic_passwordinvisible_icon_24)
                } else {
                    painterResource(id = R.drawable.ic_passwordvisible_icon_24)
                }
            }
            IconButton(onClick = {isVisiblePassword = !isVisiblePassword}){
                Image(
                    painter = icon,
                    contentDescription = null,
                )
            }
        },
        visualTransformation = if(isVisiblePassword){
            VisualTransformation.None
        }
                else{
                    PasswordVisualTransformation()
        },
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
            },


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
            focusedBorderColor = if (isError) Red600 else Primary500,
            unfocusedBorderColor = if (isError) Red600 else Gray500,
            focusedLabelColor = if (isError) Red600 else Primary600,
            focusedLeadingIconColor = if (isError) Red600 else Primary600,
            focusedTrailingIconColor = if (isError) Red600 else Primary600,
            unfocusedLabelColor = if (isError) Red600 else Gray500,
            unfocusedLeadingIconColor = if (isError) Red600 else Gray500,
            unfocusedTrailingIconColor = if (isError) Red600 else Gray500,
            errorLabelColor = Red600,
            errorBorderColor = Red600,
            cursorColor = Primary600,
        ),
        label = {
            Text(
                text = label,
                style = CVTheme.typography.captionRegular,
                color = if (isError) Red600 else Gray500
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = CVTheme.typography.captionRegular,
                color = Gray500
            )
        },

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVSignInPasswordTextField(
    value: String,
    placeholder: String,
    label: String,
    onTextChanged: (String) -> Unit,
    onFocusChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: Int? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
){
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    var password by rememberSaveable { mutableStateOf("") }
    var isVisiblePassword by rememberSaveable { mutableStateOf((false)) }

    OutlinedTextField(
        value = value,
        onValueChange = onTextChanged,
        singleLine = true,
        trailingIcon = {

            val icon = when {
                value.isEmpty() -> painterResource(id = R.drawable.ic_passwordvisible_black_icon_24)
                isError -> painterResource(id = R.drawable.ic_profile_frame_32)
                isVisiblePassword -> painterResource(id = R.drawable.ic_passwordinvisible_icon_24)
                else -> painterResource(id = R.drawable.ic_passwordvisible_icon_24)
            }
            IconButton(onClick = {isVisiblePassword = !isVisiblePassword}){
                Image(
                    painter = icon,
                    contentDescription = null,
                )
            }

        },
        visualTransformation = if(isVisiblePassword){
            VisualTransformation.None
        }
        else{
            PasswordVisualTransformation()
        },
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                onFocusChanged(focusState.isFocused)
            },


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
            focusedBorderColor = if (isError) Red600 else Primary500,
            unfocusedBorderColor = if (isError) Red600 else Gray500,
            focusedLabelColor = if (isError) Red600 else Primary600,
            focusedLeadingIconColor = if (isError) Red600 else Primary600,
            focusedTrailingIconColor = if (isError) Red600 else Primary600,
            unfocusedLabelColor = if (isError) Red600 else Gray500,
            unfocusedLeadingIconColor = if (isError) Red600 else Gray500,
            unfocusedTrailingIconColor = if (isError) Red600 else Gray500,
            errorLabelColor = Red600,
            errorBorderColor = Red600,
            cursorColor = Primary600,
        ),
        label = {
            Text(
                text = label,
                style = CVTheme.typography.captionRegular,
                color = if (isError) Red600 else Gray500
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = CVTheme.typography.captionRegular,
                color = Gray500
            )
        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CVDuplicateCheckTextField(
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
    onDuplicateCheck:() ->Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = value,
        onValueChange = onTextChanged,
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
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
            focusedBorderColor = if (isError) Red600 else Primary500,
            unfocusedBorderColor = if (isError) Red600 else Gray500,
            focusedLabelColor = if (isError) Red600 else Primary600,
            focusedLeadingIconColor = if (isError) Red600 else Primary600,
            focusedTrailingIconColor = if (isError) Red600 else Primary600,
            unfocusedLabelColor = if (isError) Red600 else Gray500,
            unfocusedLeadingIconColor = if (isError) Red600 else Gray500,
            unfocusedTrailingIconColor = if (isError) Red600 else Gray500,
            errorLabelColor = Red600,
            errorBorderColor = Red600,
            cursorColor = Primary600,
        ),
        label = {
            Text(
                text = label,
                style = CVTheme.typography.captionRegular,
                color = if (isError) Red600 else Gray500
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
            Button(
                onClick = {onDuplicateCheck()},
                modifier = Modifier
                    .padding(end = 12.dp),
                colors = ButtonDefaults.buttonColors(Primary200),
                shape = RoundedCornerShape(8.dp)

            ){
                Text(text = "중복 확인",
                    color = Primary700
                )
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
                isError = true,
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
            Spacer(modifier = Modifier.height(16.dp))

            CVPasswordTextField(
                value = "",
                placeholder = "비밀번호를 입력하세요",
                label = "비밀번호",
                onTextChanged = {},
                onFocusChanged = {},
                isError = true
            )
            Spacer(modifier = Modifier.height(16.dp))

            CVDuplicateCheckTextField(
                value = "",
                placeholder = "아이디를 입력하세요",
                label = "아이디",
                onTextChanged = {},
                onDuplicateCheck = {},
                onFocusChanged = {},
                isError = true
            )
            Spacer(modifier = Modifier.height(16.dp))

            CVSignInPasswordTextField(
                value = "",
                placeholder = "비밀번호를 입력하세요",
                label = "비밀번호",
                onTextChanged = {},
                onFocusChanged = {},
                isError = true
            )
        }
    }
}



