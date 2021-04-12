package com.example.submission2githubuserapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    @SuppressLint("SetText18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)
        setData()
        viewPagerConfig()
    }

    private fun viewPagerConfig() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            this.title = title
        }
    }

    @SuppressLint("SetTextI18n", "StringFormatInvalid")
    private fun setData() {
        val dataUser = intent.getParcelableExtra<UserData>(EXTRA_DATA)
        if (dataUser != null) {
            dataUser.name?.let { setActionBarTitle(it) }
        }
        if (dataUser != null) {
            detail_name.text = dataUser.name
        }
        if (dataUser != null) {
            detail_username.text = dataUser.username
        }
        if (dataUser != null) {
            detail_company.text = getString(R.string.corp, dataUser.company)
        }
        if (dataUser != null) {
            detail_location.text = getString(R.string.loc, dataUser.location)
        }
        if (dataUser != null) {
            detail_repository.text = getString(R.string.repo, dataUser.repository)
        }
        if (dataUser != null) {
            Glide.with(this)
                .load(dataUser.avatar)
                .into(detail_ava)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_settings) {
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}