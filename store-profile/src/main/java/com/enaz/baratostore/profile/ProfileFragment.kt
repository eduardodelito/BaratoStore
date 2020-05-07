package com.enaz.baratostore.profile

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.lifecycle.Observer
import com.enaz.baratostore.common.fragment.BaseFragment
import com.enaz.baratostore.common.util.setViewWithVisibility
import com.enaz.baratostore.profile.databinding.ProfileFragmentBinding
import com.facebook.drawee.drawable.ScalingUtils
import kotlinx.android.synthetic.main.profile_fragment.*
import javax.inject.Inject


class ProfileFragment : BaseFragment<ProfileFragmentBinding, ProfileViewModel>() {

    private val REQUEST_IMAGE_CAPTURE = 100

    @Inject
    override lateinit var viewModel: ProfileViewModel

    override fun createLayout() = R.layout.profile_fragment

    override fun getBindingVariable() = BR.profileViewModel

    override fun initData() {
        //TODO: Do nothing as of the moment
    }

    override fun initViews() {
        logout_btn.setOnClickListener {
            viewModel.signOut()
            resetProfileViews()
        }
        profile_avatar.setOnClickListener {
            takePicture()
        }
    }

    override fun subscribeUi() {
        with(viewModel) {
            imageUri().observe(viewLifecycleOwner, Observer { imageUri ->
                if (imageUri != null) profile_avatar.setImageURI(imageUri, context)
            })

            loadProfilePicture()
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

    private fun resetProfileViews() {
        profile_avatar.hierarchy.setPlaceholderImage(R.drawable.place_holder_profile)
        display_name.text = ""
        profile_email.text = ""
        profile_mobile_number.text = ""
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }
}