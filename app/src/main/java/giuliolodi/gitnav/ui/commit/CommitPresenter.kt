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

package giuliolodi.gitnav.ui.commit

import giuliolodi.gitnav.data.DataManager
import giuliolodi.gitnav.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import org.eclipse.egit.github.core.Commit
import javax.inject.Inject

/**
 * Created by giulio on 20/12/2017.
 */
class CommitPresenter<V: CommitContract.View> : BasePresenter<V>, CommitContract.Presenter<V> {

    private val TAG = "CommitPresenter"

    private val mCommit: Commit? = null

    @Inject
    constructor(mCompositeDisposable: CompositeDisposable, mDataManager: DataManager) : super(mCompositeDisposable, mDataManager)

    override fun subscribe(isNetworkAvailable: Boolean, owner: String, name: String) {
    }

    override fun onOpenInBrowser() {
        mCommit?.url?.let { getView().intentToBrowser(it) }
    }

}