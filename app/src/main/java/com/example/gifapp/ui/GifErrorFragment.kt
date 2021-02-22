package com.example.gifapp.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gifapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val TAG = "GifErrorFragment"

class GifErrorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gif_error, container, false)
        val tryBtn = view.findViewById(R.id.error_refresh_fab) as FloatingActionButton

        tryBtn.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                val cm: ConnectivityManager =
                    requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val activeNetwork = cm.activeNetwork
                if (activeNetwork != null) {
                    //TODO fix change fragment transaction
                } else {
                    Log.i(TAG, "onCreateView: No internet yet")
                }
            }

        }
        return view
    }
}