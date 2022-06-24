package eu.example.rejsekassen.screens

import androidx.compose.runtime.*


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailScreenViewModel: ViewModel() {

	// Can call this from the a composable function in the view, to set a textField
	var dname by mutableStateOf("init value")

	// trying another way
	// ViewModel
	private val _name = MutableStateFlow("")
	val name = _name.asStateFlow()

	fun setName(name: String) {
		_name.value = name
	}

	/// TEST HOW TO LIFT IT OVER TO DETAILS SCREEN
	val query = mutableStateOf("Chicken")
	// FUNCTION TO CHANGE ITS VALUE
	fun onQueryNameCHange(query: String){
		this.query.value = query
	}

	// Todo countdown timer
}