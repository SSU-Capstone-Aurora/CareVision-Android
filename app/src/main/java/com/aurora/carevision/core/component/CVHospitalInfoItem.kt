package com.aurora.carevision.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray100
import com.aurora.carevision.app.ui.theme.Gray500
import com.aurora.carevision.app.ui.theme.White

@Composable
fun AdminHospitalListItem(
    hospitalName: String,
    hospitalDepartment: String,
    modifier: Modifier = Modifier,
    onDeleteClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 12.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_hopital_icon),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .background(White)
                .size(72.dp)
                .padding(top = 12.dp, bottom = 12.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
                .padding(end = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = hospitalName,
                style = CVTheme.typography.textBody1Importance,
                color = Color.Black,
                modifier = Modifier.padding(start = 12.dp)
            )

            Text(
                text = hospitalDepartment,
                style = CVTheme.typography.captionImportance,
                color = Gray500,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Box() {
            Button(
                onClick = {},
                modifier = Modifier
                    .width(76.dp)
                    .height(24.dp)
                    .padding(end = 12.dp),

                colors = ButtonDefaults.buttonColors(Gray100),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(0.dp)
            ){
                Text(text = "로그아웃",
                    fontSize = 10.sp,
                    color = Gray500,
                    modifier= Modifier.padding(0.dp)

                )
            }
        }
    }
}

@Preview
@Composable
fun HospitalInfoItemPreview() {
    CVTheme {
        Column(
            modifier = Modifier.background(Black),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            AdminHospitalListItem(
                hospitalName = "서울대병원",
                hospitalDepartment = "정형외과"

            )
        }

    }
}