package com.aurora.carevision.feature.admin.auth.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aurora.carevision.app.ui.theme.CVTheme
import com.aurora.carevision.app.ui.theme.White
import com.aurora.carevision.core.component.CVLongButton
import com.aurora.carevision.core.component.CVTailIconSearchBar
import com.aurora.carevision.core.component.ReviewDropdownMenu
import com.aurora.carevision.core.component.TopAppBarLeft

@Composable
fun AdminSignInHospitalEntryScreen(){

    var hospitalName by rememberSaveable { mutableStateOf("") }
    var isError by remember{ mutableStateOf(false) }
    var isTyping by remember { mutableStateOf(false) }
    var isFieldVisible by remember { mutableStateOf(false) }
    var selectedItem by rememberSaveable { mutableStateOf("")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(top = 52.dp, start = 24.dp, end = 24.dp),
    ){
        TopAppBarLeft()
        Text(
            text = "환영합니다!\n어디에서 근무 중이신가요?",
            style = CVTheme.typography.headingPrimary,
            color = Color.Black,
            modifier = Modifier
                .padding(top=16.dp, bottom = 24.dp)
        )
        CVTailIconSearchBar(
            value = hospitalName,
            onValueChange = {hospitalName = it},
            placeholder = "병원 이름을 입력하세요",
            onTextChanged = { text ->
                hospitalName = text
                isTyping = text.isNotEmpty() },
            onFocusChanged = { focused ->
                if(!focused) {
                    isTyping = false
                }
            }
        )
//        if(!isTyping){
//            if(isFieldVisible){
//                Spacer(modifier = Modifier.padding(top = 24.dp))
//                val menuItems = listOf("내과", "산부인과", "안과", "정형외과")
//                ReviewDropdownMenu(
//                    menuItems = menuItems,
//                    selectedText = selectedItem,
//                    onMenuItemClick = {department ->
//                        selectedItem = department
//                    }
//                )
//            }
            CVLongButton(
                text = "다음",
                onClick = {isFieldVisible = true},
                enabled = hospitalName.isNotEmpty() && ((isFieldVisible && selectedItem.isNotEmpty()) || (!isFieldVisible)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
            )
        }
    }
//}

@Composable
@Preview
fun AdminSignInScreenPreview(){
    CVTheme{
        Column(
            modifier = Modifier
                .background(White)
                .fillMaxSize()
        ){
            AdminSignInHospitalEntryScreen()
        }
    }
}

