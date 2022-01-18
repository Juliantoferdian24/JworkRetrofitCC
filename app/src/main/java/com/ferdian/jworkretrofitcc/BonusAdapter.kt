package com.ferdian.jworkretrofitcc

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ferdian.jworkretrofitcc.databinding.ItemBonusBinding

class BonusAdapter : RecyclerView.Adapter<BonusAdapter.BonusViewHolder>() {
    inner class BonusViewHolder(val binding: ItemBonusBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Bonus>() {
        override fun areItemsTheSame(oldItem: Bonus, newItem: Bonus): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Bonus, newItem: Bonus): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var bonuses: List<Bonus>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BonusViewHolder {
        return BonusViewHolder(
            ItemBonusBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BonusViewHolder, position: Int) {
        holder.binding.apply {
            val bonus = bonuses[position]
            tvBonusName.text = bonus.referralCode
        }
    }

    override fun getItemCount(): Int = bonuses.size
}