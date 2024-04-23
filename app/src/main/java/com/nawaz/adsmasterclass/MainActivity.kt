package com.nawaz.adsmasterclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.nawaz.adsmasterclass.adsContainer.banner.AdMobBanner
import com.nawaz.adsmasterclass.adsContainer.interstitialAds.interstitialAdsContainer
import com.nawaz.adsmasterclass.adsContainer.rewardedAds.rewardedAds
import com.nawaz.adsmasterclass.ui.theme.AdsMasterClassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this)
        setContent {
            AdsMasterClassTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column {
                        AdMobBanner(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxWidth()
                        )
                        Button(onClick = {
                            interstitialAdsContainer(activity = this@MainActivity)
                        }) {
                            Text(text = "Show Interstitial Ad")
                        }
                        Button(onClick ={ rewardedAds(this@MainActivity)/*TODO*/ }) {
                            Text(text = "Show Rewarded Ads")
                        }
                    }
                }
            }
        }
    }
}

