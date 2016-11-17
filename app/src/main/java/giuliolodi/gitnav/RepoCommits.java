/*
 * Copyright 2016 GLodi
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

package giuliolodi.gitnav;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.service.CommitService;

import java.io.IOException;
import java.util.List;

import butterknife.ButterKnife;

public class RepoCommits {

    private Context context;
    private Repository repo;
    private CommitService commitService;
    private List<RepositoryCommit> repositoryCommitList;

    public void populate(Context context, View v, Repository repo) {
        this.context = context;
        this.repo = repo;

        ButterKnife.bind(this, v);

        new getCommits().execute();
    }

    private class getCommits extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            commitService = new CommitService();
            commitService.getClient().setOAuth2Token(Constants.getToken(context));

            try {
                repositoryCommitList = commitService.getCommits(new RepositoryId(repo.getOwner().getLogin(), repo.getName()));
            } catch (IOException e) {e.printStackTrace();}

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

}