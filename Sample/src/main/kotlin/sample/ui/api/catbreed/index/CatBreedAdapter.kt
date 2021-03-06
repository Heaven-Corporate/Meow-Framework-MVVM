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

package sample.ui.api.catbreed.index

import android.view.LayoutInflater
import android.view.ViewGroup
import meow.controller
import meow.core.ui.MeowAdapter
import meow.core.ui.MeowViewHolder
import sample.BR
import sample.data.catbreed.CatBreed
import sample.databinding.ItemCatBreedBinding

/**
 * [CatBreed] Adapter.
 *
 * @author  Hamidreza Etebarian
 * @version 1.0.0
 * @since   2020-04-11
 */

typealias Model = CatBreed

typealias ViewHolder = MeowViewHolder<Model>
typealias DiffCallback = CatBreed.DiffCallback

class CatBreedAdapter : MeowAdapter<Model, ViewHolder>(
    DiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCatBreedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeowViewHolder(binding.root) { _, model ->
            binding.let {
                it.controller = controller
                it.setVariable(BR.model, model)
                it.executePendingBindings()
            }
        }
    }
}
