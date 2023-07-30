package com.example.affirmations

import android.content.Context
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.model.Affirmation
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AffirmationsAdapterTests {

    //unit tests run on the jvm but we will call code that needs context so it's mocked
    private val context  = mock(Context::class.java)

    //test that the size of the adapter is the size of the list that we pass the adapter
    @Test
    fun adapter_size() {

        //create test data
        val testData = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2)
        )

        val testAdapter = ItemAdapter(context, testData)


        assertEquals("Item Adapter has size different from underlying list", 2, testAdapter.itemCount)
    }
}