package com.example.introductiontoroom

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.introductiontoroom.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), AddEditPersonFragment.AddEditPersonListener {

    private lateinit var binding : ActivityMainBinding
    private var dao : PersonDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intVars()
        attachUiListener()
    }



    private fun intVars() {
        dao = AppDatabase.getDatabase(this).personDao()
    }

    private fun attachUiListener() {
        binding.floatingActionButton.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        val bottomSheet = AddEditPersonFragment(this)
        bottomSheet.show(supportFragmentManager, AddEditPersonFragment.TAG)
    }

    override fun onSaveBtnClicked(person: Person) {

        lifecycleScope.launch(Dispatchers.IO) {
            dao?.savePerson(person)
        }
    }
}