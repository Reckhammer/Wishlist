package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishList : MutableList<Wish>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wishRV = findViewById<RecyclerView>( R.id.wishRV )
        wishList = mutableListOf()
        val adapter = WishAdapter( wishList )
        wishRV.adapter = adapter
        wishRV.layoutManager = LinearLayoutManager( this )

        findViewById<Button>( R.id.submitBtn ).setOnClickListener {
            val nameInput = findViewById<EditText>( R.id.itemNameInput )
            val priceInput = findViewById<EditText>( R.id.priceInput )
            val linkInput = findViewById<EditText>( R.id.linkInput )

            if ( !isFieldsEmpty() )
            {
                var priceStr = priceInput.getText().toString()
                var wishItem = Wish( nameInput.text.toString(), priceStr.toFloat(), linkInput.text.toString() )

                nameInput.text.clear()
                priceInput.text.clear()
                linkInput.text.clear()

                wishList.add( wishItem )
                adapter.notifyDataSetChanged()
            }
            else
            {
                Toast.makeText( this, "Fields MUST be filled", Toast.LENGTH_SHORT ).show()
            }


        }
    }

    fun isFieldsEmpty() : Boolean
    {
        val nameEmpty = findViewById<EditText>( R.id.itemNameInput ).text.isEmpty()
        val priceEmpty = findViewById<EditText>( R.id.priceInput ).text.isEmpty()
        val linkEmpty = findViewById<EditText>( R.id.linkInput ).text.isEmpty()

        return nameEmpty || priceEmpty || linkEmpty
    }
}