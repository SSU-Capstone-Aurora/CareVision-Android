package com.aurora.carevision.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.Gray300
import com.aurora.carevision.app.ui.theme.Gray700

@Composable
fun VideoNavigationBar(
    videoSavedDateTime: String = "2동 203호 1번 베드",
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(horizontal = 70.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Gray300)
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_topappbar_leftbutton_24), contentDescription = "Back", modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp))

        Text(text = videoSavedDateTime, style = CVTheme.typography.textBody2Medium, color = Gray700)

        Icon(painter = painterResource(id = R.drawable.ic_topappbar_rightbutton_24), contentDescription = "Next", modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp))
    }

}

@Composable
@Preview
fun VideoNavigationBarPreview() {
    CVTheme {
        VideoNavigationBar()
    }
}