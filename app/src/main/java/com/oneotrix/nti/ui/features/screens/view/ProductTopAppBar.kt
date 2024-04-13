package com.oneotrix.nti.ui.features.screens.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oneotrix.nti.R


@Composable
fun ProductTopAppBar() {
    val list = listOf("Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши",)
    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TopBarHead()
        TopBarFilters(filters = list)
    }
}
@Preview
@Composable
fun ProductTopAppBarPreview() {
    ProductTopAppBar()
}

@Composable
fun TopBarHead() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter), contentDescription = "filter")
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
            contentDescription = "logo",
            tint = MaterialTheme.colorScheme.primary

        )
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_search), contentDescription = "search")
    }
}
@Preview
@Composable
fun TopBarHeadPreview() {
    TopBarHead()
}

@Composable
fun TopBarFilters(filters: List<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            items(filters) {
                FilterElement(title = it)
            }
        }
    )
}
@Preview
@Composable
fun TopBarFiltersPreview() {
    val list = listOf("Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши","Суши",)
    TopBarFilters(filters = list)
}

@Composable
fun FilterElement(title: String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        selected = selected,
        onClick = { selected = !selected},
        label = { Text(text = title) },
        shape = FilterChipDefaults.shape,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.background,
            labelColor = MaterialTheme.colorScheme.onSurface,
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.background,
        ),
        border = FilterChipDefaults.filterChipBorder(borderWidth = 0.dp, enabled = true, selected = true)
    )
}
@Preview
@Composable
fun FilterElementPreview() {
    FilterElement(title = "Суши")
}