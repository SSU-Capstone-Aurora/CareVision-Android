package com.aurora.carevision.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary400
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.Red400
import com.aurora.carevision.app.ui.theme.Red600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun CVTwoButtonDialog(
    negativeButtonText: String,
    positiveButtonText: String,
    onNegativeButtonClicked: () -> Unit,
    onPositiveButtonClicked: () -> Unit,
    iconColor : Color,
    positiveButtonColor: Color,
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    dialogImage: Int? = null,
) {
    Dialog(onDismissRequest = onNegativeButtonClicked) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = White
            ),
        ) {
            Column(
                modifier = Modifier.padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                if(dialogImage == null) {
                    Icon(painter = painterResource(id = R.drawable.ic_information), contentDescription = "Dialog Image", modifier = Modifier.size(48.dp), tint = iconColor)
                }

                Spacer(modifier = Modifier.height(28.dp))
                if (title != null) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        style = CVTheme.typography.headingSecondary,
                        color = Black,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                }

                if (description != null) {
                    Text(
                        text = description,
                        textAlign = TextAlign.Center,
                        style = CVTheme.typography.textBody2Medium,
                        color = Gray500,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                }

                Row {
                    CVShortButton(text = negativeButtonText, onClick = { onNegativeButtonClicked() }, backgroundColor = Gray200, textColor = Gray500)
                    Spacer(modifier = Modifier.width(12.dp))
                    CVShortButton(text = positiveButtonText, onClick = { onPositiveButtonClicked() }, backgroundColor = positiveButtonColor, textColor = White)

                }
            }
        }
    }
}

@Preview
@Composable
fun DialogPrimaryPreview() {
    CVTheme{
        CVTwoButtonDialog(
            negativeButtonText = "취소",
            positiveButtonText = "확인",
            onNegativeButtonClicked = {},
            onPositiveButtonClicked = {},
            title = "오로라 간호사의 가입 요청을\n수락하시겠습니까?",
            iconColor = Primary400,
            positiveButtonColor = Primary600
        )
    }
}

@Preview
@Composable
fun DialogRedPreview() {
    CVTheme{
        CVTwoButtonDialog(
            negativeButtonText = "취소",
            positiveButtonText = "확인",
            onNegativeButtonClicked = {},
            onPositiveButtonClicked = {},
            title = "정말로 오로라 간호사의\n가입 요청을 거부하시겠습니까?",
            description = "거부 시 간호사가 다시 요청을 해야 합니다.",
            iconColor = Red400,
            positiveButtonColor = Red600
        )
    }
}