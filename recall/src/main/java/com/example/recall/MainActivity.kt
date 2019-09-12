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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        L.s()
        super.onCreate(savedInstanceState)
        bindingInitialization()
        GlobalScope.launch {
            sPref = getPreferences(Context.MODE_PRIVATE) // TODO - use room instead of SP
            Money.load()
            updateCounters() // TODO - add react to the money variable changes
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
            ibMain.performClick()
        }
    }

    private fun menuButton(fragment: Fragment, button: View) {
        buttonEffect(button)
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
        binding.tvMoney.text = format()
    }

    private fun buttonEffect(button: View) {
        val buttonsArray = arrayOf(
            ib_main,
            ib_work,
            ib_food,
            ib_shop,
            ib_fitness,
            ib_cars,
            ib_locations,
            ib_settings
        )
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
