package com.aurora.carevision.core.component

import androidx.compose.foundation.Image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.Black
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White

@Composable
fun TopAppBarLeft(
    title: String = "",
    onBackClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_topappbar_leftbutton_24),
                contentDescription = "LeftBack Icon",
                modifier = Modifier
            )
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()

            )
        }
    }
}

@Composable
fun TopAppBarRight(
    title: String = "",
    //rightBackIcon: Int = R.drawable.ic_topappbar_rightbutton_24,
    onBackClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            ) {
            Image(
                painter = painterResource(id = R.drawable.ic_topappbar_rightbutton_24),
                contentDescription = "RightBack Icon",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            )
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}



@Composable
fun CVTopAppBar( // �� ģ���� �̹��� �ؿ� �پ��ֳ׿�..
    title: String = "",
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun PreviewCenteredTitleTopAppBar() {
    CVTheme {
        Column(
            modifier = Modifier.background(Black),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopAppBarLeft(
                title = "Header",
                onBackClick = { /* Handle back click */ }
            )
          TopAppBarRight(
              title = "Header",
              onBackClick = {}
          )
          CVTopAppBar(
              title = "Header",
          )
        }
    }
}