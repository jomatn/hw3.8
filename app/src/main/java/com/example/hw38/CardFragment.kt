package com.example.hw38

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hw38.databinding.FragmentCardBinding
import com.example.hw38.databinding.FragmentCardBinding.inflate


class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding
    private lateinit var adapter: CardAdapter
    private lateinit var rvCard: RecyclerView

    private val cardList = arrayListOf(
        Card("", "", ""),
        Card("", "", ""),
        Card("", "", ""),
        Card("", "", ""),
        Card("", "", ""),
        Card("", "", ""),

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
        rvCard = binding.rvCards

        rvCard.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_cardFragment_to_resultFragment)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CardAdapter(cardList)
        binding.rvCards.adapter = adapter
        binding.rvCards.layoutManager = GridLayoutManager(requireContext(), 1)
    }
}

