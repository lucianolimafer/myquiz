package com.example.myquiz.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myquiz.Adapter.LeaderAdapter
import com.example.myquiz.Domain.UserModel
import com.example.myquiz.R
import com.example.myquiz.databinding.ActivityLeaderBinding

class LeaderActivity : AppCompatActivity() {
    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window: Window = this@LeaderActivity.window
        window.statusBarColor= ContextCompat.getColor(this@LeaderActivity, R.color.gray)

        binding.apply {
            titleTop1Txt.text = loadData().get(0).name
            scoreTop1Text.text = loadData().get(0).score.toString()
            titleTop2Txt.text = loadData().get(1).name
            scoreTop2Text.text = loadData().get(1).score.toString()
            titleTop3Txt.text = loadData().get(2).name
            scoreTop3Text.text = loadData().get(2).score.toString()

            val drawableResourceIdFirst: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceIdFirst)
                .into(pic1)

            val drawableResourceIdSecond: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceIdSecond)
                .into(pic2)

            val drawableResourceIdThird: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context)
                .load(drawableResourceIdThird)
                .into(pic3)

            bottomMenu.setItemSelected(R.id.ranking)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)

            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }
        }
    }

    //TODO: refactor this to user api service
    private fun loadData(): MutableList<UserModel>{
        val userList: MutableList<UserModel> = mutableListOf()

        userList.add(UserModel(1, "Matthew", "person2", 2345))
        userList.add(UserModel(2, "Robert", "person6", 2345))
        userList.add(UserModel(3, "Tom", "person3", 2345))
        userList.add(UserModel(4, "Jonny", "person9", 2345))
        userList.add(UserModel(5, "Charlie", "person4", 2345))
        userList.add(UserModel(6, "Scarlett", "person5", 2345))
        userList.add(UserModel(7, "Jennifer", "person7", 2345))
        userList.add(UserModel(8, "Anya", "person1", 2345))
        userList.add(UserModel(9, "Jenna", "person8", 2345))

        return userList
    }
}