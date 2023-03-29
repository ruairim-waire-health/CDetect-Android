package com.waire.cdetect.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.waire.cdetect.android.permissions.PermissionsHandler
import com.waire.cdetect.android.ui.theme.CDetectAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CDetectAndroidTheme {
                PermissionsHandler()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CDetectAndroidTheme {

    }
}