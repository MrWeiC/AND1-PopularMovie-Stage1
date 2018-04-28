package io.weichen.popularmovie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static io.weichen.popularmovie.BuildConfig.THEMOVIEDB_API_KEY;
import static io.weichen.popularmovie.utilities.NetworkUtils.CATEGORY_POPULAR;
import static io.weichen.popularmovie.utilities.NetworkUtils.buildUrl;
import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class UtilitiesUnitTest {

    @Test
    public void CheckUtilitiesBuildUrl_popular(){
        String targetString = "http://api.themoviedb.org/3/movie/popular?page=1&api_key="+THEMOVIEDB_API_KEY;
        String buildURL = buildUrl(CATEGORY_POPULAR).toString();
        assertEquals(targetString,buildURL);
    }
}
