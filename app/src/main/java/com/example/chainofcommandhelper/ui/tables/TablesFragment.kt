package com.example.chainofcommandhelper.ui.tables

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.chainofcommandhelper.R
import com.example.chainofcommandhelper.databinding.FragmentTablesBinding

class TablesFragment : Fragment() {

    private var _binding: FragmentTablesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTablesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dataset: List<TableModel> = listOf(
            TableModel(R.string.table1, R.drawable.table1),
            TableModel(R.string.table2, R.drawable.table2),
            TableModel(R.string.table3, R.drawable.table3),
            TableModel(R.string.table4, R.drawable.table4a),
            TableModel(R.string.table5, R.drawable.table4b),
            TableModel(R.string.table6, R.drawable.table5),
            TableModel(R.string.table7, R.drawable.table6),
            TableModel(R.string.table8, R.drawable.table7a),
            TableModel(R.string.table9, R.drawable.table7b),
            TableModel(R.string.table10, R.drawable.table7c),
            TableModel(R.string.table11, R.drawable.table8),
            TableModel(R.string.table12, R.drawable.table9),
            TableModel(R.string.table13, R.drawable.table10),
            TableModel(R.string.table14, R.drawable.table11),
            TableModel(R.string.table15, R.drawable.table12a),
            TableModel(R.string.table16, R.drawable.table12b),
            TableModel(R.string.table17, R.drawable.table13a),
            TableModel(R.string.table18, R.drawable.table13b),
            TableModel(R.string.table19, R.drawable.table14),
            TableModel(R.string.table20, R.drawable.table15),
            TableModel(R.string.table21, R.drawable.table16),
            TableModel(R.string.table22, R.drawable.table17),
            TableModel(R.string.table23, R.drawable.tableduplexdrivetanks),
            TableModel(R.string.table24, R.drawable.tablescenariogeneration),
        )

        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(requireContext(), dataset)
        recyclerView.setHasFixedSize(true)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}