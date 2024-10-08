package com.aurora.carevision.app.ui.theme

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme()

private val LocalCVTypography = staticCompositionLocalOf<CVTypography> {
    error("No BooTypography provided")
}

/* CVTheme : CareVision Theme
*
* Typo 변경 시 ex. CVTheme.typography.head1
* ex) Text(text = "Example Typo", style = CVTheme.typography.head1)
*/

object CVTheme {
    val typography: CVTypography
        @Composable get() = LocalCVTypography.current
}

@Composable
fun ProvideCVTypography(typography: CVTypography, content: @Composable () -> Unit) {
    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)
    CompositionLocalProvider(
        LocalCVTypography provides provideTypography,
        content = content
    )
}

@Composable
fun CVTheme(
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = LightColorScheme
    val typography = careVisionTypography()

    // set status bar & navigation bar color
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = White.toArgb()
            window.navigationBarColor = White.toArgb()

            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightStatusBars = true
            WindowCompat.getInsetsController(window, view)
                .isAppearanceLightNavigationBars = true
        }
    }

    ProvideCVTypography(typography) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}