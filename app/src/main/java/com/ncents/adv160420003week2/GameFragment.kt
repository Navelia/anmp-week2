package com.ncents.adv160420003week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GameFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if(arguments != null) {
//            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
//            txtTurn.text = "$playerName's Turn"
//        }

        var num1 = 0
        var num2 = 0
        var result = 0
        var score = 0

        arguments?.let{
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"

            num1 = (0..100).shuffled().last()
            num2 = (0..100).shuffled().last()
            result = num1 + num2
            txtQuestion.text = "$num1 + $num2"
        }

        btnSubmit.setOnClickListener {
            var userAnswer = txtAnswer.text.toString().toInt()
            if(userAnswer == result){
                score += 1
                num1 = (0..100).shuffled().last()
                num2 = (0..100).shuffled().last()
                result = num1 + num2
                txtQuestion.text = "$num1 + $num2"
                txtAnswer.setText("")
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            GameFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}