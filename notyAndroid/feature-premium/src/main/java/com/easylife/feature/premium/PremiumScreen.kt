package com.easylife.feature.premium

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.easylife.noty.core.designsystem.base.BaseScreen
import com.easylife.noty.core.designsystem.theme.darkGray
import com.easylife.noty.core.designsystem.theme.gold
import com.easylife.noty.core.designsystem.theme.gray
import com.easylife.noty.core.designsystem.theme.green
import com.easylife.noty.core.designsystem.theme.red
import com.easylife.noty.core.designsystem.theme.white
import com.easylife.noty.feature.premium.R

/**
 * Created by erenalpaslan on 11.02.2023
 */
class PremiumScreen : BaseScreen<PremiumViewModel>() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    override fun Screen() {
        val scrollableState = rememberScrollState()

        Scaffold() { paddingValues ->
            Box(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollableState)
            ) {
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {

                    val (topImageRef, titleRef, contentRef, productRefs, continueButtonRef, restoreRef) = createRefs()

                    Image(
                        painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.bg_success),
                        contentDescription = "",
                        modifier = Modifier.constrainAs(topImageRef) {
                            top.linkTo(parent.top, 24.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.constrainAs(titleRef) {
                            top.linkTo(topImageRef.bottom, 8.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                        }
                    ) {
                        Text(
                            text = "Get unlimited access to",
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "all Premium Features",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = gold
                        )
                    }
                    Column(modifier = Modifier.constrainAs(contentRef) {
                        top.linkTo(titleRef.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }) {
                        FeatureItem(
                            title = "Recurring reminders",
                            description = "Set up recurring reminders for your notes and never miss an important deadline or task again."
                        )
                        FeatureItem(
                            title = "Cloud Sync",
                            description = "Sync your notes across all your devices and access them anywhere, anytime with Cloud Sync."
                        )
                        FeatureItem(
                            title = "No ADS",
                            description = "Enjoy an ad-free experience and focus on what's important with premium access to the note app without any interruptions."
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    Row(
                        modifier = Modifier.constrainAs(productRefs) {
                            top.linkTo(contentRef.bottom, 8.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        },
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        ProductItem(
                            modifier = Modifier.weight(1f),
                            title = "Week",
                            price = "0.99$",
                            saveTotal = null
                        )
                        ProductItem(
                            modifier = Modifier.weight(1f),
                            title = "Month",
                            price = "1.99$",
                            saveTotal = "SAVE 22%"
                        )
                        ProductItem(
                            modifier = Modifier.weight(1f),
                            title = "Year",
                            price = "22,50$",
                            saveTotal = "SAVE 44%"
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.constrainAs(continueButtonRef) {
                            top.linkTo(productRefs.bottom, 8.dp)
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)
                            width = Dimension.fillToConstraints
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = gold,
                            contentColor = white
                        )
                    ) {
                        Text(text = "Continue")
                    }

                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.constrainAs(restoreRef) {
                            top.linkTo(continueButtonRef.bottom)
                            start.linkTo(parent.start, 16.dp)
                            end.linkTo(parent.end, 16.dp)
                            width = Dimension.fillToConstraints
                        }
                    ) {
                        Text(text = "Restore purchase")
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureItem(
    title: String,
    description: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .border(1.dp, darkGray, RoundedCornerShape(8.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            painter = painterResource(id = com.easylife.noty.core.designsystem.R.drawable.ic_tick_circle),
            contentDescription = "tick",
            tint = green
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall
            )
        }
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    saveTotal: String?
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(1.dp, gray, RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .background(
                    if (!saveTotal.isNullOrEmpty())
                        gold
                    else
                        Color.Transparent
                )
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp)),
            contentAlignment = Alignment.Center
        ) {
            if (!saveTotal.isNullOrEmpty()) {
                Text(text = saveTotal)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "1",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = gray
            )
            Text(
                text = price,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }

}