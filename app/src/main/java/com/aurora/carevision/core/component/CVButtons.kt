package com.aurora.carevision.core.component


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.Red200
import com.aurora.carevision.app.ui.theme.Red700
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVBasicButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = Primary500,
    textColor: Color = White,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    paddingValues: PaddingValues = PaddingValues(0.dp)
) {
    Box(
        modifier = modifier
            .padding(paddingValues)
            .height(58.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (enabled) backgroundColor else Gray300)
            .fillMaxWidth()
            .clickable(
                onClick = onClick,
                enabled = enabled,
                indication = null, // ripple 이 없는 button
                interactionSource = interactionSource
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = textColor, style = CVTheme.typography.button)
    }
}

@Composable
fun CVLongButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = Primary600,
    paddingValues: PaddingValues = PaddingValues(horizontal = 24.dp)
) {
    CVBasicButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        backgroundColor = backgroundColor,
        textColor = White,
        paddingValues = paddingValues
    )
}

@Composable
fun CVShortButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = Primary500,
    textColor: Color = White,
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp)
) {
    CVBasicButton(
        text = text,
        onClick = onClick,
        modifier = modifier
            .width(130.dp)
            .height(50.dp),
        enabled = enabled,
        backgroundColor = backgroundColor,
        textColor = textColor,
        paddingValues = paddingValues
    )
}

@Composable
fun CVRedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = Red200,
    paddingValues: PaddingValues = PaddingValues(horizontal = 24.dp)
) {
    CVBasicButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        backgroundColor = backgroundColor,
        textColor = if (enabled) Red700 else White,
        paddingValues = paddingValues
    )
}

@Preview
@Composable
fun CVLongButtonPreview() {
    CVTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CVLongButton(text = "다음", onClick = {})
            CVLongButton(text = "다음", onClick = {}, enabled = false)
            CVRedButton(text = "회원탈퇴", onClick = {}, enabled = false, backgroundColor = Red200)
            CVRedButton(text = "회원탈퇴", onClick = {}, enabled = true, backgroundColor = Red200)

            Row {
                CVShortButton(text = "확인인", onClick = {})
                CVShortButton(
                    text = "취소",
                    onClick = {},
                    backgroundColor = Gray200,
                    textColor = Gray500
                )
            }
        }
    }
}
// 한글