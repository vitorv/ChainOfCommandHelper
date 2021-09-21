package com.example.chainofcommandhelper.ui.rules

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chainofcommandhelper.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    private var _binding: FragmentRulesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRulesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rulesPdfView.fromAsset("ChainOfCommandRules.pdf")
            .password(null) // if password protected, then write password
            .defaultPage(0) // set the default page to open
            .onPageError { page, _ ->
                Toast.makeText(
                    this.context,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}