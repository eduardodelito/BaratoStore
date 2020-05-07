package com.enaz.baratostore.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import androidx.lifecycle.Observer
import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.common.util.setViewWithVisibility
import com.enaz.baratostore.profile.databinding.ProfileFragmentBinding
import kotlinx.android.synthetic.main.profile_fragment.*
import java.io.ByteArrayOutputStream
import javax.inject.Inject

class ProfileFragment : BaseFragment<ProfileFragmentBinding, ProfileViewModel>() {

    private lateinit var imageUri : Uri
    private val REQUEST_IMAGE_CAPTURE = 100

    @Inject
    override lateinit var viewModel: ProfileViewModel

    override fun createLayout() = R.layout.profile_fragment

    override fun getBindingVariable() = BR.profileViewModel

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        logout_btn.setOnClickListener { viewModel.signOut() }
        profile_avatar.setOnClickListener {
            takePicture()
        }
    }

    override fun subscribeUi() {
       with(viewModel) {
           isUploading().observe(viewLifecycleOwner, Observer {
               profile_avatar_progress.setViewWithVisibility(it)
           })

           imageUri().observe(viewLifecycleOwner, Observer { imageUri ->
                profile_avatar.setImageURI(imageUri, context)
           })
       }
    }

    private fun takePicture() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { pictureIntent ->
            activity?.packageManager?.let { pictureIntent.resolveActivity(it) }.also {
                startActivityForResult(pictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            viewModel.uploadImageAndSaveUri(imageBitmap)
        }
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}