package com.example.recall

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recall.Functions.sPref
import com.example.recall.Stats.formatHappiness
import com.example.recall.Stats.formatHealth
import com.example.recall.Stats.formatHunger
import com.example.recall.Stats.formatRent
import com.example.recall.fragments.cars.CarsFragment
import com.example.recall.databinding.ActivityMainBinding
import com.example.recall.fragments.fitness.FitnessFragment
import com.example.recall.fragments.food.FoodFragment
import com.example.recall.fragments.apartments.ApartmentsFragment
import com.example.recall.fragments.main.MainFragment
import com.example.recall.money.Money
import com.example.recall.money.Money.format
import com.example.recall.money.Money.increase
import com.example.recall.fragments.settings.SettingsFragment
import com.example.recall.fragments.shop.ShopFragment
import com.example.recall.fragments.work.WorkFragment
import com.example.recall.log.L
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

const val KEY_LASTCLICKED = "key_lastClicked"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var lastClicked: ImageButton
    private var lastClickedID = 0
    private lateinit var buttonsArray: Array<ImageButton>

    override fun onCreate(savedInstanceState: Bundle?) {
        L.s()
        super.onCreate(savedInstanceState)
        lastClickedID = savedInstanceState?.getInt(KEY_LASTCLICKED, 0) ?: 0
        bindingInitialization()
        GlobalScope.launch {
            sPref = getPreferences(Context.MODE_PRIVATE)
            Money.load()
            updateCounters()
        }
    }

    private fun bindingInitialization() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            ibMain.setOnClickListener { menuButton(MainFragment(), it) }
            ibWork.setOnClickListener { menuButton(WorkFragment(), it) }
            ibFood.setOnClickListener { menuButton(FoodFragment(), it) }
            ibShop.setOnClickListener { menuButton(ShopFragment(), it) }
            ibFitness.setOnClickListener { menuButton(FitnessFragment(), it) }
            ibCars.setOnClickListener { menuButton(CarsFragment(), it) }
            ibLocations.setOnClickListener { menuButton(ApartmentsFragment(), it) }
            ibSettings.setOnClickListener { menuButton(SettingsFragment(), it) }
        }
        buttonsArray = arrayOf(
            binding.ibMain,
            binding.ibWork,
            binding.ibFood,
            binding.ibShop,
            binding.ibFitness,
            binding.ibCars,
            binding.ibLocations,
            binding.ibSettings
        )
        buttonsArray[lastClickedID].performClick()

    }

    private fun menuButton(fragment: Fragment, button: View) {
        if (button is ImageButton) lastClicked = button
        buttonEffect(button)
        if (button == binding.ibSettings) binding.statsBar.visibility =
            View.GONE else binding.statsBar.visibility = View.VISIBLE
        setFragment(fragment)
    }

    fun increaseMoney(sum: Int) {
        increase(sum)
        updateCounters()
    }

    fun resetMoney() {
        Money.set(0)
        updateCounters()
    }

    private fun updateCounters() {
        binding.apply {
            tvMoney.text = format()
            tvHappiness.text = formatHappiness()
            tvHealth.text = formatHealth()
            tvHunger.text = formatHunger()
            tvRent.text = formatRent()
        }
    }

    private fun buttonEffect(button: View) {
        buttonsArray.forEach {
            it.setBackgroundColor(getColor(R.color.colorBackgroundDark))
            ImageViewCompat.setImageTintList(
                it,
                ColorStateList.valueOf(getColor(R.color.colorBackgroundLight))
            )
        }
        button.setBackgroundColor(getColor(R.color.colorBackgroundLight))
        ImageViewCompat.setImageTintList(
            button as ImageButton,
            ColorStateList.valueOf(getColor(R.color.colorBackgroundDark))
        )
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        L.s()
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_LASTCLICKED, buttonsArray.find { it == lastClicked }?.id ?: 0)
    }

    override fun onPause() {
        L.s()
        super.onPause()
        Money.save()
    }

    override fun onResume() {
        L.s()
        super.onResume()
    }

    override fun onDestroy() {
        L.s()
        super.onDestroy()
    }

    override fun onStart() {
        L.s()
        super.onStart()
    }

    override fun onStop() {
        L.s()
        super.onStop()
    }

    override fun onRestart() {
        L.s()
        super.onRestart()
    }
}
