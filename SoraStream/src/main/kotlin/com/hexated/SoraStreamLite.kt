package com.hexated

import com.hexated.SoraExtractor.invoke2embed
import com.hexated.SoraExtractor.invokeAnimes
import com.hexated.SoraExtractor.invokeDbgo
import com.hexated.SoraExtractor.invokeDoomovies
import com.hexated.SoraExtractor.invokeDramaday
import com.hexated.SoraExtractor.invokeDreamfilm
import com.hexated.SoraExtractor.invokeFilmxy
import com.hexated.SoraExtractor.invokeFlixon
import com.hexated.SoraExtractor.invokeFwatayako
import com.hexated.SoraExtractor.invokeGoku
import com.hexated.SoraExtractor.invokeKimcartoon
import com.hexated.SoraExtractor.invokeKisskh
import com.hexated.SoraExtractor.invokeLing
import com.hexated.SoraExtractor.invokeM4uhd
import com.hexated.SoraExtractor.invokeNavy
import com.hexated.SoraExtractor.invokeNinetv
import com.hexated.SoraExtractor.invokeNowTv
import com.hexated.SoraExtractor.invokeRStream
import com.hexated.SoraExtractor.invokeRidomovies
import com.hexated.SoraExtractor.invokeSmashyStream
import com.hexated.SoraExtractor.invokeDumpStream
import com.hexated.SoraExtractor.invokeEmovies
import com.hexated.SoraExtractor.invokeJump1
import com.hexated.SoraExtractor.invokeMoment
import com.hexated.SoraExtractor.invokeMultimovies
import com.hexated.SoraExtractor.invokeNetflix
import com.hexated.SoraExtractor.invokeNetmovies
import com.hexated.SoraExtractor.invokePrimewire
import com.hexated.SoraExtractor.invokeVidSrc
import com.hexated.SoraExtractor.invokeVidsrcto
import com.hexated.SoraExtractor.invokeWatchOnline
import com.hexated.SoraExtractor.invokeWatchflx
import com.hexated.SoraExtractor.invokeWatchsomuch
import com.hexated.SoraExtractor.invokeZshow
import com.lagradost.cloudstream3.SubtitleFile
import com.lagradost.cloudstream3.argamap
import com.lagradost.cloudstream3.utils.AppUtils
import com.lagradost.cloudstream3.utils.ExtractorLink

class SoraStreamLite : SoraStream() {
    override var name = "SoraStream-Lite"

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {

        val res = AppUtils.parseJson<LinkData>(data)

        argamap(
            {
                if(!res.isAnime) invokeJump1(res.id,res.tvdbId,res.title,res.year,res.season,res.episode,callback)
            },
//            {
//                invokeSusflix(
//                    res.id,
//                    res.season,
//                    res.episode,
//                    subtitleCallback,
//                    callback
//                )
//            },
            {
                invokeWatchsomuch(
                    res.imdbId,
                    res.season,
                    res.episode,
                    subtitleCallback
                )
            },
            {
                invokeDumpStream(
                    res.title,
                    res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeNinetv(
                    res.id,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeGoku(
                    res.title,
                    res.year,
                    res.season,
                    res.lastSeason,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeVidSrc(res.id, res.season, res.episode, subtitleCallback, callback)
            },
            {
                invokeDbgo(res.imdbId, res.season, res.episode, subtitleCallback, callback)
            },
            {
                if (res.isAnime) invokeAnimes(
                    res.title,
                    res.epsTitle,
                    res.date,
                    res.airedDate,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeDreamfilm(
                    res.title,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
//            {
//                invokeUniqueStream(
//                    res.title,
//                    res.year,
//                    res.season,
//                    res.episode,
//                    subtitleCallback,
//                    callback
//                )
//            },
            {
                if (!res.isAnime) invokeFilmxy(
                    res.imdbId,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeKimcartoon(
                    res.title,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeSmashyStream(
                    res.imdbId,
                    res.season,
                    res.episode,
                    res.isAnime,
                    subtitleCallback,
                    callback
                )
            },
//            {
//                invokeXmovies(
//                    res.title,
//                    res.year,
//                    res.season,
//                    res.episode,
//                    subtitleCallback,
//                    callback
//                )
//            },
            {
                if (!res.isAnime) invokeVidsrcto(
                    res.imdbId,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeKisskh(
                    res.title,
                    res.season,
                    res.episode,
                    res.isAnime,
                    res.lastSeason,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeLing(
                    res.title,
                    res.airedYear ?: res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeFwatayako(res.imdbId, res.season, res.episode, callback)
            },
            {
                if(!res.isAnime) invokeM4uhd(
                    res.title,
                    res.airedYear ?: res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeRStream(res.id, res.season, res.episode, callback)
            },
            {
                invokeFlixon(res.id, res.imdbId, res.season, res.episode, callback)
            },
            {
                invokePrimewire(res.title, res.year, res.season, res.episode, callback)
            },
            {
                invokeWatchOnline(
                    res.imdbId,
                    res.id,
                    res.title,
                    res.airedYear ?: res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeNowTv(res.id, res.season, res.episode, callback)
            },
            {
                invokeNavy(res.imdbId, res.season, res.episode, callback)
            },
            {
                if (res.season == null) invokeRidomovies(
                    res.title,
                    res.year,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeEmovies(
                    res.title,
                    res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeMultimovies(res.title, res.season, res.episode, subtitleCallback, callback)
            },
            {
                invokeNetmovies(
                    res.title,
                    res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                invokeMoment(res.imdbId, res.season, res.episode, callback)
            },
            {
                if (!res.isAnime && res.season == null) invokeDoomovies(
                    res.title,
                    subtitleCallback,
                    callback
                )
            },
            {
                if(res.isAsian) invokeDramaday(
                    res.title,
                    res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeWatchflx(
                    res.id,
                    res.season,
                    res.episode,
                    callback
                )
            },
            {
                if(!res.isAnime) invoke2embed(
                    res.imdbId,
                    res.season,
                    res.episode,
                    callback
                )
            },
            {
                if (!res.isAnime) invokeNetflix(
                    res.imdbId,
                    res.title,
                    res.season,
                    res.episode,
                    callback
                )
            },
            {
                invokeZshow(
                    res.title,
                    res.year,
                    res.season,
                    res.episode,
                    subtitleCallback,
                    callback
                )
            }
        )

        return true
    }

}