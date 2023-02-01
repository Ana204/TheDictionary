package br.com.mobile.thedictionary.ui.favorites.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.thedictionary.databinding.FavoriteWordListItemBinding
import br.com.mobile.thedictionary.model.FavoriteListModel

class AdapterFavoritesList(
    private val context: Context,
    private val onClickListener: OnClickListener,
    private val mFavoriteList: MutableList<FavoriteListModel>
) : RecyclerView.Adapter<AdapterFavoritesList.ViewHolderFavoritesList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavoritesList {
        val inflater =
            FavoriteWordListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolderFavoritesList(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolderFavoritesList, position: Int) {
       val itemsListViewModel = mFavoriteList[position]
        holder.textViewFavorites.text = itemsListViewModel.wordName

        holder.cardViewFavorites.setOnClickListener {
            onClickListener.onCLick(itemsListViewModel)
        }
    }

    override fun getItemCount(): Int {
        return mFavoriteList.size
    }

    class ViewHolderFavoritesList(binding: FavoriteWordListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val textViewFavorites = binding.wordFavorites
        val cardViewFavorites = binding.cardViewToWordFavorites
    }

    class OnClickListener(val clickListener: (favoriteList: FavoriteListModel) -> Unit){
        fun onCLick(favoriteList: FavoriteListModel) = clickListener(favoriteList)
    }
}