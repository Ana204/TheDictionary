package br.com.mobile.thedictionary.ui.historic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mobile.thedictionary.databinding.HistoricWordListItemBinding
import br.com.mobile.thedictionary.model.HistoricListModel

class AdapterHistoricList(
    private val context: Context,
    private val onClickListener: OnClickListener,
    private val mHistoricList: MutableList<HistoricListModel>
): RecyclerView.Adapter<AdapterHistoricList.ViewHolderHistoricList>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHistoricList {
        val inflater = HistoricWordListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolderHistoricList(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolderHistoricList, position: Int) {
        val itemsListViewModel = mHistoricList[position]
        holder.textViewHistoric.text = itemsListViewModel.wordName

        holder.cardViewHistoric.setOnClickListener {
            onClickListener.onClick(itemsListViewModel)
        }
    }

    override fun getItemCount(): Int {
       return mHistoricList.size
    }

    class ViewHolderHistoricList(binding: HistoricWordListItemBinding): RecyclerView.ViewHolder(binding.root){
        val textViewHistoric = binding.wordHistoric
        val cardViewHistoric = binding.cardViewToWordHistoric
    }

    class OnClickListener(val clickListener: (historicList: HistoricListModel) -> Unit){
        fun onClick(historicList: HistoricListModel) = clickListener(historicList)
    }
}