package e.aman.catgalleryapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import e.aman.catgalleryapp.ui.theme.CatGalleryAppTheme
import e.aman.catgalleryapp.viewmodel.CatViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatGalleryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatList(viewModel)
                }
            }
        }
    }
}