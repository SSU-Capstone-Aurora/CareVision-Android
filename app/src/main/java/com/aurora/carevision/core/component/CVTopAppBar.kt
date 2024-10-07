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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.R
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White

@Composable
fun TopAppBarBackLeft(
    title: String,
    LeftBackIcon: Int = R.drawable.ic_topappbar_leftbutton_24,
    onBackClick: () -> Unit = {}
) {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            //contentAlignment = Alignment.Center,
            //horizontalArrangement = Arrangement.SpaceBetween
        ){
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(id = LeftBackIcon),
                    contentDescription = "LeftBack Icon",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(end = 12.dp)
                )
            }
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) // 이 친구를 상하로도 가운데 배치시키고 싶습니다 ->12.dp말고 가운데.. 어떻게 하나요ㅠ
        }
    }
}

@Composable
fun TopAppBarBackRight(
    title: String,
    RightBackIcon: Int = R.drawable.ic_topappbar_rightbutton_24,
    onBackClick: () -> Unit = {}
) {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ){
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = RightBackIcon),
                    contentDescription = "RightBack Icon",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(start = 12.dp)
                )
            }

        }

    }
}


@Composable
fun TopAppBarNoBack( // 이 친구는 이번엔 밑에 붙어있네요..
    title: String,
) {
    Row {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)

        ){
            Text(
                text = title,
                color = Color.Black,
                style = CVTheme.typography.textBody1Importance,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )

        }

    }
}

@Preview
@Composable
fun PreviewCenteredTitleTopAppBar() {
    CVTheme {
        Column(
            modifier = Modifier.background(White),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopAppBarBackLeft(
                title = "Header",
                onBackClick = { /* Handle back click */ }
            )
          TopAppBarBackRight(
              title = "Header",
              onBackClick = {}
          )
          TopAppBarNoBack(
              title = "Header",
          )
        }
    }
}