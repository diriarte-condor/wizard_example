package com.davidsantiagoiriarte.wizardexample

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var mFragmentCardAdapter: CardFragmentPagerAdapter


    private lateinit var mFragmentCardShadowTransformer: ShadowTransformer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFragmentCardAdapter = CardFragmentPagerAdapter(supportFragmentManager,
                dpToPixels(2, this))
        mFragmentCardShadowTransformer = ShadowTransformer(viewPager, mainScroll, mFragmentCardAdapter)
        viewPager.adapter = mFragmentCardAdapter
        viewPager.setPageTransformer(false, mFragmentCardShadowTransformer)
        viewPager.offscreenPageLimit = 3
        mFragmentCardShadowTransformer.enableScaling(false)


    }


    fun dpToPixels(dp: Int, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }
}
