package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
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
import androidx.compose.ui.window.Dialog
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray200
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.Primary700
import com.aurora.carevision.app.ui.theme.White


@Composable
fun CVAdminRegistrationModal(
    isVisible: Boolean,
    onDismiss: () -> Unit,
    onDeviceRegistrationClick: () -> Unit,
    onPatientRegistrationClick: () -> Unit
) {
    if (isVisible) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 58.dp)
                    .background(White, shape = RoundedCornerShape(8.dp))
                    .width(191.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .width(191.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .clickable { onDeviceRegistrationClick() },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(
                            text = "장치 및 베드 등록",
                            style = CVTheme.typography.textBody2Importance,
                            color = Primary700,
                            modifier = Modifier
                                .clickable { onDeviceRegistrationClick() }
                                .padding(start = 16.dp),
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_modal_camera),
                            contentDescription = "Bed Registration icon",
                            tint = Primary700,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }

                    Divider(
                        color = Gray100,
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onPatientRegistrationClick() }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "환자 등록",
                            style = CVTheme.typography.textBody2Importance,
                            color = Primary700,
                            modifier = Modifier
                                .clickable { onPatientRegistrationClick() }
                                .padding(start = 16.dp),
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_patient_register_line),
                            contentDescription = "Patient Registration icon",
                            tint = Primary700,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun CenterButtonModalPreview() {
    CVTheme {
        val isVisible = remember { mutableStateOf(true) }

        Box(modifier = Modifier.fillMaxSize()) {

            Text(
                text = "동그라미~",
                color = Primary600,
                style = CVTheme.typography.headingPrimary,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable { isVisible.value = true }
                    .padding(16.dp)
            )

            // 모달 창 표시
            CVAdminRegistrationModal(
                isVisible = isVisible.value,
                onDismiss = { isVisible.value = false },
                onDeviceRegistrationClick = {
                    isVisible.value = false
                    println("장치 및 베드 등록 선택")
                },
                onPatientRegistrationClick = {
                    isVisible.value = false
                    println("환자 등록 선택")
                }
            )
        }
    }
}