    package com.example.nvest11.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nvest11.Data.Ecommodel
import com.example.nvest11.R
import kotlinx.android.synthetic.main.product_list_row.view.*

    class ProdcutAdapter(val activity: Activity): RecyclerView.Adapter<ProdcutAdapter.MyViewHolder>() {

    private var productList: List<Ecommodel>? = null


    fun setCountryList(productList: List<Ecommodel>?) {
        this.productList = productList
    }



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdcutAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_row, parent, false)

        return MyViewHolder(view)
    }

    public fun filterList(filterList: Ecommodel) {

       var productList =filterList
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: ProdcutAdapter.MyViewHolder, position: Int) {
        holder.bind(productList?.get(position)!!, activity)
    }

    override fun getItemCount(): Int {
        if(productList == null)return 0
        else return productList?.size!!
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val id = view.id_vw
        val title = view.title_vw
        val price = view.price_vw
        val description = view.description_vw
        val categoryvw = view.category_vw
        val pimg_vw1=view.pimg_vw
        val rate=view.rate_vw
//        val count=view.count_vw

//        val avatar_vw=view.avatar_vw


        fun bind(data: Ecommodel, activity: Activity) {
            id.text = "id: "+data.id
            title.text = "Title: "+data.title
            price.text = "Price: "+data.price
            description.text = "Description: "+data.description
            categoryvw.text = "Category: "+data.category
            rate.text = " "+data.rating
//            count.text = "Count: "+data.rating


//            GlideToVectorYou.justLoadImage(activity, Uri.parse(data.image), pimg_vw1)
            Glide.with(activity).load(data.image).centerCrop().into(pimg_vw1)
//            Glide.with(activity)
//                .load(imageList[index].imageUrl)
//                .override(width,height)
//                .into("your image view")
        }
    }}
