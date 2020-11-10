package com.abroliza.navigationcompexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.abroliza.navigationcompexample.R
import kotlinx.android.synthetic.main.fragment_photos.*


/**
 * A simple [Fragment] subclass.
 * Use the [PhotosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_home.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.next_action)
        }
        arguments?.let {
            val numOfPhotos = PhotosFragmentArgs.fromBundle(it).numOfPhotos
            tv_num_photos.text = String.format("Number of Photos %d", numOfPhotos)
        }
    }

}