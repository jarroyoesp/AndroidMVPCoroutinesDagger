package es.jarroyo.mvp_coroutines_dagger.domain.usecase.getGitHubContributors

import es.jarroyo.mvp_coroutines_dagger.domain.usecase.base.BaseRequest

class GetGitHubContributorsRequest(var owner: String, var repositorie: String) : BaseRequest {
    override fun validate(): Boolean {
        return true
    }
}