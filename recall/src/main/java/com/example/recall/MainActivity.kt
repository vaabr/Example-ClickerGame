package com.example.recall

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment
import com.example.recall.Functions.loadLong
import com.example.recall.Functions.sPref
import com.example.recall.Functions.saveData
import com.example.recall.Money.format
import com.example.recall.cars.CarsFragment
import com.example.recall.fitness.FitnessFragment
import com.example.recall.food.FoodFragment
import com.example.recall.locations.LocationsFragment
import com.example.recall.main.MainFragment
import com.example.recall.shop.ShopFragment
import com.example.recall.work.WorkFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var money: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setFragment(MainFragment())
        ib_main.setOnClickListener(this)
        ib_work.setOnClickListener(this)
        ib_food.setOnClickListener(this)
        ib_shop.setOnClickListener(this)
        ib_fitness.setOnClickListener(this)
        ib_cars.setOnClickListener(this)
        ib_locations.setOnClickListener(this)
        sPref = getPreferences(Context.MODE_PRIVATE)
        money = loadLong("money")
        updateCounters()

    }

    override fun onClick(v: View?) {
        updateCounters()
        if (v is ImageButton) buttonEffect(v)
        when (v) {
            ib_main -> setFragment(MainFragment())
            ib_work -> setFragment(WorkFragment())
            ib_food -> setFragment(FoodFragment())
            ib_shop -> setFragment(ShopFragment())
            ib_fitness -> setFragment(FitnessFragment())
            ib_cars -> setFragment(CarsFragment())
            ib_locations -> setFragment(LocationsFragment())
        }
    }

    fun increaseMoney(sum: Long) {
        money += sum
        updateCounters()
    }

    private fun updateCounters() {
        tv_money.text = format(money)
        saveData("money", money)
    }

    private fun buttonEffect(button: ImageButton) {
        val buttonsArray = arrayOf(ib_main, ib_work, ib_food, ib_shop, ib_fitness, ib_cars, ib_locations)
        for (x in 0 until buttonsArray.size) {
            buttonsArray[x].setBackgroundColor(getColor(R.color.colorBackgroundDark))
            ImageViewCompat.setImageTintList(
                buttonsArray[x],
                ColorStateList.valueOf(getColor(R.color.colorBackgroundLight))
            )
        }
        button.setBackgroundColor(getColor(R.color.colorBackgroundLight))
        ImageViewCompat.setImageTintList(button, ColorStateList.valueOf(getColor(R.color.colorBackgroundDark)))
    }

    private fun setFragment(fragment: Fragment) {
        val fTrans = supportFragmentManager.beginTransaction()
        fTrans.replace(R.id.fl_container, fragment)
        fTrans.commit()
    }

    override fun onPause() {
        super.onPause()
        saveData("money", money)
    }
}
