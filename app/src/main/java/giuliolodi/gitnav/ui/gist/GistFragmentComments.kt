/*
 * Copyright 2017 GLodi
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

package giuliolodi.gitnav.ui.gist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import giuliolodi.gitnav.R
import giuliolodi.gitnav.ui.base.BaseFragment
import org.eclipse.egit.github.core.Comment
import javax.inject.Inject

/**
 * Created by giulio on 03/07/2017.
 */
class GistFragmentComments : BaseFragment(), GistContractComments.View {

    @Inject lateinit var mPresenter: GistContractComments.Presenter<GistContractComments.View>

    companion object {
        fun newInstance(gistId: String): GistFragmentComments {
            val gistFragmentComments: GistFragmentComments = GistFragmentComments()
            val bundle: Bundle = Bundle()
            bundle.putString("gistId", gistId)
            gistFragmentComments.arguments = bundle
            return gistFragmentComments
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        getActivityComponent()?.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.gist_fragment_comments, container, false)
    }

    override fun initLayout(view: View?, savedInstanceState: Bundle?) {
        mPresenter.onAttach(this)
    }

    override fun showComments(gistCommentList: List<Comment>) {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showError(error: String) {
    }

}