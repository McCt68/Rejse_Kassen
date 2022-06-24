package eu.example.rejsekassen.data

import android.util.Log
import androidx.compose.runtime.Composable
import com.google.firebase.firestore.FirebaseFirestore

// this is my test to make a repository -
// Here i will have data that the viewModel can access
// here i should have methods that can act on the data i provide to them ??

class Repository() {

	val db = FirebaseFirestore.getInstance()

	// Firestore test
	@Composable
	fun CreateCollection(){

		val db = FirebaseFirestore.getInstance()

		// Pass data onto the firestore db, it must be of type hashmap
		val user = hashMapOf(
			"first" to "Michael",
			"last" to "C",
			"Opsparing" to 10000
		)

		// add the user data to the collection
		db.collection("users")
			.add(user)

			.addOnSuccessListener {
				Log.d("FB", "onCreate: ${it.id}")
			}

			.addOnFailureListener {
				Log.d("FB", "onCreate: ${it}")
			}


	}


	// Method for Update fields in document or create if they don't exist
	// It will add or update the fields in the document named tester, with the value's provided -
	// when we call the updateData() function
	fun updateData(name: String, changeHolidaysavingsAmount: Int){
		val updater = db.collection("users").document("tester")
		// updater.update("last", data)
		updater.update("opsparing", changeHolidaysavingsAmount)
		updater.update("navn", name)
	}

	// Change opsparet beløb
	fun updateOpsparetBeløb(newAmount: Int){
		val updater = db.collection("holidaySavings").document("opsparetBeløb")
		updater.update("opsparetBeløb", newAmount)
	}



}