package com.example.retrofit.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.adapters.HomeAdapter
import com.example.retrofit.classes.UnSplashUsers
import com.example.retrofit.databinding.FragmentIsBinding
import com.example.retrofit.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class IsFragment : Fragment() {

    lateinit var fraging: FragmentIsBinding
    lateinit var homervc: HomeAdapter
    private var queryType = "Technology"

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        fraging = FragmentIsBinding.inflate(inflater, container, false)
        fraging.apply {
            homervc = HomeAdapter(requireContext(), object : HomeAdapter.onItemClicked {
                override fun onCliked(url: String, position: Int) {
                    var bundle = Bundle()
                    bundle.putString(ARG_PARAM1, url)
                    findNavController().navigate(R.id.info2, bundle)
                }
            })
            fraging.rvc.adapter = homervc

            ApiClient.apiService(requireContext())
                .getUnSplashData(param1.toString(), 30)
                .enqueue(object : Callback<UnSplashUsers> {
                    override fun onResponse(
                        call: Call<UnSplashUsers>,
                        response: Response<UnSplashUsers>,
                    ) {
                        if (response.isSuccessful) {
                            homervc.submitList(response.body()?.results)
                        }
                    }

                    override fun onFailure(call: Call<UnSplashUsers>, t: Throwable) {
                    }
                })
        }
        return fraging.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            IsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}

