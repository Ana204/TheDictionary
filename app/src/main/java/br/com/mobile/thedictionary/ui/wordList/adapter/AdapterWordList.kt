package br.com.mobile.thedictionary.ui.wordList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.thedictionary.databinding.WordListItemBinding
import br.com.mobile.thedictionary.model.WordListModel

class AdapterWordList(
    private val context: Context,
    private val mWordList: MutableList<WordListModel>
) : RecyclerView.Adapter<AdapterWordList.ViewHolderWordList>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderWordList {
        val inflater = WordListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolderWordList(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolderWordList, position: Int) {
       val itemsViewModel = mWordList[position]
        holder.textViewWord.text = itemsViewModel.name
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }


    class ViewHolderWordList(binding: WordListItemBinding): RecyclerView.ViewHolder(binding.root){
        val textViewWord = binding.word
    }

}