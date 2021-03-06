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

package giuliolodi.gitnav.ui.base

import android.graphics.Bitmap

/**
 * Created by giulio on 12/05/2017.
 */
interface BaseContract {

    interface View {

        fun isNetworkAvailable(): Boolean

        fun initDrawer(username: String, fullName: String?, email: String?, profilePic: Bitmap?)

    }

    /*
     * The difference between onDetach() and onDetachView() is that the former handles the
     * dispose of any flowable and gets rid off the view reference, the latter doesn't dispose,
     * but still deletes the view reference.
     */
    interface Presenter<V: View> {

        fun onAttach(view: V)

        fun onDetach()

        fun onDetachView()

    }

}
