package com.aurora.carevision.app.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.aurora.carevision.R

val pretendardBold = FontFamily(Font(R.font.pretendard_bold, FontWeight.Bold))
val pretendardMedium = FontFamily(Font(R.font.pretendard_medium, FontWeight.Medium))
val pretendardSemiBold = FontFamily(Font(R.font.pretendard_semibold, FontWeight.SemiBold))
val pretendardRegular = FontFamily(Font(R.font.pretendard_regular, FontWeight.Normal))


@Stable
class CVTypography internal constructor(
    button: TextStyle,
    headingDisplay: TextStyle,
    headingPrimary: TextStyle,
    headingSecondary: TextStyle,
    textBody1Medium: TextStyle,
    textBody1Importance: TextStyle,
    textBody2Medium: TextStyle,
    textBody2Importance: TextStyle,
    captionRegular: TextStyle,
    captionImportance: TextStyle,
) {
    var button: TextStyle by mutableStateOf(button)
        private set
    var headingDisplay: TextStyle by mutableStateOf(headingDisplay)
        private set
    var headingPrimary: TextStyle by mutableStateOf(headingPrimary)
        private set
    var headingSecondary: TextStyle by mutableStateOf(headingSecondary)
        private set
    var textBody1Medium: TextStyle by mutableStateOf(textBody1Medium)
        private set
    var textBody1Importance: TextStyle by mutableStateOf(textBody1Importance)
        private set
    var textBody2Medium: TextStyle by mutableStateOf(textBody2Medium)
        private set
    var textBody2Importance: TextStyle by mutableStateOf(textBody2Importance)
        private set
    var captionRegular: TextStyle by mutableStateOf(captionRegular)
        private set
    var captionImportance: TextStyle by mutableStateOf(captionImportance)
        private set

    // Used when changing required properties
    fun copy(
        button: TextStyle = this.button,
        headingDisplay: TextStyle = this.headingDisplay,
        headingPrimary: TextStyle = this.headingPrimary,
        headingSecondary: TextStyle = this.headingSecondary,
        textBody1Medium: TextStyle = this.textBody1Medium,
        textBody1Importance: TextStyle = this.textBody1Importance,
        textBody2Medium: TextStyle = this.textBody2Medium,
        textBody2Importance: TextStyle = this.textBody2Importance,
        captionRegular: TextStyle = this.captionRegular,
        captionImportance: TextStyle = this.captionImportance,
    ): CVTypography = CVTypography(
        button,
        headingDisplay,
        headingPrimary,
        headingSecondary,
        textBody1Medium,
        textBody1Importance,
        textBody2Medium,
        textBody2Importance,
        captionRegular,
        captionImportance
    )

    fun update(other: CVTypography) {
        button = other.button
        headingDisplay = other.headingDisplay
        headingPrimary = other.headingPrimary
        headingSecondary = other.headingSecondary
        textBody1Medium = other.textBody1Medium
        textBody1Importance = other.textBody1Importance
        textBody2Medium = other.textBody2Medium
        textBody2Importance = other.textBody2Importance
        captionRegular = other.captionRegular
        captionImportance = other.captionImportance
    }
}

fun careVisionTextStyle(
    fontFamily: FontFamily,
    fontWeight: FontWeight = FontWeight.Normal,
    fontSize: TextUnit,
    lineHeight: TextUnit,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = lineHeight,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

@Composable
fun careVisionTypography(): CVTypography {
    return CVTypography(
        button = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 16.sp,
            lineHeight = 26.sp
        ),
        headingDisplay = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 28.sp,
            lineHeight = 56.sp
        ),
        headingPrimary = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 24.sp,
            lineHeight = 34.sp
        ),
        headingSecondary = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 20.sp,
            lineHeight = 30.sp
        ),
        textBody1Medium = careVisionTextStyle(
            fontFamily = pretendardRegular,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        textBody1Importance = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        textBody2Medium = careVisionTextStyle(
            fontFamily = pretendardRegular,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        textBody2Importance = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        captionRegular = careVisionTextStyle(
            fontFamily = pretendardRegular,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        captionImportance = careVisionTextStyle(
            fontFamily = pretendardBold,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
    )
}