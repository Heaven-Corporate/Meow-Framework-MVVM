/*
 * Copyright (C) 2020 Hamidreza Etebarian & Ali Modares.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.ui.material.form

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import meow.util.createClass
import meow.util.toastL
import sample.R
import sample.databinding.FragmentFormBinding
import sample.ui.base.BaseFragment

/**
 * Material Alerts Fragment class.
 *
 * @author  Hamidreza Etebarian
 * @version 1.0.0
 * @since   2020-03-22
 */

class FormFragment : BaseFragment<FragmentFormBinding, FormViewModel>() {

    override fun layoutId() = R.layout.fragment_form
    override fun viewModelClass() = createClass<FormViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.bt.setOnClickListener {
            binding.fv.validate {
                Log.d("testText", "Text is : ${binding.et.text.toString()}")
                toastL(binding.et.text.toString())
            }
        }

        binding.et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.et.text!!.length > binding.et.counterMaxLength)
                    binding.et.error = "Text is longer than allowed limit"
                else
                    binding.et.isErrorEnabled = false
            }
        })
    }

    override fun initViewModel() {
        binding.viewModel = viewModel
    }

    override fun observeViewModel() {
    }

}