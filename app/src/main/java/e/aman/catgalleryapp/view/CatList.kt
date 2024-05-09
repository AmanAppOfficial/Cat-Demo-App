package e.aman.catgalleryapp.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import e.aman.catgalleryapp.viewmodel.CatViewModel


@Composable
fun CatList(viewModel: CatViewModel) {
    // If list is empty show loader
    if (viewModel.catList.size <= 0) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .requiredWidth(50.dp)
                    .requiredHeight(50.dp)
            )
        }
    } else {
        // Different layouts based on orientation.
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT  -> {
                LazyColumn(
                    modifier = Modifier,
                ) {
                    itemsIndexed(viewModel.catList) {_, it ->
                        CatItemPortrait(
                            item = it,
                        )
                    }
                }
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                LazyRow(
                    modifier = Modifier,
                ) {
                    itemsIndexed(viewModel.catList) {_, it ->
                        CatItemLandscape(
                            item = it,
                        )
                    }
                }
            }
        }
    }
}
