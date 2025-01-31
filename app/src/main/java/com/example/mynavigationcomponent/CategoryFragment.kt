package com.example.mynavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mynavigationcomponent.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object{
        val EXTRA_NAME = "extra_name"
        val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
//        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailCategory.setOnClickListener{ view ->
            // menggunakan bundle()
            /*
            val nBundle = Bundle()
            nBundle.putString(EXTRA_NAME, "Lifestyle")
            nBundle.putLong(EXTRA_DESCRIPTION, 7)
            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, nBundle)
             */

            // menggunakan safeArgs
            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.description = 7
            view.findNavController().navigate(toDetailCategoryFragment)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}