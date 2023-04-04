package com.waire.cdetect.android.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.waire.cdetect.android.ui.theme.Waire
import com.waire.cdetect.android.ui.theme.grid_1
import com.waire.cdetect.android.ui.theme.grid_2
import com.waire.cdetect.android.ui.theme.grid_4
import com.waire.cdetect.android.ui.theme.grid_5

@Composable
fun VitalView(
    vitalValue: String,
    vitalLabel: String,
    vitalIcon: ImageVector,
    vitalUnit: String
) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(vertical = grid_2, horizontal = grid_4)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = grid_1,
        shape = RoundedCornerShape(grid_5)
    ) {
        Row(
            Modifier.padding(grid_4),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = vitalIcon,
                contentDescription = "",
                modifier = Modifier.padding(end = grid_4),
                tint = Waire
            )
            Text(text = vitalLabel, fontSize = 13.sp, textAlign = TextAlign.Center)
            Spacer(Modifier.weight(1f))
            Text(text = vitalValue, style = TextStyle(color = Color.Black))
            Text(text = vitalUnit, fontSize = 13.sp, textAlign = TextAlign.Center)
        }
    }
}

//@Composable
//fun VitalIcon(
//    vitalValue: String,
//    vitalLabel: String,
//    vitalIcon: ImageVector
//) {
//    Column {
//        Modifier
//            .padding(16.dp)
//            .drawBehind {
//                drawCircle(
//                    color = Color.Transparent,
//                    radius = this.size.maxDimension
//                )
//            }
//        Text(
//            modifier = Modifier,
//            text = vitalValue,
//            style = TextStyle(color = Color.Black)
//        )
//        Row {
//          Text(text = vitalLabel)
//          Icon(imageVector = vitalIcon, contentDescription = "")
//        }
//    }
//    Text(
//        modifier = Modifier
//            .padding(16.dp)
//            .drawBehind {
//                drawCircle(
//                    color = Color.Transparent,
//                    radius = this.size.maxDimension
//                )
//            },
//        text = vitalValue,
//        style = TextStyle(color = Color.Black)
//    )
//}
