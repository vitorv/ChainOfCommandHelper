package com.example.chainofcommandhelper.ui.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.chainofcommandhelper.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    private lateinit var rulesViewModel: RulesViewModel
    private var _binding: FragmentRulesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rulesViewModel =
            ViewModelProvider(this).get(RulesViewModel::class.java)

        _binding = FragmentRulesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRules
        rulesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}