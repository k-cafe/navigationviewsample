package com.example.kohi.navigationview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var checkedItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setUpNavigationView()
    }

    override fun onResume() {
        super.onResume()

        checkedItem?.isChecked = false
    }

    private fun setUpNavigationView() {

        navigationView.setNavigationItemSelectedListener{
            when(it.itemId){
                // call fragment
                R.id.menu_home -> trySomething()
                R.id.menu_1 -> trySomething()
                R.id.menu_2 -> trySomething()
                // call activity
                R.id.menu_3 -> startActivity(Intent(this, SomethingActivity::class.java))
                R.id.menu_4 -> startActivity(Intent(this, SomethingActivity::class.java))
            }
            if(checkedItem != null) checkedItem?.isChecked = false
            it.isChecked = true
            checkedItem = it
            true
        }
    }

    // call fragment
    private fun trySomething() {}

}
