package eu.example.rejsekassen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.TextFieldValue
import eu.example.rejsekassen.data.Repository
import eu.example.rejsekassen.screens.DetailScreenViewModel

@Composable
fun DetailsScreen(viewModel: DetailScreenViewModel) {

	var beløb_2 = remember {
		mutableStateOf(TextFieldValue("100"))
	}

	val name = viewModel.name.collectAsState()


	// firestore test
	val myFirestoreInstance = Repository()
	myFirestoreInstance.CreateCollection()
	var beløb_3 = myFirestoreInstance.updateData("Hansen", changeHolidaysavingsAmount = 1000)

	Surface(modifier = Modifier.fillMaxSize()) {


		Column() {
			Text(text = "Details screen")

			// NEW TEST QUERY - CHICKEN
			val query = viewModel.query.value
			TextField(
				value = query,
				onValueChange = { newValue ->
					viewModel.onQueryNameCHange(query = newValue)}
			)

			// Getting the value dname from DetailScreenViewModel
			TextField(
				value = viewModel.dname,
				onValueChange = { viewModel.dname = it }
			)

			TextField(
				value = beløb_2.value,
				onValueChange = { beløb_2.value = it })

			// val name = viewModel.name.collectAsState()
			TextField(
				value = name.value,
				onValueChange = viewModel::setName
			)

			// TODO
			// show coundown timer - get from viewModel

		}

	}

}