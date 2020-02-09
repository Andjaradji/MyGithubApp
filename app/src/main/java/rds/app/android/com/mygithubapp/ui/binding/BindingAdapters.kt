package rds.app.android.com.mygithubapp.ui.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import rds.app.android.com.mygithubapp.R
import rds.app.android.com.mygithubapp.model.GithubUser
import rds.app.android.com.mygithubapp.ui.user.UserListAdapter

@BindingAdapter("imageUserUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imgView)
    }
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<GithubUser>?) {
    val adapter = recyclerView.adapter as UserListAdapter
    adapter.submitList(data)
}

@BindingAdapter("stringTextView")
fun bindTextView(textView: TextView, text: String?) {
    text?.let {
        textView.text = text
    }
}
