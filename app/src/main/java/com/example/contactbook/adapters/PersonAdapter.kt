package com.example.contactbook.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.contactbook.data.model.UserModelItem
import com.example.contactbook.databinding.CardPresentationBinding
import com.example.contactbook.utils.GenerateColor
import com.example.contactbook.utils.GenerateFormatMoney
import java.text.NumberFormat
import java.util.*
import kotlin.random.Random

class PersonAdapter() : RecyclerView.Adapter<PersonAdapter.SearchViewHolder>() {
    private var personList: List<UserModelItem> = emptyList()
    private var getColor = GenerateColor()
    private var getMoneyFormat = GenerateFormatMoney()

    fun setData(list: List<UserModelItem>) {
        personList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding =
            CardPresentationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val binding = holder.binding
        val persons = personList[position]
        binding.txtUserName.text = "User: ${persons.username.toString()}"
        binding.txtName.text =
            "Name: ${persons.firstName} ${persons.lastName}"
        binding.linearTarjeta.setBackgroundColor(Color.parseColor(getColor.invoke()))
        binding.txtSaldoDisponible.text = "Saldo Disponible: ${getMoneyFormat.invoke()}"
        binding.txtNumeroTarjeta.text =
            "Numero de tarjeta: ${persons.creditCard!!.ccNumber.toString()}"
        binding.txtNombreTitular.text = "Titular: ${persons.firstName} ${persons.lastName}"
        Glide.with(holder.itemView.context).load(persons.avatar).into(binding.imgPerson)
    }

    class SearchViewHolder(val binding: CardPresentationBinding) :
        RecyclerView.ViewHolder(binding.root)
}
