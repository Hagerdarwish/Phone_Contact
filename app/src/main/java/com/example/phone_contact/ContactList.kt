package com.example.phone_contact

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_contact.Constants

class ContactList : AppCompatActivity() {
    lateinit var nameTV:EditText
    lateinit var numTV:EditText
    lateinit var describtionTV:EditText
    lateinit var saveBtn:Button
    lateinit var contactRecyclerView:RecyclerView
    lateinit var adabter: ContactAdabter
    val constant =Constants()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        //decration
        nameTV=findViewById(R.id.ETName)
        numTV=findViewById(R.id.ETNumber)
        describtionTV=findViewById(R.id.ETDes)
        saveBtn=findViewById(R.id.BTNSave)
        contactRecyclerView=findViewById(R.id.RVContact)
        //adabter set up
       adabterSetup()
        saveBtn.setOnClickListener{
           saveBTN()

        }

        }
    fun adabterSetup(){
            adabter=ContactAdabter(constant.dataList)
            contactRecyclerView.adapter=adabter
            contactRecyclerView.layoutManager = LinearLayoutManager(this)
        //adabter.onclick=object :ContactAdabter.OnClickItem{
            //override fun onclick(contact: Contact, index: Int) {
             //   Log.e("onclick","click ${index}")
               //val intent=Intent(this@ContactList,DetailsActivity::class.java)

               // startActivity(intent)
            //}



    }
    fun saveBTN(){

        val name=nameTV.text.toString()
        val num=numTV.text.toString()
        val description=describtionTV.text.toString()
        if(name !=  "" && num != ""&& description != ""){
        val addData:Contact=Contact(name,num,description)
        constant.dataList.add(addData)
        adabter.notifyDataSetChanged()
        nameTV.text.clear()
        numTV.text.clear()
        describtionTV.text.clear()}
    }
}