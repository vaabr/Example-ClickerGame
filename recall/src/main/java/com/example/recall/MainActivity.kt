package com.example.recall

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.recall.Functions.sPref
import com.example.recall.Money.format
import com.example.recall.Money.increase
import com.example.recall.cars.CarsFragment
import com.example.recall.fitness.FitnessFragment
import com.example.recall.food.FoodFragment
import com.example.recall.locations.LocationsFragment
import com.example.recall.main.MainFragment
import com.example.recall.settings.SettingsFragment
import com.example.recall.shop.ShopFragment
import com.example.recall.work.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fManager = supportFragmentManager
    private val lastFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setLastFragment()  // set starting fragment - in future will set last opened fragment instead of Main
        initializeOnClickListeners()
        ib_main.performClick()
        sPref = getPreferences(Context.MODE_PRIVATE) // TODO - use room instead of SP
        Money.load()
        updateCounters() // TODO - add react to the money variable changes
    }

    private fun initializeOnClickListeners() {
        ib_main.setOnClickListener { menuButton(MainFragment(), it) }
        ib_work.setOnClickListener { menuButton(WorkFragment(), it) }
        ib_food.setOnClickListener { menuButton(FoodFragment(), it) }
        ib_shop.setOnClickListener { menuButton(ShopFragment(), it) }
        ib_fitness.setOnClickListener { menuButton(FitnessFragment(), it) }
        ib_cars.setOnClickListener { menuButton(CarsFragment(), it) }
        ib_locations.setOnClickListener { menuButton(LocationsFragment(), it) }
        ib_settings.setOnClickListener { menuButton(SettingsFragment(), it) }
    }

    private fun menuButton(fragment: Fragment, button: View) {
        buttonEffect(button)
        setFragment(fragment)
    }

    private fun setLastFragment() {
        setFragment(lastFragment) // TODO - return last displayed fragment instead of Main
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
        tv_money.text = format()
    }

    private fun buttonEffect(button: View) {
        val buttonsArray = arrayOf(ib_main, ib_work, ib_food, ib_shop, ib_fitness, ib_cars, ib_locations, ib_settings)
        for (x in 0 until buttonsArray.size) {
            buttonsArray[x].setBackgroundColor(getColor(R.color.colorBackgroundDark))
            ImageViewCompat.setImageTintList(
                buttonsArray[x],
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
        fManager.beginTransaction()
        .replace(R.id.fl_container, fragment)
        .commit()
    }

    override fun onPause() {
        super.onPause()
        Money.save()
    }
}
