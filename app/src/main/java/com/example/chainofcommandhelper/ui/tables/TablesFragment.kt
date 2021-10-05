package com.example.chainofcommandhelper.ui.tables

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.chainofcommandhelper.R
import com.example.chainofcommandhelper.databinding.FragmentTablesBinding

class TablesFragment : Fragment() {

    private var _binding: FragmentTablesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var dataset: MutableList<TableModel>
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTablesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val searchView: SearchView = root.findViewById(R.id.tables_search_view)
        searchView.setOnClickListener{
            searchView.isIconified = false
        }

        val recyclerView = root.findViewById<RecyclerView>(R.id.tables_recycler_view)
        dataset = createFullDataset()
        adapter = ItemAdapter(requireContext(), dataset)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(
            object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    hideKeyboard()
                    return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    dataset.clear()
                    if (p0.isNullOrBlank()) {
                        dataset.addAll(createFullDataset())
                    }
                    else {
                        dataset.addAll(createFilteredDataset(p0))
                    }
                    adapter.notifyDataSetChanged()
                    return true
                }
            }
        )

        searchView.setOnCloseListener {
            dataset.clear()
            dataset.addAll(createFullDataset())
            adapter.notifyDataSetChanged()
            hideKeyboard()
            true
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createFilteredDataset(filterStr: String): MutableList<TableModel> {
        val fullDataset = createFullDataset()
        val resultDataset = mutableListOf<TableModel>()

        for(tableModel in fullDataset) {
            if (tableModel.searchableString.contains(filterStr.trim(), true)) {
                resultDataset.add(tableModel)
            }
        }

        return resultDataset
    }

    private fun createFullDataset(): MutableList<TableModel> {
        return mutableListOf(
            TableModel(R.string.table1, R.drawable.table1, getString(R.string.table1)),
            TableModel(R.string.table2, R.drawable.table2, getString(R.string.table2)),
            TableModel(R.string.table3, R.drawable.table3, getString(R.string.table3)),
            TableModel(R.string.table4, R.drawable.table4a, getString(R.string.table4)),
            TableModel(R.string.table5, R.drawable.table4b, getString(R.string.table5)),
            TableModel(R.string.table6, R.drawable.table5, getString(R.string.table6)),
            TableModel(R.string.table7, R.drawable.table6, getString(R.string.table7)),
            TableModel(R.string.table8, R.drawable.table7a, getString(R.string.table8)),
            TableModel(R.string.table9, R.drawable.table7b, getString(R.string.table9)),
            TableModel(R.string.table10, R.drawable.table7c, getString(R.string.table10)),
            TableModel(R.string.table11, R.drawable.table8, getString(R.string.table11)),
            TableModel(R.string.table12, R.drawable.table9, getString(R.string.table12)),
            TableModel(R.string.table13, R.drawable.table10, getString(R.string.table13)),
            TableModel(R.string.table14, R.drawable.table11, getString(R.string.table14)),
            TableModel(R.string.table15, R.drawable.table12a, getString(R.string.table15)),
            TableModel(R.string.table16, R.drawable.table12b, getString(R.string.table16)),
            TableModel(R.string.table17, R.drawable.table13a, getString(R.string.table17)),
            TableModel(R.string.table18, R.drawable.table13b, getString(R.string.table18)),
            TableModel(R.string.table19, R.drawable.table14, getString(R.string.table19)),
            TableModel(R.string.table20, R.drawable.table15, getString(R.string.table20)),
            TableModel(R.string.table21, R.drawable.table16, getString(R.string.table21)),
            TableModel(R.string.table22, R.drawable.table17, getString(R.string.table22)),
            TableModel(R.string.table23, R.drawable.tableduplexdrivetanks,
                getString(R.string.table23)),
            TableModel(R.string.table24, R.drawable.tablescenariogeneration,
                getString(R.string.table24))
        )
    }

    private fun hideKeyboard() {
        val imm: InputMethodManager =
            activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}