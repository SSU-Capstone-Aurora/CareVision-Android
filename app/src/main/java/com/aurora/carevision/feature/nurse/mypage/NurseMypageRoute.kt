package com.aurora.carevision.feature.nurse.mypage

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.Gray700
import com.aurora.carevision.app.ui.theme.Primary600
import com.aurora.carevision.app.ui.theme.White

@Composable
fun NurseMypageRoute(
    onClickLogout: () -> Unit = {},
    viewModel: MypageViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsStateWithLifecycle().value
    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.sideEffect.collect{
            when(it){
                is NurseMypageSideEffect.GetNurseMypageSuccess -> {
                    // success
                }
                is NurseMypageSideEffect.GetNurseMypageFailure -> {
                    Toast.makeText(context, "네트워크 오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
                }
                else -> {}
            }
        }
    }

    NurseMypageScreen(
        nurseName = state.nurseName,
        onClickLogout = onClickLogout,
        registeredAt = state.registeredAt,
        hospitalName = state.hospitalName,
        department = state.department
    )
    
}

@Composable
fun NurseMypageScreen(
    nurseName: String = "",
    onClickLogout: () -> Unit = {},
    registeredAt: String? = "",
    hospitalName: String = "",
    department: String = ""
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 24.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = nurseName, style = CVTheme.typography.headingPrimary, color = Gray700)
            Text(
                text = "로그아웃",
                style = CVTheme.typography.captionImportance,
                color = Gray500,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Gray100)
                    .padding(5.dp)
                    .clickable { onClickLogout() }
            )
        }

        if(!registeredAt.isNullOrBlank()) {
            Text(text = "${registeredAt} 가입", style = CVTheme.typography.textBody1Medium, color = Gray500, modifier = Modifier.padding(top = 4.dp))
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(color = Primary600)
            .padding(15.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(painter = painterResource(id = R.drawable.ic_hopital_icon), contentDescription = "hospital image")
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = hospitalName, style = CVTheme.typography.textBody1Importance, color = White)
                    Text(text = department, style = CVTheme.typography.textBody2Medium, color = White)
                }
            }
        }
    }
}

@Composable
@Preview
fun MypageScreenPreview() {
    CVTheme {
        NurseMypageScreen(
            nurseName = "김유진",
            registeredAt = "2021.09.01",
            hospitalName = "서울대학교병원",
            department = "내과"
        )
    }
}