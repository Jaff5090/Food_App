package com.example.easyfood.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.easyfood.R
import com.example.easyfood.databinding.ActivityMealBinding
import com.example.easyfood.pojo.Meal
import com.example.easyfood.viewModel.MealViewModel
import com.example.fragments.HomeFragment

class MealActivity : AppCompatActivity() {
    private lateinit var mealId:String
    private lateinit var mealName:String
    private lateinit var mealThumb:String
    private lateinit var binding:ActivityMealBinding

    private lateinit var mealMvvm:MealViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mealMvvm= ViewModelProviders.of(this)[MealViewModel::class.java ]
        getMealInformationFromIntent()

        setInformationIntoView()
        observeMealDetailsLiveData()
    }

    private fun observeMealDetailsLiveData() {
        mealMvvm.observerMealDetails().observe(this,object :Observer<Meal>{
            override fun onChanged(value: Meal) {
                TODO("Not yet implemented")

                val meal =
            }

        })
    }

    private fun setInformationIntoView(){
        Glide.with(applicationContext)
            .load(mealThumb)
            .into(binding.imgMealDetail)

        binding.collapsingToolbar.title = mealName
        binding.collapsingToolbar.setCollapsedTitleTextColor(resources.getColor(R.color.white))
        binding.collapsingToolbar.setExpandedTitleColor(resources.getColor(R.color.white))
    }
    private fun getMealInformationFromIntent() {
        val intent= intent
        mealId = intent.getStringExtra(com.example.fragments.HomeFragment.MEAL_ID)!!
        mealName= intent.getStringExtra(com.example.fragments.HomeFragment.MEAL_NAME)!!
        mealThumb = intent.getStringExtra(com.example.fragments.HomeFragment.MEAL_THUMB)!!


    }
}